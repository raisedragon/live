<#import "function.ftl" as func>
<#assign package=model.variables.package>
<#assign class=model.variables.class>
<#assign system=vars.system>
package com.winit.${system}.${package}.query;

/**
 * ${model.tabComment} Property对象
 * Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     			Version       Date			Changes
 * ${vars.developer}    	1.0       ${date?string("yyyy-MM-dd HH:mm:ss")}			Created
 *
 * </pre>
 * @since 1.
 */
public abstract class ${class}Property{
	public static String TABLE_NAME="${model.tableName}";
	<#list model.columnList as col>
		<#assign colName=func.convertUnderLine(col.columnName)>
	public static final String COLUMN_NAME_${colName}="${col.columnName}"; /*${col.comment}*/
	</#list>
}