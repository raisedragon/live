package com.winit.vms.shipment.adaptor.impl;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.winit.vms.shipment.adaptor.ShipmentAdaptor.ManifestHandlerResult;
import com.winit.vms.shipment.entity.Order;
import com.winit.vms.system.BaseTest;

public class SingPostManifestHandlerImplTest extends BaseTest {

    @Resource
    private SingPostManifestHandlerImpl singPostManifestHandlerImpl;

    @Test
    public void testGetManifest() throws Exception {
        List<Order> orders = new ArrayList<Order>();
        Order o = new Order();
        o.setProductCode("SING01");
        orders.add(o);

        ManifestHandlerResult result = singPostManifestHandlerImpl.getManifest("123", orders);
        byte[] data = result.getFileCode();

        assertTrue(data.length > 0);
    }
}
