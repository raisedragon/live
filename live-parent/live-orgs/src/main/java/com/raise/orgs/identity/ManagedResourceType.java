package com.raise.orgs.identity;


public enum ManagedResourceType {
	MENU,
	NAVIGATOR,
	ACTION;
	public String value() {
		return name();
	}

	public static ManagedResourceType fromValue(String v) {
		return valueOf(v);
	}
	
}
