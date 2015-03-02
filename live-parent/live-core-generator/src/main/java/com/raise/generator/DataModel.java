package com.raise.generator;

import java.util.Date;

import schemacrawler.schema.Table;

public class DataModel {
	private Config config;
	private Table table;
	private Date currentDate;

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public Date getCurrentDate() {
		if(currentDate==null){
			currentDate = new Date();
		}
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
	
	
	

}
