<#import "function.ftl" as func>
<#assign package=model.variables.package>
<#assign class=model.variables.class>
<#assign classVar=model.variables.classVar>
<#assign system=vars.system>
<#assign subtables=model.subTableList>
<#assign pk=func.getPk(model) >
<#assign pkVar=func.convertUnderLine(pk) >
package com.winit.${system}.${package}.manager.impl;

import java.io.Serializable;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
<#if subtables?exists && subtables?size != 0>
<#list subtables as subtable>
import com.winit.${system}.${package}.dao.${subtable.variables.class}Dao;
import com.winit.${system}.${package}.entity.${subtable.variables.class};
</#list>
</#if>
import java.util.List;
import com.winit.common.query.Searchable;
import com.winit.${system}.${package}.dao.${class}Dao;
import com.winit.${system}.${package}.entity.${class};
import com.winit.${system}.${package}.manager.${class}Manager;
import com.winit.${system}.${package}.query.${class}Query;
import com.winit.vms.core.manager.BaseManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.winit.vms.core.dao.Dao;
/**
 * ${model.tabComment} Manager impl
 * Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     			Version       Date			Changes
 * ${vars.developer}    	1.0       ${date?string("yyyy-MM-dd HH:mm:ss")}			Created
 *
 * </pre>
 * @since 1.
 */
@Service("${classVar}Manager")
public class ${class}ManagerImpl extends BaseManager<${class}> implements ${class}Manager {
	/**
	 * 日志记录对象
	 */
	private Logger logger = LoggerFactory.getLogger(${class}ManagerImpl.class);

	@Resource
	${class}Dao ${classVar}Dao;
	<#if subtables?exists && subtables?size != 0>
		<#list subtables as table>
	@Resource
	${table.variables.class}Dao ${table.variables.classVar}Dao;
		</#list>
	</#if>
	@Override
	protected Dao<${class},Long> getDao() {
		return ${classVar}Dao;
	}
	
	 @Override
	public List<${class}> queryByCriteria(${class}Query.FindQuery query) {
		return ${classVar}Dao.queryByCriteria(query);
	}
	


	@Override
	public long queryCountByCriteria(${class}Query.FindQuery query) {
		return ${classVar}Dao.queryCountByCriteria(query);
	}
	
	@Override
	public void updateByUpdateQuery(${class}Query.UpdateQuery uQuery){
		${classVar}Dao.updateByUpdateQuery(uQuery);
	}

	
	
<#if subtables?exists && subtables?size != 0>
	/**
	 * 创建实体包含子表实体
	 */
	public void add(${class} ${classVar}){
    	super.add(${classVar});
    	<#list subtables as subtable>
    	<#assign subclass=subtable.variables.class>
    	<#assign subclassvar=subtable.variables.classVar>
    	${subclassvar}Dao.delByMainId(${classVar}.get${pkVar?cap_first}());
    	List<${subclass}> ${subclassvar}List=${classVar}.get${subclass}List();
    	for(${subclass} ${subclassvar}:${subclassvar}List){
    		${subclassvar}Dao.add(${subclassvar});
    	}
    	</#list>
    }
	
	/**
	 * 删除记录包含子表记录
	 */
	public int delete(Long entityId){
		<#list subtables as subtable>
    	<#assign subclass=subtable.variables.class>
    	<#assign subclassvar=subtable.variables.classVar>
    	${subclassvar}Dao.delByMainId(entityId);
    	</#list>
		return super.delete(entityId);
		
	}
    
	/**
	 * 获取实体
	 */
    public ${class} get(Long entityId){
    	${class} ${classVar}=super.get(entityId);
    	<#list subtables as subtable>
    	<#assign subclass=subtable.variables.class>
    	<#assign subclassvar=subtable.variables.classVar>
    	List<${subclass}> ${subclassvar}List=${subclassvar}Dao.getByMainId(entityId);
    	${classVar}.set${subclass}List(${subclassvar}List);
    	</#list>
    	return ${classVar};
    }
    
    /**
     * 更新实体同时更新子表记录
     */
    public void update(${class} ${classVar}){
    	super.update(${classVar});
    	<#list subtables as subtable>
    	<#assign subclass=subtable.variables.class>
    	<#assign subclassvar=subtable.variables.classVar>
    	${subclassvar}Dao.delByMainId(${classVar}.get${pkVar?cap_first}());
    	List<${subclass}> ${subclassvar}List=${classVar}.get${subclass}List();
    	for(${subclass} ${subclassvar}:${subclassvar}List){
    		${subclassvar}Dao.add(${subclassvar});
    	}
    	</#list>
    }
	
	</#if>
	
}
