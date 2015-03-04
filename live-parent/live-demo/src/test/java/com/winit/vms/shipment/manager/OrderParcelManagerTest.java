package com.winit.vms.shipment.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.junit.Test;

import com.winit.vms.shipment.entity.OrderParcel;
import com.winit.vms.shipment.query.OrderParcelQuery;
import com.winit.vms.system.BaseTest;

public class OrderParcelManagerTest extends BaseTest {

    @Resource
    OrderParcelManager orderParcelManager;

    @Test
    public void testCreate() {
        OrderParcel orderParcel = new OrderParcel();
        Integer randId = new Double(100000 * Math.random()).intValue();

        orderParcel.setOrderNo("ord" + randId);
        orderParcel.setParcelNo("ord" + randId);
        orderParcel.setProductCode("ord" + randId);
        orderParcel.setOrganizationId(Long.parseLong(randId + ""));
        orderParcel.setCreated(new Date());
        orderParcel.setCreatedby("ord" + randId);
        orderParcel.setUpdated(new Date());
        orderParcel.setUpdatedby("ord" + randId);
        orderParcel.setActive(true);

        // 创建一实体
        orderParcelManager.add(orderParcel);
        orderParcel = orderParcelManager.getByOrderNoAndParcelNo(orderParcel.getOrderNo(), orderParcel.getParcelNo());
        OrderParcel orderParcel1 = orderParcelManager.get(orderParcel.getId());

        assertEquals(orderParcel.getOrganizationId(), orderParcel1.getOrganizationId());

    }

    @Test
    public void testUpdate() {
        OrderParcel orderParcel = new OrderParcel();
        Integer randId = new Double(100000 * Math.random()).intValue();

        orderParcel.setOrderNo("ord" + randId);
        orderParcel.setParcelNo("ord" + randId);
        orderParcel.setProductCode("ord" + randId);
        orderParcel.setOrganizationId(Long.parseLong(randId + ""));
        orderParcel.setCreated(new Date());
        orderParcel.setCreatedby("ord" + randId);
        orderParcel.setUpdated(new Date());
        orderParcel.setUpdatedby("ord" + randId);
        orderParcel.setActive(true);

        // 创建一实体
        orderParcelManager.add(orderParcel);
        orderParcel = orderParcelManager.getByOrderNoAndParcelNo(orderParcel.getOrderNo(), orderParcel.getParcelNo());
        Integer randId2 = new Double(100000 * Math.random()).intValue();
        orderParcel.setOrderNo("ord" + randId2);
        orderParcel.setParcelNo("ord" + randId2);
        orderParcel.setProductCode("ord" + randId2);
        orderParcel.setOrganizationId(Long.parseLong(randId2 + ""));
        orderParcel.setCreated(new Date());
        orderParcel.setCreatedby("ord" + randId2);
        orderParcel.setUpdated(new Date());
        orderParcel.setUpdatedby("ord" + randId2);
        orderParcel.setActive(true);

        // 创建一实体
        orderParcelManager.update(orderParcel);

        OrderParcel orderParcel2 = orderParcelManager.get(orderParcel.getId());

        assertEquals(orderParcel.getOrganizationId(), orderParcel2.getOrganizationId());
    }

    @Test
    public void testTombstoned() {
        OrderParcel orderParcel = new OrderParcel();
        Integer randId = new Double(100000 * Math.random()).intValue();

        orderParcel.setOrderNo("ord" + randId);
        orderParcel.setParcelNo("ord" + randId);
        orderParcel.setProductCode("ord" + randId);
        orderParcel.setOrganizationId(Long.parseLong(randId + ""));
        orderParcel.setCreated(new Date());
        orderParcel.setCreatedby("ord" + randId);
        orderParcel.setUpdated(new Date());
        orderParcel.setUpdatedby("ord" + randId);
        orderParcel.setActive(true);

        // 创建一实体
        orderParcelManager.add(orderParcel);
        orderParcel = orderParcelManager.getByOrderNoAndParcelNo(orderParcel.getOrderNo(), orderParcel.getParcelNo());
        orderParcelManager.tombstoned(orderParcel.getId());

        OrderParcel orderParcel2 = orderParcelManager.get(orderParcel.getId());

        assertNull(orderParcel2);
    }

    @Test
    public void testGet() {
        OrderParcel orderParcel = new OrderParcel();
        Integer randId = new Double(100000 * Math.random()).intValue();

        orderParcel.setOrderNo("ord" + randId);
        orderParcel.setParcelNo("ord" + randId);
        orderParcel.setProductCode("ord" + randId);
        orderParcel.setOrganizationId(Long.parseLong(randId + ""));
        orderParcel.setCreated(new Date());
        orderParcel.setCreatedby("ord" + randId);
        orderParcel.setUpdated(new Date());
        orderParcel.setUpdatedby("ord" + randId);
        orderParcel.setActive(true);

        // 创建一实体
        orderParcelManager.add(orderParcel);
        orderParcel = orderParcelManager.getByOrderNoAndParcelNo(orderParcel.getOrderNo(), orderParcel.getParcelNo());
        OrderParcel orderParcel2 = orderParcelManager.get(orderParcel.getId());

        assertEquals(orderParcel.getCreatedby(), orderParcel2.getCreatedby());
    }

    // @Test
    public void testQueryOrderParcelByParam() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<String> prdList = new ArrayList<String>();
        prdList.add("K01");
        prdList.add("K02");
        map.put("productCodeList", prdList);
        List<OrderParcel> list = (List<OrderParcel>) orderParcelManager.queryOrderParcelByParam(map);
        System.out.println(list.size());
    }

    @Test
    // @Rollback(false)
    public void testUpdateByUpdateQuery() {
        Random random = new Random(System.currentTimeMillis());
        OrderParcelQuery.UpdateQuery uQuery = new OrderParcelQuery.UpdateQuery();
        uQuery.createCriteria().andRealWeightIsNull();
        uQuery.getUpdateClause().setRealLength(BigDecimal.valueOf(random.nextInt(10)));
        uQuery.getUpdateClause().setRealWidth(BigDecimal.valueOf(random.nextInt(10)));
        uQuery.getUpdateClause().setRealHeight(BigDecimal.valueOf(random.nextInt(10)));
        uQuery.getUpdateClause().setRealWeight(BigDecimal.valueOf(random.nextInt(10)));
        uQuery.getUpdateClause().setRealVolume(BigDecimal.valueOf(random.nextInt(10)));
        orderParcelManager.updateByUpdateQuery(uQuery);
    }
}
