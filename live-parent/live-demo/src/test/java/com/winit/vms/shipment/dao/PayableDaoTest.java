package com.winit.vms.shipment.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.winit.vms.shipment.entity.Payable;
import com.winit.vms.shipment.entity.PayableStatus;
import com.winit.vms.system.BaseTest;

/**
 * 应付费用 Dao Test Case Change to the actual description of this class
 * 
 * @version Revision History
 * 
 * <pre>
 * Author     			Version       Date			Changes
 * longsheng.wang    	1.0       2015-01-14 22:41:46			Created
 * 
 * </pre>
 * @since 1.
 */
@SuppressWarnings("deprecation")
public class PayableDaoTest extends BaseTest {

    @Resource
    private PayableDao payableDao;

    @Test
    @Rollback(true)
    public void testCrud() {
        Payable payable = new Payable();
        Integer randId = new Double(100000 * Math.random()).intValue();
        payable.setId(idGenerator.getUId());
        payable.setPartnerId(Long.parseLong(randId + ""));
        payable.setPartnerName("pay" + randId);
        payable.setDocumentNo("pay" + randId);
        payable.setOrderNo("pay" + randId);
        payable.setChargeCode("pay" + randId);
        payable.setExchangeRate(BigDecimal.valueOf(randId));
        payable.setAmount(BigDecimal.valueOf(randId));
        payable.setCurrencyUnit("pay" + randId);
        payable.setDate(new Date());
        payable.setQuantity(randId);
        payable.setStatus(PayableStatus.INI);
        payable.setOrganizationId(Long.parseLong(randId + ""));
        payable.setCreated(new Date());
        payable.setCreatedby("pay" + randId);
        payable.setUpdated(new Date());
        payable.setUpdatedby("pay" + randId);
        payable.setActive(true);

        // 创建一实体
        payableDao.add(payable);
        Assert.assertNotNull(payable.getId());
        logger.debug("payable1:" + payable.getId());
        // 获取一实体
        Payable payable2 = (Payable) payableDao.get(payable.getId());
        Assert.assertNotNull(payable2);
        logger.debug("payable2:" + payable2.toString());
        Integer randId2 = new Double(100000 * Math.random()).intValue();
        payable2.setPartnerId(Long.parseLong(randId2 + ""));
        payable2.setPartnerName("pay" + randId2);
        payable2.setDocumentNo("pay" + randId2);
        payable2.setOrderNo("pay" + randId2);
        payable2.setChargeCode("pay" + randId2);
        payable2.setCurrencyUnit("pay" + randId2);
        payable2.setDate(new Date());
        payable2.setQuantity(randId2);
        payable2.setStatus(PayableStatus.INI);
        payable2.setOrganizationId(Long.parseLong(randId2 + ""));
        payable2.setCreated(new Date());
        payable.setCreatedby("pay" + randId2);
        payable2.setUpdated(new Date());
        payable.setUpdatedby("pay" + randId2);
        payable.setActive(true);
        // 更新一实体
        payableDao.update(payable2);

        Payable payable3 = payableDao.get(payable.getId());
        System.out.println("payable3:" + payable3.toString());
        // 删除一实体
        // payableDao.tombstoned(payable.getId());
    }

    @Test
    public void testCreate() {
        Payable payable = new Payable();
        Integer randId = new Double(100000 * Math.random()).intValue();
        payable.setId(idGenerator.getUId());
        payable.setPartnerId(Long.parseLong(randId + ""));
        payable.setPartnerName("pay" + randId);
        payable.setDocumentNo("pay" + randId);
        payable.setOrderNo("pay" + randId);
        payable.setChargeCode("pay" + randId);
        payable.setExchangeRate(BigDecimal.valueOf(randId));
        payable.setAmount(BigDecimal.valueOf(randId));
        payable.setCurrencyUnit("pay" + randId);
        payable.setDate(new Date());
        payable.setQuantity(randId);
        payable.setStatus(PayableStatus.INI);
        payable.setOrganizationId(Long.parseLong(randId + ""));
        payable.setCreated(new Date());
        payable.setCreatedby("pay" + randId);
        payable.setUpdated(new Date());
        payable.setUpdatedby("pay" + randId);
        payable.setActive(true);

        // 创建一实体
        payableDao.add(payable);

        Payable payable1 = payableDao.get(payable.getId());

        assertEquals(payable.getOrganizationId(), payable1.getOrganizationId());

    }

