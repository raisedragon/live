package com.winit.vms.shipment.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;

import com.winit.vms.shipment.entity.CalcPayableStatus;
import com.winit.vms.shipment.entity.Order;
import com.winit.vms.shipment.entity.OrderParcel;
import com.winit.vms.shipment.entity.OrderStatus;
import com.winit.vms.shipment.manager.ManifestManager;
import com.winit.vms.shipment.manager.OrderManager;
import com.winit.vms.shipment.manager.OrderParcelManager;
import com.winit.vms.spi.PreAdviceService;
import com.winit.vms.spi.command.PreAdviceCommand;
import com.winit.vms.system.BaseTest;

/**
 * <PreAdviceServiceImpl test>
 * 
 * @version <pre>
 * Author	Version		Date		Changes
 * jianfa.zhuang 	1.0  		2015-1-13 	Created
 * 
 * </pre>
 * @since 1.
 */

public class PreAdviceServiceImplTest extends BaseTest {

    @Resource
    private PreAdviceService preAdviceService;

    @Resource
    OrderManager             orderManager;

    @Resource
    OrderParcelManager       orderParcelManager;

    @Resource
    ManifestManager          manifestManager;

    @Before
    public void testAddManifest() {
        Order order = new Order();
        Integer randId = 100000;

        order.setOrderNo("ord" + randId);
        order.setName("ord" + randId);
        order.setCountryCode("US");
        order.setCity("city");
        order.setState("state");
        order.setAddress1("address1");
        order.setPostcode("postCode");
        order.setOrderStatus(OrderStatus.LGF);
        order.setOrganizationId(Long.parseLong(randId + ""));
        order.setCreated(new Date());
        order.setCreatedby("ord" + randId);
        order.setUpdated(new Date());
        order.setUpdatedby("ord" + randId);
        order.setActive(true);
        order.setProductCode("SING01");
        order.setCalcPayableStatus(CalcPayableStatus.INI);
        order.setManifestNo("manifest999");
        // 创建一实体
        orderManager.add(order);

        OrderParcel orderParcel = new OrderParcel();

        orderParcel.setOrderNo("ord" + randId);
        orderParcel.setParcelNo("ord" + randId);
        orderParcel.setProductCode("SING01");
        orderParcel.setOrganizationId(Long.parseLong(randId + ""));
        orderParcel.setCreated(new Date());
        orderParcel.setCreatedby("ord" + randId);
        orderParcel.setUpdated(new Date());
        orderParcel.setUpdatedby("ord" + randId);
        orderParcel.setActive(true);

        // 创建一实体
        orderParcelManager.add(orderParcel);

    }

    @Test
    public void preAdvice() {
        PreAdviceCommand command = new PreAdviceCommand();
        List<String> list = new ArrayList<String>();
        list.add("ord100000");
        command.setManifestNo("manifest999");
        command.setOrderNoList(list);
        command.setPayableDate(new Date());
        preAdviceService.preAdvice(command);
    }
}
