package com.gdcc.live.spi.quartz.command;

import com.gdcc.live.spi.quartz.model.SpiCommand;

public class AddJobCommand extends SpiCommand {
	private String name;
	private String group;
	private Class<?> targetClass;
	private String targetObject;
	private String targetMethod;
	private String description;
	private boolean concurrent;
	private boolean replace;
	private boolean storeNonDurableWhileAwaitingScheduling;
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

	public Class<?> getTargetClass() {
		return targetClass;
	}
	public void setTargetClass(Class<?> targetClass) {
		this.targetClass = targetClass;
	}
	public String getTargetObject() {
		return targetObject;
	}
	public void setTargetObject(String targetObject) {
		this.targetObject = targetObject;
	}
	public String getTargetMethod() {
		return targetMethod;
	}
	public void setTargetMethod(String targetMethod) {
		this.targetMethod = targetMethod;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public boolean isConcurrent() {
		return concurrent;
	}
	public void setConcurrent(boolean concurrent) {
		this.concurrent = concurrent;
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
