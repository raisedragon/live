package com.raise.orgs.identity;


public enum RightsType {
	READ,
	WRITE;
	public String value() {
		return name();
	}

	public static RightsType fromValue(String v) {
		return valueOf(v);
	}
	
}
