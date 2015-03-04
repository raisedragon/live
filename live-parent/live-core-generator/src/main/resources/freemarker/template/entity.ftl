package ${properties.basepackage}.${module}.${pkg}.entity;

import java.util.Date;

import ${properties.basepackage}.core.entity.BaseEntity;

/**
 * ${table.remarks} entity 
 * company:${properties.company}
 * author:${properties.developer}
 * date: ${currentDate?string("yyyy-MM-dd HH:mm:ss")}
 * @since 1.
 */
public class ${clazz} extends BaseEntity<${_Ongl.javaType(primaryKey)}> {
	
	private static final long serialVersionUID = 1L;
	
	<#list table.columns as column>
	//${column.remarks}
	<#if !_Ongl.isCommonColumn(column)>
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


