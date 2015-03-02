<#import "function.ftl" as func>
<#assign package=model.variables.package>
<#assign class=model.variables.class>
<#assign classVar=model.variables.classVar>
<#assign system=vars.system>
<#assign pk=func.getPk(model) >
<#assign pkVar=func.convertUnderLine(pk) >
package com.winit.${system}.${package}.manager;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.test.annotation.Rollback;

import com.winit.${system}.${package}.entity.${class};
import com.winit.${system}.${package}.manager.${class}Manager;
import com.winit.vms.system.BaseTest;

/**
 * ${model.tabComment} Manager Test Case
 * Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     			Version       Date			Changes
 * ${vars.developer}    	1.0       ${date?string("yyyy-MM-dd HH:mm:ss")}			Created
 *
 * </pre>
 * @since 1.
 */
public class ${class}ManagerTest extends BaseTest{
	@Resource
	${class}Manager ${classVar}Manager;
	
	
	@Test
	public void testCreate() {
		${class} ${classVar}=new ${class}();
		Integer randId=new Double(100000*Math.random()).intValue();
		<#list model.columnList as col>
			<#assign columnName=func.convertUnderLine(col.columnName)>
		<#if col.isPK>
		${classVar}.setId(idGenerator.getUId());
		<#else>
		<#if col.isNotNull>
		<#if columnName="isDelete"><#elseif (col.columnName?substring(0,2))?lower_case=="is">
		${classVar}.set${columnName?substring(2)}(true);
		<#elseif col.colType="java.util.Date" || col.colType="timestamp">
		${classVar}.set${columnName?cap_first}(new Date());
		<#elseif col.colType="Float">
		${classVar}.set${columnName?cap_first}(Float.parseFloat(randId+""));
		<#elseif col.colType="Double">
		${classVar}.set${columnName?cap_first}(Double.parseDouble(randId+""));
		<#elseif columnName="isActive">
		${classVar}.setActive(true);
		<#elseif columnName="isDelete">
		<#elseif col.colType="Short">
		${classVar}.set${columnName?cap_first}(new Short("11"));
		<#elseif col.colType="Integer">
		${classVar}.set${columnName?cap_first}(randId);
		<#elseif col.colType="Long">
		${classVar}.set${columnName?cap_first}(Long.parseLong(randId+""));
		<#elseif col.colType="String">
		${classVar}.set${columnName?cap_first}("${classVar?substring(0,3)}" + randId);
		<#elseif col.colType="char">
		${classVar}.set${columnName?cap_first}("${classVar?substring(0,3)}" + randId);
		</#if>
		</#if>
		</#if>
		</#list>
		
		//创建一实体
		${classVar}Manager.add(${classVar});
		
		${class} ${classVar}1 = ${classVar}Manager.get(${classVar}.getId());
		
		assertEquals(${classVar}.getOrganizationId(), ${classVar}1.getOrganizationId());
        
	}

	@Test
	public void testUpdate() {
		${class} ${classVar}=new ${class}();
		Integer randId=new Double(100000*Math.random()).intValue();
		<#list model.columnList as col>
			<#assign columnName=func.convertUnderLine(col.columnName)>
		<#if col.isPK>
		${classVar}.setId(idGenerator.getUId());
		<#else>
		<#if col.isNotNull>
		<#if columnName="isDelete"><#elseif (col.columnName?substring(0,2))?lower_case=="is">
		${classVar}.set${columnName?substring(2)}(true);
		<#elseif col.colType="java.util.Date" || col.colType="timestamp">
		${classVar}.set${columnName?cap_first}(new Date());
		<#elseif col.colType="Float">
		${classVar}.set${columnName?cap_first}(Float.parseFloat(randId+""));
		<#elseif col.colType="Double">
		${classVar}.set${columnName?cap_first}(Double.parseDouble(randId+""));
		<#elseif columnName="isActive">
		${classVar}.setActive(true);
		<#elseif columnName="isDelete">
		<#elseif col.colType="Short">
		${classVar}.set${columnName?cap_first}(new Short("11"));
		<#elseif col.colType="Integer">
		${classVar}.set${columnName?cap_first}(randId);
		<#elseif col.colType="Long">
		${classVar}.set${columnName?cap_first}(Long.parseLong(randId+""));
		<#elseif col.colType="String">
		${classVar}.set${columnName?cap_first}("${classVar?substring(0,3)}" + randId);
		<#elseif col.colType="char">
		${classVar}.set${columnName?cap_first}("${classVar?substring(0,3)}" + randId);
		</#if>
		</#if>
		</#if>
		</#list>
		
		//创建一实体
		${classVar}Manager.add(${classVar});
		
		Integer randId2=new Double(100000*Math.random()).intValue();
		<#list model.columnList as col>
			<#assign columnName=func.convertUnderLine(col.columnName)>
		<#if col.isPK>
		<#else>
		<#if col.isNotNull>
		<#if columnName="isDelete"><#elseif (col.columnName?substring(0,2))?lower_case=="is">
		${classVar}.set${columnName?substring(2)}(true);
		<#elseif col.colType="java.util.Date" || col.colType="timestamp">
		${classVar}.set${columnName?cap_first}(new Date());
		<#elseif col.colType="Float">
		${classVar}.set${columnName?cap_first}(Float.parseFloat(randId2+""));
		<#elseif col.colType="Double">
		${classVar}.set${columnName?cap_first}(Double.parseDouble(randId2+""));
		<#elseif columnName="isActive">
		${classVar}.setActive(true);
		<#elseif columnName="isDelete">
		<#elseif col.colType="Short">
		${classVar}.set${columnName?cap_first}(new Short("1"));
		<#elseif col.colType="Integer">
		${classVar}.set${columnName?cap_first}(randId2);
		<#elseif col.colType="Long">
		${classVar}.set${columnName?cap_first}(Long.parseLong(randId2+""));
		<#elseif col.colType="String">
		${classVar}.set${columnName?cap_first}("${classVar?substring(0,3)}" + randId2);
		<#elseif col.colType="char">
		${classVar}.set${columnName?cap_first}("${classVar?substring(0,3)}" + randId2);
		</#if>
		</#if>
		</#if>
		</#list>
		
		//创建一实体
		${classVar}Manager.update(${classVar});
		
		${class} ${classVar}2 = ${classVar}Manager.get(${classVar}.getId());
		
		assertEquals(${classVar}.getOrganizationId(),${classVar}2.getOrganizationId());
	}

