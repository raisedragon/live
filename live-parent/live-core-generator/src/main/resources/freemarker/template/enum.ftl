package ${properties.groupId}.${properties.system}.${table.module}.entity;
/**
 * Enum
 * organization:${properties.organization}
 * author:${properties.author}
 * date: ${.now?string("yyyy-MM-dd HH:mm:ss")}
 * @since 1.
 */
public enum ${enum.name} {
	<#list enum.values as value>
	${value}<#if value_has_next>,<#else>;</#if>
	</#list>
	
	public String value() {
	    return name();
	}
	
	public static ${enum.name} fromValue(String v) {
	    return valueOf(v);
	}
}
