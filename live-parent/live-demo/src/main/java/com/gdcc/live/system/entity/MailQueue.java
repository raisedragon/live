package com.gdcc.live.system.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.gdcc.live.core.entity.BaseEntity;

/**
 * 邮件队列 Entity Change to the actual description of this class
 * 
 * @version Revision History
 * 
 * <pre>
 * Author     			Version       Date			Changes
 * Stringsheng.wang    	1.0       2015-01-26 09:52:56			Created
 * 
 * </pre>
 * @since 1.
 */
@SuppressWarnings("serial")
public class MailQueue extends BaseEntity<String> {

    protected String   id;        /* ID */
    protected String manifestNo; /* 万邑通发货单号 */
    protected String subject;   /* 邮件标题 */
    protected String content;   /* 邮件内容 */
    protected String attachment; /* 邮件附件 */
    protected String sendTo;    /* 收件人 */
    protected String cc;        /* 抄送 */
    protected String bcc;       /* 密抄 */
    protected String status;    /* 状态 */

    public void setId(String id) {
        this.id = id;
    }

    /**
     * 返回 ID
     * 
     * @return
     */
    public String getId() {
        return this.id;
    }

    public void setManifestNo(String manifestNo) {
        this.manifestNo = manifestNo;
    }

    /**
     * 返回 万邑通发货单号
     * 
     * @return
     */
    public String getManifestNo() {
        return this.manifestNo;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * 返回 邮件标题
     * 
     * @return
     */
    public String getSubject() {
        return this.subject;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 返回 邮件内容
     * 
     * @return
     */
    public String getContent() {
        return this.content;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    /**
     * 返回 邮件附件
     * 
     * @return
     */
    public String getAttachment() {
        return this.attachment;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    /**
     * 返回 收件人
     * 
     * @return
     */
    public String getSendTo() {
        return this.sendTo;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    /**
     * 返回 抄送
     * 
     * @return
     */
    public String getCc() {
        return this.cc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    /**
     * 返回 密抄
     * 
     * @return
     */
    public String getBcc() {
        return this.bcc;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 返回 状态
     * 
     * @return
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("id", this.id)
            .append("manifestNo", this.manifestNo)
            .append("subject", this.subject)
            .append("content", this.content)
            .append("attachment", this.attachment)
            .append("sendTo", this.sendTo)
            .append("cc", this.cc)
            .append("bcc", this.bcc)
            .append("status", this.status)
            .append("organizationId", this.organizationId)
            .append("created", this.created)
            .append("createdby", this.createdby)
            .append("updated", this.updated)
            .append("updatedby", this.updatedby)
            .append("isActive", this.isActive)
            .append("isDelete", this.isDelete)
            .toString();
    }
}
