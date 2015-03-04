package com.gdcc.live.core.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * 对象功能:java中的boolean和jdbc中的int之间转
 * 
 * @author longsheng.wang
 */
@SuppressWarnings("rawtypes")
public class BooleanTypeHandler implements TypeHandler {

    /*
     * (non-Javadoc)
     * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.ResultSet,
     * java.lang.String)
     */
    @Override
    public Object getResult(ResultSet arg0, String arg1) throws SQLException {
        String str = arg0.getString(arg1);
        Boolean rt = null;
        if ("Y".equalsIgnoreCase(str)) {
            rt = Boolean.TRUE;
        } else if ("N".equalsIgnoreCase(str)) {
            rt = Boolean.FALSE;
        }
        return rt;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.apache.ibatis.type.TypeHandler#getResult(java.sql.CallableStatement,
     * int)
     */
    @Override
    public Object getResult(CallableStatement arg0, int arg1) throws SQLException {
        String str = arg0.getString(arg1);
        Boolean rt = null;
        if ("Y".equalsIgnoreCase(str)) {
            rt = Boolean.TRUE;
        } else if ("N".equalsIgnoreCase(str)) {
            rt = Boolean.FALSE;
        }
        return rt;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.apache.ibatis.type.TypeHandler#setParameter(java.sql.PreparedStatement
     * , int, java.lang.Object, org.apache.ibatis.type.JdbcType)
     */
    @Override
    public void setParameter(PreparedStatement arg0, int arg1, Object arg2, JdbcType arg3) throws SQLException {
        if (arg2 == null) {
            arg0.setString(arg1, null);
            return;
        }
        Boolean b = (Boolean) arg2;
        String value = (Boolean) b ? "Y" : "N";
        arg0.setString(arg1, value);
    }

    @Override
    public Object getResult(ResultSet arg0, int arg1) throws SQLException {
        String str = arg0.getString(arg1);
        Boolean rt = null;
        if ("Y".equalsIgnoreCase(str)) {
            rt = Boolean.TRUE;
        } else if ("N".equalsIgnoreCase(str)) {
            rt = Boolean.FALSE;
        }
        return rt;
    }
}
