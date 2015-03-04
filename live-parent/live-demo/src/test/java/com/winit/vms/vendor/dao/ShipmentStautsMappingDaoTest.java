package com.winit.vms.vendor.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.winit.vms.system.BaseTest;
import com.winit.vms.vendor.entity.ShipmentStautsMapping;

/**
 * 轨迹状态映射 Dao Test Case Change to the actual description of this class
 * 
 * @version Revision History
 * 
 * <pre>
 * Author     			Version       Date			Changes
 * longsheng.wang    	1.0       2015-01-10 20:21:56			Created
 * 
 * </pre>
 * @since 1.
 */
@SuppressWarnings("deprecation")
public class ShipmentStautsMappingDaoTest extends BaseTest {

    @Resource
    private ShipmentStautsMappingDao shipmentStautsMappingDao;

    @Test
    @Rollback(true)
    public void testCrud() {
        ShipmentStautsMapping shipmentStautsMapping = new ShipmentStautsMapping();
        Integer randId = new Double(100000 * Math.random()).intValue();

        shipmentStautsMapping.setCategoryCode("shi" + randId);
        shipmentStautsMapping.setVendorCode("shi" + randId);
        shipmentStautsMapping.setVendorDescription("shi" + randId);
        shipmentStautsMapping.setWinitCode("shi" + randId);
        shipmentStautsMapping.setWinitDescription("shi" + randId);
        shipmentStautsMapping.setOrganizationId(Long.parseLong(randId + ""));
        shipmentStautsMapping.setCreated(new Date());
        shipmentStautsMapping.setCreatedby("shi" + randId);
        shipmentStautsMapping.setUpdated(new Date());
        shipmentStautsMapping.setUpdatedby("shi" + randId);
        shipmentStautsMapping.setActive(true);

        // 创建一实体
        shipmentStautsMappingDao.add(shipmentStautsMapping);
        Assert.assertNotNull(shipmentStautsMapping.getId());
        logger.debug("shipmentStautsMapping1:" + shipmentStautsMapping.getId());
        // 获取一实体
        ShipmentStautsMapping shipmentStautsMapping2 = (ShipmentStautsMapping) shipmentStautsMappingDao.get(shipmentStautsMapping.getId());
        Assert.assertNotNull(shipmentStautsMapping2);
        logger.debug("shipmentStautsMapping2:" + shipmentStautsMapping2.toString());
        Integer randId2 = new Double(100000 * Math.random()).intValue();
        shipmentStautsMapping2.setCategoryCode("shi" + randId2);
        shipmentStautsMapping2.setVendorCode("shi" + randId2);
        shipmentStautsMapping2.setVendorDescription("shi" + randId2);
        shipmentStautsMapping2.setWinitCode("shi" + randId2);
        shipmentStautsMapping2.setWinitDescription("shi" + randId2);
        shipmentStautsMapping2.setOrganizationId(Long.parseLong(randId2 + ""));
        shipmentStautsMapping2.setCreated(new Date());
        shipmentStautsMapping.setCreatedby("shi" + randId2);
        shipmentStautsMapping2.setUpdated(new Date());
        shipmentStautsMapping.setUpdatedby("shi" + randId2);
        shipmentStautsMapping.setActive(true);
        // 更新一实体
        shipmentStautsMappingDao.update(shipmentStautsMapping2);

        ShipmentStautsMapping shipmentStautsMapping3 = shipmentStautsMappingDao.get(shipmentStautsMapping.getId());
        System.out.println("shipmentStautsMapping3:" + shipmentStautsMapping3.toString());
        // 删除一实体
        // shipmentStautsMappingDao.tombstoned(shipmentStautsMapping.getId());
    }

    @Test
    public void testCreate() {
        ShipmentStautsMapping shipmentStautsMapping = new ShipmentStautsMapping();
        Integer randId = new Double(100000 * Math.random()).intValue();

        shipmentStautsMapping.setCategoryCode("shi" + randId);
        shipmentStautsMapping.setVendorCode("shi" + randId);
        shipmentStautsMapping.setVendorDescription("shi" + randId);
        shipmentStautsMapping.setWinitCode("shi" + randId);
        shipmentStautsMapping.setWinitDescription("shi" + randId);
        shipmentStautsMapping.setOrganizationId(Long.parseLong(randId + ""));
        shipmentStautsMapping.setCreated(new Date());
        shipmentStautsMapping.setCreatedby("shi" + randId);
        shipmentStautsMapping.setUpdated(new Date());
        shipmentStautsMapping.setUpdatedby("shi" + randId);
        shipmentStautsMapping.setActive(true);

        // 创建一实体
        shipmentStautsMappingDao.add(shipmentStautsMapping);

        ShipmentStautsMapping shipmentStautsMapping1 = shipmentStautsMappingDao.get(shipmentStautsMapping.getId());

        assertEquals(shipmentStautsMapping.getOrganizationId(), shipmentStautsMapping1.getOrganizationId());

    }

