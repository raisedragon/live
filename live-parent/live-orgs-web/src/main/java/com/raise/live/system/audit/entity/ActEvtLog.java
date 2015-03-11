package com.raise.live.audit.entity;

import java.util.Date;

import com.raise.live.core.entity.BaseEntity;

/**
 * WWWWW entity 
 * company:raise
 * author:longsheng.wang
 * date: 2015-03-06 14:37:58
 * @since 1.
 */
public class ActEvtLog extends BaseEntity<Long> {
	
	private static final long serialVersionUID = 1L;
	
	//aaa
	protected Long  logNr;
	//aaaa
	protected String  type;
	//bbbb
	protected String  procDefId;
	//bbb
	protected String  procInstId;
	//ccc
	protected String  executionId;
	//
	protected String  taskId;
	//
	protected Date  timeStamp;
	//
	protected String  userId;
	//
	protected Byte[]  data;
	//
	protected String  lockOwner;
	//
	protected Date  lockTime;
	//
	protected Integer  isProcessed;
	
	
	//getter setter
	public Long  getLogNr(){
		return this.logNr;
	}
	
	public void setLogNr( Long   logNr){
		this.logNr=logNr;
	}
	public String  getType(){
		return this.type;
	}
	
	public void setType( String   type){
		this.type=type;
	}
	public String  getProcDefId(){
		return this.procDefId;
	}
	
	public void setProcDefId( String   procDefId){
		this.procDefId=procDefId;
	}
	public String  getProcInstId(){
		return this.procInstId;
	}
	
	public void setProcInstId( String   procInstId){
		this.procInstId=procInstId;
	}
	public String  getExecutionId(){
		return this.executionId;
	}
	
	public void setExecutionId( String   executionId){
		this.executionId=executionId;
	}
	public String  getTaskId(){
		return this.taskId;
	}
	
	public void setTaskId( String   taskId){
		this.taskId=taskId;
	}
	public Date  getTimeStamp(){
		return this.timeStamp;
	}
	
	public void setTimeStamp( Date   timeStamp){
		this.timeStamp=timeStamp;
	}
	public String  getUserId(){
		return this.userId;
	}
	
	public void setUserId( String   userId){
		this.userId=userId;
	}
	public Byte[]  getData(){
		return this.data;
	}
	
	public void setData( Byte[]   data){
		this.data=data;
	}
	public String  getLockOwner(){
		return this.lockOwner;
	}
	
	public void setLockOwner( String   lockOwner){
		this.lockOwner=lockOwner;
	}
	public Date  getLockTime(){
		return this.lockTime;
	}
	
	public void setLockTime( Date   lockTime){
		this.lockTime=lockTime;
	}
	public Integer  getIsProcessed(){
		return this.isProcessed;
	}
	
	public void setIsProcessed( Integer   isProcessed){
		this.isProcessed=isProcessed;
	}
}


