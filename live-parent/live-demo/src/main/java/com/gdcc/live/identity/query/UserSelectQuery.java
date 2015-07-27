package com.gdcc.live.identity.query;

import java.util.List;

import com.gdcc.live.core.context.AppContext;
import com.gdcc.live.core.exception.LiveException;
import com.gdcc.live.core.query.AbstractQuery;
import com.gdcc.live.core.query.Page;
import com.gdcc.live.identity.dao.UserDao;
import com.gdcc.live.identity.entity.User;

public class UserSelectQuery extends AbstractQuery<UserSelectQuery,User>  {
    
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserCriteria criteria;

	public UserSelectQuery(AppContext appContext) {
		super(appContext);
		criteria = new UserCriteria();
	}
	
	public UserCriteria getCriteria() {
		return criteria;
	}

	// sorting //////////////////////////////////////////////////////////

	public UserSelectQuery orderByUserId() {
		return orderBy(UserProperty.COLUMN_NAME_id);
	}

	public UserSelectQuery orderByUserEmail() {
		return orderBy(UserProperty.COLUMN_NAME_email);
	}

	public UserSelectQuery orderByUserFirstName() {
		return orderBy(UserProperty.COLUMN_NAME_firstName);
	}

	public UserSelectQuery orderByUserLastName() {
		return orderBy(UserProperty.COLUMN_NAME_lastName);
	}

	// results //////////////////////////////////////////////////////////

	public long executeCount() {
		checkQueryOk();
		return appContext.getDao(UserDao.class).selectCountByCriteria(
				this);
	}

	public List<User> executeList(Page page) {
		checkQueryOk();
		return appContext.getDao(UserDao.class).selectByCriteria(this);
	}


}
