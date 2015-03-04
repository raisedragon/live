package com.winit.vms.shipment.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

import com.winit.vms.shipment.entity.CalcPayableStatus;
import com.winit.vms.shipment.entity.Order;
import com.winit.vms.shipment.entity.OrderStatus;
import com.winit.vms.shipment.query.OrderQuery;
import com.winit.vms.system.BaseTest;

@SuppressWarnings("deprecation")
public class OrderDaoTest extends BaseTest {

    @Resource
    private OrderDao orderDao;

    public Order getByOrderNo(String orderNo) {
        OrderQuery.FindQuery query = new OrderQuery.FindQuery();
        query.createCriteria().andOrderNoEqualTo(orderNo).andIsActiveEqualTo(true);
        List<Order> orders = orderDao.queryByCriteria(query);
        if (orders.size() > 0) {
            return orders.get(0);
        }
        return null;
    }

    @Test
    public void testCrud() {
        Order order = new Order();
        Integer randId = new Double(100000 * Math.random()).intValue();
        order.setOrderNo("ord" + randId);
        order.setName("ord" + randId);
        order.setCountryCode("US");
        order.setCity("city");
        order.setState("state");
        order.setAddress1("address1");
        order.setPostcode("postCode");
        order.setVendorOrderNo("ord" + randId);
        order.setOrderStatus(OrderStatus.LGF);
        order.setProductCode("ord" + randId);
        order.setManifestNo("ord" + randId);
        order.setVendorManifestNo("ord" + randId);
        order.setOrganizationId(Long.parseLong(randId + ""));
        order.setCreated(new Date());
        order.setCreatedby("ord" + randId);
        order.setUpdated(new Date());
        order.setUpdatedby("ord" + randId);
        order.setActive(true);
        order.setCalcPayableStatus(CalcPayableStatus.INI);
        // 创建一实体
        orderDao.add(order);
        order = getByOrderNo(order.getOrderNo());

        Assert.assertNotNull(order.getId());
        logger.debug("order1:" + order.getId());
        // 获取一实体
        Order order2 = (Order) orderDao.get(order.getId());
        Assert.assertNotNull(order2);
        logger.debug("order2:" + order2.toString());
        Integer randId2 = new Double(100000 * Math.random()).intValue();

        order2.setOrderNo("ord" + randId2);

        order2.setVendorOrderNo("ord" + randId2);

        order2.setOrderStatus(OrderStatus.LGF);

        order2.setProductCode("ord" + randId2);

        order2.setManifestNo("ord" + randId2);

        order2.setVendorManifestNo("ord" + randId2);

        order2.setOrganizationId(Long.parseLong(randId2 + ""));

        order2.setCreated(new Date());

        order.setCreatedby("ord" + randId2);

        order2.setUpdated(new Date());

        order.setUpdatedby("ord" + randId2);

        order.setActive(true);
        order.setCalcPayableStatus(CalcPayableStatus.INI);
        // 更新一实体
        orderDao.update(order2);
        // 删除一实体
        // orderDao.tombstoned(order.getId());
    }

    @Test
    public void testCreate() {
        Order order = new Order();
        Integer randId = new Double(100000 * Math.random()).intValue();
        order.setOrderNo("ord" + randId);
        order.setName("ord" + randId);
        order.setCountryCode("US");
        order.setCity("city");
        order.setState("state");
        order.setAddress1("address1");
        order.setPostcode("postCode");
        order.setVendorOrderNo("ord" + randId);
        order.setOrderStatus(OrderStatus.LGF);
        order.setProductCode("ord" + randId);
        order.setManifestNo("ord" + randId);
        order.setVendorManifestNo("ord" + randId);
        order.setOrganizationId(Long.parseLong(randId + ""));
        order.setCreated(new Date());
        order.setCreatedby("ord" + randId);
        order.setUpdated(new Date());
        order.setUpdatedby("ord" + randId);
        order.setActive(true);
        order.setCalcPayableStatus(CalcPayableStatus.INI);
        // 创建一实体
        orderDao.add(order);
        order = getByOrderNo(order.getOrderNo());
        Order order1 = orderDao.get(order.getId());

        assertEquals(order.getOrganizationId(), order1.getOrganizationId());

    }

