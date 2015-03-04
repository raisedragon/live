package com.gdcc.live.identity.entity;

public enum GroupType {
	
	ROLE,
	ORG;
	
    public String value() {
        return name();
    }

    public static GroupType fromValue(String v) {
        return valueOf(v);
    }
}
