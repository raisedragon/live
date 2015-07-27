package com.gdcc.live.identity.manager;

import com.gdcc.live.core.manager.Manager;
import com.gdcc.live.identity.entity.User;
import com.gdcc.live.identity.query.UserSelectQuery;

public interface UserManager extends Manager<User, String> {

	UserSelectQuery createUserQuery();
}
