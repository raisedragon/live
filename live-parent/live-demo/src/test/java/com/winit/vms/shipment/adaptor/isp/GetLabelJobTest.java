package com.winit.vms.shipment.adaptor.isp;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.winit.vms.system.BaseTest;

@Ignore
public class GetLabelJobTest extends BaseTest {

    @Resource
    private GetLabelJob job;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Test
    public void testExecute() throws InterruptedException {
        job.execute();
    }

}
