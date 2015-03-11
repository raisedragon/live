<#import "function.ftl" as func>
<#assign package=model.variables.package>
<#assign class=model.variables.class>
<#assign classVar=model.variables.classVar>
<#assign system=vars.system>
<#assign sub=model.sub>
<#assign foreignKey=func.convertUnderLine(model.foreignKey)>
package com.winit.${system}.${package}.dao.impl;

<#if sub?exists && sub>
import java.util.HashMap;
import java.util.Map;
</#if>
import java.io.Serializable;
import com.winit.common.orm.mybatis.MyBatisRepo;

import com.winit.vms.base.api.query.Page;
import com.winit.vms.base.db.impl.MyBatisDaoImpl;
import java.util.List;
import com.winit.${system}.${package}.dao.${class}Dao;
import com.winit.${system}.${package}.entity.${class};
import com.winit.${system}.${package}.query.${class}Query;


/**
 * ${model.tabComment} Dao Impl
 * Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     			Version       Date			Changes
 * ${vars.developer}    	1.0       ${date?string("yyyy-MM-dd HH:mm:ss")}			Created
 *
 * </pre>
 * @since 1.
 */
@MyBatisRepo
public class ${class}DaoImpl extends MyBatisDaoImpl<Long,${class}> implements ${class}Dao{

    @Override
    public String getNamespace() {
        return ${class}.class.getName();
    }
     
    @Override
	public List<${class}> queryByCriteria(${class}Query.FindQuery query) {
		return this.getByKey("queryByCriteria", query);
	}
	
	
	@Override
	public List<${class}> queryByCriteria(${class}Query.FindQuery query, Page page) {
		return this.getByKey("queryByCriteria", query, page);
	}

	@Override
	public long queryCountByCriteria(${class}Query.FindQuery query) {
		return (Long) this.getOne("queryCountByCriteria", query);
	}
	
	@Override
	public void updateByUpdateQuery(${class}Query.UpdateQuery uQuery){
		this.updateByKey("updateByUpdateQuery",uQuery);
	}

	
	@Override
	public void deleteByDeleteQuery(${class}Query.DeleteQuery dQuery) {
		this.deleteByKey("deleteByDeleteQuery",dQuery);
	}
<#if sub?exists && sub>
	/**
	 * 根据外键获取子表明细列表
	 * @param ${foreignKey}
	 * @return
	 */
	public List<${class}> getByMainId(Long ${foreignKey}) {
		Map<String,Object>params=new HashMap<String, Object>();
		params.put("${foreignKey}", ${foreignKey});
		return (List<${class}>) this.getByKey("get${class}List", params);
	}
	
	/**
	 * 根据外键删除子表记录
	 * @param ${foreignKey}
	 * @return
	 */
	public void delByMainId(Long ${foreignKey}) {
		Map<String,Object>params=new HashMap<String, Object>();
		params.put("${foreignKey}", ${foreignKey});
		this.deleteByKey("delByMainId", params);
	}
	
</#if>	
	
}

