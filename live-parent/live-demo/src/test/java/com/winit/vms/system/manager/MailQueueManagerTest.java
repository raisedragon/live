package com.winit.vms.system.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.winit.vms.system.BaseTest;
import com.winit.vms.system.entity.MailQueue;

/**
 * 邮件队列 Manager Test Case Change to the actual description of this class
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
public class MailQueueManagerTest extends BaseTest {

    @Resource
    MailQueueManager mailQueueManager;

    @Test
    public void testCreate() {
        MailQueue mailQueue = new MailQueue();
        Integer randId = new Double(100000 * Math.random()).intValue();
        mailQueue.setId(idGenerator.getUId());
        mailQueue.setSubject("mai" + randId);
        mailQueue.setSendTo("mai" + randId);
        mailQueue.setStatus("mai" + randId);
        mailQueue.setOrganizationId(Long.parseLong(randId + ""));
        mailQueue.setCreated(new Date());
        mailQueue.setCreatedby("mai" + randId);
        mailQueue.setUpdated(new Date());
        mailQueue.setUpdatedby("mai" + randId);
        mailQueue.setActive(true);

        // 创建一实体
        mailQueueManager.add(mailQueue);

        MailQueue mailQueue1 = mailQueueManager.get(mailQueue.getId());

        assertEquals(mailQueue.getOrganizationId(), mailQueue1.getOrganizationId());

    }

    @Test
    public void testUpdate() {
        MailQueue mailQueue = new MailQueue();
        Integer randId = new Double(100000 * Math.random()).intValue();
        mailQueue.setId(idGenerator.getUId());
        mailQueue.setSubject("mai" + randId);
        mailQueue.setSendTo("mai" + randId);
        mailQueue.setStatus("mai" + randId);
        mailQueue.setOrganizationId(Long.parseLong(randId + ""));
        mailQueue.setCreated(new Date());
        mailQueue.setCreatedby("mai" + randId);
        mailQueue.setUpdated(new Date());
        mailQueue.setUpdatedby("mai" + randId);
        mailQueue.setActive(true);

        // 创建一实体
        mailQueueManager.add(mailQueue);

        Integer randId2 = new Double(100000 * Math.random()).intValue();
        mailQueue.setSubject("mai" + randId2);
        mailQueue.setSendTo("mai" + randId2);
        mailQueue.setStatus("mai" + randId2);
        mailQueue.setOrganizationId(Long.parseLong(randId2 + ""));
        mailQueue.setCreated(new Date());
        mailQueue.setCreatedby("mai" + randId2);
        mailQueue.setUpdated(new Date());
        mailQueue.setUpdatedby("mai" + randId2);
        mailQueue.setActive(true);

        // 创建一实体
        mailQueueManager.update(mailQueue);

        MailQueue mailQueue2 = mailQueueManager.get(mailQueue.getId());

        assertEquals(mailQueue.getOrganizationId(), mailQueue2.getOrganizationId());
    }

    @Test
    public void testTombstoned() {
        MailQueue mailQueue = new MailQueue();
        Integer randId = new Double(100000 * Math.random()).intValue();
        mailQueue.setId(idGenerator.getUId());
        mailQueue.setSubject("mai" + randId);
        mailQueue.setSendTo("mai" + randId);
        mailQueue.setStatus("mai" + randId);
        mailQueue.setOrganizationId(Long.parseLong(randId + ""));
        mailQueue.setCreated(new Date());
        mailQueue.setCreatedby("mai" + randId);
        mailQueue.setUpdated(new Date());
        mailQueue.setUpdatedby("mai" + randId);
        mailQueue.setActive(true);

        // 创建一实体
        mailQueueManager.add(mailQueue);

        mailQueueManager.tombstoned(mailQueue.getId());

        MailQueue mailQueue2 = mailQueueManager.get(mailQueue.getId());

        assertNull(mailQueue2);
    }

    @Test
    public void testGet() {
        MailQueue mailQueue = new MailQueue();
        Integer randId = new Double(100000 * Math.random()).intValue();
        mailQueue.setId(idGenerator.getUId());
        mailQueue.setSubject("mai" + randId);
        mailQueue.setSendTo("mai" + randId);
        mailQueue.setStatus("mai" + randId);
        mailQueue.setOrganizationId(Long.parseLong(randId + ""));
        mailQueue.setCreated(new Date());
        mailQueue.setCreatedby("mai" + randId);
        mailQueue.setUpdated(new Date());
        mailQueue.setUpdatedby("mai" + randId);
        mailQueue.setActive(true);

        // 创建一实体
        mailQueueManager.add(mailQueue);

        MailQueue mailQueue2 = mailQueueManager.get(mailQueue.getId());

        assertEquals(mailQueue.getCreatedby(), mailQueue2.getCreatedby());
    }

}
