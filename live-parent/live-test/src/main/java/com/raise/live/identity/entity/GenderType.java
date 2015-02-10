package com.raise.live.identity.entity;


public enum GenderType {
	
	MALE, 		/*男性*/
	FEMALE;		/*女性*/
	
    public String value() {
        return name();
    }

    public static GenderType fromValue(String v) {
        return valueOf(v);
    }
}
