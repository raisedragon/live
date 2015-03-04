package com.raise.generator;

import java.util.Date;
import java.util.Properties;

import schemacrawler.schema.PrimaryKey;
import schemacrawler.schema.Table;

public class DataModel {
	private Configuration configuration;
	private Table table;
	private com.raise.generator.Table configTable;

	public DataModel(Configuration configuration, Table table) {
		this.configuration = configuration;
		this.table = table;
		this.configTable = findConfigTable(table.getName());
	}

	public Properties getProperties() {
		return configuration.getProperties();
	}

	public String getTablename() {
		return this.table.getName();
	}

	public String getPkg() {
		return configTable.getPkg();
	}

	public String getClazz() {
		return configTable.getClazz();
	}
	
	public String getModule(){
		return configTable.getModule(); 
	}

	public Table getTable() {
		return table;
	}
	
	public PrimaryKey getPrimaryKey() {
		return table.getPrimaryKey();
	}

	
	public Date getCurrentDate(){
		return new Date();
	}

	private com.raise.generator.Table findConfigTable(String tablename) {
		for (com.raise.generator.Table t : configuration.getTables()) {
			if (t.getName().equalsIgnoreCase(tablename)) {
				return t;
			}
		}
		return null;
	}
}
