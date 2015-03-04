package com.gdcc.live.system.query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gdcc.live.core.query.SetData;
import com.winit.common.query.Sort;

/**
 * 系统配置项 Query对象 Change to the actual description of this class
 * 
 * @version Revision History
 * 
 * <pre>
 * Author     			Version       Date			Changes
 * longsheng.wang    	1.0       2015-01-10 20:21:56			Created
 * 
 * </pre>
 * @since 1.
 */
public class ConfigQuery {

    public static class FindQuery {

        protected List<ConfigCriteria> oredCriteria;

        protected Sort                 sort;

        protected boolean              first;

        public FindQuery(){
            oredCriteria = new ArrayList<ConfigCriteria>();
        }

        public Sort getSort() {
            return sort;
        }

        public List<ConfigCriteria> getOredCriteria() {
            return oredCriteria;
        }

        public void or(ConfigCriteria criteria) {
            oredCriteria.add(criteria);
        }

        public ConfigCriteria or() {
            ConfigCriteria criteria = createCriteriaInternal();
            oredCriteria.add(criteria);
            return criteria;
        }

        public ConfigCriteria createCriteria() {
            ConfigCriteria criteria = createCriteriaInternal();
            if (oredCriteria.size() == 0) {
                oredCriteria.add(criteria);
            }
            return criteria;
        }

        protected ConfigCriteria createCriteriaInternal() {
            ConfigCriteria criteria = new ConfigCriteria();
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

        protected UpdateClause         updateClause;

        protected List<ConfigCriteria> oredCriteria;

        public UpdateClause getUpdateClause() {
            return updateClause;
        }

        public List<ConfigCriteria> getOredCriteria() {
            return oredCriteria;
        }

        public void or(ConfigCriteria criteria) {
            oredCriteria.add(criteria);
        }

        public ConfigCriteria or() {
            ConfigCriteria criteria = createCriteriaInternal();
            oredCriteria.add(criteria);
            return criteria;
        }

        public ConfigCriteria createCriteria() {
            ConfigCriteria criteria = createCriteriaInternal();
            if (oredCriteria.size() == 0) {
                oredCriteria.add(criteria);
            }
            return criteria;
        }

        protected ConfigCriteria createCriteriaInternal() {
            ConfigCriteria criteria = new ConfigCriteria();
            return criteria;
        }

        public UpdateQuery(){
            oredCriteria = new ArrayList<ConfigCriteria>();
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

        public void setName(String name) {
            dataClauses.add(new SetData(ConfigProperty.COLUMN_NAME_name + " = ", name));
        }

        public void setValue(String value) {
            dataClauses.add(new SetData(ConfigProperty.COLUMN_NAME_value + " = ", value));
        }

        public void setDescription(String description) {
            dataClauses.add(new SetData(ConfigProperty.COLUMN_NAME_description + " = ", description));
        }

        public void setOrganizationId(Long organizationId) {
            dataClauses.add(new SetData(ConfigProperty.COLUMN_NAME_organizationId + " = ", organizationId));
        }

        public void setCreated(Date created) {
            dataClauses.add(new SetData(ConfigProperty.COLUMN_NAME_created + " = ", created));
        }

        public void setCreatedby(Boolean createdby) {
            dataClauses.add(new SetData(ConfigProperty.COLUMN_NAME_createdby + " = ", createdby));
        }

        public void setUpdated(Date updated) {
            dataClauses.add(new SetData(ConfigProperty.COLUMN_NAME_updated + " = ", updated));
        }

        public void setUpdatedby(Boolean updatedby) {
            dataClauses.add(new SetData(ConfigProperty.COLUMN_NAME_updatedby + " = ", updatedby));
        }

        public void setIsActive(Boolean isActive) {
            dataClauses.add(new SetData(ConfigProperty.COLUMN_NAME_isActive + " = ", isActive));
        }

        public void setIsDelete(Boolean isDelete) {
            dataClauses.add(new SetData(ConfigProperty.COLUMN_NAME_isDelete + " = ", isDelete));
        }

    }
}
