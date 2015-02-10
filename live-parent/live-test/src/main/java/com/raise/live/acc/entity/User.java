package com.raise.live.acc.entity;

import java.util.Date;

import com.raise.live.core.entity.BaseEntity;

public class User extends BaseEntity<String> {
	
	protected String id;
	protected String account;
	protected String password;
	protected String firstname;
	protected String lastname;
	protected Date birthday;
	
	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
