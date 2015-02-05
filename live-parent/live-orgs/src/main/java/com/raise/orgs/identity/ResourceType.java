package com.raise.orgs.identity;


public enum ResourceType {
	MENU,
	NAVIGATOR,
	ACTION;
	public String value() {
		return name();
	}

	public static ResourceType fromValue(String v) {
		return valueOf(v);
	}
	
}
