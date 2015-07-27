package com.gdcc.live.identity.entity;

import java.util.Date;

import com.gdcc.live.core.entity.BaseEntity;

/**
 * 用户信息 entity 
 * company:raise
 * author:longsheng.wang
 * date: 2015-03-18 18:26:26
 * @since 1.
 */
public class User extends BaseEntity<String> {
	
	private static final long serialVersionUID = 1L;
	
	//ID
	protected String  id;
	//账号
	protected String  account;
	//密码
	protected String  password;
	//名字
	protected String  firstName;
	//姓
	protected String  lastName;
	//性别
	protected String  gender;
	//生日
	protected Date  birthday;
	//组织ID
	protected String  orgId;
	
	
	//getter setter
	public String  getId(){
		return this.id;
	}
	
	public void setId( String   id){
		this.id=id;
	}
	public String  getAccount(){
		return this.account;
	}
	
	public void setAccount( String   account){
		this.account=account;
	}
	public String  getPassword(){
		return this.password;
	}
	
	public void setPassword( String   password){
		this.password=password;
	}
	public String  getFirstName(){
		return this.firstName;
	}
	
	public void setFirstName( String   firstName){
		this.firstName=firstName;
	}
	public String  getLastName(){
		return this.lastName;
	}
	
	public void setLastName( String   lastName){
		this.lastName=lastName;
	}
	public String  getGender(){
		return this.gender;
	}
	
	public void setGender( String   gender){
		this.gender=gender;
	}
	public Date  getBirthday(){
		return this.birthday;
	}
	
	public void setBirthday( Date   birthday){
		this.birthday=birthday;
	}
	public String  getOrgId(){
		return this.orgId;
	}
	
	public void setOrgId( String   orgId){
		this.orgId=orgId;
	}
}


