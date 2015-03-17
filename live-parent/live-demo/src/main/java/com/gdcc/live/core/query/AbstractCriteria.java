package com.gdcc.live.core.query;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCriteria<T extends AbstractCriteria<T>> {

	protected T next;

	protected List<Criterion> criteria = new ArrayList<Criterion>();

	public boolean isValid() {
		return criteria.size() > 0;
	}

	public List<Criterion> getCriteria() {
		return criteria;
	}

	protected void addCriterion(String condition) {
		if (condition == null) {
			throw new RuntimeException("Value for condition cannot be null");
		}
		criteria.add(new Criterion(condition));
	}

	protected void addCriterion(String condition, Object value, String property) {
		if (value == null) {
			throw new RuntimeException("Value for " + property + " cannot be null");
		}
		criteria.add(new Criterion(condition, value));
	}

	protected void addCriterion(String condition, Object value1, Object value2, String property) {
		if (value1 == null || value2 == null) {
			throw new RuntimeException("Between values for " + property + " cannot be null");
		}
		criteria.add(new Criterion(condition, value1, value2));
	}


	public T or() {
		this.next = newInstance();
		return this.next;
	}


	public abstract T newInstance();

	@SuppressWarnings("unchecked")
	public List<T> getCriterias() {
		List<T> list = new ArrayList<T>();
		list.add((T) this);
		T item = (T) this;
		while ((item = item.next) != null) {
			list.add(item);
		}
		return list;
	}

}
