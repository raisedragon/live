package com.gdcc.live.identity.query;

import java.util.ArrayList;
import java.util.List;

import com.gdcc.live.core.query.AbstractCriteria;
import com.gdcc.live.core.query.Criterion;

public class UserCriteria extends AbstractCriteria<UserCriteria> {
	
	
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

	@Override
	public UserCriteria newInstance() {
		return new UserCriteria();
	}

}
