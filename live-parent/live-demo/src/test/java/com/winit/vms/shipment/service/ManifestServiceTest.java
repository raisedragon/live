package com.winit.vms.shipment.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;

import com.winit.vms.shipment.entity.CalcPayableStatus;
import com.winit.vms.shipment.entity.ManifestStatus;
import com.winit.vms.shipment.entity.Order;
import com.winit.vms.shipment.entity.OrderParcel;
import com.winit.vms.shipment.entity.OrderStatus;
import com.winit.vms.shipment.manager.ManifestManager;
import com.winit.vms.shipment.manager.OrderManager;
import com.winit.vms.shipment.manager.OrderParcelManager;
import com.winit.vms.spi.ManifestService;
import com.winit.vms.spi.command.GetManifestCommand;
import com.winit.vms.spi.vo.Manifest;
import com.winit.vms.system.BaseTest;

/**
 * <SPI SERVICE TEST CLASS>
 * 
 * @version <pre>
 * Author	Version		Date		Changes
 * jianfa.zhuang 	1.0  		2015-1-12 	Created
 * 
 * </pre>
 * @since 1.
 */
public class ManifestServiceTest extends BaseTest {

    @Resource
    private ManifestService manifestService;

    @Resource
    OrderManager            orderManager;

    @Resource
    OrderParcelManager      orderParcelManager;

    @Resource
    ManifestManager         manifestManager;

    @Before
    public void testAddManifest() {
        Order order = new Order();
        Integer randId = new Double(100000 * Math.random()).intValue();

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
        Integer randId2 = new Double(100000 * Math.random()).intValue();

        orderParcel.setOrderNo("ord" + randId2);
        orderParcel.setParcelNo("ord" + randId2);
        orderParcel.setProductCode("SING01");
        orderParcel.setOrganizationId(Long.parseLong(randId2 + ""));
        orderParcel.setCreated(new Date());
        orderParcel.setCreatedby("ord" + randId2);
        orderParcel.setUpdated(new Date());
        orderParcel.setUpdatedby("ord" + randId2);
        orderParcel.setActive(true);

        // 创建一实体
        orderParcelManager.add(orderParcel);

        com.winit.vms.shipment.entity.Manifest manifest = new com.winit.vms.shipment.entity.Manifest();
        Integer randId3 = new Double(100000 * Math.random()).intValue();
        manifest.setManifestNo("manifest999");
        manifest.setOrganizationId(Long.parseLong(randId3 + ""));
        manifest.setCreated(new Date());
        manifest.setCreatedby("man" + randId);
        manifest.setUpdated(new Date());
        manifest.setUpdatedby("man" + randId);
        manifest.setActive(true);
        manifest.setStatus(ManifestStatus.INI);
        manifest.setProductCode("SING01");
        // 创建一实体
        manifestManager.add(manifest);
    }

    @Test
    public void testManifestService() {
        String manifestNo = "manifest999";
        GetManifestCommand command = new GetManifestCommand();
        command.setManifestNo(manifestNo);
        Manifest manifest = manifestService.getManifest(command);
        assertEquals(manifest.getManifestNo(), manifestNo);
    }
}
