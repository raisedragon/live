package com.winit.vms.shipment.adaptor.isp;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.winit.vms.system.BaseTest;

public class MailJobTest extends BaseTest {

    @Resource
    MailJob mailJob;

    @Test
    @Rollback(false)
    public void testExecute() {
        mailJob.execute();
    }

}
