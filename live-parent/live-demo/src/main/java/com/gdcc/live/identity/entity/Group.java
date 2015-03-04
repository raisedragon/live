package com.gdcc.live.identity.entity;

import com.gdcc.live.core.entity.BaseEntity;


public class Group extends BaseEntity<String> {
	
	private static final long serialVersionUID = 1L;
	
	protected String id;
	protected String name;
	protected String desc;
	
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
