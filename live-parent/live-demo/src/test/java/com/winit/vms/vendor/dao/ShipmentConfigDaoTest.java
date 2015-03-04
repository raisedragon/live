package com.winit.vms.vendor.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.winit.vms.system.BaseTest;
import com.winit.vms.vendor.entity.ShipmentConfig;

/**
 * 供应商产品对接配置项 Dao Test Case Change to the actual description of this class
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
@SuppressWarnings("deprecation")
public class ShipmentConfigDaoTest extends BaseTest {

    @Resource
    private ShipmentConfigDao shipmentConfigDao;

    @Test
    @Rollback(true)
    public void testCrud() {
        ShipmentConfig shipmentConfig = new ShipmentConfig();
        Integer randId = new Double(100000 * Math.random()).intValue();

        shipmentConfig.setProductCode("shi" + randId);
        shipmentConfig.setName("shi" + randId);
        shipmentConfig.setValue("shi" + randId);
        shipmentConfig.setDescription("shi" + randId);
        shipmentConfig.setOrganizationId(Long.parseLong(randId + ""));
        shipmentConfig.setCreated(new Date());
        shipmentConfig.setCreatedby("shi" + randId);
        shipmentConfig.setUpdated(new Date());
        shipmentConfig.setUpdatedby("shi" + randId);
        shipmentConfig.setActive(true);

        // 创建一实体
        shipmentConfigDao.add(shipmentConfig);
        Assert.assertNotNull(shipmentConfig.getId());
        logger.debug("shipmentConfig1:" + shipmentConfig.getId());
        // 获取一实体
        ShipmentConfig shipmentConfig2 = (ShipmentConfig) shipmentConfigDao.get(shipmentConfig.getId());
        Assert.assertNotNull(shipmentConfig2);
        logger.debug("shipmentConfig2:" + shipmentConfig2.toString());
        Integer randId2 = new Double(100000 * Math.random()).intValue();
        shipmentConfig2.setProductCode("shi" + randId2);
        shipmentConfig2.setName("shi" + randId2);
        shipmentConfig2.setValue("shi" + randId2);
        shipmentConfig2.setDescription("shi" + randId2);
        shipmentConfig2.setOrganizationId(Long.parseLong(randId2 + ""));
        shipmentConfig2.setCreated(new Date());
        shipmentConfig.setCreatedby("shi" + randId2);
        shipmentConfig2.setUpdated(new Date());
        shipmentConfig.setUpdatedby("shi" + randId2);
        shipmentConfig.setActive(true);
        // 更新一实体
        shipmentConfigDao.update(shipmentConfig2);

        ShipmentConfig shipmentConfig3 = shipmentConfigDao.get(shipmentConfig.getId());
        System.out.println("shipmentConfig3:" + shipmentConfig3.toString());
        // 删除一实体
        // shipmentConfigDao.tombstoned(shipmentConfig.getId());
    }

    @Test
    public void testCreate() {
        ShipmentConfig shipmentConfig = new ShipmentConfig();
        Integer randId = new Double(100000 * Math.random()).intValue();

        shipmentConfig.setProductCode("shi" + randId);
        shipmentConfig.setName("shi" + randId);
        shipmentConfig.setValue("shi" + randId);
        shipmentConfig.setDescription("shi" + randId);
        shipmentConfig.setOrganizationId(Long.parseLong(randId + ""));
        shipmentConfig.setCreated(new Date());
        shipmentConfig.setCreatedby("shi" + randId);
        shipmentConfig.setUpdated(new Date());
        shipmentConfig.setUpdatedby("shi" + randId);
        shipmentConfig.setActive(true);

        // 创建一实体
        shipmentConfigDao.add(shipmentConfig);

        ShipmentConfig shipmentConfig1 = shipmentConfigDao.get(shipmentConfig.getId());

        assertEquals(shipmentConfig.getOrganizationId(), shipmentConfig1.getOrganizationId());

    }

    @Test
    public void testUpdate() {
        ShipmentConfig shipmentConfig = new ShipmentConfig();
        Integer randId = new Double(100000 * Math.random()).intValue();

        shipmentConfig.setProductCode("shi" + randId);
        shipmentConfig.setName("shi" + randId);
        shipmentConfig.setValue("shi" + randId);
        shipmentConfig.setDescription("shi" + randId);
        shipmentConfig.setOrganizationId(Long.parseLong(randId + ""));
        shipmentConfig.setCreated(new Date());
        shipmentConfig.setCreatedby("shi" + randId);
        shipmentConfig.setUpdated(new Date());
        shipmentConfig.setUpdatedby("shi" + randId);
        shipmentConfig.setActive(true);

        // 创建一实体
        shipmentConfigDao.add(shipmentConfig);

        Integer randId2 = new Double(100000 * Math.random()).intValue();
        shipmentConfig.setProductCode("shi" + randId2);
        shipmentConfig.setName("shi" + randId2);
        shipmentConfig.setValue("shi" + randId2);
        shipmentConfig.setDescription("shi" + randId2);
        shipmentConfig.setOrganizationId(Long.parseLong(randId2 + ""));
        shipmentConfig.setCreated(new Date());
        shipmentConfig.setCreatedby("shi" + randId2);
        shipmentConfig.setUpdated(new Date());
        shipmentConfig.setUpdatedby("shi" + randId2);
        shipmentConfig.setActive(true);

        // 创建一实体
        shipmentConfigDao.update(shipmentConfig);

        ShipmentConfig shipmentConfig2 = shipmentConfigDao.get(shipmentConfig.getId());

        assertEquals(shipmentConfig.getOrganizationId(), shipmentConfig2.getOrganizationId());
    }

    @Test
    public void testTombstoned() {
        ShipmentConfig shipmentConfig = new ShipmentConfig();
        Integer randId = new Double(100000 * Math.random()).intValue();

        shipmentConfig.setProductCode("shi" + randId);
        shipmentConfig.setName("shi" + randId);
        shipmentConfig.setValue("shi" + randId);
        shipmentConfig.setDescription("shi" + randId);
        shipmentConfig.setOrganizationId(Long.parseLong(randId + ""));
        shipmentConfig.setCreated(new Date());
        shipmentConfig.setCreatedby("shi" + randId);
        shipmentConfig.setUpdated(new Date());
        shipmentConfig.setUpdatedby("shi" + randId);
        shipmentConfig.setActive(true);

        // 创建一实体
        shipmentConfigDao.add(shipmentConfig);

        shipmentConfigDao.tombstoned(shipmentConfig.getId());

        ShipmentConfig shipmentConfig2 = shipmentConfigDao.get(shipmentConfig.getId());

        assertNull(shipmentConfig2);
    }

    @Test
    public void testGet() {
        ShipmentConfig shipmentConfig = new ShipmentConfig();
        Integer randId = new Double(100000 * Math.random()).intValue();

        shipmentConfig.setProductCode("shi" + randId);
        shipmentConfig.setName("shi" + randId);
        shipmentConfig.setValue("shi" + randId);
        shipmentConfig.setDescription("shi" + randId);
        shipmentConfig.setOrganizationId(Long.parseLong(randId + ""));
        shipmentConfig.setCreated(new Date());
        shipmentConfig.setCreatedby("shi" + randId);
        shipmentConfig.setUpdated(new Date());
        shipmentConfig.setUpdatedby("shi" + randId);
        shipmentConfig.setActive(true);

        // 创建一实体
        shipmentConfigDao.add(shipmentConfig);

        ShipmentConfig shipmentConfig2 = shipmentConfigDao.get(shipmentConfig.getId());

        assertEquals(shipmentConfig.getCreatedby(), shipmentConfig2.getCreatedby());
    }

}
