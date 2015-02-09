package com.raise.live.acc.query;

import com.raise.live.acc.entity.User;
import com.raise.live.core.query.Query;

public interface UserQuery extends Query<UserQuery, User>{
	
	UserQuery andUserNameEquel(String name);
	
	UserQuery andUserNameLike(String name);
	
	
}
