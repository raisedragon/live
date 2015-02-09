package com.raise.orgs.identity;

import java.io.Serializable;

public interface ManagedResource extends Serializable {
	
	  String getId();
	  void setId(String id);
	  
	  String getName();
	  void setName(String name);
	  
	  ManagedResourceType getType();
	  void setType(ManagedResourceType type);
	  
	  String getUri();
	  void setUri(String uri);
	  
	  String getDesc();
	  void setDesc(String desc);
	  
	  String getSubsystemId();
	  void setSubsystemId(String subsystemId);
	  
}
