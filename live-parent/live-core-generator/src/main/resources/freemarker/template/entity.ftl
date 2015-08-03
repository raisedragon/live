package ${properties.basepackage}.${pkg}.entity;

import java.util.Date;

import ${properties.basepackage}.core.entity.BaseEntity;

/**
 * ${table.description} entity 
 * company:${properties.company}
 * author:${properties.developer}
 * date: ${currentDate?string("yyyy-MM-dd HH:mm:ss")}
 * @since 1.
 */
public class ${table.jName} extends BaseEntity<${_Ongl.javaType(primaryKey)}> {
	
	private static final long serialVersionUID = 1L;
	
	<#list table.columns as column>
	<#if !_Ongl.isCommonColumn(column)>
	//${column.remarks}
	protected ${_Ongl.javaType(column.columnDataType.databaseSpecificTypeName)}  ${Guava_CaseFormat.UPPER_UNDERSCORE.to(Guava_CaseFormat.LOWER_CAMEL, column.name)};
	</#if>
	</#list>
	
	
	//getter setter
	<#list table.columns as column>
	<#if !_Ongl.isCommonColumn(column)>
	public ${_Ongl.javaType(column.columnDataType.databaseSpecificTypeName)}  get${Guava_CaseFormat.UPPER_UNDERSCORE.to(Guava_CaseFormat.UPPER_CAMEL, column.name)}(){
		return this.${Guava_CaseFormat.UPPER_UNDERSCORE.to(Guava_CaseFormat.LOWER_CAMEL, column.name)};
	}
	
	public void set${Guava_CaseFormat.UPPER_UNDERSCORE.to(Guava_CaseFormat.UPPER_CAMEL, column.name)}( ${_Ongl.javaType(column.columnDataType.databaseSpecificTypeName)}   ${Guava_CaseFormat.UPPER_UNDERSCORE.to(Guava_CaseFormat.LOWER_CAMEL, column.name)}){
		this.${Guava_CaseFormat.UPPER_UNDERSCORE.to(Guava_CaseFormat.LOWER_CAMEL, column.name)}=${Guava_CaseFormat.UPPER_UNDERSCORE.to(Guava_CaseFormat.LOWER_CAMEL, column.name)};
	}
	</#if>
	</#list>
}


