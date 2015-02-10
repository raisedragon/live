package com.raise.live.acc.service;

import com.raise.live.acc.query.UserQuery;
import com.raise.live.core.service.Service;

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
