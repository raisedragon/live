package com.winit.vms.shipment.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.winit.vms.shipment.entity.LabelStatus;
import com.winit.vms.shipment.entity.OrderParcelLabel;
import com.winit.vms.system.BaseTest;

/**
 * 面单 Manager Test Case Change to the actual description of this class
 * 
 * @version Revision History
 * 
 * <pre>
 * Author     			Version       Date			Changes
 * longsheng.wang    	1.0       2015-01-13 14:09:28			Created
 * 
 * </pre>
 * @since 1.
 */

public class OrderParcelLabelManagerTest extends BaseTest {

    @Resource
    OrderParcelLabelManager orderParcelLabelManager;

    @Test
    public void testCreate() {
        OrderParcelLabel orderParcelLabel = new OrderParcelLabel();
        Integer randId = new Double(100000 * Math.random()).intValue();

        orderParcelLabel.setOrderNo("ord" + randId);
        orderParcelLabel.setParcelNo("0");
        orderParcelLabel.setParcelNo("ord" + randId);
        orderParcelLabel.setOrganizationId(Long.parseLong(randId + ""));
        orderParcelLabel.setCreated(new Date());
        orderParcelLabel.setCreatedby("ord" + randId);
        orderParcelLabel.setUpdated(new Date());
        orderParcelLabel.setUpdatedby("ord" + randId);
        orderParcelLabel.setActive(true);
        orderParcelLabel.setStatus(LabelStatus.INI);

        // 创建一实体
        orderParcelLabelManager.add(orderParcelLabel);
        orderParcelLabel = orderParcelLabelManager.getByOrderNoAndParcelNo(orderParcelLabel.getOrderNo(),
            orderParcelLabel.getParcelNo());
        OrderParcelLabel orderParcelLabel1 = orderParcelLabelManager.get(orderParcelLabel.getId());

        assertEquals(orderParcelLabel.getOrganizationId(), orderParcelLabel1.getOrganizationId());

    }

    @Test
    public void testUpdate() {
        OrderParcelLabel orderParcelLabel = new OrderParcelLabel();
        Integer randId = new Double(100000 * Math.random()).intValue();

        orderParcelLabel.setOrderNo("ord" + randId);
        orderParcelLabel.setParcelNo("0");
        orderParcelLabel.setParcelNo("ord" + randId);
        orderParcelLabel.setOrganizationId(Long.parseLong(randId + ""));
        orderParcelLabel.setCreated(new Date());
        orderParcelLabel.setCreatedby("ord" + randId);
        orderParcelLabel.setUpdated(new Date());
        orderParcelLabel.setUpdatedby("ord" + randId);
        orderParcelLabel.setActive(true);
        orderParcelLabel.setStatus(LabelStatus.INI);

        // 创建一实体
        orderParcelLabelManager.add(orderParcelLabel);
        orderParcelLabel = orderParcelLabelManager.getByOrderNoAndParcelNo(orderParcelLabel.getOrderNo(),
            orderParcelLabel.getParcelNo());
        Integer randId2 = new Double(100000 * Math.random()).intValue();
        orderParcelLabel.setOrderNo("ord" + randId2);
        orderParcelLabel.setParcelNo(randId2 + "");
        orderParcelLabel.setParcelNo("ord" + randId2);
        orderParcelLabel.setOrganizationId(Long.parseLong(randId2 + ""));
        orderParcelLabel.setCreated(new Date());
        orderParcelLabel.setCreatedby("ord" + randId2);
        orderParcelLabel.setUpdated(new Date());
        orderParcelLabel.setUpdatedby("ord" + randId2);
        orderParcelLabel.setActive(true);
        orderParcelLabel.setStatus(LabelStatus.INI);
        // 创建一实体
        orderParcelLabelManager.update(orderParcelLabel);

        OrderParcelLabel orderParcelLabel2 = orderParcelLabelManager.get(orderParcelLabel.getId());

        assertEquals(orderParcelLabel.getOrganizationId(), orderParcelLabel2.getOrganizationId());
    }

    @Test
    public void testTombstoned() {
        OrderParcelLabel orderParcelLabel = new OrderParcelLabel();
        Integer randId = new Double(100000 * Math.random()).intValue();

        orderParcelLabel.setOrderNo("ord" + randId);
        orderParcelLabel.setParcelNo("0");
        orderParcelLabel.setParcelNo("ord" + randId);
        orderParcelLabel.setOrganizationId(Long.parseLong(randId + ""));
        orderParcelLabel.setCreated(new Date());
        orderParcelLabel.setCreatedby("ord" + randId);
        orderParcelLabel.setUpdated(new Date());
        orderParcelLabel.setUpdatedby("ord" + randId);
        orderParcelLabel.setActive(true);
        orderParcelLabel.setStatus(LabelStatus.INI);
        // 创建一实体
        orderParcelLabelManager.add(orderParcelLabel);
        orderParcelLabel = orderParcelLabelManager.getByOrderNoAndParcelNo(orderParcelLabel.getOrderNo(),
            orderParcelLabel.getParcelNo());
        orderParcelLabelManager.tombstoned(orderParcelLabel.getId());

        OrderParcelLabel orderParcelLabel2 = orderParcelLabelManager.get(orderParcelLabel.getId());

        assertNull(orderParcelLabel2);
    }

    @Test
    public void testGet() {
        OrderParcelLabel orderParcelLabel = new OrderParcelLabel();
        Integer randId = new Double(100000 * Math.random()).intValue();

        orderParcelLabel.setOrderNo("ord" + randId);
        orderParcelLabel.setParcelNo("0");
        orderParcelLabel.setParcelNo("ord" + randId);
        orderParcelLabel.setOrganizationId(Long.parseLong(randId + ""));
        orderParcelLabel.setCreated(new Date());
        orderParcelLabel.setCreatedby("ord" + randId);
        orderParcelLabel.setUpdated(new Date());
        orderParcelLabel.setUpdatedby("ord" + randId);
        orderParcelLabel.setActive(true);
        orderParcelLabel.setStatus(LabelStatus.INI);
        // 创建一实体
        orderParcelLabelManager.add(orderParcelLabel);
        orderParcelLabel = orderParcelLabelManager.getByOrderNoAndParcelNo(orderParcelLabel.getOrderNo(),
            orderParcelLabel.getParcelNo());
        OrderParcelLabel orderParcelLabel2 = orderParcelLabelManager.get(orderParcelLabel.getId());

        assertEquals(orderParcelLabel.getCreatedby(), orderParcelLabel2.getCreatedby());
    }

}
