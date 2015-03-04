package com.gdcc.live.identity.entity;

import com.gdcc.live.core.entity.BaseEntity;


public class Resource extends BaseEntity<String> {
	
	private static final long serialVersionUID = 1L;
	
	protected String id;
	protected String name;
	protected String key;
	protected String path;
	protected String desc;
	protected ResourceType type;
	
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
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public ResourceType getType() {
		return type;
	}
	public void setType(ResourceType type) {
		this.type = type;
	}
	
}
