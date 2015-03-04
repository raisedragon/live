package com.winit.vms.shipment.adaptor.isp;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.winit.vms.system.BaseTest;

public class ShipmentCompensationJobTest extends BaseTest {

    @Resource
    ShipmentCompensationJob shipmentCompensation;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Test
    @Rollback(false)
    public void testExecute() {
        shipmentCompensation.execute();
    }

}
