package com.gdcc.live.identity.entity;


public enum ResourceType {
	
	ACTION,
	MENU,
	SUBSYSTEM;
	
    public String value() {
        return name();
    }

    public static ResourceType fromValue(String v) {
        return valueOf(v);
    }
}
