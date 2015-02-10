package com.raise.live.identity.query;

import com.raise.live.core.query.Query;
import com.raise.live.identity.entity.User;

/**
 * 用户查询对象
 * @author longsheng.wang
 *
 */
public interface UserQuery extends Query<UserQuery, User>{
	
	UserQuery andUserNameEquel(String name);
	
	UserQuery andUserNameLike(String name);
	
	
}
