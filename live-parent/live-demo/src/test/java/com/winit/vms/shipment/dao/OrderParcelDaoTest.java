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

import com.winit.vms.shipment.entity.OrderParcel;
import com.winit.vms.shipment.entity.ParcelStatus;
import com.winit.vms.shipment.query.OrderParcelQuery;
import com.winit.vms.system.BaseTest;

@SuppressWarnings("deprecation")
public class OrderParcelDaoTest extends BaseTest {

    @Resource
    private OrderParcelDao orderParcelDao;

    public OrderParcel getByOrderNoAndParcelNo(String orderNo, String parcelNo) {
        OrderParcelQuery.FindQuery query = new OrderParcelQuery.FindQuery();
        query.createCriteria().andOrderNoEqualTo(orderNo).andParcelNoEqualTo(parcelNo).andIsActiveEqualTo(true);
        List<OrderParcel> parcels = orderParcelDao.queryByCriteria(query);
        if (parcels.isEmpty()) {
            return null;
        }
        return parcels.get(0);
    }

    @Test
    @Rollback(true)
    public void testCrud() {
        OrderParcel orderParcel = new OrderParcel();
        Integer randId = new Double(100000 * Math.random()).intValue();
        orderParcel.setOrderNo("ord" + randId);
        orderParcel.setParcelNo("ord" + randId);
        orderParcel.setProductCode("ord" + randId);
        orderParcel.setVenderShippingNo("ord" + randId);
        orderParcel.setLength(BigDecimal.valueOf(randId));
        orderParcel.setWidth(BigDecimal.valueOf(randId));
        orderParcel.setHeight(BigDecimal.valueOf(randId));
        orderParcel.setWeight(BigDecimal.valueOf(randId));
        orderParcel.setValue(BigDecimal.valueOf(randId));
        orderParcel.setCurrencyUnit("ord" + randId);
        orderParcel.setDescription("ord" + randId);
        orderParcel.setStatus(ParcelStatus.LGF);
        orderParcel.setOrganizationId(Long.parseLong(randId + ""));
        orderParcel.setCreated(new Date());
        orderParcel.setCreatedby("ord" + randId);
        orderParcel.setUpdated(new Date());
        orderParcel.setUpdatedby("ord" + randId);
        orderParcel.setActive(true);

        // 创建一实体
        orderParcelDao.add(orderParcel);
        orderParcel = this.getByOrderNoAndParcelNo(orderParcel.getOrderNo(), orderParcel.getParcelNo());

        Assert.assertNotNull(orderParcel.getId());
        logger.debug("orderParcel1:" + orderParcel.getId());
        // 获取一实体
        OrderParcel orderParcel2 = (OrderParcel) orderParcelDao.get(orderParcel.getId());
        Assert.assertNotNull(orderParcel2);
        logger.debug("orderParcel2:" + orderParcel2.toString());
        Integer randId2 = new Double(100000 * Math.random()).intValue();

        orderParcel2.setOrderNo("ord" + randId2);

        orderParcel2.setParcelNo("ord" + randId2);

        orderParcel2.setProductCode("ord" + randId2);

        orderParcel2.setVenderShippingNo("ord" + randId2);

        orderParcel2.setCurrencyUnit("ord" + randId2);

        orderParcel2.setDescription("ord" + randId2);

        orderParcel2.setStatus(ParcelStatus.LGF);

        orderParcel2.setOrganizationId(Long.parseLong(randId2 + ""));

        orderParcel2.setCreated(new Date());

        orderParcel.setCreatedby("ord" + randId2);

        orderParcel2.setUpdated(new Date());

        orderParcel.setUpdatedby("ord" + randId2);

        orderParcel.setActive(true);

        // 更新一实体
        orderParcelDao.update(orderParcel2);

        OrderParcel orderParcel3 = orderParcelDao.get(orderParcel.getId());
        System.out.println("orderParcel3:" + orderParcel3.toString());
        // 删除一实体
        // orderParcelDao.tombstoned(orderParcel.getId());
    }