    @Test
    public void testUpdate() {
        ShipmentStautsMapping shipmentStautsMapping = new ShipmentStautsMapping();
        Integer randId = new Double(100000 * Math.random()).intValue();

        shipmentStautsMapping.setCategoryCode("shi" + randId);
        shipmentStautsMapping.setVendorCode("shi" + randId);
        shipmentStautsMapping.setVendorDescription("shi" + randId);
        shipmentStautsMapping.setWinitCode("shi" + randId);
        shipmentStautsMapping.setWinitDescription("shi" + randId);
        shipmentStautsMapping.setOrganizationId(Long.parseLong(randId + ""));
        shipmentStautsMapping.setCreated(new Date());
        shipmentStautsMapping.setCreatedby("shi" + randId);
        shipmentStautsMapping.setUpdated(new Date());
        shipmentStautsMapping.setUpdatedby("shi" + randId);
        shipmentStautsMapping.setActive(true);

        // 创建一实体
        shipmentStautsMappingDao.add(shipmentStautsMapping);

        Integer randId2 = new Double(100000 * Math.random()).intValue();
        shipmentStautsMapping.setCategoryCode("shi" + randId2);
        shipmentStautsMapping.setVendorCode("shi" + randId2);
        shipmentStautsMapping.setVendorDescription("shi" + randId2);
        shipmentStautsMapping.setWinitCode("shi" + randId2);
        shipmentStautsMapping.setWinitDescription("shi" + randId2);
        shipmentStautsMapping.setOrganizationId(Long.parseLong(randId2 + ""));
        shipmentStautsMapping.setCreated(new Date());
        shipmentStautsMapping.setCreatedby("shi" + randId2);
        shipmentStautsMapping.setUpdated(new Date());
        shipmentStautsMapping.setUpdatedby("shi" + randId2);
        shipmentStautsMapping.setActive(true);

        // 创建一实体
        shipmentStautsMappingDao.update(shipmentStautsMapping);

        ShipmentStautsMapping shipmentStautsMapping2 = shipmentStautsMappingDao.get(shipmentStautsMapping.getId());

        assertEquals(shipmentStautsMapping.getOrganizationId(), shipmentStautsMapping2.getOrganizationId());
    }

    @Test
    public void testTombstoned() {
        ShipmentStautsMapping shipmentStautsMapping = new ShipmentStautsMapping();
        Integer randId = new Double(100000 * Math.random()).intValue();

        shipmentStautsMapping.setCategoryCode("shi" + randId);
        shipmentStautsMapping.setVendorCode("shi" + randId);
        shipmentStautsMapping.setVendorDescription("shi" + randId);
        shipmentStautsMapping.setWinitCode("shi" + randId);
        shipmentStautsMapping.setWinitDescription("shi" + randId);
        shipmentStautsMapping.setOrganizationId(Long.parseLong(randId + ""));
        shipmentStautsMapping.setCreated(new Date());
        shipmentStautsMapping.setCreatedby("shi" + randId);
        shipmentStautsMapping.setUpdated(new Date());
        shipmentStautsMapping.setUpdatedby("shi" + randId);
        shipmentStautsMapping.setActive(true);

        // 创建一实体
        shipmentStautsMappingDao.add(shipmentStautsMapping);

        shipmentStautsMappingDao.tombstoned(shipmentStautsMapping.getId());

        ShipmentStautsMapping shipmentStautsMapping2 = shipmentStautsMappingDao.get(shipmentStautsMapping.getId());

        assertNull(shipmentStautsMapping2);
    }

    @Test
    public void testGet() {
        ShipmentStautsMapping shipmentStautsMapping = new ShipmentStautsMapping();
        Integer randId = new Double(100000 * Math.random()).intValue();

        shipmentStautsMapping.setCategoryCode("shi" + randId);
        shipmentStautsMapping.setVendorCode("shi" + randId);
        shipmentStautsMapping.setVendorDescription("shi" + randId);
        shipmentStautsMapping.setWinitCode("shi" + randId);
        shipmentStautsMapping.setWinitDescription("shi" + randId);
        shipmentStautsMapping.setOrganizationId(Long.parseLong(randId + ""));
        shipmentStautsMapping.setCreated(new Date());
        shipmentStautsMapping.setCreatedby("shi" + randId);
        shipmentStautsMapping.setUpdated(new Date());
        shipmentStautsMapping.setUpdatedby("shi" + randId);
        shipmentStautsMapping.setActive(true);

        // 创建一实体
        shipmentStautsMappingDao.add(shipmentStautsMapping);

        ShipmentStautsMapping shipmentStautsMapping2 = shipmentStautsMappingDao.get(shipmentStautsMapping.getId());

        assertEquals(shipmentStautsMapping.getCreatedby(), shipmentStautsMapping2.getCreatedby());
    }

}
