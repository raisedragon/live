package ${configuration.groupId}.${configuration.system}.${table.module}.entity;

import java.util.Date;

import ${configuration.groupId}.${configuration.system}.core.entity.BaseEntity;

/**
 * ${table.jDescription} entity 
 * organization:${configuration.organization}
 * author:${configuration.author}
 * date: ${.now?string("yyyy-MM-dd HH:mm:ss")}
 * @since 1.
 */
public class ${table.jName} extends BaseEntity<${table.primaryKeyJavaType}> {
	
	private static final long serialVersionUID = 1L;
	
	<#list table.columns as column>
	<#if !column.commonColumn>
	//${column.jDescription}
	protected ${column.jType.name}  ${column.jNameLowerCamel};
	</#if>
	</#list>
	
	
	//getter setter
	<#list table.columns as column>
	<#if !column.commonColumn>
	public ${column.jType.name}  get${column.jName}(){
		return this.${column.jNameLowerCamel};
	}
	
	public void set${column.jName}(${column.jType.name} ${column.jNameLowerCamel}){
		this.${column.jNameLowerCamel}=${column.jNameLowerCamel};
	}
	</#if>
	</#list>
}


