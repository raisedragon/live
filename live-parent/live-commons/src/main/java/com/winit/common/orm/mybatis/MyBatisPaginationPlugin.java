package com.winit.common.orm.mybatis;

import com.winit.common.query.SearchRequest;
import com.winit.common.query.Searchable;
import com.winit.common.query.Sort;
import com.winit.common.query.filter.AndCondition;
import com.winit.common.query.filter.Condition;
import com.winit.common.query.filter.OrCondition;
import com.winit.common.query.filter.SearchFilter;
import com.winit.common.utils.Dates;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.*;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.mapping.MappedStatement.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Mybatis - 通用分页拦截器
 * Created by ye.liu on 2014/8/08.
 */
@Intercepts({
	@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
	})
public class MyBatisPaginationPlugin implements Interceptor {
	private static Logger logger = LoggerFactory.getLogger(MyBatisPaginationPlugin.class);
    private Properties properties;
    //数据库方言
    private String dialect = "oracle"; 

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
    	 Object[] args = invocation.getArgs();
    	 Object obj = args[1];
    	 if(null != obj && obj instanceof SearchRequest){
    		 MappedStatement ms = (MappedStatement) args[0];
    		 SearchRequest searchRequest = (SearchRequest) obj;
             BoundSql boundSql = ms.getBoundSql(searchRequest);
    		 //原始sql
    		 String sql = boundSql.getSql();
    		 //封装过滤条件和排序后的sql
    		 String searchableSql = getSearchableSql(sql, searchRequest);
    		 //总记录sql
    		 String countSql = getCountSql(searchableSql);
    		 //获取总记录
    		 long totalCount = getTotalCount(countSql, ms, boundSql);
    	     
    		 //数据分页sql
    		 String pageSql = getPageSql(searchableSql, searchRequest);
    		 BoundSql pageBoundSql = new BoundSql(ms.getConfiguration(), pageSql, boundSql.getParameterMappings(), boundSql.getParameterObject());
    		 MappedStatement pageMappend = copyFromMappedStatement(ms, new BoundSqlSqlSource(pageBoundSql)); 
    	     //设置新的分页sql语句
    	     invocation.getArgs()[0]= pageMappend;
    	     //注销内存分页
    	     args[2] = RowBounds.DEFAULT; 
    	     
	    	 List ObjList = (List)invocation.proceed();
	    	 PageBase pageList = new PageBase(ObjList, searchRequest.getPage(), totalCount);
	    	 return pageList;
    	 }
    	 return invocation.proceed();
    }

    /**
     * sqlSource
     * @author fu.wan
     *
     */
    public static class BoundSqlSqlSource implements SqlSource {    
        BoundSql boundSql;    
        public BoundSqlSqlSource(BoundSql boundSql) {    
            this.boundSql = boundSql;    
        }    
        public BoundSql getBoundSql(Object parameterObject) {    
            return boundSql;    
        }    
    }
    private MappedStatement copyFromMappedStatement(MappedStatement ms,SqlSource newSqlSource) {
		Builder builder = new Builder(ms.getConfiguration(),ms.getId(),newSqlSource,ms.getSqlCommandType());
		
		builder.resource(ms.getResource());
		builder.fetchSize(ms.getFetchSize());
		builder.statementType(ms.getStatementType());
		builder.keyGenerator(ms.getKeyGenerator());
		if(ms.getKeyProperties() != null && ms.getKeyProperties().length !=0){
            StringBuffer keyProperties = new StringBuffer();
            for(String keyProperty : ms.getKeyProperties()){
                keyProperties.append(keyProperty).append(",");
            }
            keyProperties.delete(keyProperties.length()-1, keyProperties.length());
			builder.keyProperty(keyProperties.toString());
		}
		builder.timeout(ms.getTimeout());
		builder.parameterMap(ms.getParameterMap());
        builder.resultMaps(ms.getResultMaps());
		builder.resultSetType(ms.getResultSetType());
		builder.cache(ms.getCache());
		builder.flushCacheRequired(ms.isFlushCacheRequired());
		builder.useCache(ms.isUseCache());
		return builder.build();
	}
    
    /**
     * 封装查询条件和排序字段
     * @param sql
     * @param searchable
     * @return
     */
    private String getSearchableSql(String sql, Searchable searchable){
    	Collection<SearchFilter> searchFilterList = searchable.getSearchFilters();
    	StringBuilder searchableSql = new StringBuilder();
    	searchableSql.append(sql);
    	int from = sql.lastIndexOf("from");
    	if(from <= 0){
    		from = sql.lastIndexOf("FROM");
    	}
    	String where = sql.substring(from);
    	if(where.lastIndexOf("where") < 0 && where.lastIndexOf("WHERE") < 0){
    		searchableSql.append(" where 1=1");
    	}
    	List<SearchFilter> conditionList = new ArrayList<SearchFilter>();
    	String connectStr = "";
    	for(SearchFilter searchFilter:searchFilterList){
    		if(searchFilter instanceof AndCondition){
    			connectStr = " and ";
    			conditionList = ((AndCondition) searchFilter).getAndFilters();
    		}else if(searchFilter instanceof OrCondition){
    			connectStr = " or ";
    			conditionList = ((OrCondition) searchFilter).getOrFilters();
    		}else if(searchFilter instanceof Condition){
    			connectStr = " and ";
    			conditionList = new ArrayList<SearchFilter>();
    			conditionList.add(searchFilter);
    		}
    		for(SearchFilter filter:conditionList){
				if(filter instanceof Condition){
					Condition condition = (Condition)filter;
					String operatorStr = condition.getOperatorStr();
					operatorStr = (null == operatorStr || operatorStr.length() <= 0)?"=":operatorStr;
					Object value = condition.getValue();
					if(value instanceof Date){
						Date date = Dates.getLocalDate((Date)value);
						String dateStr = Dates.formatDate(date, "yyyy-MM-dd HH:mm:ss");
						value = "'" + dateStr + "'";
					}else if("in".equals(operatorStr) || "not in".equals(operatorStr) || "IN".equals(operatorStr) || "NOT IN".equals(operatorStr)){
						value = value + "";
					}else{
						value = "'" + value + "'";
					}
					searchableSql.append(connectStr + condition.getSearchProperty() + " " + operatorStr + " " + value);
				}
			}
    	}
    	Sort sort = searchable.getSort();
    	String sortStr = (null != sort)?sort.getSortSql():null;
    	if(null != sortStr && sortStr.length() > 0){
    		searchableSql.append(" order by " + sortStr);
    	}
    	return searchableSql.toString();
    }
    
    /**
     * 获取总数sql - 如果要支持其他数据库，修改这里就可以
     * @param sql
     * @return
     */
    private String getCountSql(String sql) {
        return "select count(0) from (" + sql + ") obj";
    }

    
    /**
     * 获取分页sql - 支持Oracle,Mysql,hsqldb
     * @param sql
     * @param request
     * @return
     */
    private String getPageSql(String sql, SearchRequest request) {
        StringBuilder pageSql = new StringBuilder(200);
        if("mysql".equals(dialect)){
            pageSql.append(sql);
            pageSql.append(" limit "+request.getPage().getOffset()+","+request.getPage().getPageSize());
        }else if("oracle".equals(dialect)){
            pageSql.append("select * from ( select temp.*, rownum row_id from ( ");
            pageSql.append(sql);
            pageSql.append(" ) temp where rownum <= ").append(request.getPage().getOffset()+request.getPage().getPageSize());
            pageSql.append(") where row_id > ").append(request.getPage().getOffset());
        }else if("hsqldb".equals(dialect)){
            pageSql.append(sql);
            pageSql.append(" LIMIT " + request.getPage().getOffset() + " OFFSET " + request.getPage().getPageSize());
        }else if("h2db".equals(dialect)){
        	pageSql.append("select top " + request.getPage().getPageSize() + " * from ( ");
        	pageSql.append(sql);
        	pageSql.append(" ) interceptorObject where interceptorObject.id not in (");  
        	pageSql.append("select top " + request.getPage().getOffset() + " interceptorPage.id from ( " + sql + " ) interceptorPage )");
        }
        return pageSql.toString();
    }

    /**
     * 只拦截StatementHandler
     *
     * @param target
     * @return
     */
    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler || target instanceof Executor) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties p) {
        this.properties=p;
        String dialectProp = p.getProperty("dialect");
        String dialects = "oracle,mysql,h2db,hsqldb";
        if(dialectProp !=null && dialects.indexOf(dialectProp) >= 0 ){
            this.dialect = dialectProp;
        }else{
            logger.error("the dialect property '" + dialectProp + "' not be availabled,default dialect is 'oracle'");
        }
    }
    
    
    /** 
     * 从数据库里查询总的记录数并计算总页数，回写进分页参数totalCount
     * @param countSql
     * @param mappedStatement
     * @param boundSql 
     */  
    private long getTotalCount(String countSql, MappedStatement mappedStatement,  BoundSql boundSql) {
        long totalCount = 0;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conn=null;
        try {
            conn=mappedStatement.getConfiguration().getEnvironment().getDataSource().getConnection();
            stmt = conn.prepareStatement(countSql);
            Configuration configuration = mappedStatement.getConfiguration();
            List<ParameterMapping> parameList = boundSql.getParameterMappings();
            Object objParame = boundSql.getParameterObject();
            //设置参数
            BoundSql countBS = new BoundSql(configuration, countSql,  parameList, objParame);  
            setParameters(stmt, mappedStatement, countBS, objParame);
            rs = stmt.executeQuery();
            if (rs.next()) {
                totalCount = rs.getInt(1);  
            }  
        } catch (SQLException e) {
            logger.error("MyBatisPaginationPlugin.setPageParameter error.", e);
        } finally {
            close(rs, stmt,conn);
        }  
        return totalCount;
    } 
    
    /** 
     * 对SQL参数(?)设值 
     *  
     * @param ps 
     * @param mappedStatement 
     * @param boundSql 
     * @param parameterObject 
     * @throws SQLException 
     */  
    private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,  
            Object parameterObject) throws SQLException {  
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);  
        parameterHandler.setParameters(ps);  
    }

    private void close(ResultSet rs,Statement stmt,Connection conn){
        try {
            if(null!=rs && !rs.isClosed()){
                rs.close();
            }
        } catch (SQLException e) {
            logger.error("close jdbc resultset error.", e);
        }
        try {
            if(null!=rs && !stmt.isClosed()){
                stmt.close();
            }
        } catch (SQLException e) {
            logger.error("close jdbc statement error.", e);
        }
        try {
            if(null!=rs && !conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            logger.error("close jdbc connection error.", e);
        }
    }
}
