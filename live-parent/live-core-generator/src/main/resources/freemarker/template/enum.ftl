package ${configuration.groupId}.${configuration.system}.${table.module}.entity;
/**
 * Enum
 * organization:${configuration.organization}
 * author:${configuration.author}
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