    @Test
    public void testCreate() {
        OrderParcel orderParcel = new OrderParcel();
        Integer randId = new Double(100000 * Math.random()).intValue();
        orderParcel.setOrderNo("ord" + randId);
        orderParcel.setParcelNo("ord" + randId);
        orderParcel.setProductCode("ord" + randId);
        orderParcel.setVenderShippingNo("ord" + randId);
        orderParcel.setLength(BigDecimal.valueOf(randId));
        orderParcel.setWidth(BigDecimal.valueOf(randId));
        orderParcel.setHeight(BigDecimal.valueOf(randId));
        orderParcel.setWeight(BigDecimal.valueOf(randId));
        orderParcel.setValue(BigDecimal.valueOf(randId));
        orderParcel.setCurrencyUnit("ord" + randId);
        orderParcel.setDescription("ord" + randId);
        orderParcel.setStatus(ParcelStatus.LGF);
        orderParcel.setOrganizationId(Long.parseLong(randId + ""));
        orderParcel.setCreated(new Date());
        orderParcel.setCreatedby("ord" + randId);
        orderParcel.setUpdated(new Date());
        orderParcel.setUpdatedby("ord" + randId);
        orderParcel.setActive(true);

        // 创建一实体
        orderParcelDao.add(orderParcel);
        orderParcel = this.getByOrderNoAndParcelNo(orderParcel.getOrderNo(), orderParcel.getParcelNo());
        OrderParcel orderParcel1 = orderParcelDao.get(orderParcel.getId());

        assertEquals(orderParcel.getOrganizationId(), orderParcel1.getOrganizationId());

    }

    @Test
    public void testUpdate() {
        OrderParcel orderParcel = new OrderParcel();
        Integer randId = new Double(100000 * Math.random()).intValue();
        orderParcel.setOrderNo("ord" + randId);
        orderParcel.setParcelNo("ord" + randId);
        orderParcel.setProductCode("ord" + randId);
        orderParcel.setVenderShippingNo("ord" + randId);
        orderParcel.setLength(BigDecimal.valueOf(randId));
        orderParcel.setWidth(BigDecimal.valueOf(randId));
        orderParcel.setHeight(BigDecimal.valueOf(randId));
        orderParcel.setWeight(BigDecimal.valueOf(randId));
        orderParcel.setValue(BigDecimal.valueOf(randId));
        orderParcel.setCurrencyUnit("ord" + randId);
        orderParcel.setDescription("ord" + randId);
        orderParcel.setStatus(ParcelStatus.LGF);
        orderParcel.setOrganizationId(Long.parseLong(randId + ""));
        orderParcel.setCreated(new Date());
        orderParcel.setCreatedby("ord" + randId);
        orderParcel.setUpdated(new Date());
        orderParcel.setUpdatedby("ord" + randId);
        orderParcel.setActive(true);

        // 创建一实体
        orderParcelDao.add(orderParcel);
        orderParcel = this.getByOrderNoAndParcelNo(orderParcel.getOrderNo(), orderParcel.getParcelNo());
        Integer randId2 = new Double(100000 * Math.random()).intValue();

        orderParcel.setOrderNo("ord" + randId2);

        orderParcel.setParcelNo("ord" + randId2);

        orderParcel.setProductCode("ord" + randId2);

        orderParcel.setVenderShippingNo("ord" + randId2);

        orderParcel.setLength(BigDecimal.valueOf(randId2));

        orderParcel.setWidth(BigDecimal.valueOf(randId2));

        orderParcel.setHeight(BigDecimal.valueOf(randId2));

        orderParcel.setWeight(BigDecimal.valueOf(randId2));

        orderParcel.setValue(BigDecimal.valueOf(randId2));

        orderParcel.setCurrencyUnit("ord" + randId2);

        orderParcel.setDescription("ord" + randId2);

        orderParcel.setStatus(ParcelStatus.LGF);

        orderParcel.setOrganizationId(Long.parseLong(randId2 + ""));

        orderParcel.setCreated(new Date());

        orderParcel.setCreatedby("ord" + randId2);

        orderParcel.setUpdated(new Date());

        orderParcel.setUpdatedby("ord" + randId2);

        orderParcel.setActive(true);

        // 创建一实体
        orderParcelDao.update(orderParcel);

        OrderParcel orderParcel2 = orderParcelDao.get(orderParcel.getId());

        assertEquals(orderParcel.getOrganizationId(), orderParcel2.getOrganizationId());
    }

