package com.gdcc.live.system.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdcc.live.core.dao.Dao;
import com.gdcc.live.core.manager.AbstractManager;
import com.gdcc.live.system.dao.MailQueueDao;
import com.gdcc.live.system.entity.MailQueue;
import com.gdcc.live.system.manager.MailQueueManager;
import com.gdcc.live.system.query.MailQueueQuery;

/**
 * 邮件队列 Manager impl Change to the actual description of this class
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
public class MailQueueManagerImpl extends AbstractManager<MailQueue,String> implements MailQueueManager {

    @Resource
    MailQueueDao mailQueueDao;

    @Override
    protected Dao<MailQueue, String> getDao() {
        return mailQueueDao;
    }

    @Override
    public List<MailQueue> queryByCriteria(MailQueueQuery.FindQuery query) {
        return mailQueueDao.queryByCriteria(query);
    }

    @Override
    public long queryCountByCriteria(MailQueueQuery.FindQuery query) {
        return mailQueueDao.queryCountByCriteria(query);
    }

    @Override
    public void updateByUpdateQuery(MailQueueQuery.UpdateQuery uQuery) {
        mailQueueDao.updateByUpdateQuery(uQuery);
    }

}
