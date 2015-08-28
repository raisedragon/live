package com.raise.live.system.entity;

import java.util.Date;

import com.raise.live.core.entity.BaseEntity;

/**
 *  entity 
 * organization:raise
 * author:longsheng.wang
 * date: 2015-08-26 13:58:23
 * @since 1.
 */
public class SysConfig extends BaseEntity<Integer> {
	
	private static final long serialVersionUID = 1L;
	
	//key值
	protected String  name;
	//value
	protected String  value;
	//创建人
	protected String  createby;
	//更新人
	protected String  updateby;
	//描述
	protected String  description;
	
	
	//getter setter
	public String  getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	public String  getValue(){
		return this.value;
	}
	
	public void setValue(String value){
		this.value=value;
	}
	public String  getCreateby(){
		return this.createby;
	}
	
	public void setCreateby(String createby){
		this.createby=createby;
	}
	public String  getUpdateby(){
		return this.updateby;
	}
	
	public void setUpdateby(String updateby){
		this.updateby=updateby;
	}
	public String  getDescription(){
		return this.description;
	}
	
	public void setDescription(String description){
		this.description=description;
	}
}


