package com.raise.orgs.entity;

import com.raise.core.entity.BaseEntity;

/**
 * 系统配置
 * @author longsheng.wang
 *
 */
public class ConfigEntity extends BaseEntity {
	private String name;
	private String value;
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
