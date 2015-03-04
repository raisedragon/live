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
import com.winit.vms.system.entity.SchedulerJob;

@SuppressWarnings("deprecation")
@Ignore
public class SchedulerJobDaoTest extends BaseTest {

    @Resource
    private SchedulerJobDao schedulerJobDao;

    @Test
    @Rollback(true)
    public void testCrud() {
        SchedulerJob schedulerJob = new SchedulerJob();
        Integer randId = new Double(100000 * Math.random()).intValue();

        schedulerJob.setJobName("sch" + randId);
        schedulerJob.setBeanClass("sch" + randId);
        schedulerJob.setMethodName("sch" + randId);
        schedulerJob.setCronExpression("sch" + randId);
        schedulerJob.setIpAddress("sch" + randId);
        schedulerJob.setJobStatus("1");
        schedulerJob.setCode("sch" + randId);
        schedulerJob.setJobGroup("sch" + randId);
        schedulerJob.setSpringId("sch" + randId);
        schedulerJob.setConcurrent(false);
        schedulerJob.setOrganizationId(Long.parseLong(randId + ""));
        schedulerJob.setCreated(new Date());
        schedulerJob.setCreatedby("sch" + randId);
        schedulerJob.setUpdated(new Date());
        schedulerJob.setUpdatedby("sch" + randId);
        schedulerJob.setActive(true);

        // 创建一实体
        schedulerJobDao.add(schedulerJob);
        Assert.assertNotNull(schedulerJob.getId());
        logger.debug("schedulerJob1:" + schedulerJob.getId());
        // 获取一实体
        SchedulerJob schedulerJob2 = (SchedulerJob) schedulerJobDao.get(schedulerJob.getId());
        Assert.assertNotNull(schedulerJob2);
        logger.debug("schedulerJob2:" + schedulerJob2.toString());
        Integer randId2 = new Double(100000 * Math.random()).intValue();

        schedulerJob2.setJobName("sch" + randId2);

        schedulerJob2.setBeanClass("sch" + randId2);

        schedulerJob2.setMethodName("sch" + randId2);

        schedulerJob2.setCronExpression("sch" + randId2);

        schedulerJob2.setIpAddress("sch" + randId2);

        schedulerJob2.setJobStatus("1");

        schedulerJob2.setCode("sch" + randId2);

        schedulerJob2.setJobGroup("sch" + randId2);

        schedulerJob2.setSpringId("sch" + randId2);

        schedulerJob2.setConcurrent(false);

        schedulerJob2.setOrganizationId(Long.parseLong(randId2 + ""));

        schedulerJob2.setCreated(new Date());

        schedulerJob.setCreatedby("sch" + randId2);

        schedulerJob2.setUpdated(new Date());

        schedulerJob.setUpdatedby("sch" + randId2);

        schedulerJob.setActive(true);

        // 更新一实体
        schedulerJobDao.update(schedulerJob2);

        SchedulerJob schedulerJob3 = schedulerJobDao.get(schedulerJob.getId());
        System.out.println("schedulerJob3:" + schedulerJob3.toString());
        // 删除一实体
        // schedulerJobDao.tombstoned(schedulerJob.getId());
    }

    @Test
    public void testCreate() {
        SchedulerJob schedulerJob = new SchedulerJob();
        Integer randId = new Double(100000 * Math.random()).intValue();

        schedulerJob.setJobName("sch" + randId);
        schedulerJob.setBeanClass("sch" + randId);
        schedulerJob.setMethodName("sch" + randId);
        schedulerJob.setCronExpression("sch" + randId);
        schedulerJob.setIpAddress("sch" + randId);
        schedulerJob.setJobStatus("1");
        schedulerJob.setCode("sch" + randId);
        schedulerJob.setJobGroup("sch" + randId);
        schedulerJob.setSpringId("sch" + randId);
        schedulerJob.setConcurrent(false);
        schedulerJob.setOrganizationId(Long.parseLong(randId + ""));
        schedulerJob.setCreated(new Date());
        schedulerJob.setCreatedby("sch" + randId);
        schedulerJob.setUpdated(new Date());
        schedulerJob.setUpdatedby("sch" + randId);
        schedulerJob.setActive(true);

        // 创建一实体
        schedulerJobDao.add(schedulerJob);

        SchedulerJob schedulerJob1 = schedulerJobDao.get(schedulerJob.getId());

        assertEquals(schedulerJob.getOrganizationId(), schedulerJob1.getOrganizationId());

    }

