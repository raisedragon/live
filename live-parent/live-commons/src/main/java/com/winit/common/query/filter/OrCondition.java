package com.winit.common.query.filter;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

/**
 * or 条件
 */
public class OrCondition implements SearchFilter,Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8814602281471325473L;
	
	private List<SearchFilter> orFilters = Lists.newArrayList();

    public OrCondition() {
    }

    public void setOrFilters(List<SearchFilter> orFilters) {
		this.orFilters = orFilters;
	}

	public OrCondition add(SearchFilter filter) {
        this.orFilters.add(filter);
        return this;
    }

    public List<SearchFilter> getOrFilters() {
        return orFilters;
    }

    @Override
    public String toString() {
        return "OrCondition{" + orFilters + '}';
    }
}
