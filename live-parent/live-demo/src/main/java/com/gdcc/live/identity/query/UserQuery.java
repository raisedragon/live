package com.gdcc.live.identity.query;

import java.util.List;

import com.gdcc.live.core.context.AppContext;
import com.gdcc.live.core.exception.LiveException;
import com.gdcc.live.core.query.AbstractQuery;
import com.gdcc.live.core.query.Page;
import com.gdcc.live.identity.dao.UserDao;
import com.gdcc.live.identity.entity.User;

public class UserQuery extends AbstractQuery<UserQuery,User>  {

	private static final long serialVersionUID = 1L;
	
	protected String id;
	protected String firstName;
	protected String firstNameLike;
	protected String lastName;
	protected String lastNameLike;
	protected String fullNameLike;
	protected String email;
	protected String emailLike;
	protected String groupId;
	
	public UserQuery(AppContext appContext) {
		super(appContext);
	}
	

	public UserQuery userId(String id) {
		if (id == null) {
			throw new LiveException("Provided id is null");
		}
		this.id = id;
		return this;
	}

	public UserQuery userFirstName(String firstName) {
		if (firstName == null) {
			throw new LiveException("Provided firstName is null");
		}
		this.firstName = firstName;
		return this;
	}

	public UserQuery userFirstNameLike(String firstNameLike) {
		if (firstNameLike == null) {
			throw new LiveException("Provided firstNameLike is null");
		}
		this.firstNameLike = firstNameLike;
		return this;
	}

	public UserQuery userLastName(String lastName) {
		if (lastName == null) {
			throw new LiveException("Provided lastName is null");
		}
		this.lastName = lastName;
		return this;
	}

	public UserQuery userLastNameLike(String lastNameLike) {
		if (lastNameLike == null) {
			throw new LiveException("Provided lastNameLike is null");
		}
		this.lastNameLike = lastNameLike;
		return this;
	}

	public UserQuery userFullNameLike(String fullNameLike) {
		if (fullNameLike == null) {
			throw new LiveException("Provided full name is null");
		}
		this.fullNameLike = fullNameLike;
		return this;
	}

	public UserQuery userEmail(String email) {
		if (email == null) {
			throw new LiveException("Provided email is null");
		}
		this.email = email;
		return this;
	}

	public UserQuery userEmailLike(String emailLike) {
		if (emailLike == null) {
			throw new LiveException("Provided emailLike is null");
		}
		this.emailLike = emailLike;
		return this;
	}

	public UserQuery memberOfGroup(String groupId) {
		if (groupId == null) {
			throw new LiveException("Provided groupIds is null or empty");
		}
		this.groupId = groupId;
		return this;
	}

	// sorting //////////////////////////////////////////////////////////

	public UserQuery orderByUserId() {
		return orderBy(UserQueryProperty.USER_ID);
	}

	public UserQuery orderByUserEmail() {
		return orderBy(UserQueryProperty.EMAIL);
	}

	public UserQuery orderByUserFirstName() {
		return orderBy(UserQueryProperty.FIRST_NAME);
	}

	public UserQuery orderByUserLastName() {
		return orderBy(UserQueryProperty.LAST_NAME);
	}

	// results //////////////////////////////////////////////////////////

	public long executeCount() {
		checkQueryOk();
		return appContext.getDao(UserDao.class).selectUserCountByQueryCriteria(
				this);
	}

	public List<User> executeList(Page page) {
		checkQueryOk();
		return appContext.getDao(UserDao.class).selectUserByQueryCriteria(this);
	}

	// getters //////////////////////////////////////////////////////////

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getFirstNameLike() {
		return firstNameLike;
	}

	public String getLastName() {
		return lastName;
	}

	public String getLastNameLike() {
		return lastNameLike;
	}

	public String getEmail() {
		return email;
	}

	public String getEmailLike() {
		return emailLike;
	}

	public String getGroupId() {
		return groupId;
	}

	public String getFullNameLike() {
		return fullNameLike;
	}
}
