package com.winit.vms.shipment.adaptor.support;

import java.util.List;

import org.springframework.stereotype.Service;

import com.winit.vms.shipment.adaptor.ShipmentAdaptor.ManifestHandlerResult;
import com.winit.vms.shipment.entity.Order;

@Service
public class MockManifestHandler extends ManifestHandlerSupport {

    @Override
    public ManifestHandlerResult generateManifest(String manifestNo, List<Order> value) {
        // TODO Auto-generated method stub
        ManifestHandlerResult result = new ManifestHandlerResult();
        result.setFileCode("ABCE".getBytes());
        result.setManifestNo(manifestNo);
        return result;
    }

}
