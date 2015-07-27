<#import "function.ftl" as func>
<#assign classVar=Guava_CaseFormat.UPPER_UNDERSCORE.to(Guava_CaseFormat.LOWER_CAMEL, clazz)>
package ${properties.basepackage}.${pkg}.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.test.annotation.Rollback;

import ${properties.basepackage}.${pkg}.dao.${clazz}Dao;
import ${properties.basepackage}.${pkg}.entity.${clazz};
import com.gdcc.live.test.BaseTest;

/**
 * ${table.remarks} dao test 
 * company:${properties.company}
 * author:${properties.developer}
 * date: ${currentDate?string("yyyy-MM-dd HH:mm:ss")}
 * @since 1.
 */
public class ${clazz}DaoTest extends BaseTest{
	@Resource
	private ${clazz}Dao ${Guava_CaseFormat.UPPER_UNDERSCORE.to(Guava_CaseFormat.LOWER_CAMEL, clazz)}Dao;
	
	
	@Test
	public void testCreate() {
	
		${clazz} ${classVar}=new ${clazz}();
		Integer randId=new Double(100000*Math.random()).intValue();
		<#list table.columns as column>
		<#assign columnName="${Guava_CaseFormat.UPPER_UNDERSCORE.to(Guava_CaseFormat.LOWER_CAMEL, column.name)}">
		<#if (column.partOfPrimaryKey) >
			${classVar}.setId(idGenerator.getUId());
		<#else>
			${classVar}.set${columnName}(column);
		</#if>
		</#list>
		
	
		${clazz} ${classVar}=new ${clazz}();
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
		
		${clazz} ${classVar}1 = ${classVar}Dao.get(${classVar}.getId());
		
		assertEquals(${classVar}.getOrganizationId(), ${classVar}1.getOrganizationId());
        
	}

	@Test
	public void testUpdate() {
		${clazz} ${classVar}=new ${clazz}();
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
		
		${clazz} ${classVar}2 = ${classVar}Dao.get(${classVar}.getId());
		
		assertEquals(${classVar}.getOrganizationId(),${classVar}2.getOrganizationId());
	}

	@Test
	public void testTombstoned() {
		${clazz} ${classVar}=new ${clazz}();
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
		
		${clazz}  ${classVar}2 = ${classVar}Dao.get(${classVar}.getId());
		
		assertNull(${classVar}2);
	}

	@Test
	public void testGet() {
		${clazz} ${classVar}=new ${clazz}();
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
		
		${clazz} ${classVar}2 = ${classVar}Dao.get(${classVar}.getId());
		
		

		assertEquals(${classVar}.getCreatedby(),${classVar}2.getCreatedby());
	}

	
	
}
