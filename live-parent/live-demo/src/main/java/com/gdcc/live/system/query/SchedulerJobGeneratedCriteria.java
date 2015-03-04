package com.gdcc.live.system.query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gdcc.live.core.query.Criterion;

abstract class SchedulerJobGeneratedCriteria {

    protected List<Criterion> criteria;

    protected SchedulerJobGeneratedCriteria(){
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

    public SchedulerJobCriteria andIdIsNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_id + " is null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andIdIsNotNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_id + " is not null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andIdEqualTo(Long value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_id + " =", value, "id");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andIdBetween(Long value1, Long value2) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_id + " between", value1, value2, "id");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andIdIn(List<Long> values) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_id + " in", values, "id");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andIdGreaterThan(Long value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_id + " >", value, "id");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andIdGreaterThanOrEqualTo(Long value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_id + " >=", value, "id");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andIdLessThan(Long value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_id + " <", value, "id");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andIdLessThanOrEqualTo(Long value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_id + " <=", value, "id");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andJobNameIsNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_jobName + " is null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andJobNameIsNotNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_jobName + " is not null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andJobNameEqualTo(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_jobName + " =", value, "jobName");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andJobNameBetween(String value1, String value2) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_jobName + " between", value1, value2, "jobName");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andJobNameIn(List<String> values) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_jobName + " in", values, "jobName");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andJobNameLike(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_jobName + " like", value, "jobName");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andJobNameNotLike(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_jobName + " not like", value, "jobName");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andBeanClassIsNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_beanClass + " is null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andBeanClassIsNotNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_beanClass + " is not null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andBeanClassEqualTo(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_beanClass + " =", value, "beanClass");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andBeanClassBetween(String value1, String value2) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_beanClass + " between", value1, value2, "beanClass");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andBeanClassIn(List<String> values) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_beanClass + " in", values, "beanClass");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andBeanClassLike(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_beanClass + " like", value, "beanClass");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andBeanClassNotLike(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_beanClass + " not like", value, "beanClass");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andMethodNameIsNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_methodName + " is null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andMethodNameIsNotNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_methodName + " is not null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andMethodNameEqualTo(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_methodName + " =", value, "methodName");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andMethodNameBetween(String value1, String value2) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_methodName + " between", value1, value2, "methodName");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andMethodNameIn(List<String> values) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_methodName + " in", values, "methodName");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andMethodNameLike(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_methodName + " like", value, "methodName");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andMethodNameNotLike(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_methodName + " not like", value, "methodName");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andCronExpressionIsNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_cronExpression + " is null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andCronExpressionIsNotNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_cronExpression + " is not null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andCronExpressionEqualTo(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_cronExpression + " =", value, "cronExpression");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andCronExpressionBetween(String value1, String value2) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_cronExpression + " between", value1, value2, "cronExpression");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andCronExpressionIn(List<String> values) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_cronExpression + " in", values, "cronExpression");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andCronExpressionLike(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_cronExpression + " like", value, "cronExpression");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andCronExpressionNotLike(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_cronExpression + " not like", value, "cronExpression");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andIpAddressIsNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_ipAddress + " is null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andIpAddressIsNotNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_ipAddress + " is not null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andIpAddressEqualTo(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_ipAddress + " =", value, "ipAddress");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andIpAddressBetween(String value1, String value2) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_ipAddress + " between", value1, value2, "ipAddress");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andIpAddressIn(List<String> values) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_ipAddress + " in", values, "ipAddress");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andIpAddressLike(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_ipAddress + " like", value, "ipAddress");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andIpAddressNotLike(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_ipAddress + " not like", value, "ipAddress");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andJobStatusIsNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_jobStatus + " is null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andJobStatusIsNotNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_jobStatus + " is not null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andJobStatusEqualTo(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_jobStatus + " =", value, "jobStatus");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andJobStatusBetween(String value1, String value2) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_jobStatus + " between", value1, value2, "jobStatus");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andJobStatusIn(List<String> values) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_jobStatus + " in", values, "jobStatus");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andJobStatusLike(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_jobStatus + " like", value, "jobStatus");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andJobStatusNotLike(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_jobStatus + " not like", value, "jobStatus");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andCodeIsNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_code + " is null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andCodeIsNotNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_code + " is not null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andCodeEqualTo(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_code + " =", value, "code");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andCodeBetween(String value1, String value2) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_code + " between", value1, value2, "code");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andCodeIn(List<String> values) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_code + " in", values, "code");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andCodeLike(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_code + " like", value, "code");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andCodeNotLike(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_code + " not like", value, "code");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andJobGroupIsNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_jobGroup + " is null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andJobGroupIsNotNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_jobGroup + " is not null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andJobGroupEqualTo(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_jobGroup + " =", value, "jobGroup");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andJobGroupBetween(String value1, String value2) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_jobGroup + " between", value1, value2, "jobGroup");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andJobGroupIn(List<String> values) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_jobGroup + " in", values, "jobGroup");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andJobGroupLike(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_jobGroup + " like", value, "jobGroup");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andJobGroupNotLike(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_jobGroup + " not like", value, "jobGroup");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andSpringIdIsNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_springId + " is null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andSpringIdIsNotNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_springId + " is not null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andSpringIdEqualTo(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_springId + " =", value, "springId");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andSpringIdBetween(String value1, String value2) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_springId + " between", value1, value2, "springId");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andSpringIdIn(List<String> values) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_springId + " in", values, "springId");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andSpringIdLike(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_springId + " like", value, "springId");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andSpringIdNotLike(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_springId + " not like", value, "springId");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andIsConcurrentIsNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_isConcurrent + " is null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andIsConcurrentIsNotNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_isConcurrent + " is not null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andIsConcurrentEqualTo(Boolean value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_isConcurrent + " =", value, "isConcurrent");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andOrganizationIdIsNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_organizationId + " is null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andOrganizationIdIsNotNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_organizationId + " is not null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andOrganizationIdEqualTo(Long value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_organizationId + " =", value, "organizationId");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andOrganizationIdBetween(Long value1, Long value2) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_organizationId + " between", value1, value2, "organizationId");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andOrganizationIdIn(List<Long> values) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_organizationId + " in", values, "organizationId");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andOrganizationIdGreaterThan(Long value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_organizationId + " >", value, "organizationId");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andOrganizationIdGreaterThanOrEqualTo(Long value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_organizationId + " >=", value, "organizationId");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andOrganizationIdLessThan(Long value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_organizationId + " <", value, "organizationId");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andOrganizationIdLessThanOrEqualTo(Long value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_organizationId + " <=", value, "organizationId");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andCreatedIsNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_created + " is null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andCreatedIsNotNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_created + " is not null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andCreatedEqualTo(Date value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_created + " =", value, "created");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andCreatedBetween(Date value1, Date value2) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_created + " between", value1, value2, "created");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andCreatedbyIsNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_createdby + " is null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andCreatedbyIsNotNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_createdby + " is not null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andCreatedbyEqualTo(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_createdby + " =", value, "createdby");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andCreatedbyBetween(String value1, String value2) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_createdby + " between", value1, value2, "createdby");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andCreatedbyIn(List<String> values) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_createdby + " in", values, "createdby");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andCreatedbyLike(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_createdby + " like", value, "createdby");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andCreatedbyNotLike(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_createdby + " not like", value, "createdby");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andUpdatedIsNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_updated + " is null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andUpdatedIsNotNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_updated + " is not null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andUpdatedEqualTo(Date value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_updated + " =", value, "updated");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andUpdatedBetween(Date value1, Date value2) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_updated + " between", value1, value2, "updated");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andUpdatedbyIsNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_updatedby + " is null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andUpdatedbyIsNotNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_updatedby + " is not null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andUpdatedbyEqualTo(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_updatedby + " =", value, "updatedby");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andUpdatedbyBetween(String value1, String value2) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_updatedby + " between", value1, value2, "updatedby");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andUpdatedbyIn(List<String> values) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_updatedby + " in", values, "updatedby");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andUpdatedbyLike(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_updatedby + " like", value, "updatedby");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andUpdatedbyNotLike(String value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_updatedby + " not like", value, "updatedby");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andIsActiveIsNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_isActive + " is null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andIsActiveIsNotNull() {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_isActive + " is not null");
        return (SchedulerJobCriteria) this;
    }

    public SchedulerJobCriteria andIsActiveEqualTo(Boolean value) {
        addCriterion(SchedulerJobProperty.COLUMN_NAME_isActive + " =", value, "isActive");
        return (SchedulerJobCriteria) this;
    }

}
