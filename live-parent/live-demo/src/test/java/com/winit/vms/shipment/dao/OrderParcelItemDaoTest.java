package com.winit.vms.shipment.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.winit.vms.shipment.entity.OrderParcelItem;
import com.winit.vms.shipment.query.OrderParcelItemQuery;
import com.winit.vms.system.BaseTest;

/**
 * 运输订单包裹明细 Dao Test Case Change to the actual description of this class
 * 
 * @version Revision History
 * 
 * <pre>
 * Author     			Version       Date			Changes
 * longsheng.wang    	1.0       2015-01-13 14:13:37			Created
 * 
 * </pre>
 * @since 1.
 */
@SuppressWarnings("deprecation")
public class OrderParcelItemDaoTest extends BaseTest {

    @Resource
    private OrderParcelItemDao orderParcelItemDao;

    public OrderParcelItem getByOrderNoAndParcelNoSku(String orderNo, String parcelNo, String sku) {
        OrderParcelItemQuery.FindQuery query = new OrderParcelItemQuery.FindQuery();
        query.createCriteria()
            .andOrderNoEqualTo(orderNo)
            .andParcelNoEqualTo(parcelNo)
            .andSkuEqualTo(sku)
            .andIsActiveEqualTo(true);
        List<OrderParcelItem> list = orderParcelItemDao.queryByCriteria(query);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Test
    @Rollback(true)
    public void testCrud() {
        OrderParcelItem orderParcelItem = new OrderParcelItem();
        Integer randId = new Double(100000 * Math.random()).intValue();
        orderParcelItem.setOrderNo("ord" + randId);
        orderParcelItem.setParcelNo("0");
        orderParcelItem.setParcelNo("ord" + randId);
        orderParcelItem.setName("ord" + randId);
        orderParcelItem.setSku("ord" + randId);
        orderParcelItem.setLength(BigDecimal.valueOf(randId));
        orderParcelItem.setWidth(BigDecimal.valueOf(randId));
        orderParcelItem.setHeight(BigDecimal.valueOf(randId));
        orderParcelItem.setWeight(BigDecimal.valueOf(randId));
        orderParcelItem.setValue(BigDecimal.valueOf(randId));
        orderParcelItem.setCurrencyUnit("ord" + randId);
        orderParcelItem.setDescription("ord" + randId);
        orderParcelItem.setQuantity(randId);
        orderParcelItem.setOrganizationId(Long.parseLong(randId + ""));
        orderParcelItem.setCreated(new Date());
        orderParcelItem.setCreatedby("ord" + randId);
        orderParcelItem.setUpdated(new Date());
        orderParcelItem.setUpdatedby("ord" + randId);
        orderParcelItem.setActive(true);

        // 创建一实体
        orderParcelItemDao.add(orderParcelItem);
        orderParcelItem = this.getByOrderNoAndParcelNoSku(orderParcelItem.getOrderNo(),
            orderParcelItem.getParcelNo(),
            orderParcelItem.getSku());
        Assert.assertNotNull(orderParcelItem.getId());
        logger.debug("orderParcelItem1:" + orderParcelItem.getId());
        // 获取一实体
        OrderParcelItem orderParcelItem2 = (OrderParcelItem) orderParcelItemDao.get(orderParcelItem.getId());
        Assert.assertNotNull(orderParcelItem2);
        logger.debug("orderParcelItem2:" + orderParcelItem2.toString());
        Integer randId2 = new Double(100000 * Math.random()).intValue();
        orderParcelItem2.setOrderNo("ord" + randId2);
        orderParcelItem2.setParcelNo("0");
        orderParcelItem2.setParcelNo("ord" + randId2);
        orderParcelItem2.setName("ord" + randId2);
        orderParcelItem2.setSku("ord" + randId2);
        orderParcelItem2.setCurrencyUnit("ord" + randId2);
        orderParcelItem2.setDescription("ord" + randId2);
        orderParcelItem2.setQuantity(randId2);
        orderParcelItem2.setOrganizationId(Long.parseLong(randId2 + ""));
        orderParcelItem2.setCreated(new Date());
        orderParcelItem.setCreatedby("ord" + randId2);
        orderParcelItem2.setUpdated(new Date());
        orderParcelItem.setUpdatedby("ord" + randId2);
        orderParcelItem.setActive(true);
        // 更新一实体
        orderParcelItemDao.update(orderParcelItem2);

        OrderParcelItem orderParcelItem3 = orderParcelItemDao.get(orderParcelItem.getId());
        System.out.println("orderParcelItem3:" + orderParcelItem3.toString());
        // 删除一实体
        // orderParcelItemDao.tombstoned(orderParcelItem.getId());
    }

    @Test
    public void testCreate() {
        OrderParcelItem orderParcelItem = new OrderParcelItem();
        Integer randId = new Double(100000 * Math.random()).intValue();
        orderParcelItem.setOrderNo("ord" + randId);
        orderParcelItem.setParcelNo("0");
        orderParcelItem.setParcelNo("ord" + randId);
        orderParcelItem.setName("ord" + randId);
        orderParcelItem.setSku("ord" + randId);
        orderParcelItem.setLength(BigDecimal.valueOf(randId));
        orderParcelItem.setWidth(BigDecimal.valueOf(randId));
        orderParcelItem.setHeight(BigDecimal.valueOf(randId));
        orderParcelItem.setWeight(BigDecimal.valueOf(randId));
        orderParcelItem.setValue(BigDecimal.valueOf(randId));
        orderParcelItem.setCurrencyUnit("ord" + randId);
        orderParcelItem.setDescription("ord" + randId);
        orderParcelItem.setQuantity(randId);
        orderParcelItem.setOrganizationId(Long.parseLong(randId + ""));
        orderParcelItem.setCreated(new Date());
        orderParcelItem.setCreatedby("ord" + randId);
        orderParcelItem.setUpdated(new Date());
        orderParcelItem.setUpdatedby("ord" + randId);
        orderParcelItem.setActive(true);

        // 创建一实体
        orderParcelItemDao.add(orderParcelItem);
        orderParcelItem = this.getByOrderNoAndParcelNoSku(orderParcelItem.getOrderNo(),
            orderParcelItem.getParcelNo(),
            orderParcelItem.getSku());
        OrderParcelItem orderParcelItem1 = orderParcelItemDao.get(orderParcelItem.getId());

        assertEquals(orderParcelItem.getOrganizationId(), orderParcelItem1.getOrganizationId());

    }

    @Test
    public void testUpdate() {
        OrderParcelItem orderParcelItem = new OrderParcelItem();
        Integer randId = new Double(100000 * Math.random()).intValue();
        orderParcelItem.setOrderNo("ord" + randId);
        orderParcelItem.setParcelNo("0");
        orderParcelItem.setParcelNo("ord" + randId);
        orderParcelItem.setName("ord" + randId);
        orderParcelItem.setSku("ord" + randId);
        orderParcelItem.setLength(BigDecimal.valueOf(randId));
        orderParcelItem.setWidth(BigDecimal.valueOf(randId));
        orderParcelItem.setHeight(BigDecimal.valueOf(randId));
        orderParcelItem.setWeight(BigDecimal.valueOf(randId));
        orderParcelItem.setValue(BigDecimal.valueOf(randId));
        orderParcelItem.setCurrencyUnit("ord" + randId);
        orderParcelItem.setDescription("ord" + randId);
        orderParcelItem.setQuantity(randId);
        orderParcelItem.setOrganizationId(Long.parseLong(randId + ""));
        orderParcelItem.setCreated(new Date());
        orderParcelItem.setCreatedby("ord" + randId);
        orderParcelItem.setUpdated(new Date());
        orderParcelItem.setUpdatedby("ord" + randId);
        orderParcelItem.setActive(true);

        // 创建一实体
        orderParcelItemDao.add(orderParcelItem);
        orderParcelItem = this.getByOrderNoAndParcelNoSku(orderParcelItem.getOrderNo(),
            orderParcelItem.getParcelNo(),
            orderParcelItem.getSku());
        Integer randId2 = new Double(100000 * Math.random()).intValue();
        orderParcelItem.setOrderNo("ord" + randId2);
        orderParcelItem.setParcelNo("0");
        orderParcelItem.setParcelNo("ord" + randId2);
        orderParcelItem.setName("ord" + randId2);
        orderParcelItem.setSku("ord" + randId2);
        orderParcelItem.setLength(BigDecimal.valueOf(randId2));
        orderParcelItem.setWidth(BigDecimal.valueOf(randId2));
        orderParcelItem.setHeight(BigDecimal.valueOf(randId2));
        orderParcelItem.setWeight(BigDecimal.valueOf(randId2));
        orderParcelItem.setValue(BigDecimal.valueOf(randId2));
        orderParcelItem.setCurrencyUnit("ord" + randId2);
        orderParcelItem.setDescription("ord" + randId2);
        orderParcelItem.setQuantity(randId2);
        orderParcelItem.setOrganizationId(Long.parseLong(randId2 + ""));
        orderParcelItem.setCreated(new Date());
        orderParcelItem.setCreatedby("ord" + randId2);
        orderParcelItem.setUpdated(new Date());
        orderParcelItem.setUpdatedby("ord" + randId2);
        orderParcelItem.setActive(true);

        // 创建一实体
        orderParcelItemDao.update(orderParcelItem);

        OrderParcelItem orderParcelItem2 = orderParcelItemDao.get(orderParcelItem.getId());

        assertEquals(orderParcelItem.getOrganizationId(), orderParcelItem2.getOrganizationId());
    }

    @Test
    public void testTombstoned() {
        OrderParcelItem orderParcelItem = new OrderParcelItem();
        Integer randId = new Double(100000 * Math.random()).intValue();
        orderParcelItem.setOrderNo("ord" + randId);
        orderParcelItem.setParcelNo("0");
        orderParcelItem.setParcelNo("ord" + randId);
        orderParcelItem.setName("ord" + randId);
        orderParcelItem.setSku("ord" + randId);
        orderParcelItem.setLength(BigDecimal.valueOf(randId));
        orderParcelItem.setWidth(BigDecimal.valueOf(randId));
        orderParcelItem.setHeight(BigDecimal.valueOf(randId));
        orderParcelItem.setWeight(BigDecimal.valueOf(randId));
        orderParcelItem.setValue(BigDecimal.valueOf(randId));
        orderParcelItem.setCurrencyUnit("ord" + randId);
        orderParcelItem.setDescription("ord" + randId);
        orderParcelItem.setQuantity(randId);
        orderParcelItem.setOrganizationId(Long.parseLong(randId + ""));
        orderParcelItem.setCreated(new Date());
        orderParcelItem.setCreatedby("ord" + randId);
        orderParcelItem.setUpdated(new Date());
        orderParcelItem.setUpdatedby("ord" + randId);
        orderParcelItem.setActive(true);

        // 创建一实体
        orderParcelItemDao.add(orderParcelItem);
        orderParcelItem = this.getByOrderNoAndParcelNoSku(orderParcelItem.getOrderNo(),
            orderParcelItem.getParcelNo(),
            orderParcelItem.getSku());
        orderParcelItemDao.tombstoned(orderParcelItem.getId());

        OrderParcelItem orderParcelItem2 = orderParcelItemDao.get(orderParcelItem.getId());

        assertNull(orderParcelItem2);
    }

    @Test
    public void testGet() {
        OrderParcelItem orderParcelItem = new OrderParcelItem();
        Integer randId = new Double(100000 * Math.random()).intValue();
        orderParcelItem.setOrderNo("ord" + randId);
        orderParcelItem.setParcelNo("0");
        orderParcelItem.setParcelNo("ord" + randId);
        orderParcelItem.setName("ord" + randId);
        orderParcelItem.setSku("ord" + randId);
        orderParcelItem.setLength(BigDecimal.valueOf(randId));
        orderParcelItem.setWidth(BigDecimal.valueOf(randId));
        orderParcelItem.setHeight(BigDecimal.valueOf(randId));
        orderParcelItem.setWeight(BigDecimal.valueOf(randId));
        orderParcelItem.setValue(BigDecimal.valueOf(randId));
        orderParcelItem.setCurrencyUnit("ord" + randId);
        orderParcelItem.setDescription("ord" + randId);
        orderParcelItem.setQuantity(randId);
        orderParcelItem.setOrganizationId(Long.parseLong(randId + ""));
        orderParcelItem.setCreated(new Date());
        orderParcelItem.setCreatedby("ord" + randId);
        orderParcelItem.setUpdated(new Date());
        orderParcelItem.setUpdatedby("ord" + randId);
        orderParcelItem.setActive(true);

        // 创建一实体
        orderParcelItemDao.add(orderParcelItem);
        orderParcelItem = this.getByOrderNoAndParcelNoSku(orderParcelItem.getOrderNo(),
            orderParcelItem.getParcelNo(),
            orderParcelItem.getSku());
        OrderParcelItem orderParcelItem2 = orderParcelItemDao.get(orderParcelItem.getId());

        assertEquals(orderParcelItem.getCreatedby(), orderParcelItem2.getCreatedby());
    }

}
