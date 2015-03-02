package com.raise.generator;

import java.util.List;
import java.util.Properties;

public class GConfiguration {
	private Properties properties;

	private List<GTemplate> templates;

	private List<GFile> files;

	private List<GTable> tables;

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public List<GTemplate> getTemplates() {
		return templates;
	}

	public void setTemplates(List<GTemplate> templates) {
		this.templates = templates;
	}

	public List<GFile> getFiles() {
		return files;
	}

	public void setFiles(List<GFile> files) {
		this.files = files;
	}

	public List<GTable> getTables() {
		return tables;
	}

	public void setTables(List<GTable> tables) {
		this.tables = tables;
	}

}
