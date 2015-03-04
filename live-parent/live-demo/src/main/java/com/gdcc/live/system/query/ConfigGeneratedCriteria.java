package com.gdcc.live.system.query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gdcc.live.core.query.Criterion;

abstract class ConfigGeneratedCriteria {

    protected List<Criterion> criteria;

    protected ConfigGeneratedCriteria(){
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

    public ConfigCriteria andIdIsNull() {
        addCriterion(ConfigProperty.COLUMN_NAME_id + " is null");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andIdIsNotNull() {
        addCriterion(ConfigProperty.COLUMN_NAME_id + " is not null");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andIdEqualTo(Long value) {
        addCriterion(ConfigProperty.COLUMN_NAME_id + " =", value, "id");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andIdBetween(Long value1, Long value2) {
        addCriterion(ConfigProperty.COLUMN_NAME_id + " between", value1, value2, "id");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andIdIn(List<Long> values) {
        addCriterion(ConfigProperty.COLUMN_NAME_id + " in", values, "id");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andIdGreaterThan(Long value) {
        addCriterion(ConfigProperty.COLUMN_NAME_id + " >", value, "id");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andIdGreaterThanOrEqualTo(Long value) {
        addCriterion(ConfigProperty.COLUMN_NAME_id + " >=", value, "id");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andIdLessThan(Long value) {
        addCriterion(ConfigProperty.COLUMN_NAME_id + " <", value, "id");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andIdLessThanOrEqualTo(Long value) {
        addCriterion(ConfigProperty.COLUMN_NAME_id + " <=", value, "id");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andNameIsNull() {
        addCriterion(ConfigProperty.COLUMN_NAME_name + " is null");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andNameIsNotNull() {
        addCriterion(ConfigProperty.COLUMN_NAME_name + " is not null");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andNameEqualTo(String value) {
        addCriterion(ConfigProperty.COLUMN_NAME_name + " =", value, "name");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andNameBetween(String value1, String value2) {
        addCriterion(ConfigProperty.COLUMN_NAME_name + " between", value1, value2, "name");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andNameIn(List<String> values) {
        addCriterion(ConfigProperty.COLUMN_NAME_name + " in", values, "name");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andNameLike(String value) {
        addCriterion(ConfigProperty.COLUMN_NAME_name + " like", value, "name");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andNameNotLike(String value) {
        addCriterion(ConfigProperty.COLUMN_NAME_name + " not like", value, "name");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andValueIsNull() {
        addCriterion(ConfigProperty.COLUMN_NAME_value + " is null");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andValueIsNotNull() {
        addCriterion(ConfigProperty.COLUMN_NAME_value + " is not null");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andValueEqualTo(String value) {
        addCriterion(ConfigProperty.COLUMN_NAME_value + " =", value, "value");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andValueBetween(String value1, String value2) {
        addCriterion(ConfigProperty.COLUMN_NAME_value + " between", value1, value2, "value");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andValueIn(List<String> values) {
        addCriterion(ConfigProperty.COLUMN_NAME_value + " in", values, "value");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andValueLike(String value) {
        addCriterion(ConfigProperty.COLUMN_NAME_value + " like", value, "value");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andValueNotLike(String value) {
        addCriterion(ConfigProperty.COLUMN_NAME_value + " not like", value, "value");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andDescriptionIsNull() {
        addCriterion(ConfigProperty.COLUMN_NAME_description + " is null");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andDescriptionIsNotNull() {
        addCriterion(ConfigProperty.COLUMN_NAME_description + " is not null");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andDescriptionEqualTo(String value) {
        addCriterion(ConfigProperty.COLUMN_NAME_description + " =", value, "description");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andDescriptionBetween(String value1, String value2) {
        addCriterion(ConfigProperty.COLUMN_NAME_description + " between", value1, value2, "description");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andDescriptionIn(List<String> values) {
        addCriterion(ConfigProperty.COLUMN_NAME_description + " in", values, "description");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andDescriptionLike(String value) {
        addCriterion(ConfigProperty.COLUMN_NAME_description + " like", value, "description");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andDescriptionNotLike(String value) {
        addCriterion(ConfigProperty.COLUMN_NAME_description + " not like", value, "description");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andOrganizationIdIsNull() {
        addCriterion(ConfigProperty.COLUMN_NAME_organizationId + " is null");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andOrganizationIdIsNotNull() {
        addCriterion(ConfigProperty.COLUMN_NAME_organizationId + " is not null");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andOrganizationIdEqualTo(Long value) {
        addCriterion(ConfigProperty.COLUMN_NAME_organizationId + " =", value, "organizationId");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andOrganizationIdBetween(Long value1, Long value2) {
        addCriterion(ConfigProperty.COLUMN_NAME_organizationId + " between", value1, value2, "organizationId");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andOrganizationIdIn(List<Long> values) {
        addCriterion(ConfigProperty.COLUMN_NAME_organizationId + " in", values, "organizationId");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andOrganizationIdGreaterThan(Long value) {
        addCriterion(ConfigProperty.COLUMN_NAME_organizationId + " >", value, "organizationId");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andOrganizationIdGreaterThanOrEqualTo(Long value) {
        addCriterion(ConfigProperty.COLUMN_NAME_organizationId + " >=", value, "organizationId");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andOrganizationIdLessThan(Long value) {
        addCriterion(ConfigProperty.COLUMN_NAME_organizationId + " <", value, "organizationId");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andOrganizationIdLessThanOrEqualTo(Long value) {
        addCriterion(ConfigProperty.COLUMN_NAME_organizationId + " <=", value, "organizationId");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andCreatedIsNull() {
        addCriterion(ConfigProperty.COLUMN_NAME_created + " is null");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andCreatedIsNotNull() {
        addCriterion(ConfigProperty.COLUMN_NAME_created + " is not null");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andCreatedEqualTo(Date value) {
        addCriterion(ConfigProperty.COLUMN_NAME_created + " =", value, "created");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andCreatedBetween(Date value1, Date value2) {
        addCriterion(ConfigProperty.COLUMN_NAME_created + " between", value1, value2, "created");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andCreatedbyIsNull() {
        addCriterion(ConfigProperty.COLUMN_NAME_createdby + " is null");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andCreatedbyIsNotNull() {
        addCriterion(ConfigProperty.COLUMN_NAME_createdby + " is not null");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andCreatedbyEqualTo(String value) {
        addCriterion(ConfigProperty.COLUMN_NAME_createdby + " =", value, "createdby");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andCreatedbyBetween(String value1, String value2) {
        addCriterion(ConfigProperty.COLUMN_NAME_createdby + " between", value1, value2, "createdby");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andCreatedbyIn(List<String> values) {
        addCriterion(ConfigProperty.COLUMN_NAME_createdby + " in", values, "createdby");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andCreatedbyLike(String value) {
        addCriterion(ConfigProperty.COLUMN_NAME_createdby + " like", value, "createdby");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andCreatedbyNotLike(String value) {
        addCriterion(ConfigProperty.COLUMN_NAME_createdby + " not like", value, "createdby");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andUpdatedIsNull() {
        addCriterion(ConfigProperty.COLUMN_NAME_updated + " is null");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andUpdatedIsNotNull() {
        addCriterion(ConfigProperty.COLUMN_NAME_updated + " is not null");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andUpdatedEqualTo(Date value) {
        addCriterion(ConfigProperty.COLUMN_NAME_updated + " =", value, "updated");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andUpdatedBetween(Date value1, Date value2) {
        addCriterion(ConfigProperty.COLUMN_NAME_updated + " between", value1, value2, "updated");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andUpdatedbyIsNull() {
        addCriterion(ConfigProperty.COLUMN_NAME_updatedby + " is null");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andUpdatedbyIsNotNull() {
        addCriterion(ConfigProperty.COLUMN_NAME_updatedby + " is not null");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andUpdatedbyEqualTo(String value) {
        addCriterion(ConfigProperty.COLUMN_NAME_updatedby + " =", value, "updatedby");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andUpdatedbyBetween(String value1, String value2) {
        addCriterion(ConfigProperty.COLUMN_NAME_updatedby + " between", value1, value2, "updatedby");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andUpdatedbyIn(List<String> values) {
        addCriterion(ConfigProperty.COLUMN_NAME_updatedby + " in", values, "updatedby");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andUpdatedbyLike(String value) {
        addCriterion(ConfigProperty.COLUMN_NAME_updatedby + " like", value, "updatedby");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andUpdatedbyNotLike(String value) {
        addCriterion(ConfigProperty.COLUMN_NAME_updatedby + " not like", value, "updatedby");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andIsActiveIsNull() {
        addCriterion(ConfigProperty.COLUMN_NAME_isActive + " is null");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andIsActiveIsNotNull() {
        addCriterion(ConfigProperty.COLUMN_NAME_isActive + " is not null");
        return (ConfigCriteria) this;
    }

    public ConfigCriteria andIsActiveEqualTo(Boolean value) {
        addCriterion(ConfigProperty.COLUMN_NAME_isActive + " =", value, "isActive");
        return (ConfigCriteria) this;
    }

}