    @Test
    public void testUpdate() {
        Payable payable = new Payable();
        Integer randId = new Double(100000 * Math.random()).intValue();
        payable.setId(idGenerator.getUId());
        payable.setPartnerId(Long.parseLong(randId + ""));
        payable.setPartnerName("pay" + randId);
        payable.setDocumentNo("pay" + randId);
        payable.setOrderNo("pay" + randId);
        payable.setChargeCode("pay" + randId);
        payable.setExchangeRate(BigDecimal.valueOf(randId));
        payable.setAmount(BigDecimal.valueOf(randId));
        payable.setCurrencyUnit("pay" + randId);
        payable.setDate(new Date());
        payable.setQuantity(randId);
        payable.setStatus(PayableStatus.INI);
        payable.setOrganizationId(Long.parseLong(randId + ""));
        payable.setCreated(new Date());
        payable.setCreatedby("pay" + randId);
        payable.setUpdated(new Date());
        payable.setUpdatedby("pay" + randId);
        payable.setActive(true);

        // 创建一实体
        payableDao.add(payable);

        Integer randId2 = new Double(100000 * Math.random()).intValue();
        payable.setPartnerId(Long.parseLong(randId2 + ""));
        payable.setPartnerName("pay" + randId2);
        payable.setDocumentNo("pay" + randId2);
        payable.setOrderNo("pay" + randId2);
        payable.setChargeCode("pay" + randId2);
        payable.setExchangeRate(BigDecimal.valueOf(randId2));
        payable.setAmount(BigDecimal.valueOf(randId2));
        payable.setCurrencyUnit("pay" + randId2);
        payable.setDate(new Date());
        payable.setQuantity(randId2);
        payable.setStatus(PayableStatus.INI);
        payable.setOrganizationId(Long.parseLong(randId2 + ""));
        payable.setCreated(new Date());
        payable.setCreatedby("pay" + randId2);
        payable.setUpdated(new Date());
        payable.setUpdatedby("pay" + randId2);
        payable.setActive(true);

        // 创建一实体
        payableDao.update(payable);

        Payable payable2 = payableDao.get(payable.getId());

        assertEquals(payable.getOrganizationId(), payable2.getOrganizationId());
    }

    @Test
    public void testTombstoned() {
        Payable payable = new Payable();
        Integer randId = new Double(100000 * Math.random()).intValue();
        payable.setId(idGenerator.getUId());
        payable.setPartnerId(Long.parseLong(randId + ""));
        payable.setPartnerName("pay" + randId);
        payable.setDocumentNo("pay" + randId);
        payable.setOrderNo("pay" + randId);
        payable.setChargeCode("pay" + randId);
        payable.setExchangeRate(BigDecimal.valueOf(randId));
        payable.setAmount(BigDecimal.valueOf(randId));
        payable.setCurrencyUnit("pay" + randId);
        payable.setDate(new Date());
        payable.setQuantity(randId);
        payable.setStatus(PayableStatus.INI);
        payable.setOrganizationId(Long.parseLong(randId + ""));
        payable.setCreated(new Date());
        payable.setCreatedby("pay" + randId);
        payable.setUpdated(new Date());
        payable.setUpdatedby("pay" + randId);
        payable.setActive(true);

        // 创建一实体
        payableDao.add(payable);

        payableDao.tombstoned(payable.getId());

        Payable payable2 = payableDao.get(payable.getId());

        assertNull(payable2);
    }

    @Test
    public void testGet() {
        Payable payable = new Payable();
        Integer randId = new Double(100000 * Math.random()).intValue();
        payable.setId(idGenerator.getUId());
        payable.setPartnerId(Long.parseLong(randId + ""));
        payable.setPartnerName("pay" + randId);
        payable.setDocumentNo("pay" + randId);
        payable.setOrderNo("pay" + randId);
        payable.setChargeCode("pay" + randId);
        payable.setExchangeRate(BigDecimal.valueOf(randId));
        payable.setAmount(BigDecimal.valueOf(randId));
        payable.setCurrencyUnit("pay" + randId);
        payable.setDate(new Date());
        payable.setQuantity(randId);
        payable.setStatus(PayableStatus.INI);
        payable.setOrganizationId(Long.parseLong(randId + ""));
        payable.setCreated(new Date());
        payable.setCreatedby("pay" + randId);
        payable.setUpdated(new Date());
        payable.setUpdatedby("pay" + randId);
        payable.setActive(true);

        // 创建一实体
        payableDao.add(payable);

        Payable payable2 = payableDao.get(payable.getId());

        assertEquals(payable.getCreatedby(), payable2.getCreatedby());
    }

}
