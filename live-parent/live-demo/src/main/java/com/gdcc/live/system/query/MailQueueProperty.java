package com.gdcc.live.system.query;

/**
 * 邮件队列 Property对象 Change to the actual description of this class
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
public abstract class MailQueueProperty {

    public static String       TABLE_NAME                 = "VMS_SYS_MAIL_QUEUE";
    public static final String COLUMN_NAME_id             = "ID";                /* ID */
    public static final String COLUMN_NAME_manifestNo     = "MANIFEST_NO";       /* 万邑通发货单号 */
    public static final String COLUMN_NAME_subject        = "SUBJECT";           /* 邮件标题 */
    public static final String COLUMN_NAME_content        = "CONTENT";           /* 邮件内容 */
    public static final String COLUMN_NAME_attachment     = "ATTACHMENT";        /* 邮件附件 */
    public static final String COLUMN_NAME_sendTo         = "SEND_TO";           /* 收件人 */
    public static final String COLUMN_NAME_cc             = "CC";                /* 抄送 */
    public static final String COLUMN_NAME_bcc            = "BCC";               /* 密抄 */
    public static final String COLUMN_NAME_status         = "STATUS";            /* 状态 */
    public static final String COLUMN_NAME_organizationId = "ORGANIZATION_ID";   /* 组织ID */
    public static final String COLUMN_NAME_created        = "CREATED";           /* 创建时间 */
    public static final String COLUMN_NAME_createdby      = "CREATEDBY";         /* 创建人 */
    public static final String COLUMN_NAME_updated        = "UPDATED";           /* 更新时间 */
    public static final String COLUMN_NAME_updatedby      = "UPDATEDBY";         /* 更新人 */
    public static final String COLUMN_NAME_isActive       = "IS_ACTIVE";         /* 是否有效 */
    public static final String COLUMN_NAME_isDelete       = "IS_DELETE";         /* 是否删除 */
}
