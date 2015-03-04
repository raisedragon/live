package com.winit.vms.shipment.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;

import org.junit.Test;

import com.winit.vms.shipment.entity.CalcPayableStatus;
import com.winit.vms.shipment.entity.Order;
import com.winit.vms.shipment.entity.OrderStatus;
import com.winit.vms.shipment.query.OrderQuery;
import com.winit.vms.system.BaseTest;

public class OrderManagerTest extends BaseTest {

    @Resource
    OrderManager orderManager;

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
        order.setOrderStatus(OrderStatus.LGF);
        order.setOrganizationId(Long.parseLong(randId + ""));
        order.setCreated(new Date());
        order.setCreatedby("ord" + randId);
        order.setUpdated(new Date());
        order.setUpdatedby("ord" + randId);
        order.setActive(true);
        order.setCalcPayableStatus(CalcPayableStatus.INI);
        // 创建一实体
        orderManager.add(order);
        order = orderManager.getByOrderNo(order.getOrderNo());
        Order order1 = orderManager.get(order.getId());

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
        order.setOrderStatus(OrderStatus.LGF);
        order.setOrganizationId(Long.parseLong(randId + ""));
        order.setCreated(new Date());
        order.setCreatedby("ord" + randId);
        order.setUpdated(new Date());
        order.setUpdatedby("ord" + randId);
        order.setActive(true);
        order.setCalcPayableStatus(CalcPayableStatus.INI);
        // 创建一实体
        orderManager.add(order);
        order = orderManager.getByOrderNo(order.getOrderNo());
        Integer randId2 = new Double(100000 * Math.random()).intValue();
        order.setOrderNo("ord" + randId2);
        order.setOrderStatus(OrderStatus.LGF);
        order.setOrganizationId(Long.parseLong(randId2 + ""));
        order.setCreated(new Date());
        order.setCreatedby("ord" + randId2);
        order.setUpdated(new Date());
        order.setUpdatedby("ord" + randId2);
        order.setActive(true);
        order.setCalcPayableStatus(CalcPayableStatus.INI);
        // 创建一实体
        orderManager.update(order);

        Order order2 = orderManager.get(order.getId());

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
        order.setOrderStatus(OrderStatus.LGF);
        order.setOrganizationId(Long.parseLong(randId + ""));
        order.setCreated(new Date());
        order.setCreatedby("ord" + randId);
        order.setUpdated(new Date());
        order.setUpdatedby("ord" + randId);
        order.setActive(true);
        order.setCalcPayableStatus(CalcPayableStatus.INI);
        // 创建一实体
        orderManager.add(order);
        order = orderManager.getByOrderNo(order.getOrderNo());
        orderManager.tombstoned(order.getId());

        Order order2 = orderManager.get(order.getId());

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
        order.setOrderStatus(OrderStatus.LGF);
        order.setOrganizationId(Long.parseLong(randId + ""));
        order.setCreated(new Date());
        order.setCreatedby("ord" + randId);
        order.setUpdated(new Date());
        order.setUpdatedby("ord" + randId);
        order.setActive(true);
        order.setCalcPayableStatus(CalcPayableStatus.INI);
        // 创建一实体
        orderManager.add(order);
        order = orderManager.getByOrderNo(order.getOrderNo());
        Order order2 = orderManager.get(order.getId());

        assertEquals(order.getCreatedby(), order2.getCreatedby());
    }

    @Test
    // @Rollback(false)
    public void testUpdateByUpdateQuery() {
        Random random = new Random(System.currentTimeMillis());
        OrderQuery.UpdateQuery uQuery = new OrderQuery.UpdateQuery();
        uQuery.createCriteria().andRealWeightIsNull();
        uQuery.getUpdateClause().setRealLength(BigDecimal.valueOf(random.nextInt(10)));
        uQuery.getUpdateClause().setRealWidth(BigDecimal.valueOf(random.nextInt(10)));
        uQuery.getUpdateClause().setRealHeight(BigDecimal.valueOf(random.nextInt(10)));
        uQuery.getUpdateClause().setRealWeight(BigDecimal.valueOf(random.nextInt(10)));
        uQuery.getUpdateClause().setRealVolume(BigDecimal.valueOf(random.nextInt(10)));
        uQuery.getUpdateClause().setAccountingDate(new Date());
        orderManager.updateByUpdateQuery(uQuery);
    }

}
