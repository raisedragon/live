package com.gdcc.live.spi.quartz.command;

import com.gdcc.live.spi.quartz.model.SpiCommand;

public class AddTriggerCommand extends SpiCommand {
	private String jobName;
	private String jobGroup;
	private String name;
	private String group;
	private String description;
	private String cronExpression;
	private boolean replace;
	private boolean storeNonDurableWhileAwaitingScheduling;
	
	
	
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobGroup() {
		return jobGroup;
	}
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public String getCronExpression() {
		return cronExpression;
	}
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}
	public boolean isReplace() {
		return replace;
	}
	public void setReplace(boolean replace) {
		this.replace = replace;
	}
	public boolean isStoreNonDurableWhileAwaitingScheduling() {
		return storeNonDurableWhileAwaitingScheduling;
	}
	public void setStoreNonDurableWhileAwaitingScheduling(boolean storeNonDurableWhileAwaitingScheduling) {
		this.storeNonDurableWhileAwaitingScheduling = storeNonDurableWhileAwaitingScheduling;
	}
	
	

}