	@Test
	public void testTombstoned() {
		${class} ${classVar}=new ${class}();
		Integer randId=new Double(100000*Math.random()).intValue();
		<#list model.columnList as col>
			<#assign columnName=func.convertUnderLine(col.columnName)>
		<#if col.isPK>
		${classVar}.setId(idGenerator.getUId());
		<#else>
		<#if col.isNotNull>
		<#if columnName="isDelete"><#elseif (col.columnName?substring(0,2))?lower_case=="is">
		${classVar}.set${columnName?substring(2)}(true);
		<#elseif col.colType="java.util.Date" || col.colType="timestamp">
		${classVar}.set${columnName?cap_first}(new Date());
		<#elseif col.colType="Float">
		${classVar}.set${columnName?cap_first}(Float.parseFloat(randId+""));
		<#elseif col.colType="Double">
		${classVar}.set${columnName?cap_first}(Double.parseDouble(randId+""));
		<#elseif columnName="isActive">
		${classVar}.setActive(true);
		<#elseif columnName="isDelete">
		<#elseif col.colType="Short">
		${classVar}.set${columnName?cap_first}(new Short("11"));
		<#elseif col.colType="Integer">
		${classVar}.set${columnName?cap_first}(randId);
		<#elseif col.colType="Long">
		${classVar}.set${columnName?cap_first}(Long.parseLong(randId+""));
		<#elseif col.colType="String">
		${classVar}.set${columnName?cap_first}("${classVar?substring(0,3)}" + randId);
		<#elseif col.colType="char">
		${classVar}.set${columnName?cap_first}("${classVar?substring(0,3)}" + randId);
		</#if>
		</#if>
		</#if>
		</#list>
		
		//创建一实体
		${classVar}Manager.add(${classVar});
		
		${classVar}Manager.tombstoned(${classVar}.getId());
		
		${class}  ${classVar}2 = ${classVar}Manager.get(${classVar}.getId());
		
		assertNull(${classVar}2);
	}

	@Test
	public void testGet() {
		${class} ${classVar}=new ${class}();
		Integer randId=new Double(100000*Math.random()).intValue();
		<#list model.columnList as col>
			<#assign columnName=func.convertUnderLine(col.columnName)>
		<#if col.isPK>
		${classVar}.setId(idGenerator.getUId());
		<#else>
		<#if col.isNotNull>
		<#if columnName="isDelete"><#elseif (col.columnName?substring(0,2))?lower_case=="is">
		${classVar}.set${columnName?substring(2)}(true);
		<#elseif col.colType="java.util.Date" || col.colType="timestamp">
		${classVar}.set${columnName?cap_first}(new Date());
		<#elseif col.colType="Float">
		${classVar}.set${columnName?cap_first}(Float.parseFloat(randId+""));
		<#elseif col.colType="Double">
		${classVar}.set${columnName?cap_first}(Double.parseDouble(randId+""));
		<#elseif columnName="isActive">
		${classVar}.setActive(true);
		<#elseif columnName="isDelete">
		<#elseif col.colType="Short">
		${classVar}.set${columnName?cap_first}(new Short("11"));
		<#elseif col.colType="Integer">
		${classVar}.set${columnName?cap_first}(randId);
		<#elseif col.colType="Long">
		${classVar}.set${columnName?cap_first}(Long.parseLong(randId+""));
		<#elseif col.colType="String">
		${classVar}.set${columnName?cap_first}("${classVar?substring(0,3)}" + randId);
		<#elseif col.colType="char">
		${classVar}.set${columnName?cap_first}("${classVar?substring(0,3)}" + randId);
		</#if>
		</#if>
		</#if>
		</#list>
		
		//创建一实体
		${classVar}Manager.add(${classVar});
		
		${class} ${classVar}2 = ${classVar}Manager.get(${classVar}.getId());
		
		

		assertEquals(${classVar}.getCreatedby(),${classVar}2.getCreatedby());
	}

	
	
}
	