package com.winit.vms.shipment.adaptor.isp;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;

import com.winit.vms.system.BaseTest;

@Ignore
public class TestTrack extends BaseTest {

    @Resource
    private SingpostTrackTask        singpostTrackTask;

    @Resource
    private WriteBackOrderStatusTask writeBackOrderStatusTask;

    @Test
    public void testSingPost() {
        singpostTrackTask.execute();
    }

    @Test
    public void testWriteBack() {
        writeBackOrderStatusTask.writeBackOrderStatus();
    }
}
