<#import "function.ftl" as func>
<#assign package=model.variables.package>
<#assign class=model.variables.class>
<#assign system=vars.system>
<#assign subtables=model.subTableList>
<#assign pk=func.getPk(model) >
<#assign pkVar=func.convertUnderLine(pk) >
package com.winit.${system}.${package}.entity;
<#if subtables?exists && subtables?size!=0>
import java.util.ArrayList;
import java.util.List;
</#if>
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.winit.vms.core.entity.BaseEntity;
import java.math.BigDecimal;

/**
 * ${model.tabComment} Entity
 * Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     			Version       Date			Changes
 * ${vars.developer}    	1.0       ${date?string("yyyy-MM-dd HH:mm:ss")}			Created
 *
 * </pre>
 * @since 1.
 */
public class ${class} extends BaseEntity<Long> {
	<#list model.columnList as col>
		<#assign colName=func.convertUnderLine(col.columnName)>
		<#if colName!="isActive" && 
		 colName!="created" &&
		 colName!="createdby" &&
		 colName!="updated" &&
		 colName!="updatedby" &&
		 colName!="isDelete" &&
		 colName!="organizationId" >
		 <#if (col.columnName?substring(0,2))?lower_case=="is">
	protected Boolean ${func.convertUnderLine(col.columnName)}; /*${col.comment}*/
		 <#else>
		  <#assign colType><#if col.colType=="timestamp">Date<#elseif (col.colType="Double")>BigDecimal<#elseif (col.colType="Integer")>Integer<#elseif col.colType=="char">Boolean<#else>${col.colType}</#if></#assign>
	protected ${colType}  ${func.convertUnderLine(col.columnName)}; /*${col.comment}*/
		 </#if>
		</#if>
	</#list>
	<#if subtables?exists && subtables?size!=0>
	<#list subtables as table>
	<#assign vars=table.variables>
	protected List<${vars.class}> ${vars.classVar}List=new ArrayList<${vars.class}>(); /*${table.tabComment}列表*/
	</#list>
	</#if>
<#if (pkVar!="id")>
	@Override
	public void setId(Long ${pkVar}) {
		set${pkVar?cap_first}(${pkVar});
	}
	@Override
	public Long getId() {
		return get${pkVar?cap_first}();
	}	
	
</#if>
<#list model.columnList as col>
	<#assign colName=func.convertUnderLine(col.columnName)>
		<#if colName!="isActive" && 
		 colName!="created" &&
		 colName!="createdby" &&
		 colName!="updated" &&
		 colName!="updatedby" &&
		 colName!="isDelete" &&
		 colName!="organizationId" >
		<#if (col.columnName?substring(0,2))?lower_case=="is">
	public void set${colName?substring(2)}(Boolean ${colName}) 
	{
		this.${colName} = ${colName};
	}
	/**
	 * 返回 ${col.comment}
	 * @return
	 */
	public Boolean ${colName}() 
	{
		return this.${colName};
	}
		 <#else>
		 <#assign colType><#if col.colType=="timestamp">Date<#elseif col.colType=="Double">BigDecimal<#elseif (col.colType="Integer")>Integer<#elseif col.colType=="char">Boolean<#else>${col.colType}</#if></#assign>
	public void set${colName?cap_first}(${colType} ${colName}) 
	{
		this.${colName} = ${colName};
	}
	/**
	 * 返回 ${col.comment}
	 * @return
	 */
	public ${colType} get${colName?cap_first}() 
	{
		return this.${colName};
	}
	 </#if>
	</#if>
</#list>
<#if subtables?exists && subtables?size!=0>
<#list subtables as table>
<#assign vars=table.variables>
	public void set${vars.classVar?cap_first}List(List<${vars.class}> ${vars.classVar}List) 
	{
		this.${vars.classVar}List = ${vars.classVar}List;
	}
	/**
	 * 返回 ${table.tabComment}列表
	 * @return
	 */
	public List<${vars.class}> get${vars.classVar?cap_first}List() 
	{
		return this.${vars.classVar}List;
	}
</#list>
</#if>
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		<#list model.columnList as col>
		<#assign colName=func.convertUnderLine(col.columnName)>
		.append("${colName}", this.${colName}) 
		</#list>
		.toString();
	}
}