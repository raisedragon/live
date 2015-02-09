package com.raise.orgs.identity;

import java.io.Serializable;

public interface Rights extends Serializable{
	  String getId();
	  void setId(String id);
	  
	  String getGroupId();
	  void setGroupId(String groupId);
	  
	  String getManagedResourceId();
	  void setManagedResourceId(String managedResourceId);
	  
	  RightsType getType();
	  void setType(RightsType type);
	  
}
