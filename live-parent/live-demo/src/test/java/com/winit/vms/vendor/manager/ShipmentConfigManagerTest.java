package com.winit.vms.vendor.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.winit.vms.system.BaseTest;
import com.winit.vms.vendor.entity.ShipmentConfig;

/**
 * 供应商产品对接配置项 Manager Test Case Change to the actual description of this class
 * 
 * @version Revision History
 * 
 * <pre>
 * Author     			Version       Date			Changes
 * longsheng.wang    	1.0       2015-01-10 20:21:57			Created
 * 
 * </pre>
 * @since 1.
 */

public class ShipmentConfigManagerTest extends BaseTest {

    @Resource
    ShipmentConfigManager shipmentConfigManager;

    @Test
    public void testCreate() {
        ShipmentConfig shipmentConfig = new ShipmentConfig();
        Integer randId = new Double(100000 * Math.random()).intValue();

        shipmentConfig.setProductCode("shi" + randId);
        shipmentConfig.setName("shi" + randId);
        shipmentConfig.setOrganizationId(Long.parseLong(randId + ""));
        shipmentConfig.setCreated(new Date());
        shipmentConfig.setCreatedby("shi" + randId);
        shipmentConfig.setUpdated(new Date());
        shipmentConfig.setUpdatedby("shi" + randId);
        shipmentConfig.setActive(true);

        // 创建一实体
        shipmentConfigManager.add(shipmentConfig);

        ShipmentConfig shipmentConfig1 = shipmentConfigManager.get(shipmentConfig.getId());

        assertEquals(shipmentConfig.getOrganizationId(), shipmentConfig1.getOrganizationId());

    }

    @Test
    public void testUpdate() {
        ShipmentConfig shipmentConfig = new ShipmentConfig();
        Integer randId = new Double(100000 * Math.random()).intValue();

        shipmentConfig.setProductCode("shi" + randId);
        shipmentConfig.setName("shi" + randId);
        shipmentConfig.setOrganizationId(Long.parseLong(randId + ""));
        shipmentConfig.setCreated(new Date());
        shipmentConfig.setCreatedby("shi" + randId);
        shipmentConfig.setUpdated(new Date());
        shipmentConfig.setUpdatedby("shi" + randId);
        shipmentConfig.setActive(true);

        // 创建一实体
        shipmentConfigManager.add(shipmentConfig);

        Integer randId2 = new Double(100000 * Math.random()).intValue();
        shipmentConfig.setProductCode("shi" + randId2);
        shipmentConfig.setName("shi" + randId2);
        shipmentConfig.setOrganizationId(Long.parseLong(randId2 + ""));
        shipmentConfig.setCreated(new Date());
        shipmentConfig.setCreatedby("shi" + randId2);
        shipmentConfig.setUpdated(new Date());
        shipmentConfig.setUpdatedby("shi" + randId2);
        shipmentConfig.setActive(true);

        // 创建一实体
        shipmentConfigManager.update(shipmentConfig);

        ShipmentConfig shipmentConfig2 = shipmentConfigManager.get(shipmentConfig.getId());

        assertEquals(shipmentConfig.getOrganizationId(), shipmentConfig2.getOrganizationId());
    }

    @Test
    public void testTombstoned() {
        ShipmentConfig shipmentConfig = new ShipmentConfig();
        Integer randId = new Double(100000 * Math.random()).intValue();

        shipmentConfig.setProductCode("shi" + randId);
        shipmentConfig.setName("shi" + randId);
        shipmentConfig.setOrganizationId(Long.parseLong(randId + ""));
        shipmentConfig.setCreated(new Date());
        shipmentConfig.setCreatedby("shi" + randId);
        shipmentConfig.setUpdated(new Date());
        shipmentConfig.setUpdatedby("shi" + randId);
        shipmentConfig.setActive(true);

        // 创建一实体
        shipmentConfigManager.add(shipmentConfig);

        shipmentConfigManager.tombstoned(shipmentConfig.getId());

        ShipmentConfig shipmentConfig2 = shipmentConfigManager.get(shipmentConfig.getId());

        assertNull(shipmentConfig2);
    }

    @Test
    public void testGet() {
        ShipmentConfig shipmentConfig = new ShipmentConfig();
        Integer randId = new Double(100000 * Math.random()).intValue();

        shipmentConfig.setProductCode("shi" + randId);
        shipmentConfig.setName("shi" + randId);
        shipmentConfig.setOrganizationId(Long.parseLong(randId + ""));
        shipmentConfig.setCreated(new Date());
        shipmentConfig.setCreatedby("shi" + randId);
        shipmentConfig.setUpdated(new Date());
        shipmentConfig.setUpdatedby("shi" + randId);
        shipmentConfig.setActive(true);

        // 创建一实体
        shipmentConfigManager.add(shipmentConfig);

        ShipmentConfig shipmentConfig2 = shipmentConfigManager.get(shipmentConfig.getId());

        assertEquals(shipmentConfig.getCreatedby(), shipmentConfig2.getCreatedby());
    }

}
