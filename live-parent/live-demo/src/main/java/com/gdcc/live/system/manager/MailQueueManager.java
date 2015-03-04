package com.gdcc.live.system.manager;

import java.util.List;

import com.gdcc.live.core.manager.Manager;
import com.gdcc.live.system.entity.MailQueue;
import com.gdcc.live.system.query.MailQueueQuery;

/**
 * 邮件队列 Manager Change to the actual description of this class
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
public interface MailQueueManager extends Manager<MailQueue,String> {

    /**
     * 根据查询对象查询
     * 
     * @param query
     * @return
     */
    List<MailQueue> queryByCriteria(MailQueueQuery.FindQuery query);

    /**
     * 根据查询对象查询
     * 
     * @param query
     * @return
     */
    long queryCountByCriteria(MailQueueQuery.FindQuery query);

    /**
     * 根据查询对象更新
     * 
     * @param query
     * @return
     */
    void updateByUpdateQuery(MailQueueQuery.UpdateQuery uQuery);

    /**
     * 设置记录为有效状态
     * 
     * @param id
     */
    void enable(String id);

    /**
     * 设置记录为无效状态
     * 
     * @param id
     */
    void disable(String id);
}
