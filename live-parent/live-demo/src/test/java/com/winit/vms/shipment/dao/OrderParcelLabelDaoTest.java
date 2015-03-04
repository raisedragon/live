package com.winit.vms.shipment.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.winit.vms.shipment.entity.LabelStatus;
import com.winit.vms.shipment.entity.OrderParcelLabel;
import com.winit.vms.shipment.query.OrderParcelLabelQuery;
import com.winit.vms.system.BaseTest;

/**
 * 面单 Dao Test Case Change to the actual description of this class
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
@SuppressWarnings("deprecation")
public class OrderParcelLabelDaoTest extends BaseTest {

    @Resource
    private OrderParcelLabelDao orderParcelLabelDao;

    public OrderParcelLabel getByOrderNoAndParcelNo(String orderNo, String parcelNo) {
        OrderParcelLabelQuery.FindQuery query = new OrderParcelLabelQuery.FindQuery();
        query.createCriteria().andOrderNoEqualTo(orderNo).andParcelNoEqualTo(parcelNo).andIsActiveEqualTo(true);
        List<OrderParcelLabel> list = orderParcelLabelDao.queryByCriteria(query);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Test
    @Rollback(true)
    public void testCrud() {
        OrderParcelLabel orderParcelLabel = new OrderParcelLabel();
        Integer randId = new Double(100000 * Math.random()).intValue();
        orderParcelLabel.setOrderNo("ord" + randId);
        orderParcelLabel.setParcelNo("0");
        orderParcelLabel.setParcelNo("ord" + randId);
        orderParcelLabel.setPath("ord" + randId);
        orderParcelLabel.setMessage("ord" + randId);
        orderParcelLabel.setOrganizationId(Long.parseLong(randId + ""));
        orderParcelLabel.setCreated(new Date());
        orderParcelLabel.setCreatedby("ord" + randId);
        orderParcelLabel.setUpdated(new Date());
        orderParcelLabel.setUpdatedby("ord" + randId);
        orderParcelLabel.setStatus(LabelStatus.INI);
        orderParcelLabel.setActive(true);

        // 创建一实体
        orderParcelLabelDao.add(orderParcelLabel);
        orderParcelLabel = getByOrderNoAndParcelNo(orderParcelLabel.getOrderNo(), orderParcelLabel.getParcelNo());
        Assert.assertNotNull(orderParcelLabel.getId());
        logger.debug("orderParcelLabel1:" + orderParcelLabel.getId());
        // 获取一实体
        OrderParcelLabel orderParcelLabel2 = (OrderParcelLabel) orderParcelLabelDao.get(orderParcelLabel.getId());
        Assert.assertNotNull(orderParcelLabel2);
        logger.debug("orderParcelLabel2:" + orderParcelLabel2.toString());
        Integer randId2 = new Double(100000 * Math.random()).intValue();
        orderParcelLabel2.setOrderNo("ord" + randId2);
        orderParcelLabel2.setParcelNo("0");
        orderParcelLabel2.setParcelNo("ord" + randId2);
        orderParcelLabel2.setPath("ord" + randId2);
        orderParcelLabel2.setMessage("ord" + randId2);
        orderParcelLabel2.setOrganizationId(Long.parseLong(randId2 + ""));
        orderParcelLabel2.setCreated(new Date());
        orderParcelLabel.setCreatedby("ord" + randId2);
        orderParcelLabel2.setUpdated(new Date());
        orderParcelLabel.setUpdatedby("ord" + randId2);
        orderParcelLabel.setActive(true);
        orderParcelLabel.setStatus(LabelStatus.INI);
        // 更新一实体
        orderParcelLabelDao.update(orderParcelLabel2);

        OrderParcelLabel orderParcelLabel3 = orderParcelLabelDao.get(orderParcelLabel.getId());
        System.out.println("orderParcelLabel3:" + orderParcelLabel3.toString());
        // 删除一实体
        // orderParcelLabelDao.tombstoned(orderParcelLabel.getId());
    }

    @Test
    public void testCreate() {
        OrderParcelLabel orderParcelLabel = new OrderParcelLabel();
        Integer randId = new Double(100000 * Math.random()).intValue();
        orderParcelLabel.setOrderNo("ord" + randId);
        orderParcelLabel.setParcelNo("0");
        orderParcelLabel.setParcelNo("ord" + randId);
        orderParcelLabel.setPath("ord" + randId);
        orderParcelLabel.setMessage("ord" + randId);
        orderParcelLabel.setOrganizationId(Long.parseLong(randId + ""));
        orderParcelLabel.setCreated(new Date());
        orderParcelLabel.setCreatedby("ord" + randId);
        orderParcelLabel.setUpdated(new Date());
        orderParcelLabel.setUpdatedby("ord" + randId);
        orderParcelLabel.setActive(true);
        orderParcelLabel.setStatus(LabelStatus.INI);

        // 创建一实体
        orderParcelLabelDao.add(orderParcelLabel);
        orderParcelLabel = getByOrderNoAndParcelNo(orderParcelLabel.getOrderNo(), orderParcelLabel.getParcelNo());
        OrderParcelLabel orderParcelLabel1 = orderParcelLabelDao.get(orderParcelLabel.getId());

        assertEquals(orderParcelLabel.getOrganizationId(), orderParcelLabel1.getOrganizationId());

    }

    @Test
    public void testUpdate() {
        OrderParcelLabel orderParcelLabel = new OrderParcelLabel();
        Integer randId = new Double(100000 * Math.random()).intValue();
        orderParcelLabel.setOrderNo("ord" + randId);
        orderParcelLabel.setParcelNo("0");
        orderParcelLabel.setParcelNo("ord" + randId);
        orderParcelLabel.setPath("ord" + randId);
        orderParcelLabel.setMessage("ord" + randId);
        orderParcelLabel.setOrganizationId(Long.parseLong(randId + ""));
        orderParcelLabel.setCreated(new Date());
        orderParcelLabel.setCreatedby("ord" + randId);
        orderParcelLabel.setUpdated(new Date());
        orderParcelLabel.setUpdatedby("ord" + randId);
        orderParcelLabel.setActive(true);
        orderParcelLabel.setStatus(LabelStatus.INI);

        // 创建一实体
        orderParcelLabelDao.add(orderParcelLabel);
        orderParcelLabel = getByOrderNoAndParcelNo(orderParcelLabel.getOrderNo(), orderParcelLabel.getParcelNo());
        Integer randId2 = new Double(100000 * Math.random()).intValue();
        orderParcelLabel.setOrderNo("ord" + randId2);
        orderParcelLabel.setParcelNo("0");
        orderParcelLabel.setParcelNo("ord" + randId2);
        orderParcelLabel.setPath("ord" + randId2);
        orderParcelLabel.setMessage("ord" + randId2);
        orderParcelLabel.setOrganizationId(Long.parseLong(randId2 + ""));
        orderParcelLabel.setCreated(new Date());
        orderParcelLabel.setCreatedby("ord" + randId2);
        orderParcelLabel.setUpdated(new Date());
        orderParcelLabel.setUpdatedby("ord" + randId2);
        orderParcelLabel.setActive(true);
        orderParcelLabel.setStatus(LabelStatus.INI);

        // 创建一实体
        orderParcelLabelDao.update(orderParcelLabel);

        OrderParcelLabel orderParcelLabel2 = orderParcelLabelDao.get(orderParcelLabel.getId());

        assertEquals(orderParcelLabel.getOrganizationId(), orderParcelLabel2.getOrganizationId());
    }

    @Test
    public void testTombstoned() {
        OrderParcelLabel orderParcelLabel = new OrderParcelLabel();
        Integer randId = new Double(100000 * Math.random()).intValue();
        orderParcelLabel.setOrderNo("ord" + randId);
        orderParcelLabel.setParcelNo("0");
        orderParcelLabel.setParcelNo("ord" + randId);
        orderParcelLabel.setPath("ord" + randId);
        orderParcelLabel.setMessage("ord" + randId);
        orderParcelLabel.setOrganizationId(Long.parseLong(randId + ""));
        orderParcelLabel.setCreated(new Date());
        orderParcelLabel.setCreatedby("ord" + randId);
        orderParcelLabel.setUpdated(new Date());
        orderParcelLabel.setUpdatedby("ord" + randId);
        orderParcelLabel.setActive(true);
        orderParcelLabel.setStatus(LabelStatus.INI);

        // 创建一实体
        orderParcelLabelDao.add(orderParcelLabel);
        orderParcelLabel = getByOrderNoAndParcelNo(orderParcelLabel.getOrderNo(), orderParcelLabel.getParcelNo());
        orderParcelLabelDao.tombstoned(orderParcelLabel.getId());

        OrderParcelLabel orderParcelLabel2 = orderParcelLabelDao.get(orderParcelLabel.getId());

        assertNull(orderParcelLabel2);
    }

    @Test
    public void testGet() {
        OrderParcelLabel orderParcelLabel = new OrderParcelLabel();
        Integer randId = new Double(100000 * Math.random()).intValue();
        orderParcelLabel.setOrderNo("ord" + randId);
        orderParcelLabel.setParcelNo("0");
        orderParcelLabel.setParcelNo("ord" + randId);
        orderParcelLabel.setPath("ord" + randId);
        orderParcelLabel.setMessage("ord" + randId);
        orderParcelLabel.setOrganizationId(Long.parseLong(randId + ""));
        orderParcelLabel.setCreated(new Date());
        orderParcelLabel.setCreatedby("ord" + randId);
        orderParcelLabel.setUpdated(new Date());
        orderParcelLabel.setUpdatedby("ord" + randId);
        orderParcelLabel.setActive(true);
        orderParcelLabel.setStatus(LabelStatus.INI);

        // 创建一实体
        orderParcelLabelDao.add(orderParcelLabel);
        orderParcelLabel = getByOrderNoAndParcelNo(orderParcelLabel.getOrderNo(), orderParcelLabel.getParcelNo());
        OrderParcelLabel orderParcelLabel2 = orderParcelLabelDao.get(orderParcelLabel.getId());

        assertEquals(orderParcelLabel.getCreatedby(), orderParcelLabel2.getCreatedby());
    }

}
