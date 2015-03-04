package com.winit.vms.system.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.winit.vms.system.BaseTest;
import com.winit.vms.system.entity.SchedulerJob;

public class SchedulerJobManagerTest extends BaseTest {

    @Resource
    SchedulerJobManager schedulerJobManager;

    @Test
    public void testCreate() {
        SchedulerJob schedulerJob = new SchedulerJob();
        Integer randId = new Double(100000 * Math.random()).intValue();

        schedulerJob.setJobName("sch" + randId);
        schedulerJob.setBeanClass("sch" + randId);
        schedulerJob.setMethodName("sch" + randId);
        schedulerJob.setJobStatus("1");
        schedulerJob.setOrganizationId(Long.parseLong(randId + ""));
        schedulerJob.setCreated(new Date());
        schedulerJob.setCreatedby("sch" + randId);
        schedulerJob.setUpdated(new Date());
        schedulerJob.setUpdatedby("sch" + randId);
        schedulerJob.setActive(true);

        // 创建一实体
        schedulerJobManager.add(schedulerJob);

        SchedulerJob schedulerJob1 = schedulerJobManager.get(schedulerJob.getId());

        assertEquals(schedulerJob.getOrganizationId(), schedulerJob1.getOrganizationId());

    }

    @Test
    public void testUpdate() {
        SchedulerJob schedulerJob = new SchedulerJob();
        Integer randId = new Double(100000 * Math.random()).intValue();

        schedulerJob.setJobName("sch" + randId);
        schedulerJob.setBeanClass("sch" + randId);
        schedulerJob.setMethodName("sch" + randId);
        schedulerJob.setJobStatus("1");
        schedulerJob.setOrganizationId(Long.parseLong(randId + ""));
        schedulerJob.setCreated(new Date());
        schedulerJob.setCreatedby("sch" + randId);
        schedulerJob.setUpdated(new Date());
        schedulerJob.setUpdatedby("sch" + randId);
        schedulerJob.setActive(true);

        // 创建一实体
        schedulerJobManager.add(schedulerJob);

        Integer randId2 = new Double(100000 * Math.random()).intValue();
        schedulerJob.setJobName("sch" + randId2);
        schedulerJob.setBeanClass("sch" + randId2);
        schedulerJob.setMethodName("sch" + randId2);
        schedulerJob.setJobStatus("1");
        schedulerJob.setOrganizationId(Long.parseLong(randId2 + ""));
        schedulerJob.setCreated(new Date());
        schedulerJob.setCreatedby("sch" + randId2);
        schedulerJob.setUpdated(new Date());
        schedulerJob.setUpdatedby("sch" + randId2);
        schedulerJob.setActive(true);

        // 创建一实体
        schedulerJobManager.update(schedulerJob);

        SchedulerJob schedulerJob2 = schedulerJobManager.get(schedulerJob.getId());

        assertEquals(schedulerJob.getOrganizationId(), schedulerJob2.getOrganizationId());
    }

    @Test
    public void testTombstoned() {
        SchedulerJob schedulerJob = new SchedulerJob();
        Integer randId = new Double(100000 * Math.random()).intValue();

        schedulerJob.setJobName("sch" + randId);
        schedulerJob.setBeanClass("sch" + randId);
        schedulerJob.setMethodName("sch" + randId);
        schedulerJob.setJobStatus("1");
        schedulerJob.setOrganizationId(Long.parseLong(randId + ""));
        schedulerJob.setCreated(new Date());
        schedulerJob.setCreatedby("sch" + randId);
        schedulerJob.setUpdated(new Date());
        schedulerJob.setUpdatedby("sch" + randId);
        schedulerJob.setActive(true);

        // 创建一实体
        schedulerJobManager.add(schedulerJob);

        schedulerJobManager.tombstoned(schedulerJob.getId());

        SchedulerJob schedulerJob2 = schedulerJobManager.get(schedulerJob.getId());

        assertNull(schedulerJob2);
    }

    @Test
    public void testGet() {
        SchedulerJob schedulerJob = new SchedulerJob();
        Integer randId = new Double(100000 * Math.random()).intValue();

        schedulerJob.setJobName("sch" + randId);
        schedulerJob.setBeanClass("sch" + randId);
        schedulerJob.setMethodName("sch" + randId);
        schedulerJob.setJobStatus("1");
        schedulerJob.setOrganizationId(Long.parseLong(randId + ""));
        schedulerJob.setCreated(new Date());
        schedulerJob.setCreatedby("sch" + randId);
        schedulerJob.setUpdated(new Date());
        schedulerJob.setUpdatedby("sch" + randId);
        schedulerJob.setActive(true);

        // 创建一实体
        schedulerJobManager.add(schedulerJob);

        SchedulerJob schedulerJob2 = schedulerJobManager.get(schedulerJob.getId());

        assertEquals(schedulerJob.getCreatedby(), schedulerJob2.getCreatedby());
    }

}
