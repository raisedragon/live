package com.gdcc.live.core.entity;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public abstract class BaseEntity<T extends Serializable> implements Serializable {

    // 创建人
    protected String  createdby;
    // 更新人
    protected String  updatedby;
    // 创建时间
    protected Date    created;
    // 更新时间
    protected Date    updated;
    // 创建人组织ID
    protected Long    organizationId;

    protected boolean isActive = true;

    protected boolean isDelete = false;

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 设置主键ID
     * 
     * @param id
     */
    public abstract void setId(T id);

    /**
     * 获取主键ID
     * 
     * @return
     */
    public abstract T getId();

}
