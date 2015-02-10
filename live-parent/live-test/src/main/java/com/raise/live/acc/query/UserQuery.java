package com.raise.live.acc.query;

import com.raise.live.acc.entity.User;
import com.raise.live.core.query.Query;

/**
 * 用户查询对象
 * @author longsheng.wang
 *
 */
public interface UserQuery extends Query<UserQuery, User>{
	
	UserQuery andUserNameEquel(String name);
	
	UserQuery andUserNameLike(String name);
	
	
}
