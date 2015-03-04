package com.gdcc.live.system.dao;

import java.util.List;

import com.gdcc.live.core.dao.Dao;
import com.gdcc.live.system.entity.MailQueue;
import com.gdcc.live.system.query.MailQueueQuery;
import com.winit.common.orm.mybatis.MyBatisRepo;

/**
 * 邮件队列 Dao Change to the actual description of this class
 * 
 * @version Revision History
 * 
 * <pre>
 * Author     			Version       Date			Changes
 * longsheng.wang    	1.0       2015-01-26 09:52:56			Created
 * 
 * </pre>
 * @since 1.
 */
@MyBatisRepo
public interface MailQueueDao extends Dao<MailQueue, String> {

    /**
     * 根据查询对象查询
     * 
     * @param query
     * @return
     */
    public List<MailQueue> queryByCriteria(MailQueueQuery.FindQuery query);

    /**
     * 根据查询对象查询
     * 
     * @param query
     * @return
     */
    public long queryCountByCriteria(MailQueueQuery.FindQuery query);

    /**
     * 根据查询对象更新
     * 
     * @param query
     * @return
     */
    public void updateByUpdateQuery(MailQueueQuery.UpdateQuery uQuery);

}
