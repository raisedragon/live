package com.gdcc.live.system.query;

/**
 * 系统配置项 Property对象 Change to the actual description of this class
 * 
 * @version Revision History
 * 
 * <pre>
 * Author     			Version       Date			Changes
 * longsheng.wang    	1.0       2015-01-29 15:12:16			Created
 * 
 * </pre>
 * @since 1.
 */
public abstract class ConfigProperty {

    public static String       TABLE_NAME                 = "VMS_SYS_CONFIG";
    public static final String COLUMN_NAME_id             = "ID";             /* ID */
    public static final String COLUMN_NAME_name           = "NAME";           /* 名称 */
    public static final String COLUMN_NAME_value          = "VALUE";          /* 值 */
    public static final String COLUMN_NAME_description    = "DESCRIPTION";    /* 描述 */
    public static final String COLUMN_NAME_organizationId = "ORGANIZATION_ID"; /* 组织ID */
    public static final String COLUMN_NAME_created        = "CREATED";        /* 创建时间 */
    public static final String COLUMN_NAME_createdby      = "CREATEDBY";      /* 创建人 */
    public static final String COLUMN_NAME_updated        = "UPDATED";        /* 更新时间 */
    public static final String COLUMN_NAME_updatedby      = "UPDATEDBY";      /* 更新人 */
    public static final String COLUMN_NAME_isActive       = "IS_ACTIVE";      /* 是否有效 */
    public static final String COLUMN_NAME_isDelete       = "IS_DELETE";      /* 是否删除 */
}
