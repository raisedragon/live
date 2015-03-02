<#import "function.ftl" as func>
<#assign package=model.variables.package>
<#assign class=model.variables.class>
<#assign classVar=model.variables.classVar>
<#assign system=vars.system>
<#assign sub=model.sub>
<#assign foreignKey=func.convertUnderLine(model.foreignKey)>
package com.winit.${system}.${package}.dao;
<#if sub?exists && sub>
import java.util.HashMap;
import java.util.Map;
</#if>
import java.util.List;

import com.winit.vms.core.dao.Dao;
import com.winit.common.query.Searchable;
import com.winit.common.orm.mybatis.MyBatisPageRepo;
import com.winit.common.orm.mybatis.MyBatisRepo;
import com.winit.${system}.${package}.entity.${class};
import com.winit.${system}.${package}.query.${class}Query;

/**
 * ${model.tabComment} Dao
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
public interface ${class}Dao extends Dao<${class},Long>{
	
	/**
	 * 根据查询对象查询
	 * @param query
	 * @return
	 */
	public List<${class}> queryByCriteria(${class}Query.FindQuery query);
	
	/**
	 * 根据查询对象查询
	 * @param query
	 * @return
	 */
	public long queryCountByCriteria(${class}Query.FindQuery query);
	
	/**
	 * 根据查询对象更新
	 * @param query
	 * @return
	 */
	public void updateByUpdateQuery(${class}Query.UpdateQuery uQuery);


	<#if sub?exists && sub>
	/**
	 * 根据外键获取子表明细列表
	 * @param ${foreignKey}
	 * @return
	 */
	public List<${class}> getByMainId(Long ${foreignKey});
	
	/**
	 * 根据外键删除子表记录
	 * @param ${foreignKey}
	 * @return
	 */
	public void delByMainId(Long ${foreignKey});
	
	</#if>	
}


