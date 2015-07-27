package com.raise.generator;

import java.util.List;
import java.util.Properties;

public class Configuration {
	private Properties properties;
	private List<Template> templates;
	private List<Source> sources;
	private List<Table> tables;

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public List<Template> getTemplates() {
		return templates;
	}
	
	public Template getTemplate(String id){
		for(Template t:templates){
			if(t.getId().equals(id)){
				return t;
			}
		}
		return null;
	}

	public void setTemplates(List<Template> templates) {
		this.templates = templates;
	}

	public List<Source> getSources() {
		return sources;
	}

	public void setSources(List<Source> sources) {
		this.sources = sources;
	}

	public List<Table> getTables() {
		return tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}

	
	public Table getTable(String tablename){
		for(Table table: tables){
			if(table.getName().equalsIgnoreCase(tablename)){
				return table;
			}
		}
		return null;
	}
}