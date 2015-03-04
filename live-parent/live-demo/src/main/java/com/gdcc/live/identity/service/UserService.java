package com.gdcc.live.identity.service;

import com.gdcc.live.core.service.Service;
import com.gdcc.live.identity.query.UserQuery;


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
