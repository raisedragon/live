<#import "function.ftl" as func>
<#assign package=model.variables.package>
<#assign class=model.variables.class>
<#assign classVar=model.variables.classVar>
<#assign system=vars.system>
<#assign pk=func.getPk(model) >
<#assign pkVar=func.convertUnderLine(pk) >
package com.winit.${system}.${package}.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.test.annotation.Rollback;

import com.winit.${system}.${package}.dao.${class}Dao;
import com.winit.${system}.${package}.entity.${class};
import com.winit.vms.system.BaseTest;

/**
 * ${model.tabComment} Dao Test Case
 * Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     			Version       Date			Changes
 * ${vars.developer}    	1.0       ${date?string("yyyy-MM-dd HH:mm:ss")}			Created
 *
 * </pre>
 * @since 1.
 */
public class ${class}DaoTest extends BaseTest{
	@Resource
	private ${class}Dao ${classVar}Dao;
	
	@Test
	@Rollback(true)
	public void testCrud(){
		${class} ${classVar}=new ${class}();
		Integer randId=new Double(100000*Math.random()).intValue();
		<#list model.columnList as col>
			<#assign columnName=func.convertUnderLine(col.columnName)>
		<#if col.isPK>
		${classVar}.setId(idGenerator.getUId());
		<#else>
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
		</#list>
		
		//创建一实体
		${classVar}Dao.add(${classVar});
        Assert.assertNotNull(${classVar}.getId());
        logger.debug("${classVar}1:"+ ${classVar}.getId());
		//获取一实体
		${class} ${classVar}2=(${class})${classVar}Dao.get(${classVar}.getId());
		Assert.assertNotNull(${classVar}2);
		logger.debug("${classVar}2:" + ${classVar}2.toString());
		Integer randId2=new Double(100000*Math.random()).intValue();
		<#list model.columnList as col>
			<#assign columnName=func.convertUnderLine(col.columnName)>
			<#if !col.isPK>
		<#if columnName="isDelete"><#elseif (col.columnName?substring(0,2))?lower_case=="is">
		${classVar}.set${columnName?substring(2)}(true);
		<#elseif col.colType="java.util.Date" || col.colType="timestamp">
		${classVar}2.set${columnName?cap_first}(new Date());
		<#elseif col.colType="Float">
		${classVar}2.set${columnName?cap_first}(Float.parseFloat(randId2+""));
		<#elseif columnName="isActive">
		${classVar}.setActive(true);
		<#elseif columnName="isDelete">
		<#elseif col.colType="Short">
		${classVar}2.set${columnName?cap_first}(new Short("1"));
		<#elseif col.colType="Integer">
		${classVar}2.set${columnName?cap_first}(randId2);
		<#elseif col.colType="Long">
		${classVar}2.set${columnName?cap_first}(Long.parseLong(randId2+""));
		<#elseif col.colType="String">
		${classVar}2.set${columnName?cap_first}("${classVar?substring(0,3)}" + randId2);
		<#elseif col.colType="char">
		${classVar}.set${columnName?cap_first}("${classVar?substring(0,3)}" + randId2);
		</#if>
		</#if>
		</#list>
		//更新一实体
		${classVar}Dao.update(${classVar}2);
		
		${class} ${classVar}3=${classVar}Dao.get(${classVar}.getId());
		System.out.println("${classVar}3:"+${classVar}3.toString());
		//删除一实体
		//${classVar}Dao.tombstoned(${classVar}.getId());
	}
	
	
	@Test
	public void testCreate() {
		${class} ${classVar}=new ${class}();
		Integer randId=new Double(100000*Math.random()).intValue();
		<#list model.columnList as col>
			<#assign columnName=func.convertUnderLine(col.columnName)>
		<#if col.isPK>
		${classVar}.setId(idGenerator.getUId());
		<#else>
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
		</#list>
		
		//创建一实体
		${classVar}Dao.add(${classVar});
		
		${class} ${classVar}1 = ${classVar}Dao.get(${classVar}.getId());
		
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
		</#list>
		
		//创建一实体
		${classVar}Dao.add(${classVar});
		
		Integer randId2=new Double(100000*Math.random()).intValue();
		<#list model.columnList as col>
			<#assign columnName=func.convertUnderLine(col.columnName)>
		<#if col.isPK>
		<#else>
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
		</#list>
		
		//创建一实体
		${classVar}Dao.update(${classVar});
		
		${class} ${classVar}2 = ${classVar}Dao.get(${classVar}.getId());
		
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
		</#list>
		
		//创建一实体
		${classVar}Dao.add(${classVar});
		
		${classVar}Dao.tombstoned(${classVar}.getId());
		
		${class}  ${classVar}2 = ${classVar}Dao.get(${classVar}.getId());
		
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
		</#list>
		
		//创建一实体
		${classVar}Dao.add(${classVar});
		
		${class} ${classVar}2 = ${classVar}Dao.get(${classVar}.getId());
		
		

		assertEquals(${classVar}.getCreatedby(),${classVar}2.getCreatedby());
	}

	
	
}
