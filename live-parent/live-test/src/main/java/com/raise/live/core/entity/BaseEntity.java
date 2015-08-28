package com.raise.live.core.entity;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public abstract class BaseEntity<PK extends Serializable> implements Serializable {

    protected PK      id;
    // 创建人
    protected String  createdBy;
    // 更新人
    protected String  updatedBy;
    // 创建时间
    protected Date    created;
    // 更新时间
    protected Date    updated;
    // 创建人组织ID
    protected String  orgId;

    protected boolean isActive = true;

    protected boolean isDelete = false;

    

    public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
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


    public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
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
    public void setId(PK id) {
        this.id = id;
    }

    /**
     * 获取主键ID
     * 
     * @return
     */
    public PK getId() {
        return id;
    }

}
