package com.winit.vms.system.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.winit.vms.system.BaseTest;
import com.winit.vms.system.entity.MailQueue;

/**
 * 邮件队列 Dao Test Case Change to the actual description of this class
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
@SuppressWarnings("deprecation")
@Ignore
public class MailQueueDaoTest extends BaseTest {

    @Resource
    private MailQueueDao mailQueueDao;

    @Test
    @Rollback(true)
    public void testCrud() {
        MailQueue mailQueue = new MailQueue();
        Integer randId = new Double(100000 * Math.random()).intValue();
        mailQueue.setId(idGenerator.getUId());
        mailQueue.setManifestNo("mai" + randId);
        mailQueue.setSubject("mai" + randId);
        mailQueue.setContent("mai" + randId);
        mailQueue.setAttachment("mai" + randId);
        mailQueue.setSendTo("mai" + randId);
        mailQueue.setCc("mai" + randId);
        mailQueue.setBcc("mai" + randId);
        mailQueue.setStatus("mai" + randId);
        mailQueue.setOrganizationId(Long.parseLong(randId + ""));
        mailQueue.setCreated(new Date());
        mailQueue.setCreatedby("mai" + randId);
        mailQueue.setUpdated(new Date());
        mailQueue.setUpdatedby("mai" + randId);
        mailQueue.setActive(true);

        // 创建一实体
        mailQueueDao.add(mailQueue);
        Assert.assertNotNull(mailQueue.getId());
        logger.debug("mailQueue1:" + mailQueue.getId());
        // 获取一实体
        MailQueue mailQueue2 = (MailQueue) mailQueueDao.get(mailQueue.getId());
        Assert.assertNotNull(mailQueue2);
        logger.debug("mailQueue2:" + mailQueue2.toString());
        Integer randId2 = new Double(100000 * Math.random()).intValue();
        mailQueue2.setManifestNo("mai" + randId2);
        mailQueue2.setSubject("mai" + randId2);
        mailQueue2.setContent("mai" + randId2);
        mailQueue2.setAttachment("mai" + randId2);
        mailQueue2.setSendTo("mai" + randId2);
        mailQueue2.setCc("mai" + randId2);
        mailQueue2.setBcc("mai" + randId2);
        mailQueue2.setStatus("mai" + randId2);
        mailQueue2.setOrganizationId(Long.parseLong(randId2 + ""));
        mailQueue2.setCreated(new Date());
        mailQueue.setCreatedby("mai" + randId2);
        mailQueue2.setUpdated(new Date());
        mailQueue.setUpdatedby("mai" + randId2);
        mailQueue.setActive(true);
        // 更新一实体
        mailQueueDao.update(mailQueue2);

        MailQueue mailQueue3 = mailQueueDao.get(mailQueue.getId());
        System.out.println("mailQueue3:" + mailQueue3.toString());
        // 删除一实体
        // mailQueueDao.tombstoned(mailQueue.getId());
    }

    @Test
    public void testCreate() {
        MailQueue mailQueue = new MailQueue();
        Integer randId = new Double(100000 * Math.random()).intValue();
        mailQueue.setId(idGenerator.getUId());
        mailQueue.setManifestNo("mai" + randId);
        mailQueue.setSubject("mai" + randId);
        mailQueue.setContent("mai" + randId);
        mailQueue.setAttachment("mai" + randId);
        mailQueue.setSendTo("mai" + randId);
        mailQueue.setCc("mai" + randId);
        mailQueue.setBcc("mai" + randId);
        mailQueue.setStatus("mai" + randId);
        mailQueue.setOrganizationId(Long.parseLong(randId + ""));
        mailQueue.setCreated(new Date());
        mailQueue.setCreatedby("mai" + randId);
        mailQueue.setUpdated(new Date());
        mailQueue.setUpdatedby("mai" + randId);
        mailQueue.setActive(true);

        // 创建一实体
        mailQueueDao.add(mailQueue);

        MailQueue mailQueue1 = mailQueueDao.get(mailQueue.getId());

        assertEquals(mailQueue.getOrganizationId(), mailQueue1.getOrganizationId());

    }

    @Test
    public void testUpdate() {
        MailQueue mailQueue = new MailQueue();
        Integer randId = new Double(100000 * Math.random()).intValue();
        mailQueue.setId(idGenerator.getUId());
        mailQueue.setManifestNo("mai" + randId);
        mailQueue.setSubject("mai" + randId);
        mailQueue.setContent("mai" + randId);
        mailQueue.setAttachment("mai" + randId);
        mailQueue.setSendTo("mai" + randId);
        mailQueue.setCc("mai" + randId);
        mailQueue.setBcc("mai" + randId);
        mailQueue.setStatus("mai" + randId);
        mailQueue.setOrganizationId(Long.parseLong(randId + ""));
        mailQueue.setCreated(new Date());
        mailQueue.setCreatedby("mai" + randId);
        mailQueue.setUpdated(new Date());
        mailQueue.setUpdatedby("mai" + randId);
        mailQueue.setActive(true);

        // 创建一实体
        mailQueueDao.add(mailQueue);

        Integer randId2 = new Double(100000 * Math.random()).intValue();
        mailQueue.setManifestNo("mai" + randId2);
        mailQueue.setSubject("mai" + randId2);
        mailQueue.setContent("mai" + randId2);
        mailQueue.setAttachment("mai" + randId2);
        mailQueue.setSendTo("mai" + randId2);
        mailQueue.setCc("mai" + randId2);
        mailQueue.setBcc("mai" + randId2);
        mailQueue.setStatus("mai" + randId2);
        mailQueue.setOrganizationId(Long.parseLong(randId2 + ""));
        mailQueue.setCreated(new Date());
        mailQueue.setCreatedby("mai" + randId2);
        mailQueue.setUpdated(new Date());
        mailQueue.setUpdatedby("mai" + randId2);
        mailQueue.setActive(true);

        // 创建一实体
        mailQueueDao.update(mailQueue);

        MailQueue mailQueue2 = mailQueueDao.get(mailQueue.getId());

        assertEquals(mailQueue.getOrganizationId(), mailQueue2.getOrganizationId());
    }

    @Test
    public void testTombstoned() {
        MailQueue mailQueue = new MailQueue();
        Integer randId = new Double(100000 * Math.random()).intValue();
        mailQueue.setId(idGenerator.getUId());
        mailQueue.setManifestNo("mai" + randId);
        mailQueue.setSubject("mai" + randId);
        mailQueue.setContent("mai" + randId);
        mailQueue.setAttachment("mai" + randId);
        mailQueue.setSendTo("mai" + randId);
        mailQueue.setCc("mai" + randId);
        mailQueue.setBcc("mai" + randId);
        mailQueue.setStatus("mai" + randId);
        mailQueue.setOrganizationId(Long.parseLong(randId + ""));
        mailQueue.setCreated(new Date());
        mailQueue.setCreatedby("mai" + randId);
        mailQueue.setUpdated(new Date());
        mailQueue.setUpdatedby("mai" + randId);
        mailQueue.setActive(true);

        // 创建一实体
        mailQueueDao.add(mailQueue);

        mailQueueDao.tombstoned(mailQueue.getId());

        MailQueue mailQueue2 = mailQueueDao.get(mailQueue.getId());

        assertNull(mailQueue2);
    }

    @Test
    public void testGet() {
        MailQueue mailQueue = new MailQueue();
        Integer randId = new Double(100000 * Math.random()).intValue();
        mailQueue.setId(idGenerator.getUId());
        mailQueue.setManifestNo("mai" + randId);
        mailQueue.setSubject("mai" + randId);
        mailQueue.setContent("mai" + randId);
        mailQueue.setAttachment("mai" + randId);
        mailQueue.setSendTo("mai" + randId);
        mailQueue.setCc("mai" + randId);
        mailQueue.setBcc("mai" + randId);
        mailQueue.setStatus("mai" + randId);
        mailQueue.setOrganizationId(Long.parseLong(randId + ""));
        mailQueue.setCreated(new Date());
        mailQueue.setCreatedby("mai" + randId);
        mailQueue.setUpdated(new Date());
        mailQueue.setUpdatedby("mai" + randId);
        mailQueue.setActive(true);

        // 创建一实体
        mailQueueDao.add(mailQueue);

        MailQueue mailQueue2 = mailQueueDao.get(mailQueue.getId());

        assertEquals(mailQueue.getCreatedby(), mailQueue2.getCreatedby());
    }

}
