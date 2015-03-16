package com.gdcc.live.identity.query;

import java.util.ArrayList;
import java.util.List;

import com.gdcc.live.core.query.Criterion;

public class UserCriteria {
	
	protected List<Criterion> criteria;

	public UserCriteria() {
		super();
		this.criteria = new ArrayList<Criterion>();
	}

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
	
	public UserCriteria andFirstNameIsNull() {
        addCriterion(UserProperty.COLUMN_NAME_firstName + " is null");
        return (UserCriteria) this;
    }

    public UserCriteria andFirstNameIsNotNull() {
        addCriterion(UserProperty.COLUMN_NAME_firstName + " is not null");
        return (UserCriteria) this;
    }

    public UserCriteria andFirstNameEqualTo(String value) {
        addCriterion(UserProperty.COLUMN_NAME_firstName + " =", value, "firstName");
        return (UserCriteria) this;
    }

    public UserCriteria andFirstNameBetween(String value1, String value2) {
        addCriterion(UserProperty.COLUMN_NAME_firstName + " between", value1, value2, "firstName");
        return (UserCriteria) this;
    }

    public UserCriteria andFirstNameIn(List<String> values) {
        addCriterion(UserProperty.COLUMN_NAME_firstName + " in", values, "firstName");
        return (UserCriteria) this;
    }

    public UserCriteria andFirstNameLike(String value) {
        addCriterion(UserProperty.COLUMN_NAME_firstName + " like", value, "firstName");
        return (UserCriteria) this;
    }

    public UserCriteria andFirstNameNotLike(String value) {
        addCriterion(UserProperty.COLUMN_NAME_firstName + " not like", value, "firstName");
        return (UserCriteria) this;
    }

}
