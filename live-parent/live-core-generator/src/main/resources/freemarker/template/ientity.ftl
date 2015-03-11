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



/**
 * ${model.tabComment} Identity
 * Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     			Version       Date			Changes
 * ${vars.developer}    	1.0       ${date?string("yyyy-MM-dd HH:mm:ss")}			Created
 *
 * </pre>
 * @since 1.
 */
public interface ${class} {

<#if (pkVar!="id")>
	@Override
	public void setId(String ${pkVar}) {
		set${pkVar?cap_first}(${pkVar});
	}
	@Override
	public String getId() {
		return get${pkVar?cap_first}();
	}	
</#if>
<#list model.columnList as col>
	<#assign colName=func.convertUnderLine(col.columnName)>
	
	/**
	 * 返回 ${col.comment}
	 * @return
	 */
	public <#if (col.colType="Integer")>Long<#else>${col.colType}</#if> get${colName?cap_first}() ;
</#list>
<#if subtables?exists && subtables?size!=0>
<#list subtables as table>
<#assign vars=table.variables>
	
	/**
	 * 返回 ${table.tabComment}列表
	 * @return
	 */
	public List<${vars.class}> get${vars.classVar?cap_first}List() ;
</#list>
</#if>
	
}