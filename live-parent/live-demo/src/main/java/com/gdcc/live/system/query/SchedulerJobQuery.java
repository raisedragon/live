package com.gdcc.live.system.query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gdcc.live.core.query.SetData;
import com.winit.common.query.Sort;

/**
 * VMS_SYS_SCHEDULER Query对象 Change to the actual description of this class
 * 
 * @version Revision History
 * 
 * <pre>
 * Author     			Version       Date			Changes
 * longsheng.wang    	1.0       2015-01-10 14:38:16			Created
 * 
 * </pre>
 * @since 1.
 */
public class SchedulerJobQuery {

    public static class FindQuery {

        protected List<SchedulerJobCriteria> oredCriteria;

        protected Sort                       sort;

        protected boolean                    first;

        public FindQuery(){
            oredCriteria = new ArrayList<SchedulerJobCriteria>();
        }

        public Sort getSort() {
            return sort;
        }

        public List<SchedulerJobCriteria> getOredCriteria() {
            return oredCriteria;
        }

        public void or(SchedulerJobCriteria criteria) {
            oredCriteria.add(criteria);
        }

        public SchedulerJobCriteria or() {
            SchedulerJobCriteria criteria = createCriteriaInternal();
            oredCriteria.add(criteria);
            return criteria;
        }

        public SchedulerJobCriteria createCriteria() {
            SchedulerJobCriteria criteria = createCriteriaInternal();
            if (oredCriteria.size() == 0) {
                oredCriteria.add(criteria);
            }
            return criteria;
        }

        protected SchedulerJobCriteria createCriteriaInternal() {
            SchedulerJobCriteria criteria = new SchedulerJobCriteria();
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

        protected UpdateClause               updateClause;

        protected List<SchedulerJobCriteria> oredCriteria;

        public UpdateClause getUpdateClause() {
            return updateClause;
        }

        public List<SchedulerJobCriteria> getOredCriteria() {
            return oredCriteria;
        }

        public void or(SchedulerJobCriteria criteria) {
            oredCriteria.add(criteria);
        }

        public SchedulerJobCriteria or() {
            SchedulerJobCriteria criteria = createCriteriaInternal();
            oredCriteria.add(criteria);
            return criteria;
        }

        public SchedulerJobCriteria createCriteria() {
            SchedulerJobCriteria criteria = createCriteriaInternal();
            if (oredCriteria.size() == 0) {
                oredCriteria.add(criteria);
            }
            return criteria;
        }

        protected SchedulerJobCriteria createCriteriaInternal() {
            SchedulerJobCriteria criteria = new SchedulerJobCriteria();
            return criteria;
        }

        public UpdateQuery(){
            oredCriteria = new ArrayList<SchedulerJobCriteria>();
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

        public void setJobName(String jobName) {
            dataClauses.add(new SetData(SchedulerJobProperty.COLUMN_NAME_jobName + " = ", jobName));
        }

        public void setBeanClass(String beanClass) {
            dataClauses.add(new SetData(SchedulerJobProperty.COLUMN_NAME_beanClass + " = ", beanClass));
        }

        public void setMethodName(String methodName) {
            dataClauses.add(new SetData(SchedulerJobProperty.COLUMN_NAME_methodName + " = ", methodName));
        }

        public void setCronExpression(String cronExpression) {
            dataClauses.add(new SetData(SchedulerJobProperty.COLUMN_NAME_cronExpression + " = ", cronExpression));
        }

        public void setIpAddress(String ipAddress) {
            dataClauses.add(new SetData(SchedulerJobProperty.COLUMN_NAME_ipAddress + " = ", ipAddress));
        }

        public void setJobStatus(String jobStatus) {
            dataClauses.add(new SetData(SchedulerJobProperty.COLUMN_NAME_jobStatus + " = ", jobStatus));
        }

        public void setCode(String code) {
            dataClauses.add(new SetData(SchedulerJobProperty.COLUMN_NAME_code + " = ", code));
        }

        public void setJobGroup(String jobGroup) {
            dataClauses.add(new SetData(SchedulerJobProperty.COLUMN_NAME_jobGroup + " = ", jobGroup));
        }

        public void setSpringId(String springId) {
            dataClauses.add(new SetData(SchedulerJobProperty.COLUMN_NAME_springId + " = ", springId));
        }

        public void setIsConcurrent(String isConcurrent) {
            dataClauses.add(new SetData(SchedulerJobProperty.COLUMN_NAME_isConcurrent + " = ", isConcurrent));
        }

        public void setOrganizationId(Long organizationId) {
            dataClauses.add(new SetData(SchedulerJobProperty.COLUMN_NAME_organizationId + " = ", organizationId));
        }

        public void setCreated(Date created) {
            dataClauses.add(new SetData(SchedulerJobProperty.COLUMN_NAME_created + " = ", created));
        }

        public void setCreatedby(Boolean createdby) {
            dataClauses.add(new SetData(SchedulerJobProperty.COLUMN_NAME_createdby + " = ", createdby));
        }

        public void setUpdated(Date updated) {
            dataClauses.add(new SetData(SchedulerJobProperty.COLUMN_NAME_updated + " = ", updated));
        }

        public void setUpdatedby(Boolean updatedby) {
            dataClauses.add(new SetData(SchedulerJobProperty.COLUMN_NAME_updatedby + " = ", updatedby));
        }

        public void setIsActive(Boolean isActive) {
            dataClauses.add(new SetData(SchedulerJobProperty.COLUMN_NAME_isActive + " = ", isActive));
        }

        public void setIsDelete(Boolean isDelete) {
            dataClauses.add(new SetData(SchedulerJobProperty.COLUMN_NAME_isDelete + " = ", isDelete));
        }

    }
}
