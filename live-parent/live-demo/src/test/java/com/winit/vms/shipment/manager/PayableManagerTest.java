package com.winit.vms.shipment.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.winit.vms.shipment.entity.Payable;
import com.winit.vms.shipment.entity.PayableStatus;
import com.winit.vms.system.BaseTest;

/**
 * 应付费用 Manager Test Case Change to the actual description of this class
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
public class PayableManagerTest extends BaseTest {

    @Resource
    PayableManager payableManager;

    @Test
    public void testCreate() {
        Payable payable = new Payable();
        Integer randId = new Double(100000 * Math.random()).intValue();
        payable.setId(idGenerator.getUId());
        payable.setPartnerId(Long.parseLong(randId + ""));
        payable.setDocumentNo("pay" + randId);
        payable.setOrderNo("pay" + randId);
        payable.setChargeCode("pay" + randId);
        payable.setAmount(BigDecimal.valueOf(randId));
        payable.setCurrencyUnit("pay" + randId);
        payable.setDate(new Date());
        payable.setOrganizationId(Long.parseLong(randId + ""));
        payable.setCreated(new Date());
        payable.setCreatedby("pay" + randId);
        payable.setUpdated(new Date());
        payable.setUpdatedby("pay" + randId);
        payable.setActive(true);
        payable.setStatus(PayableStatus.INI);

        // 创建一实体
        payableManager.add(payable);

        Payable payable1 = payableManager.get(payable.getId());

        assertEquals(payable.getOrganizationId(), payable1.getOrganizationId());

    }

    @Test
    public void testUpdate() {
        Payable payable = new Payable();
        Integer randId = new Double(100000 * Math.random()).intValue();
        payable.setId(idGenerator.getUId());
        payable.setPartnerId(Long.parseLong(randId + ""));
        payable.setDocumentNo("pay" + randId);
        payable.setOrderNo("pay" + randId);
        payable.setChargeCode("pay" + randId);
        payable.setAmount(BigDecimal.valueOf(randId));
        payable.setCurrencyUnit("pay" + randId);
        payable.setDate(new Date());
        payable.setOrganizationId(Long.parseLong(randId + ""));
        payable.setCreated(new Date());
        payable.setCreatedby("pay" + randId);
        payable.setUpdated(new Date());
        payable.setUpdatedby("pay" + randId);
        payable.setActive(true);
        payable.setStatus(PayableStatus.INI);

        // 创建一实体
        payableManager.add(payable);

        Integer randId2 = new Double(100000 * Math.random()).intValue();
        payable.setPartnerId(Long.parseLong(randId2 + ""));
        payable.setDocumentNo("pay" + randId2);
        payable.setOrderNo("pay" + randId2);
        payable.setChargeCode("pay" + randId2);
        payable.setAmount(BigDecimal.valueOf(randId2));
        payable.setCurrencyUnit("pay" + randId2);
        payable.setDate(new Date());
        payable.setOrganizationId(Long.parseLong(randId2 + ""));
        payable.setCreated(new Date());
        payable.setCreatedby("pay" + randId2);
        payable.setUpdated(new Date());
        payable.setUpdatedby("pay" + randId2);
        payable.setActive(true);
        payable.setStatus(PayableStatus.INI);

        // 创建一实体
        payableManager.update(payable);

        Payable payable2 = payableManager.get(payable.getId());

        assertEquals(payable.getOrganizationId(), payable2.getOrganizationId());
    }

    @Test
    public void testTombstoned() {
        Payable payable = new Payable();
        Integer randId = new Double(100000 * Math.random()).intValue();
        payable.setId(idGenerator.getUId());
        payable.setPartnerId(Long.parseLong(randId + ""));
        payable.setDocumentNo("pay" + randId);
        payable.setOrderNo("pay" + randId);
        payable.setChargeCode("pay" + randId);
        payable.setAmount(BigDecimal.valueOf(randId));
        payable.setCurrencyUnit("pay" + randId);
        payable.setDate(new Date());
        payable.setOrganizationId(Long.parseLong(randId + ""));
        payable.setCreated(new Date());
        payable.setCreatedby("pay" + randId);
        payable.setUpdated(new Date());
        payable.setUpdatedby("pay" + randId);
        payable.setActive(true);
        payable.setStatus(PayableStatus.INI);
        // 创建一实体
        payableManager.add(payable);

        payableManager.tombstoned(payable.getId());

        Payable payable2 = payableManager.get(payable.getId());

        assertNull(payable2);
    }

    @Test
    public void testGet() {
        Payable payable = new Payable();
        Integer randId = new Double(100000 * Math.random()).intValue();
        payable.setId(idGenerator.getUId());
        payable.setPartnerId(Long.parseLong(randId + ""));
        payable.setDocumentNo("pay" + randId);
        payable.setOrderNo("pay" + randId);
        payable.setChargeCode("pay" + randId);
        payable.setAmount(BigDecimal.valueOf(randId));
        payable.setCurrencyUnit("pay" + randId);
        payable.setDate(new Date());
        payable.setOrganizationId(Long.parseLong(randId + ""));
        payable.setCreated(new Date());
        payable.setCreatedby("pay" + randId);
        payable.setUpdated(new Date());
        payable.setUpdatedby("pay" + randId);
        payable.setActive(true);
        payable.setStatus(PayableStatus.INI);
        // 创建一实体
        payableManager.add(payable);

        Payable payable2 = payableManager.get(payable.getId());

        assertEquals(payable.getCreatedby(), payable2.getCreatedby());
    }

}
