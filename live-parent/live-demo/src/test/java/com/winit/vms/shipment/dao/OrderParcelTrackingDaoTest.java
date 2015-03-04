package com.winit.vms.shipment.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.winit.vms.shipment.entity.OrderParcelTracking;
import com.winit.vms.shipment.query.OrderParcelTrackingQuery;
import com.winit.vms.system.BaseTest;

/**
 * 派送轨迹 Dao Test Case Change to the actual description of this class
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
public class OrderParcelTrackingDaoTest extends BaseTest {

    @Resource
    private OrderParcelTrackingDao orderParcelTrackingDao;

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
        List<OrderParcelTracking> list = orderParcelTrackingDao.queryByCriteria(query);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Test
    @Rollback(true)
    public void testCrud() {
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
        orderParcelTrackingDao.add(orderParcelTracking);
        orderParcelTracking = this.getByOrderNoParcelNoShippingNoTimeLocationStatusAndMessage(orderParcelTracking.getOrderNo(),
            orderParcelTracking.getParcelNo(),
            orderParcelTracking.getVendorShippingNo(),
            orderParcelTracking.getTime(),
            orderParcelTracking.getLocation(),
            orderParcelTracking.getStatus(),
            orderParcelTracking.getMessage(),
            orderParcelTracking.getSource());
        Assert.assertNotNull(orderParcelTracking.getId());
        logger.debug("orderParcelTracking1:" + orderParcelTracking.getId());
        // 获取一实体
        OrderParcelTracking orderParcelTracking2 = (OrderParcelTracking) orderParcelTrackingDao.get(orderParcelTracking.getId());
        Assert.assertNotNull(orderParcelTracking2);
        logger.debug("orderParcelTracking2:" + orderParcelTracking2.toString());
        Integer randId2 = new Double(100000 * Math.random()).intValue();
        orderParcelTracking2.setOrderNo("ord" + randId2);
        orderParcelTracking2.setParcelNo("ord" + randId2);
        orderParcelTracking2.setProductCode("ord" + randId2);
        orderParcelTracking2.setVendorShippingNo("ord" + randId2);
        orderParcelTracking2.setTime(new Date());
        orderParcelTracking2.setLocation("ord" + randId2);
        orderParcelTracking2.setOperator("ord" + randId2);
        orderParcelTracking2.setReceivedBy("ord" + randId2);
        orderParcelTracking2.setMessage("ord" + randId2);
        orderParcelTracking2.setStatus("ord" + randId2);
        orderParcelTracking2.setVendorStatus("ord" + randId2);
        orderParcelTracking2.setSource("ord" + randId2);
        orderParcelTracking2.setOrganizationId(Long.parseLong(randId2 + ""));
        orderParcelTracking2.setCreated(new Date());
        orderParcelTracking.setCreatedby("ord" + randId2);
        orderParcelTracking2.setUpdated(new Date());
        orderParcelTracking.setUpdatedby("ord" + randId2);
        orderParcelTracking.setActive(true);
        // 更新一实体
        orderParcelTrackingDao.update(orderParcelTracking2);

        OrderParcelTracking orderParcelTracking3 = orderParcelTrackingDao.get(orderParcelTracking.getId());
        System.out.println("orderParcelTracking3:" + orderParcelTracking3.toString());
        // 删除一实体
        // orderParcelTrackingDao.tombstoned(orderParcelTracking.getId());
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
        orderParcelTrackingDao.add(orderParcelTracking);
        orderParcelTracking = this.getByOrderNoParcelNoShippingNoTimeLocationStatusAndMessage(orderParcelTracking.getOrderNo(),
            orderParcelTracking.getParcelNo(),
            orderParcelTracking.getVendorShippingNo(),
            orderParcelTracking.getTime(),
            orderParcelTracking.getLocation(),
            orderParcelTracking.getStatus(),
            orderParcelTracking.getMessage(),
            orderParcelTracking.getSource());
        OrderParcelTracking orderParcelTracking1 = orderParcelTrackingDao.get(orderParcelTracking.getId());

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
        orderParcelTrackingDao.add(orderParcelTracking);
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
        orderParcelTracking.setTime(new Date());
        orderParcelTracking.setLocation("ord" + randId2);
        orderParcelTracking.setOperator("ord" + randId2);
        orderParcelTracking.setReceivedBy("ord" + randId2);
        orderParcelTracking.setMessage("ord" + randId2);
        orderParcelTracking.setStatus("ord" + randId2);
        orderParcelTracking.setVendorStatus("ord" + randId2);
        orderParcelTracking.setSource("ord" + randId2);
        orderParcelTracking.setOrganizationId(Long.parseLong(randId2 + ""));
        orderParcelTracking.setCreated(new Date());
        orderParcelTracking.setCreatedby("ord" + randId2);
        orderParcelTracking.setUpdated(new Date());
        orderParcelTracking.setUpdatedby("ord" + randId2);
        orderParcelTracking.setActive(true);

        // 创建一实体
        orderParcelTrackingDao.update(orderParcelTracking);

        OrderParcelTracking orderParcelTracking2 = orderParcelTrackingDao.get(orderParcelTracking.getId());

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
        orderParcelTrackingDao.add(orderParcelTracking);
        orderParcelTracking = this.getByOrderNoParcelNoShippingNoTimeLocationStatusAndMessage(orderParcelTracking.getOrderNo(),
            orderParcelTracking.getParcelNo(),
            orderParcelTracking.getVendorShippingNo(),
            orderParcelTracking.getTime(),
            orderParcelTracking.getLocation(),
            orderParcelTracking.getStatus(),
            orderParcelTracking.getMessage(),
            orderParcelTracking.getSource());
        orderParcelTrackingDao.tombstoned(orderParcelTracking.getId());

        OrderParcelTracking orderParcelTracking2 = orderParcelTrackingDao.get(orderParcelTracking.getId());

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
        orderParcelTrackingDao.add(orderParcelTracking);
        orderParcelTracking = this.getByOrderNoParcelNoShippingNoTimeLocationStatusAndMessage(orderParcelTracking.getOrderNo(),
            orderParcelTracking.getParcelNo(),
            orderParcelTracking.getVendorShippingNo(),
            orderParcelTracking.getTime(),
            orderParcelTracking.getLocation(),
            orderParcelTracking.getStatus(),
            orderParcelTracking.getMessage(),
            orderParcelTracking.getSource());
        OrderParcelTracking orderParcelTracking2 = orderParcelTrackingDao.get(orderParcelTracking.getId());

        assertEquals(orderParcelTracking.getCreatedby(), orderParcelTracking2.getCreatedby());
    }

}
