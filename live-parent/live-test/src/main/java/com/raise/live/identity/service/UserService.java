package com.raise.live.identity.service;

import com.raise.live.core.service.Service;
import com.raise.live.identity.query.UserQuery;

/**
 * 用户服务
 * @author longsheng.wang
 *
 */
public interface UserService extends Service{
	/**创建用户查询对象
	 * @return
	 */
	UserQuery createUserQuery();
}
