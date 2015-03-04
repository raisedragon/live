package com.winit.vms.vendor.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.winit.vms.system.BaseTest;
import com.winit.vms.vendor.entity.ShipmentStautsMapping;

/**
 * 轨迹状态映射 Manager Test Case Change to the actual description of this class
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
public class ShipmentStautsMappingManagerTest extends BaseTest {

    @Resource
    ShipmentStautsMappingManager shipmentStautsMappingManager;

    @Test
    public void testCreate() {
        ShipmentStautsMapping shipmentStautsMapping = new ShipmentStautsMapping();
        Integer randId = new Double(100000 * Math.random()).intValue();

        shipmentStautsMapping.setCategoryCode("shi" + randId);
        shipmentStautsMapping.setVendorCode("shi" + randId);
        shipmentStautsMapping.setWinitCode("shi" + randId);
        shipmentStautsMapping.setOrganizationId(Long.parseLong(randId + ""));
        shipmentStautsMapping.setCreated(new Date());
        shipmentStautsMapping.setCreatedby("shi" + randId);
        shipmentStautsMapping.setUpdated(new Date());
        shipmentStautsMapping.setUpdatedby("shi" + randId);
        shipmentStautsMapping.setActive(true);

        // 创建一实体
        shipmentStautsMappingManager.add(shipmentStautsMapping);

        ShipmentStautsMapping shipmentStautsMapping1 = shipmentStautsMappingManager.get(shipmentStautsMapping.getId());

        assertEquals(shipmentStautsMapping.getOrganizationId(), shipmentStautsMapping1.getOrganizationId());

    }

    @Test
    public void testUpdate() {
        ShipmentStautsMapping shipmentStautsMapping = new ShipmentStautsMapping();
        Integer randId = new Double(100000 * Math.random()).intValue();

        shipmentStautsMapping.setCategoryCode("shi" + randId);
        shipmentStautsMapping.setVendorCode("shi" + randId);
        shipmentStautsMapping.setWinitCode("shi" + randId);
        shipmentStautsMapping.setOrganizationId(Long.parseLong(randId + ""));
        shipmentStautsMapping.setCreated(new Date());
        shipmentStautsMapping.setCreatedby("shi" + randId);
        shipmentStautsMapping.setUpdated(new Date());
        shipmentStautsMapping.setUpdatedby("shi" + randId);
        shipmentStautsMapping.setActive(true);

        // 创建一实体
        shipmentStautsMappingManager.add(shipmentStautsMapping);

        Integer randId2 = new Double(100000 * Math.random()).intValue();
        shipmentStautsMapping.setCategoryCode("shi" + randId2);
        shipmentStautsMapping.setVendorCode("shi" + randId2);
        shipmentStautsMapping.setWinitCode("shi" + randId2);
        shipmentStautsMapping.setOrganizationId(Long.parseLong(randId2 + ""));
        shipmentStautsMapping.setCreated(new Date());
        shipmentStautsMapping.setCreatedby("shi" + randId2);
        shipmentStautsMapping.setUpdated(new Date());
        shipmentStautsMapping.setUpdatedby("shi" + randId2);
        shipmentStautsMapping.setActive(true);

        // 创建一实体
        shipmentStautsMappingManager.update(shipmentStautsMapping);

        ShipmentStautsMapping shipmentStautsMapping2 = shipmentStautsMappingManager.get(shipmentStautsMapping.getId());

        assertEquals(shipmentStautsMapping.getOrganizationId(), shipmentStautsMapping2.getOrganizationId());
    }

    @Test
    public void testTombstoned() {
        ShipmentStautsMapping shipmentStautsMapping = new ShipmentStautsMapping();
        Integer randId = new Double(100000 * Math.random()).intValue();

        shipmentStautsMapping.setCategoryCode("shi" + randId);
        shipmentStautsMapping.setVendorCode("shi" + randId);
        shipmentStautsMapping.setWinitCode("shi" + randId);
        shipmentStautsMapping.setOrganizationId(Long.parseLong(randId + ""));
        shipmentStautsMapping.setCreated(new Date());
        shipmentStautsMapping.setCreatedby("shi" + randId);
        shipmentStautsMapping.setUpdated(new Date());
        shipmentStautsMapping.setUpdatedby("shi" + randId);
        shipmentStautsMapping.setActive(true);

        // 创建一实体
        shipmentStautsMappingManager.add(shipmentStautsMapping);

        shipmentStautsMappingManager.tombstoned(shipmentStautsMapping.getId());

        ShipmentStautsMapping shipmentStautsMapping2 = shipmentStautsMappingManager.get(shipmentStautsMapping.getId());

        assertNull(shipmentStautsMapping2);
    }

    @Test
    public void testGet() {
        ShipmentStautsMapping shipmentStautsMapping = new ShipmentStautsMapping();
        Integer randId = new Double(100000 * Math.random()).intValue();

        shipmentStautsMapping.setCategoryCode("shi" + randId);
        shipmentStautsMapping.setVendorCode("shi" + randId);
        shipmentStautsMapping.setWinitCode("shi" + randId);
        shipmentStautsMapping.setOrganizationId(Long.parseLong(randId + ""));
        shipmentStautsMapping.setCreated(new Date());
        shipmentStautsMapping.setCreatedby("shi" + randId);
        shipmentStautsMapping.setUpdated(new Date());
        shipmentStautsMapping.setUpdatedby("shi" + randId);
        shipmentStautsMapping.setActive(true);

        // 创建一实体
        shipmentStautsMappingManager.add(shipmentStautsMapping);

        ShipmentStautsMapping shipmentStautsMapping2 = shipmentStautsMappingManager.get(shipmentStautsMapping.getId());

        assertEquals(shipmentStautsMapping.getCreatedby(), shipmentStautsMapping2.getCreatedby());
    }

}
