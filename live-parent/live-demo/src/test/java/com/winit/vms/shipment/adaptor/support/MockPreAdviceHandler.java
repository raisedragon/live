package com.winit.vms.shipment.adaptor.support;

import java.util.List;

import org.springframework.stereotype.Service;

import com.winit.vms.shipment.adaptor.ShipmentAdaptor.PreAdviceHandlerResult;
import com.winit.vms.shipment.adaptor.ShipmentAdaptor.PreAdviceHandlerResult.PreAdvice;
import com.winit.vms.shipment.entity.Order;

@Service
public class MockPreAdviceHandler extends PreAdviceHandlerSupport {

    @Override
    public PreAdviceHandlerResult postPreAdvice(String manifestNo, List<Order> value) {
        PreAdviceHandlerResult result = new PreAdviceHandlerResult();
        for (int i = 0; i < 10; i++) {
            PreAdvice e = new PreAdvice();
            e.setFileCode("BBB".getBytes());
            e.setFilename("file" + i);
            result.getPreAdvices().add(e);
        }
        return result;
    }

}
