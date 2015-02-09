package com.raise.orgs.jsp.tag;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private String name;
	private String titleKey;
	private List<MenuItem> items;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public String getTitleKey() {
		return titleKey;
	}

	public void setTitleKey(String titleKey) {
		this.titleKey = titleKey;
	}

	public List<MenuItem> getItems() {
		if(items==null){
			items = new ArrayList<MenuItem>();
		}
		return items;
	}

	public void setItems(List<MenuItem> items) {
		this.items = items;
	}
	
}
