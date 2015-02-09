
package com.raise.orgs.impl.persistence.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.raise.orgs.identity.Rights;
import com.raise.orgs.identity.RightsType;
import com.raise.orgs.impl.db.PersistentObject;



public class RightsEntity implements Rights, PersistentObject, Serializable {

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String managedResourceId;
  protected String groupId;
  protected RightsType type;
  public Object getPersistentState() {
    Map<String,Object> state = new HashMap<String, Object>();
    state.put("type", type);
    return state;
  }
  public String getId() {
	  return this.id;
  }
  public void setId(String id) {
	  this.id = id;
  }

	@Override
	public String getManagedResourceId() {
		return this.managedResourceId;
	}
	@Override
	public void setManagedResourceId(String managedResourceId) {
		this.managedResourceId = managedResourceId;
	}
	@Override
	public String getGroupId() {
		return this.groupId;
	}
	@Override
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	@Override
	public RightsType getType() {
		return this.type;
	}
	@Override
	public void setType(RightsType type) {
		this.type = type;
	}
  
}
