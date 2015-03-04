package com.winit.vms.shipment.adaptor.support;

import org.springframework.stereotype.Service;

import com.winit.vms.shipment.adaptor.ShipmentAdaptor.LabelHanlerResult;
import com.winit.vms.shipment.adaptor.ShipmentAdaptor.LabelHanlerResult.Label;
import com.winit.vms.shipment.entity.Order;
import com.winit.vms.shipment.entity.OrderParcel;

@Service
public class MockLabelHander extends LabelHandlerSupport {

    @Override
    public LabelHanlerResult getLabel(Order order) {
        LabelHanlerResult result = new LabelHanlerResult();
        result.setOrderNo(order.getOrderNo());
        result.setVenderOrderNo("V001");
        for (OrderParcel orderParcel : order.getParcels()) {
            Label l = new Label();
            l.setFileCode("fiel".getBytes());
            l.setParcelNo(orderParcel.getParcelNo());
            l.setShipmentNo("SIP001");
            result.getLabels().add(l);
        }
        return result;
    }

}