    @Test
    public void testTombstoned() {
        OrderParcel orderParcel = new OrderParcel();
        Integer randId = new Double(100000 * Math.random()).intValue();
        orderParcel.setOrderNo("ord" + randId);
        orderParcel.setParcelNo("ord" + randId);
        orderParcel.setProductCode("ord" + randId);
        orderParcel.setVenderShippingNo("ord" + randId);
        orderParcel.setLength(BigDecimal.valueOf(randId));
        orderParcel.setWidth(BigDecimal.valueOf(randId));
        orderParcel.setHeight(BigDecimal.valueOf(randId));
        orderParcel.setWeight(BigDecimal.valueOf(randId));
        orderParcel.setValue(BigDecimal.valueOf(randId));
        orderParcel.setCurrencyUnit("ord" + randId);
        orderParcel.setDescription("ord" + randId);
        orderParcel.setStatus(ParcelStatus.LGF);
        orderParcel.setOrganizationId(Long.parseLong(randId + ""));
        orderParcel.setCreated(new Date());
        orderParcel.setCreatedby("ord" + randId);
        orderParcel.setUpdated(new Date());
        orderParcel.setUpdatedby("ord" + randId);
        orderParcel.setActive(true);

        // 创建一实体
        orderParcelDao.add(orderParcel);
        orderParcel = this.getByOrderNoAndParcelNo(orderParcel.getOrderNo(), orderParcel.getParcelNo());
        orderParcelDao.tombstoned(orderParcel.getId());

        OrderParcel orderParcel2 = orderParcelDao.get(orderParcel.getId());

        assertNull(orderParcel2);
    }

    @Test
    public void testGet() {
        OrderParcel orderParcel = new OrderParcel();
        Integer randId = new Double(100000 * Math.random()).intValue();
        orderParcel.setOrderNo("ord" + randId);
        orderParcel.setParcelNo("ord" + randId);
        orderParcel.setProductCode("ord" + randId);
        orderParcel.setVenderShippingNo("ord" + randId);
        orderParcel.setLength(BigDecimal.valueOf(randId));
        orderParcel.setWidth(BigDecimal.valueOf(randId));
        orderParcel.setHeight(BigDecimal.valueOf(randId));
        orderParcel.setWeight(BigDecimal.valueOf(randId));
        orderParcel.setValue(BigDecimal.valueOf(randId));
        orderParcel.setCurrencyUnit("ord" + randId);
        orderParcel.setDescription("ord" + randId);
        orderParcel.setStatus(ParcelStatus.LGF);
        orderParcel.setOrganizationId(Long.parseLong(randId + ""));
        orderParcel.setCreated(new Date());
        orderParcel.setCreatedby("ord" + randId);
        orderParcel.setUpdated(new Date());
        orderParcel.setUpdatedby("ord" + randId);
        orderParcel.setActive(true);

        // 创建一实体
        orderParcelDao.add(orderParcel);
        orderParcel = this.getByOrderNoAndParcelNo(orderParcel.getOrderNo(), orderParcel.getParcelNo());
        OrderParcel orderParcel2 = orderParcelDao.get(orderParcel.getId());

        assertEquals(orderParcel.getCreatedby(), orderParcel2.getCreatedby());
    }

}
