package com.gdcc.live.system.query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gdcc.live.core.query.SetData;
import com.winit.common.query.Sort;

/**
 * 邮件队列 Query对象 Change to the actual description of this class
 * 
 * @version Revision History
 * 
 * <pre>
 * Author     			Version       Date			Changes
 * longsheng.wang    	1.0       2015-01-26 09:52:56			Created
 * 
 * </pre>
 * @since 1.
 */
public class MailQueueQuery {

    public static class FindQuery {

        protected List<MailQueueCriteria> oredCriteria;

        protected Sort                    sort;

        protected boolean                 first;

        public FindQuery(){
            oredCriteria = new ArrayList<MailQueueCriteria>();
        }

        public Sort getSort() {
            return sort;
        }

        public List<MailQueueCriteria> getOredCriteria() {
            return oredCriteria;
        }

        public void or(MailQueueCriteria criteria) {
            oredCriteria.add(criteria);
        }

        public MailQueueCriteria or() {
            MailQueueCriteria criteria = createCriteriaInternal();
            oredCriteria.add(criteria);
            return criteria;
        }

        public MailQueueCriteria createCriteria() {
            MailQueueCriteria criteria = createCriteriaInternal();
            if (oredCriteria.size() == 0) {
                oredCriteria.add(criteria);
            }
            return criteria;
        }

        protected MailQueueCriteria createCriteriaInternal() {
            MailQueueCriteria criteria = new MailQueueCriteria();
            return criteria;
        }

        public FindQuery first() {
            first = true;
            return this;
        }

        public void clear() {
            oredCriteria.clear();
            sort = null;
            first = false;
        }
    }

    public static class UpdateQuery {

        protected UpdateClause            updateClause;

        protected List<MailQueueCriteria> oredCriteria;

        public UpdateClause getUpdateClause() {
            return updateClause;
        }

        public List<MailQueueCriteria> getOredCriteria() {
            return oredCriteria;
        }

        public void or(MailQueueCriteria criteria) {
            oredCriteria.add(criteria);
        }

        public MailQueueCriteria or() {
            MailQueueCriteria criteria = createCriteriaInternal();
            oredCriteria.add(criteria);
            return criteria;
        }

        public MailQueueCriteria createCriteria() {
            MailQueueCriteria criteria = createCriteriaInternal();
            if (oredCriteria.size() == 0) {
                oredCriteria.add(criteria);
            }
            return criteria;
        }

        protected MailQueueCriteria createCriteriaInternal() {
            MailQueueCriteria criteria = new MailQueueCriteria();
            return criteria;
        }

        public UpdateQuery(){
            oredCriteria = new ArrayList<MailQueueCriteria>();
            updateClause = new UpdateClause();
        }

    }

    public static class UpdateClause {

        protected List<SetData> dataClauses;

        public List<SetData> getdataClauses() {
            if (dataClauses.size() == 0) {
                throw new RuntimeException("更新的数据，必须指定");
            }
            return dataClauses;
        }

        protected UpdateClause(){
            this.dataClauses = new ArrayList<SetData>();
        }

        /* 设置 万邑通发货单号 */
        public void setManifestNo(String manifestNo) {
            dataClauses.add(new SetData(MailQueueProperty.COLUMN_NAME_manifestNo + " = ", manifestNo));
        }

        /* 设置 邮件标题 */
        public void setSubject(String subject) {
            dataClauses.add(new SetData(MailQueueProperty.COLUMN_NAME_subject + " = ", subject));
        }

        /* 设置 邮件内容 */
        public void setContent(String content) {
            dataClauses.add(new SetData(MailQueueProperty.COLUMN_NAME_content + " = ", content));
        }

        /* 设置 邮件附件 */
        public void setAttachment(String attachment) {
            dataClauses.add(new SetData(MailQueueProperty.COLUMN_NAME_attachment + " = ", attachment));
        }

        /* 设置 收件人 */
        public void setSendTo(String sendTo) {
            dataClauses.add(new SetData(MailQueueProperty.COLUMN_NAME_sendTo + " = ", sendTo));
        }

        /* 设置 抄送 */
        public void setCc(String cc) {
            dataClauses.add(new SetData(MailQueueProperty.COLUMN_NAME_cc + " = ", cc));
        }

        /* 设置 密抄 */
        public void setBcc(String bcc) {
            dataClauses.add(new SetData(MailQueueProperty.COLUMN_NAME_bcc + " = ", bcc));
        }

        /* 设置 状态 */
        public void setStatus(String status) {
            dataClauses.add(new SetData(MailQueueProperty.COLUMN_NAME_status + " = ", status));
        }

        /* 设置 组织ID */
        public void setOrganizationId(Long organizationId) {
            dataClauses.add(new SetData(MailQueueProperty.COLUMN_NAME_organizationId + " = ", organizationId));
        }

        /* 设置 创建时间 */
        public void setCreated(Date created) {
            dataClauses.add(new SetData(MailQueueProperty.COLUMN_NAME_created + " = ", created));
        }

        /* 设置 创建人 */
        public void setCreatedby(String createdby) {
            dataClauses.add(new SetData(MailQueueProperty.COLUMN_NAME_createdby + " = ", createdby));
        }

        /* 设置 更新时间 */
        public void setUpdated(Date updated) {
            dataClauses.add(new SetData(MailQueueProperty.COLUMN_NAME_updated + " = ", updated));
        }

        /* 设置 更新人 */
        public void setUpdatedby(String updatedby) {
            dataClauses.add(new SetData(MailQueueProperty.COLUMN_NAME_updatedby + " = ", updatedby));
        }

        /* 设置 是否有效 */
        public void setIsActive(Boolean isActive) {
            dataClauses.add(new SetData(MailQueueProperty.COLUMN_NAME_isActive + " = ", isActive));
        }

        /* 设置 是否删除 */
        public void setIsDelete(Boolean isDelete) {
            dataClauses.add(new SetData(MailQueueProperty.COLUMN_NAME_isDelete + " = ", isDelete));
        }

    }
}
