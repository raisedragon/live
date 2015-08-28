package com.raise.live.user.entity;
/**
 * Enum
 * organization:raise
 * author:longsheng.wang
 * date: 2015-08-28 15:55:27
 * @since 1.
 */
public enum Status {
	DELETED,
	ARCHIVED;
	
	public String value() {
	    return name();
	}
	
	public static Status fromValue(String v) {
	    return valueOf(v);
	}
}
