package com.winit.vms.shipment.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.winit.vms.shipment.entity.OrderParcelItem;
import com.winit.vms.shipment.query.OrderParcelItemQuery;
import com.winit.vms.system.BaseTest;

/**
 * 运输订单包裹明细 Manager Test Case Change to the actual description of this class
 * 
 * @version Revision History
 * 
 * <pre>
 * Author     			Version       Date			Changes
 * longsheng.wang    	1.0       2015-01-13 14:13:38			Created
 * 
 * </pre>
 * @since 1.
 */

public class OrderParcelItemManagerTest extends BaseTest {

    @Resource
    OrderParcelItemManager orderParcelItemManager;

    public OrderParcelItem getByOrderNoAndParcelNoSku(String orderNo, String parcelNo, String sku) {
        OrderParcelItemQuery.FindQuery query = new OrderParcelItemQuery.FindQuery();
        query.createCriteria()
            .andOrderNoEqualTo(orderNo)
            .andParcelNoEqualTo(parcelNo)
            .andSkuEqualTo(sku)
            .andIsActiveEqualTo(true);
        List<OrderParcelItem> list = orderParcelItemManager.queryByCriteria(query);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Test
    public void testCreate() {
        OrderParcelItem orderParcelItem = new OrderParcelItem();
        Integer randId = new Double(100000 * Math.random()).intValue();

        orderParcelItem.setOrderNo("ord" + randId);
        orderParcelItem.setParcelNo(randId + "");
        orderParcelItem.setParcelNo("ord" + randId);
        orderParcelItem.setName("ord" + randId);
        orderParcelItem.setSku("ord" + randId);
        orderParcelItem.setQuantity(randId);
        orderParcelItem.setOrganizationId(Long.parseLong(randId + ""));
        orderParcelItem.setCreated(new Date());
        orderParcelItem.setCreatedby("ord" + randId);
        orderParcelItem.setUpdated(new Date());
        orderParcelItem.setUpdatedby("ord" + randId);
        orderParcelItem.setActive(true);

        // 创建一实体
        orderParcelItemManager.add(orderParcelItem);
        orderParcelItem = this.getByOrderNoAndParcelNoSku(orderParcelItem.getOrderNo(),
            orderParcelItem.getParcelNo(),
            orderParcelItem.getSku());
        OrderParcelItem orderParcelItem1 = orderParcelItemManager.get(orderParcelItem.getId());

        assertEquals(orderParcelItem.getOrganizationId(), orderParcelItem1.getOrganizationId());

    }

    @Test
    public void testUpdate() {
        OrderParcelItem orderParcelItem = new OrderParcelItem();
        Integer randId = new Double(100000 * Math.random()).intValue();

        orderParcelItem.setOrderNo("ord" + randId);
        orderParcelItem.setParcelNo(randId + "");
        orderParcelItem.setParcelNo("ord" + randId);
        orderParcelItem.setName("ord" + randId);
        orderParcelItem.setSku("ord" + randId);
        orderParcelItem.setQuantity(randId);
        orderParcelItem.setOrganizationId(Long.parseLong(randId + ""));
        orderParcelItem.setCreated(new Date());
        orderParcelItem.setCreatedby("ord" + randId);
        orderParcelItem.setUpdated(new Date());
        orderParcelItem.setUpdatedby("ord" + randId);
        orderParcelItem.setActive(true);

        // 创建一实体
        orderParcelItemManager.add(orderParcelItem);
        orderParcelItem = this.getByOrderNoAndParcelNoSku(orderParcelItem.getOrderNo(),
            orderParcelItem.getParcelNo(),
            orderParcelItem.getSku());
        Integer randId2 = new Double(100000 * Math.random()).intValue();
        orderParcelItem.setOrderNo("ord" + randId2);
        orderParcelItem.setParcelNo(randId2 + "");
        orderParcelItem.setParcelNo("ord" + randId2);
        orderParcelItem.setName("ord" + randId2);
        orderParcelItem.setSku("ord" + randId2);
        orderParcelItem.setQuantity(randId2);
        orderParcelItem.setOrganizationId(Long.parseLong(randId2 + ""));
        orderParcelItem.setCreated(new Date());
        orderParcelItem.setCreatedby("ord" + randId2);
        orderParcelItem.setUpdated(new Date());
        orderParcelItem.setUpdatedby("ord" + randId2);
        orderParcelItem.setActive(true);

        // 创建一实体
        orderParcelItemManager.update(orderParcelItem);

        OrderParcelItem orderParcelItem2 = orderParcelItemManager.get(orderParcelItem.getId());

        assertEquals(orderParcelItem.getOrganizationId(), orderParcelItem2.getOrganizationId());
    }

    @Test
    public void testTombstoned() {
        OrderParcelItem orderParcelItem = new OrderParcelItem();
        Integer randId = new Double(100000 * Math.random()).intValue();

        orderParcelItem.setOrderNo("ord" + randId);
        orderParcelItem.setParcelNo(randId + "");
        orderParcelItem.setParcelNo("ord" + randId);
        orderParcelItem.setName("ord" + randId);
        orderParcelItem.setSku("ord" + randId);
        orderParcelItem.setQuantity(randId);
        orderParcelItem.setOrganizationId(Long.parseLong(randId + ""));
        orderParcelItem.setCreated(new Date());
        orderParcelItem.setCreatedby("ord" + randId);
        orderParcelItem.setUpdated(new Date());
        orderParcelItem.setUpdatedby("ord" + randId);
        orderParcelItem.setActive(true);

        // 创建一实体
        orderParcelItemManager.add(orderParcelItem);
        orderParcelItem = this.getByOrderNoAndParcelNoSku(orderParcelItem.getOrderNo(),
            orderParcelItem.getParcelNo(),
            orderParcelItem.getSku());
        orderParcelItemManager.tombstoned(orderParcelItem.getId());

        OrderParcelItem orderParcelItem2 = orderParcelItemManager.get(orderParcelItem.getId());

        assertNull(orderParcelItem2);
    }

    @Test
    public void testGet() {
        OrderParcelItem orderParcelItem = new OrderParcelItem();
        Integer randId = new Double(100000 * Math.random()).intValue();

        orderParcelItem.setOrderNo("ord" + randId);
        orderParcelItem.setParcelNo(randId + "");
        orderParcelItem.setParcelNo("ord" + randId);
        orderParcelItem.setName("ord" + randId);
        orderParcelItem.setSku("ord" + randId);
        orderParcelItem.setQuantity(randId);
        orderParcelItem.setOrganizationId(Long.parseLong(randId + ""));
        orderParcelItem.setCreated(new Date());
        orderParcelItem.setCreatedby("ord" + randId);
        orderParcelItem.setUpdated(new Date());
        orderParcelItem.setUpdatedby("ord" + randId);
        orderParcelItem.setActive(true);

        // 创建一实体
        orderParcelItemManager.add(orderParcelItem);
        orderParcelItem = this.getByOrderNoAndParcelNoSku(orderParcelItem.getOrderNo(),
            orderParcelItem.getParcelNo(),
            orderParcelItem.getSku());
        OrderParcelItem orderParcelItem2 = orderParcelItemManager.get(orderParcelItem.getId());

        assertEquals(orderParcelItem.getCreatedby(), orderParcelItem2.getCreatedby());
    }

}