    @Test
    public void testUpdate() {
        SchedulerJob schedulerJob = new SchedulerJob();
        Integer randId = new Double(100000 * Math.random()).intValue();

        schedulerJob.setJobName("sch" + randId);
        schedulerJob.setBeanClass("sch" + randId);
        schedulerJob.setMethodName("sch" + randId);
        schedulerJob.setCronExpression("sch" + randId);
        schedulerJob.setIpAddress("sch" + randId);
        schedulerJob.setJobStatus("1");
        schedulerJob.setCode("sch" + randId);
        schedulerJob.setJobGroup("sch" + randId);
        schedulerJob.setSpringId("sch" + randId);
        schedulerJob.setConcurrent(false);
        schedulerJob.setOrganizationId(Long.parseLong(randId + ""));
        schedulerJob.setCreated(new Date());
        schedulerJob.setCreatedby("sch" + randId);
        schedulerJob.setUpdated(new Date());
        schedulerJob.setUpdatedby("sch" + randId);
        schedulerJob.setActive(true);

        // 创建一实体
        schedulerJobDao.add(schedulerJob);

        Integer randId2 = new Double(100000 * Math.random()).intValue();

        schedulerJob.setJobName("sch" + randId2);

        schedulerJob.setBeanClass("sch" + randId2);

        schedulerJob.setMethodName("sch" + randId2);

        schedulerJob.setCronExpression("sch" + randId2);

        schedulerJob.setIpAddress("sch" + randId2);

        schedulerJob.setJobStatus("1");

        schedulerJob.setCode("sch" + randId2);

        schedulerJob.setJobGroup("sch" + randId2);

        schedulerJob.setSpringId("sch" + randId2);

        schedulerJob.setConcurrent(false);

        schedulerJob.setOrganizationId(Long.parseLong(randId2 + ""));

        schedulerJob.setCreated(new Date());

        schedulerJob.setCreatedby("sch" + randId2);

        schedulerJob.setUpdated(new Date());

        schedulerJob.setUpdatedby("sch" + randId2);

        schedulerJob.setActive(true);

        // 创建一实体
        schedulerJobDao.update(schedulerJob);

        SchedulerJob schedulerJob2 = schedulerJobDao.get(schedulerJob.getId());

        assertEquals(schedulerJob.getOrganizationId(), schedulerJob2.getOrganizationId());
    }

    @Test
    public void testTombstoned() {
        SchedulerJob schedulerJob = new SchedulerJob();
        Integer randId = new Double(100000 * Math.random()).intValue();

        schedulerJob.setJobName("sch" + randId);
        schedulerJob.setBeanClass("sch" + randId);
        schedulerJob.setMethodName("sch" + randId);
        schedulerJob.setCronExpression("sch" + randId);
        schedulerJob.setIpAddress("sch" + randId);
        schedulerJob.setJobStatus("1");
        schedulerJob.setCode("sch" + randId);
        schedulerJob.setJobGroup("sch" + randId);
        schedulerJob.setSpringId("sch" + randId);
        schedulerJob.setConcurrent(false);
        schedulerJob.setOrganizationId(Long.parseLong(randId + ""));
        schedulerJob.setCreated(new Date());
        schedulerJob.setCreatedby("sch" + randId);
        schedulerJob.setUpdated(new Date());
        schedulerJob.setUpdatedby("sch" + randId);
        schedulerJob.setActive(true);

        // 创建一实体
        schedulerJobDao.add(schedulerJob);

        schedulerJobDao.tombstoned(schedulerJob.getId());

        SchedulerJob schedulerJob2 = schedulerJobDao.get(schedulerJob.getId());

        assertNull(schedulerJob2);
    }

    @Test
    public void testGet() {
        SchedulerJob schedulerJob = new SchedulerJob();
        Integer randId = new Double(100000 * Math.random()).intValue();

        schedulerJob.setJobName("sch" + randId);
        schedulerJob.setBeanClass("sch" + randId);
        schedulerJob.setMethodName("sch" + randId);
        schedulerJob.setCronExpression("sch" + randId);
        schedulerJob.setIpAddress("sch" + randId);
        schedulerJob.setJobStatus("1");
        schedulerJob.setCode("sch" + randId);
        schedulerJob.setJobGroup("sch" + randId);
        schedulerJob.setSpringId("sch" + randId);
        schedulerJob.setConcurrent(false);
        schedulerJob.setOrganizationId(Long.parseLong(randId + ""));
        schedulerJob.setCreated(new Date());
        schedulerJob.setCreatedby("sch" + randId);
        schedulerJob.setUpdated(new Date());
        schedulerJob.setUpdatedby("sch" + randId);
        schedulerJob.setActive(true);

        // 创建一实体
        schedulerJobDao.add(schedulerJob);

        SchedulerJob schedulerJob2 = schedulerJobDao.get(schedulerJob.getId());

        assertEquals(schedulerJob.getCreatedby(), schedulerJob2.getCreatedby());
    }

}
