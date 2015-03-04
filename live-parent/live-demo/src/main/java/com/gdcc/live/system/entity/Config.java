package com.gdcc.live.system.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.gdcc.live.core.entity.BaseEntity;

/**
 * 对象功能:系统配置项 entity对象 开发公司:WINIT 开发人员:Stringsheng.wang 创建时间:2015-01-07 14:46:54
 */
public class Config extends BaseEntity<String> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String            id;                                      /* ID */
    protected String          name;                                    /* 名称 */
    protected String          value;                                   /* 值 */
    protected String          description;                             /* 描述 */

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

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 返回 名称
     * 
     * @return
     */
    public String getName() {
        return this.name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 返回 值
     * 
     * @return
     */
    public String getValue() {
        return this.value;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 返回 描述
     * 
     * @return
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("id", this.id)
            .append("name", this.name)
            .append("value", this.value)
            .append("description", this.description)
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
