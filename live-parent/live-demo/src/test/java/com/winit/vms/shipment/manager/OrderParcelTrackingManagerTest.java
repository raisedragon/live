package com.winit.vms.shipment.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.winit.vms.shipment.entity.OrderParcelTracking;
import com.winit.vms.shipment.query.OrderParcelTrackingQuery;
import com.winit.vms.system.BaseTest;

/**
 * 派送轨迹 Manager Test Case Change to the actual description of this class
 * 
 * @version Revision History
 * 
 * <pre>
 * Author     			Version       Date			Changes
 * longsheng.wang    	1.0       2015-01-10 11:36:55			Created
 * 
 * </pre>
 * @since 1.
 */
public class OrderParcelTrackingManagerTest extends BaseTest {

    @Resource
    OrderParcelTrackingManager orderParcelTrackingManager;

    private OrderParcelTracking getByOrderNoParcelNoShippingNoTimeLocationStatusAndMessage(String orderNo,
                                                                                           String parcelNo,
                                                                                           String shippingNo,
                                                                                           Date time, String loation,
                                                                                           String status,
                                                                                           String message, String source) {
        OrderParcelTrackingQuery.FindQuery query = new OrderParcelTrackingQuery.FindQuery();
        query.createCriteria()
            .andOrderNoEqualTo(orderNo)
            .andParcelNoEqualTo(parcelNo)
            .andVendorShippingNoEqualTo(shippingNo)
            .andTimeEqualTo(time)
            .andLocationEqualTo(loation)
            .andStatusEqualTo(status)
            .andMessageEqualTo(message)
            .andSourceEqualTo(source)
            .andIsActiveEqualTo(true);
        List<OrderParcelTracking> list = orderParcelTrackingManager.queryByCriteria(query);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Test
    public void testCreate() {
        OrderParcelTracking orderParcelTracking = new OrderParcelTracking();
        Integer randId = new Double(100000 * Math.random()).intValue();

        orderParcelTracking.setOrderNo("ord" + randId);
        orderParcelTracking.setParcelNo("ord" + randId);
        orderParcelTracking.setProductCode("ord" + randId);
        orderParcelTracking.setVendorShippingNo("ord" + randId);
        orderParcelTracking.setTime(new Date());
        orderParcelTracking.setLocation("ord" + randId);
        orderParcelTracking.setOperator("ord" + randId);
        orderParcelTracking.setReceivedBy("ord" + randId);
        orderParcelTracking.setMessage("ord" + randId);
        orderParcelTracking.setStatus("ord" + randId);
        orderParcelTracking.setVendorStatus("ord" + randId);
        orderParcelTracking.setSource("ord" + randId);
        orderParcelTracking.setOrganizationId(Long.parseLong(randId + ""));
        orderParcelTracking.setCreated(new Date());
        orderParcelTracking.setCreatedby("ord" + randId);
        orderParcelTracking.setUpdated(new Date());
        orderParcelTracking.setUpdatedby("ord" + randId);
        orderParcelTracking.setActive(true);

        // 创建一实体
        orderParcelTrackingManager.add(orderParcelTracking);
        orderParcelTracking = this.getByOrderNoParcelNoShippingNoTimeLocationStatusAndMessage(orderParcelTracking.getOrderNo(),
            orderParcelTracking.getParcelNo(),
            orderParcelTracking.getVendorShippingNo(),
            orderParcelTracking.getTime(),
            orderParcelTracking.getLocation(),
            orderParcelTracking.getStatus(),
            orderParcelTracking.getMessage(),
            orderParcelTracking.getSource());
        OrderParcelTracking orderParcelTracking1 = orderParcelTrackingManager.get(orderParcelTracking.getId());

        assertEquals(orderParcelTracking.getOrganizationId(), orderParcelTracking1.getOrganizationId());

    }

    @Test
    public void testUpdate() {
        OrderParcelTracking orderParcelTracking = new OrderParcelTracking();
        Integer randId = new Double(100000 * Math.random()).intValue();

        orderParcelTracking.setOrderNo("ord" + randId);
        orderParcelTracking.setParcelNo("ord" + randId);
        orderParcelTracking.setProductCode("ord" + randId);
        orderParcelTracking.setVendorShippingNo("ord" + randId);
        orderParcelTracking.setTime(new Date());
        orderParcelTracking.setLocation("ord" + randId);
        orderParcelTracking.setOperator("ord" + randId);
        orderParcelTracking.setReceivedBy("ord" + randId);
        orderParcelTracking.setMessage("ord" + randId);
        orderParcelTracking.setStatus("ord" + randId);
        orderParcelTracking.setVendorStatus("ord" + randId);
        orderParcelTracking.setSource("ord" + randId);
        orderParcelTracking.setOrganizationId(Long.parseLong(randId + ""));
        orderParcelTracking.setCreated(new Date());
        orderParcelTracking.setCreatedby("ord" + randId);
        orderParcelTracking.setUpdated(new Date());
        orderParcelTracking.setUpdatedby("ord" + randId);
        orderParcelTracking.setActive(true);

        // 创建一实体
        orderParcelTrackingManager.add(orderParcelTracking);
        orderParcelTracking = this.getByOrderNoParcelNoShippingNoTimeLocationStatusAndMessage(orderParcelTracking.getOrderNo(),
            orderParcelTracking.getParcelNo(),
            orderParcelTracking.getVendorShippingNo(),
            orderParcelTracking.getTime(),
            orderParcelTracking.getLocation(),
            orderParcelTracking.getStatus(),
            orderParcelTracking.getMessage(),
            orderParcelTracking.getSource());
        Integer randId2 = new Double(100000 * Math.random()).intValue();
        orderParcelTracking.setOrderNo("ord" + randId2);
        orderParcelTracking.setParcelNo("ord" + randId2);
        orderParcelTracking.setProductCode("ord" + randId2);
        orderParcelTracking.setVendorShippingNo("ord" + randId2);
        orderParcelTracking.setSource("ord" + randId2);
        orderParcelTracking.setOrganizationId(Long.parseLong(randId2 + ""));
        orderParcelTracking.setCreated(new Date());
        orderParcelTracking.setCreatedby("ord" + randId2);
        orderParcelTracking.setUpdated(new Date());
        orderParcelTracking.setUpdatedby("ord" + randId2);
        orderParcelTracking.setActive(true);

        // 创建一实体
        orderParcelTrackingManager.update(orderParcelTracking);

        OrderParcelTracking orderParcelTracking2 = orderParcelTrackingManager.get(orderParcelTracking.getId());

        assertEquals(orderParcelTracking.getOrganizationId(), orderParcelTracking2.getOrganizationId());
    }

    @Test
    public void testTombstoned() {
        OrderParcelTracking orderParcelTracking = new OrderParcelTracking();
        Integer randId = new Double(100000 * Math.random()).intValue();

        orderParcelTracking.setOrderNo("ord" + randId);
        orderParcelTracking.setParcelNo("ord" + randId);
        orderParcelTracking.setProductCode("ord" + randId);
        orderParcelTracking.setVendorShippingNo("ord" + randId);
        orderParcelTracking.setTime(new Date());
        orderParcelTracking.setLocation("ord" + randId);
        orderParcelTracking.setOperator("ord" + randId);
        orderParcelTracking.setReceivedBy("ord" + randId);
        orderParcelTracking.setMessage("ord" + randId);
        orderParcelTracking.setStatus("ord" + randId);
        orderParcelTracking.setVendorStatus("ord" + randId);
        orderParcelTracking.setSource("ord" + randId);
        orderParcelTracking.setOrganizationId(Long.parseLong(randId + ""));
        orderParcelTracking.setCreated(new Date());
        orderParcelTracking.setCreatedby("ord" + randId);
        orderParcelTracking.setUpdated(new Date());
        orderParcelTracking.setUpdatedby("ord" + randId);
        orderParcelTracking.setActive(true);

        // 创建一实体
        orderParcelTrackingManager.add(orderParcelTracking);
        orderParcelTracking = this.getByOrderNoParcelNoShippingNoTimeLocationStatusAndMessage(orderParcelTracking.getOrderNo(),
            orderParcelTracking.getParcelNo(),
            orderParcelTracking.getVendorShippingNo(),
            orderParcelTracking.getTime(),
            orderParcelTracking.getLocation(),
            orderParcelTracking.getStatus(),
            orderParcelTracking.getMessage(),
            orderParcelTracking.getSource());
        orderParcelTrackingManager.tombstoned(orderParcelTracking.getId());

        OrderParcelTracking orderParcelTracking2 = orderParcelTrackingManager.get(orderParcelTracking.getId());

        assertNull(orderParcelTracking2);
    }

    @Test
    public void testGet() {
        OrderParcelTracking orderParcelTracking = new OrderParcelTracking();
        Integer randId = new Double(100000 * Math.random()).intValue();

        orderParcelTracking.setOrderNo("ord" + randId);
        orderParcelTracking.setParcelNo("ord" + randId);
        orderParcelTracking.setProductCode("ord" + randId);
        orderParcelTracking.setVendorShippingNo("ord" + randId);
        orderParcelTracking.setTime(new Date());
        orderParcelTracking.setLocation("ord" + randId);
        orderParcelTracking.setOperator("ord" + randId);
        orderParcelTracking.setReceivedBy("ord" + randId);
        orderParcelTracking.setMessage("ord" + randId);
        orderParcelTracking.setStatus("ord" + randId);
        orderParcelTracking.setVendorStatus("ord" + randId);
        orderParcelTracking.setSource("ord" + randId);
        orderParcelTracking.setOrganizationId(Long.parseLong(randId + ""));
        orderParcelTracking.setCreated(new Date());
        orderParcelTracking.setCreatedby("ord" + randId);
        orderParcelTracking.setUpdated(new Date());
        orderParcelTracking.setUpdatedby("ord" + randId);
        orderParcelTracking.setActive(true);

        // 创建一实体
        orderParcelTrackingManager.add(orderParcelTracking);
        orderParcelTracking = this.getByOrderNoParcelNoShippingNoTimeLocationStatusAndMessage(orderParcelTracking.getOrderNo(),
            orderParcelTracking.getParcelNo(),
            orderParcelTracking.getVendorShippingNo(),
            orderParcelTracking.getTime(),
            orderParcelTracking.getLocation(),
            orderParcelTracking.getStatus(),
            orderParcelTracking.getMessage(),
            orderParcelTracking.getSource());
        OrderParcelTracking orderParcelTracking2 = orderParcelTrackingManager.get(orderParcelTracking.getId());

        assertEquals(orderParcelTracking.getCreatedby(), orderParcelTracking2.getCreatedby());
    }

}
