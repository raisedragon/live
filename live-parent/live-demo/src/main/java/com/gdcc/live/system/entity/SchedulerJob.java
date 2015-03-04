package com.gdcc.live.system.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.gdcc.live.core.entity.BaseEntity;

/**
 * <定时任务表 entity对象>
 * 
 * @version <pre>
 * Author	Version		Date		Changes
 * jianfa.zhuang 	1.0  		2015-1-9 	Created
 * 
 * </pre>
 * @since 1.
 */
public class SchedulerJob extends BaseEntity<String> {

    /**
     * 序列化
     */
    private static final long  serialVersionUID   = 2594151552963642108L;

    /**
     * 运行
     */
    public static final String STATUS_RUNNING     = "1";

    /**
     * 停止
     */
    public static final String STATUS_NOT_RUNNING = "0";

    /**
     * 主键
     */
    protected String             id;

    /**
     * 定时任务名称
     */
    protected String           jobName;

    /**
     * 定时任务类
     */
    protected String           beanClass;

    /**
     * 定时任务方法名
     */
    protected String           methodName;

    /**
     * 定时任务时间表达式
     */
    protected String           cronExpression;

    /**
     * 哪台服务器使用,为空则全部服务器都可执行
     */
    protected String           ipAddress;

    /**
     * 任务状态:0不启用，1启用
     */
    protected String           jobStatus;

    /**
     * 定时任务编码
     */
    protected String           code;

    /**
     * 任务分组
     */
    protected String           jobGroup;

    /**
     * SPRING配置文件中引入BEAN的声明式ID
     */
    protected String           springId;

    /**
     * 工作状态:0异步，1同步
     */
    protected Boolean          isConcurrent;

    public void setId(String id) {
        this.id = id;
    }

    /**
     * 返回 主键ID
     * 
     * @return
     */
    public String getId() {
        return this.id;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * 返回 定时任务名称
     * 
     * @return
     */
    public String getJobName() {
        return this.jobName;
    }

    public void setBeanClass(String beanClass) {
        this.beanClass = beanClass;
    }

    /**
     * 返回 定时任务类
     * 
     * @return
     */
    public String getBeanClass() {
        return this.beanClass;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * 返回 定时任务方法名
     * 
     * @return
     */
    public String getMethodName() {
        return this.methodName;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    /**
     * 返回 定时任务时间表达式
     * 
     * @return
     */
    public String getCronExpression() {
        return this.cronExpression;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * 返回 哪台服务器使用,为空则全部服务器都可执行
     * 
     * @return
     */
    public String getIpAddress() {
        return this.ipAddress;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    /**
     * 返回 任务状态:0不启用，1启用
     * 
     * @return
     */
    public String getJobStatus() {
        return this.jobStatus;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 返回 定时任务编码
     * 
     * @return
     */
    public String getCode() {
        return this.code;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    /**
     * 返回 任务分组
     * 
     * @return
     */
    public String getJobGroup() {
        return this.jobGroup;
    }

    public void setSpringId(String springId) {
        this.springId = springId;
    }

    /**
     * 返回 SPRING配置文件中引入BEAN的声明式ID
     * 
     * @return
     */
    public String getSpringId() {
        return this.springId;
    }

    public void setConcurrent(Boolean isConcurrent) {
        this.isConcurrent = isConcurrent;
    }

    /**
     * 返回 工作状态:0异步，1同步
     * 
     * @return
     */
    public Boolean isConcurrent() {
        return this.isConcurrent;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("id", this.id)
            .append("jobName", this.jobName)
            .append("beanClass", this.beanClass)
            .append("methodName", this.methodName)
            .append("cronExpression", this.cronExpression)
            .append("ipAddress", this.ipAddress)
            .append("jobStatus", this.jobStatus)
            .append("code", this.code)
            .append("jobGroup", this.jobGroup)
            .append("springId", this.springId)
            .append("isConcurrent", this.isConcurrent)
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
