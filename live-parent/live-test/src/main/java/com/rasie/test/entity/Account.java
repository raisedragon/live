package com.rasie.test.entity;

import com.raise.live.core.entity.BaseEntity;

/**
 *  entity 
 * organization:raise
 * author:longsheng.wang
 * date: 2015-08-28 15:55:27
 * @since 1.
 */
public class Account extends BaseEntity<Integer> {
	
	private static final long serialVersionUID = 1L;
	
	//创建人
	protected String  createBy;
	//更新人
	protected String  updateBy;
	//描述
	protected String  description;
	//账号
	protected String  name;
	//密码
	protected String  password;
	//状态
	protected Status  status;
	
	
	//getter setter
	public String  getCreateBy(){
		return this.createBy;
	}
	
	public void setCreateBy(String createBy){
		this.createBy=createBy;
	}
	public String  getUpdateBy(){
		return this.updateBy;
	}
	
	public void setUpdateBy(String updateBy){
		this.updateBy=updateBy;
	}
	public String  getDescription(){
		return this.description;
	}
	
	public void setDescription(String description){
		this.description=description;
	}
	public String  getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	public String  getPassword(){
		return this.password;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	public Status  getStatus(){
		return this.status;
	}
	
	public void setStatus(Status status){
		this.status=status;
	}
}


