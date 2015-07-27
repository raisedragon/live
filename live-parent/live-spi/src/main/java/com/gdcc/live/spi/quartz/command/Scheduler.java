package com.gdcc.live.spi.quartz.command;

import java.util.Date;

public class Scheduler {
	private String schedName;

	private String schedInst;

	private Class<?> schedClass;

	private boolean isRemote;

	private boolean started;

	private boolean isInStandbyMode;

	private boolean shutdown;

	private Date startTime;

	private int numJobsExec;

	private Class<?> jsClass;

	private boolean jsPersistent;

	private boolean jsClustered;

	private Class<?> tpClass;

	private int tpSize;

	private String version;

	public String getSchedName() {
		return schedName;
	}

	public void setSchedName(String schedName) {
		this.schedName = schedName;
	}

	public String getSchedInst() {
		return schedInst;
	}

	public void setSchedInst(String schedInst) {
		this.schedInst = schedInst;
	}

	public Class<?> getSchedClass() {
		return schedClass;
	}

	public void setSchedClass(Class<?> schedClass) {
		this.schedClass = schedClass;
	}

	public boolean isRemote() {
		return isRemote;
	}

	public void setRemote(boolean isRemote) {
		this.isRemote = isRemote;
	}

	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

	public boolean isInStandbyMode() {
		return isInStandbyMode;
	}

	public void setInStandbyMode(boolean isInStandbyMode) {
		this.isInStandbyMode = isInStandbyMode;
	}

	public boolean isShutdown() {
		return shutdown;
	}

	public void setShutdown(boolean shutdown) {
		this.shutdown = shutdown;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public int getNumJobsExec() {
		return numJobsExec;
	}

	public void setNumJobsExec(int numJobsExec) {
		this.numJobsExec = numJobsExec;
	}

	public Class<?> getJsClass() {
		return jsClass;
	}

	public void setJsClass(Class<?> jsClass) {
		this.jsClass = jsClass;
	}

	public boolean isJsPersistent() {
		return jsPersistent;
	}

	public void setJsPersistent(boolean jsPersistent) {
		this.jsPersistent = jsPersistent;
	}

	public boolean isJsClustered() {
		return jsClustered;
	}

	public void setJsClustered(boolean jsClustered) {
		this.jsClustered = jsClustered;
	}

	public Class<?> getTpClass() {
		return tpClass;
	}

	public void setTpClass(Class<?> tpClass) {
		this.tpClass = tpClass;
	}

	public int getTpSize() {
		return tpSize;
	}

	public void setTpSize(int tpSize) {
		this.tpSize = tpSize;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
