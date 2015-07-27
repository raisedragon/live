package com.gdcc.live.identity.query;

import java.util.List;

import com.gdcc.live.core.query.AbstractCriteria;

public class UserCriteria extends AbstractCriteria<UserCriteria> {

	private Long groupId;

	public UserCriteria memberOfGroup(Long groupId) {
		if (groupId == null) {
			throw new RuntimeException("Provided groupIds is null or empty");
		}
		this.groupId = groupId;
		return this;
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

	@Override
	public UserCriteria newInstance() {
		return new UserCriteria();
	}

	
	public Long getGroupId() {
		return groupId;
	}
}
