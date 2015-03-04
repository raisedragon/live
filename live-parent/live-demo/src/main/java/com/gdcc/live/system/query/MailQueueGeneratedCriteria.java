package com.gdcc.live.system.query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gdcc.live.core.query.Criterion;

abstract class MailQueueGeneratedCriteria {

    protected List<Criterion> criteria;

    protected MailQueueGeneratedCriteria(){
        super();
        criteria = new ArrayList<Criterion>();
    }

    public boolean isValid() {
        return criteria.size() > 0;
    }

    public List<Criterion> getCriteria() {
        return criteria;
    }

    protected void addCriterion(String condition) {
        if (condition == null) {
            throw new RuntimeException("Value for condition cannot be null");
        }
        criteria.add(new Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
        if (value == null) {
            throw new RuntimeException("Value for " + property + " cannot be null");
        }
        criteria.add(new Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
        if (value1 == null || value2 == null) {
            throw new RuntimeException("Between values for " + property + " cannot be null");
        }
        criteria.add(new Criterion(condition, value1, value2));
    }

    /* ID */
    public MailQueueCriteria andIdIsNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_id + " is null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andIdIsNotNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_id + " is not null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andIdEqualTo(Long value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_id + " =", value, "id");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andIdBetween(Long value1, Long value2) {
        addCriterion(MailQueueProperty.COLUMN_NAME_id + " between", value1, value2, "id");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andIdIn(List<Long> values) {
        addCriterion(MailQueueProperty.COLUMN_NAME_id + " in", values, "id");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andIdGreaterThan(Long value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_id + " >", value, "id");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andIdGreaterThanOrEqualTo(Long value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_id + " >=", value, "id");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andIdLessThan(Long value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_id + " <", value, "id");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andIdLessThanOrEqualTo(Long value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_id + " <=", value, "id");
        return (MailQueueCriteria) this;
    }

    /* 万邑通发货单号 */
    public MailQueueCriteria andManifestNoIsNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_manifestNo + " is null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andManifestNoIsNotNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_manifestNo + " is not null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andManifestNoEqualTo(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_manifestNo + " =", value, "manifestNo");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andManifestNoBetween(String value1, String value2) {
        addCriterion(MailQueueProperty.COLUMN_NAME_manifestNo + " between", value1, value2, "manifestNo");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andManifestNoIn(List<String> values) {
        addCriterion(MailQueueProperty.COLUMN_NAME_manifestNo + " in", values, "manifestNo");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andManifestNoLike(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_manifestNo + " like", value, "manifestNo");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andManifestNoNotLike(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_manifestNo + " not like", value, "manifestNo");
        return (MailQueueCriteria) this;
    }

    /* 邮件标题 */
    public MailQueueCriteria andSubjectIsNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_subject + " is null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andSubjectIsNotNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_subject + " is not null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andSubjectEqualTo(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_subject + " =", value, "subject");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andSubjectBetween(String value1, String value2) {
        addCriterion(MailQueueProperty.COLUMN_NAME_subject + " between", value1, value2, "subject");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andSubjectIn(List<String> values) {
        addCriterion(MailQueueProperty.COLUMN_NAME_subject + " in", values, "subject");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andSubjectLike(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_subject + " like", value, "subject");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andSubjectNotLike(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_subject + " not like", value, "subject");
        return (MailQueueCriteria) this;
    }

    /* 邮件内容 */
    public MailQueueCriteria andContentIsNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_content + " is null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andContentIsNotNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_content + " is not null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andContentEqualTo(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_content + " =", value, "content");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andContentBetween(String value1, String value2) {
        addCriterion(MailQueueProperty.COLUMN_NAME_content + " between", value1, value2, "content");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andContentIn(List<String> values) {
        addCriterion(MailQueueProperty.COLUMN_NAME_content + " in", values, "content");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andContentLike(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_content + " like", value, "content");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andContentNotLike(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_content + " not like", value, "content");
        return (MailQueueCriteria) this;
    }

    /* 邮件附件 */
    public MailQueueCriteria andAttachmentIsNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_attachment + " is null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andAttachmentIsNotNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_attachment + " is not null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andAttachmentEqualTo(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_attachment + " =", value, "attachment");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andAttachmentBetween(String value1, String value2) {
        addCriterion(MailQueueProperty.COLUMN_NAME_attachment + " between", value1, value2, "attachment");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andAttachmentIn(List<String> values) {
        addCriterion(MailQueueProperty.COLUMN_NAME_attachment + " in", values, "attachment");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andAttachmentLike(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_attachment + " like", value, "attachment");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andAttachmentNotLike(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_attachment + " not like", value, "attachment");
        return (MailQueueCriteria) this;
    }

    /* 收件人 */
    public MailQueueCriteria andSendToIsNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_sendTo + " is null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andSendToIsNotNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_sendTo + " is not null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andSendToEqualTo(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_sendTo + " =", value, "sendTo");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andSendToBetween(String value1, String value2) {
        addCriterion(MailQueueProperty.COLUMN_NAME_sendTo + " between", value1, value2, "sendTo");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andSendToIn(List<String> values) {
        addCriterion(MailQueueProperty.COLUMN_NAME_sendTo + " in", values, "sendTo");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andSendToLike(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_sendTo + " like", value, "sendTo");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andSendToNotLike(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_sendTo + " not like", value, "sendTo");
        return (MailQueueCriteria) this;
    }

    /* 抄送 */
    public MailQueueCriteria andCcIsNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_cc + " is null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andCcIsNotNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_cc + " is not null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andCcEqualTo(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_cc + " =", value, "cc");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andCcBetween(String value1, String value2) {
        addCriterion(MailQueueProperty.COLUMN_NAME_cc + " between", value1, value2, "cc");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andCcIn(List<String> values) {
        addCriterion(MailQueueProperty.COLUMN_NAME_cc + " in", values, "cc");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andCcLike(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_cc + " like", value, "cc");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andCcNotLike(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_cc + " not like", value, "cc");
        return (MailQueueCriteria) this;
    }

    /* 密抄 */
    public MailQueueCriteria andBccIsNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_bcc + " is null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andBccIsNotNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_bcc + " is not null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andBccEqualTo(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_bcc + " =", value, "bcc");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andBccBetween(String value1, String value2) {
        addCriterion(MailQueueProperty.COLUMN_NAME_bcc + " between", value1, value2, "bcc");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andBccIn(List<String> values) {
        addCriterion(MailQueueProperty.COLUMN_NAME_bcc + " in", values, "bcc");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andBccLike(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_bcc + " like", value, "bcc");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andBccNotLike(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_bcc + " not like", value, "bcc");
        return (MailQueueCriteria) this;
    }

    /* 状态 */
    public MailQueueCriteria andStatusIsNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_status + " is null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andStatusIsNotNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_status + " is not null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andStatusEqualTo(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_status + " =", value, "status");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andStatusBetween(String value1, String value2) {
        addCriterion(MailQueueProperty.COLUMN_NAME_status + " between", value1, value2, "status");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andStatusIn(List<String> values) {
        addCriterion(MailQueueProperty.COLUMN_NAME_status + " in", values, "status");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andStatusLike(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_status + " like", value, "status");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andStatusNotLike(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_status + " not like", value, "status");
        return (MailQueueCriteria) this;
    }

    /* 组织ID */
    public MailQueueCriteria andOrganizationIdIsNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_organizationId + " is null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andOrganizationIdIsNotNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_organizationId + " is not null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andOrganizationIdEqualTo(Long value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_organizationId + " =", value, "organizationId");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andOrganizationIdBetween(Long value1, Long value2) {
        addCriterion(MailQueueProperty.COLUMN_NAME_organizationId + " between", value1, value2, "organizationId");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andOrganizationIdIn(List<Long> values) {
        addCriterion(MailQueueProperty.COLUMN_NAME_organizationId + " in", values, "organizationId");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andOrganizationIdGreaterThan(Long value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_organizationId + " >", value, "organizationId");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andOrganizationIdGreaterThanOrEqualTo(Long value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_organizationId + " >=", value, "organizationId");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andOrganizationIdLessThan(Long value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_organizationId + " <", value, "organizationId");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andOrganizationIdLessThanOrEqualTo(Long value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_organizationId + " <=", value, "organizationId");
        return (MailQueueCriteria) this;
    }

    /* 创建时间 */
    public MailQueueCriteria andCreatedIsNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_created + " is null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andCreatedIsNotNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_created + " is not null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andCreatedEqualTo(Date value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_created + " =", value, "created");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andCreatedBetween(Date value1, Date value2) {
        addCriterion(MailQueueProperty.COLUMN_NAME_created + " between", value1, value2, "created");
        return (MailQueueCriteria) this;
    }

    /* 创建人 */
    public MailQueueCriteria andCreatedbyIsNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_createdby + " is null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andCreatedbyIsNotNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_createdby + " is not null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andCreatedbyEqualTo(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_createdby + " =", value, "createdby");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andCreatedbyBetween(String value1, String value2) {
        addCriterion(MailQueueProperty.COLUMN_NAME_createdby + " between", value1, value2, "createdby");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andCreatedbyIn(List<String> values) {
        addCriterion(MailQueueProperty.COLUMN_NAME_createdby + " in", values, "createdby");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andCreatedbyLike(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_createdby + " like", value, "createdby");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andCreatedbyNotLike(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_createdby + " not like", value, "createdby");
        return (MailQueueCriteria) this;
    }

    /* 更新时间 */
    public MailQueueCriteria andUpdatedIsNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_updated + " is null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andUpdatedIsNotNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_updated + " is not null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andUpdatedEqualTo(Date value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_updated + " =", value, "updated");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andUpdatedBetween(Date value1, Date value2) {
        addCriterion(MailQueueProperty.COLUMN_NAME_updated + " between", value1, value2, "updated");
        return (MailQueueCriteria) this;
    }

    /* 更新人 */
    public MailQueueCriteria andUpdatedbyIsNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_updatedby + " is null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andUpdatedbyIsNotNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_updatedby + " is not null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andUpdatedbyEqualTo(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_updatedby + " =", value, "updatedby");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andUpdatedbyBetween(String value1, String value2) {
        addCriterion(MailQueueProperty.COLUMN_NAME_updatedby + " between", value1, value2, "updatedby");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andUpdatedbyIn(List<String> values) {
        addCriterion(MailQueueProperty.COLUMN_NAME_updatedby + " in", values, "updatedby");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andUpdatedbyLike(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_updatedby + " like", value, "updatedby");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andUpdatedbyNotLike(String value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_updatedby + " not like", value, "updatedby");
        return (MailQueueCriteria) this;
    }

    /* 是否有效 */
    public MailQueueCriteria andIsActiveIsNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_isActive + " is null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andIsActiveIsNotNull() {
        addCriterion(MailQueueProperty.COLUMN_NAME_isActive + " is not null");
        return (MailQueueCriteria) this;
    }

    public MailQueueCriteria andIsActiveEqualTo(Boolean value) {
        addCriterion(MailQueueProperty.COLUMN_NAME_isActive + " =", value, "isActive");
        return (MailQueueCriteria) this;
    }

}
