package org.activiti.engine.impl.persistence.entity;

import org.activiti.engine.identity.Role;

public class RoleEntity implements Role {


	protected String id;
	protected String name;
	protected String desc;

	public RoleEntity() {
	}

	public RoleEntity(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