    @Test
    public void testUpdate() {
        Order order = new Order();
        Integer randId = new Double(100000 * Math.random()).intValue();
        order.setOrderNo("ord" + randId);
        order.setName("ord" + randId);
        order.setCountryCode("US");
        order.setCity("city");
        order.setState("state");
        order.setAddress1("address1");
        order.setPostcode("postCode");
        order.setVendorOrderNo("ord" + randId);
        order.setOrderStatus(OrderStatus.LGF);
        order.setProductCode("ord" + randId);
        order.setManifestNo("ord" + randId);
        order.setVendorManifestNo("ord" + randId);
        order.setOrganizationId(Long.parseLong(randId + ""));
        order.setCreated(new Date());
        order.setCreatedby("ord" + randId);
        order.setUpdated(new Date());
        order.setUpdatedby("ord" + randId);
        order.setActive(true);
        order.setCalcPayableStatus(CalcPayableStatus.INI);
        // 创建一实体
        orderDao.add(order);
        order = getByOrderNo(order.getOrderNo());
        Integer randId2 = new Double(100000 * Math.random()).intValue();

        order.setOrderNo("ord" + randId2);

        order.setVendorOrderNo("ord" + randId2);

        order.setOrderStatus(OrderStatus.LGF);

        order.setProductCode("ord" + randId2);

        order.setManifestNo("ord" + randId2);

        order.setVendorManifestNo("ord" + randId2);

        order.setOrganizationId(Long.parseLong(randId2 + ""));

        order.setCreated(new Date());

        order.setCreatedby("ord" + randId2);

        order.setUpdated(new Date());

        order.setUpdatedby("ord" + randId2);

        order.setActive(true);
        order.setCalcPayableStatus(CalcPayableStatus.INI);

        // 创建一实体
        orderDao.update(order);

        Order order2 = orderDao.get(order.getId());

        assertEquals(order.getOrganizationId(), order2.getOrganizationId());
    }

    @Test
    public void testTombstoned() {
        Order order = new Order();
        Integer randId = new Double(100000 * Math.random()).intValue();
        order.setOrderNo("ord" + randId);
        order.setName("ord" + randId);
        order.setCountryCode("US");
        order.setCity("city");
        order.setState("state");
        order.setAddress1("address1");
        order.setPostcode("postCode");
        order.setVendorOrderNo("ord" + randId);
        order.setOrderStatus(OrderStatus.LGF);
        order.setProductCode("ord" + randId);
        order.setManifestNo("ord" + randId);
        order.setVendorManifestNo("ord" + randId);
        order.setOrganizationId(Long.parseLong(randId + ""));
        order.setCreated(new Date());
        order.setCreatedby("ord" + randId);
        order.setUpdated(new Date());
        order.setUpdatedby("ord" + randId);
        order.setActive(true);
        order.setCalcPayableStatus(CalcPayableStatus.INI);
        // 创建一实体
        orderDao.add(order);
        order = getByOrderNo(order.getOrderNo());
        orderDao.tombstoned(order.getId());

        Order order2 = orderDao.get(order.getId());

        assertNull(order2);
    }

    @Test
    public void testGet() {
        Order order = new Order();
        Integer randId = new Double(100000 * Math.random()).intValue();
        order.setOrderNo("ord" + randId);
        order.setName("ord" + randId);
        order.setCountryCode("US");
        order.setCity("city");
        order.setState("state");
        order.setAddress1("address1");
        order.setPostcode("postCode");
        order.setVendorOrderNo("ord" + randId);
        order.setOrderStatus(OrderStatus.LGF);
        order.setProductCode("ord" + randId);
        order.setManifestNo("ord" + randId);
        order.setVendorManifestNo("ord" + randId);
        order.setOrganizationId(Long.parseLong(randId + ""));
        order.setCreated(new Date());
        order.setCreatedby("ord" + randId);
        order.setUpdated(new Date());
        order.setUpdatedby("ord" + randId);
        order.setActive(true);
        order.setCalcPayableStatus(CalcPayableStatus.INI);

        // 创建一实体
        orderDao.add(order);
        order = getByOrderNo(order.getOrderNo());
        Order order2 = orderDao.get(order.getId());

        assertEquals(order.getCreatedby(), order2.getCreatedby());
    }

}
