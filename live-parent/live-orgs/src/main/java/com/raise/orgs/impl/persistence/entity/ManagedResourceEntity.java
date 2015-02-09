package com.raise.orgs.impl.persistence.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.raise.orgs.identity.ManagedResource;
import com.raise.orgs.identity.ManagedResourceType;
import com.raise.orgs.impl.db.HasRevision;
import com.raise.orgs.impl.db.PersistentObject;

public class ManagedResourceEntity  implements ManagedResource, Serializable, PersistentObject, HasRevision {

	private static final long serialVersionUID = 1L;
	
	protected String id;
	protected int revision;
	protected String name;
	protected ManagedResourceType type;
	protected String uri;
	protected String desc;
	protected String subsystemId;
	
	//Getter and setter method
	@Override
	public void setRevision(int revision) {
		this.revision = revision;
	}

	@Override
	public int getRevision() {
		return this.revision;
	}

	@Override
	public int getRevisionNext() {
		return this.revision+1;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public Object getPersistentState() {
	    Map<String, Object> persistentState = new HashMap<String, Object>();
	    persistentState.put("name", name);
	    persistentState.put("type", type);
	    persistentState.put("uri", uri);
	    return persistentState;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public ManagedResourceType getType() {
		return this.type;
	}

	@Override
	public void setType(ManagedResourceType type) {
		this.type = type;
	}

	@Override
	public String getUri() {
		return this.uri;
	}

	@Override
	public void setUri(String uri) {
		this.uri = uri;
		
	}

	@Override
	public String getDesc() {
		return this.desc;
	}

	@Override
	public void setDesc(String desc) {
		this.desc = desc;
		
	}

	@Override
	public String getSubsystemId() {
		return this.subsystemId;
	}

	@Override
	public void setSubsystemId(String subsystemId) {
		this.subsystemId = subsystemId;
		
	}


}
