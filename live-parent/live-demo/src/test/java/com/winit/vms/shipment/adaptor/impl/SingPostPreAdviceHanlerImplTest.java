package com.winit.vms.shipment.adaptor.impl;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.winit.vms.shipment.adaptor.ShipmentAdaptor.PreAdviceHandlerResult;
import com.winit.vms.shipment.entity.Order;
import com.winit.vms.shipment.entity.OrderParcel;
import com.winit.vms.system.BaseTest;

public class SingPostPreAdviceHanlerImplTest extends BaseTest {

    @Resource
    SingPostPreAdviceHanlerImpl singPostPreAdviceHanlerImpl;

    @Test
    public void testGenerateExcel() throws Exception {
        List<OrderParcel> parcels = new ArrayList<OrderParcel>();
        for (int i = 0; i < 1; i++) {
            OrderParcel parcel = new OrderParcel();
            parcel.setProductCode("SP001");
            parcel.setParcelNo("1338337");
            parcel.setDescription("Toys");
            parcel.setLength(BigDecimal.valueOf(1d));
            parcel.setWidth(BigDecimal.valueOf(1d));
            parcel.setHeight(BigDecimal.valueOf(1d));
            parcel.setWeight(BigDecimal.valueOf(2d));
            parcel.setValue(BigDecimal.valueOf(800d));
            parcels.add(parcel);
        }

        List<Order> orders = new ArrayList<Order>();
        for (int i = 0; i < 4; i++) {
            Order order = new Order();
            order.setOrderNo("orderNo");
            order.setParcels(parcels);
            order.setName("Michael Metcalfe");
            order.setPhone("12345");
            order.setEmail("");
            order.setCountryCode("GB");
            order.setPostcode("SE18 2PD");
            order.setCity("London");
            order.setAddress1("27 clothworkers road");
            order.setAddress2("plumstead se18 2pd");

            orders.add(order);
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        singPostPreAdviceHanlerImpl.generateExcel(orders, out, "新加坡挂号件明细");

        assertTrue(out.size() > 0);
    }

    @Test
    public void testPostPreAdvice() {
        List<OrderParcel> parcels = new ArrayList<OrderParcel>();
        for (int i = 0; i < 1; i++) {
            OrderParcel parcel = new OrderParcel();
            parcel.setProductCode("SING01");
            parcel.setParcelNo("1338337");
            parcel.setDescription("Toys");
            parcel.setLength(BigDecimal.valueOf(1d));
            parcel.setWidth(BigDecimal.valueOf(1d));
            parcel.setHeight(BigDecimal.valueOf(1d));
            parcel.setWeight(BigDecimal.valueOf(2d));
            parcel.setValue(BigDecimal.valueOf(800d));
            parcels.add(parcel);
        }

        List<Order> orders = new ArrayList<Order>();
        for (int i = 0; i < 4; i++) {
            Order order = new Order();
            order.setOrderNo("orderNo");
            order.setProductCode("SING01");
            order.setParcels(parcels);
            order.setName("Michael Metcalfe");
            order.setPhone("12345");
            order.setEmail("");
            order.setCountryCode("GB");
            order.setPostcode("SE18 2PD");
            order.setCity("London");
            order.setAddress1("27 clothworkers road");
            order.setAddress2("plumstead se18 2pd");

            orders.add(order);
        }

        PreAdviceHandlerResult result = singPostPreAdviceHanlerImpl.postPreAdvice("M001", orders);

        assertTrue(result.getPreAdvices().size() > 0);
    }
}
