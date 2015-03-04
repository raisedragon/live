package com.gdcc.live.system.query;

/**
 * 定时作业 Property对象 Change to the actual description of this class
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
public abstract class SchedulerJobProperty {

    public static String       TABLE_NAME                 = "VMS_SYS_SCHEDULER";
    public static final String COLUMN_NAME_id             = "ID";               /* 主键ID */
    public static final String COLUMN_NAME_jobName        = "JOB_NAME";         /* 定时任务名称 */
    public static final String COLUMN_NAME_beanClass      = "BEAN_CLASS";       /* 定时任务类 */
    public static final String COLUMN_NAME_methodName     = "METHOD_NAME";      /* 定时任务方法名 */
    public static final String COLUMN_NAME_cronExpression = "CRON_EXPRESSION";  /* 定时任务时间表达式 */
    public static final String COLUMN_NAME_ipAddress      = "IP_ADDRESS";       /*
                                                                                  * 哪台服务器使用
                                                                                  * ,
                                                                                  * 为空则全部服务器都可执行
                                                                                  */
    public static final String COLUMN_NAME_jobStatus      = "JOB_STATUS";       /*
                                                                                  * 任务状态
                                                                                  * :
                                                                                  * 0
                                                                                  * 不启用
                                                                                  * ，
                                                                                  * 1
                                                                                  * 启用
                                                                                  */
    public static final String COLUMN_NAME_code           = "CODE";             /* 定时任务编码 */
    public static final String COLUMN_NAME_jobGroup       = "JOB_GROUP";        /* 任务分组 */
    public static final String COLUMN_NAME_springId       = "SPRING_ID";        /* SPRING配置文件中引入BEAN的声明式ID */
    public static final String COLUMN_NAME_isConcurrent   = "IS_CONCURRENT";    /*
                                                                                  * 工作状态
                                                                                  * :
                                                                                  * 0
                                                                                  * 异步
                                                                                  * ，
                                                                                  * 1
                                                                                  * 同步
                                                                                  */
    public static final String COLUMN_NAME_organizationId = "ORGANIZATION_ID";  /* 组织ID */
    public static final String COLUMN_NAME_created        = "CREATED";          /* 创建时间 */
    public static final String COLUMN_NAME_createdby      = "CREATEDBY";        /* 创建人 */
    public static final String COLUMN_NAME_updated        = "UPDATED";          /* 更新时间 */
    public static final String COLUMN_NAME_updatedby      = "UPDATEDBY";        /* 更新人 */
    public static final String COLUMN_NAME_isActive       = "IS_ACTIVE";        /* 是否有效 */
    public static final String COLUMN_NAME_isDelete       = "IS_DELETE";        /* 是否删除 */
}
