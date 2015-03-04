package com.raise.generator;

public class Source {
	private String refTemplate;
	private String directory;
	private String filename;
	private boolean override;
	public String getRefTemplate() {
		return refTemplate;
	}
	public void setRefTemplate(String refTemplate) {
		this.refTemplate = refTemplate;
	}
	public String getDirectory() {
		return directory;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public boolean isOverride() {
		return override;
	}
	public void setOverride(boolean override) {
		this.override = override;
	}
	
	
}
