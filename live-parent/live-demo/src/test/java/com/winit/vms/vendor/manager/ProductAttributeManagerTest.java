package com.winit.vms.vendor.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.winit.vms.system.BaseTest;
import com.winit.vms.vendor.entity.ProductAttribute;

/**
 * 供应商产品属性 Manager Test Case Change to the actual description of this class
 * 
 * @version Revision History
 * 
 * <pre>
 * Author     			Version       Date			Changes
 * longsheng.wang    	1.0       2015-01-10 11:36:56			Created
 * 
 * </pre>
 * @since 1.
 */

public class ProductAttributeManagerTest extends BaseTest {

    @Resource
    ProductAttributeManager productAttributeManager;

    @Test
    public void testCreate() {
        ProductAttribute productAttribute = new ProductAttribute();
        Integer randId = new Double(100000 * Math.random()).intValue();

        productAttribute.setProductCode("pro" + randId);
        productAttribute.setButtJoinLabel(true);
        productAttribute.setButtJoinManifest(true);
        productAttribute.setButtJoinPreadvice(true);
        productAttribute.setButtJoinTracking(true);
        productAttribute.setLabelFileExtensioin("pro" + randId);
        productAttribute.setManifestFileExtensioin("pro" + randId);
        productAttribute.setOpenFtpTrackFetch(true);
        productAttribute.setOpenApiTrackFetch(true);
        productAttribute.setOpenWebTrackFetch(true);
        productAttribute.setOrganizationId(Long.parseLong(randId + ""));
        productAttribute.setCreated(new Date());
        productAttribute.setCreatedby("pro" + randId);
        productAttribute.setUpdated(new Date());
        productAttribute.setUpdatedby("pro" + randId);
        productAttribute.setActive(true);

        // 创建一实体
        productAttributeManager.add(productAttribute);

        ProductAttribute productAttribute1 = productAttributeManager.get(productAttribute.getId());

        assertEquals(productAttribute.getOrganizationId(), productAttribute1.getOrganizationId());

    }

    @Test
    public void testUpdate() {
        ProductAttribute productAttribute = new ProductAttribute();
        Integer randId = new Double(100000 * Math.random()).intValue();

        productAttribute.setProductCode("pro" + randId);
        productAttribute.setButtJoinLabel(true);
        productAttribute.setButtJoinManifest(true);
        productAttribute.setButtJoinPreadvice(true);
        productAttribute.setButtJoinTracking(true);
        productAttribute.setLabelFileExtensioin("pro" + randId);
        productAttribute.setManifestFileExtensioin("pro" + randId);
        productAttribute.setOpenFtpTrackFetch(true);
        productAttribute.setOpenApiTrackFetch(true);
        productAttribute.setOpenWebTrackFetch(true);
        productAttribute.setOrganizationId(Long.parseLong(randId + ""));
        productAttribute.setCreated(new Date());
        productAttribute.setCreatedby("pro" + randId);
        productAttribute.setUpdated(new Date());
        productAttribute.setUpdatedby("pro" + randId);
        productAttribute.setActive(true);

        // 创建一实体
        productAttributeManager.add(productAttribute);

        Integer randId2 = new Double(100000 * Math.random()).intValue();
        productAttribute.setProductCode("pro" + randId2);
        productAttribute.setButtJoinLabel(true);
        productAttribute.setButtJoinManifest(true);
        productAttribute.setButtJoinPreadvice(true);
        productAttribute.setButtJoinTracking(true);
        productAttribute.setLabelFileExtensioin("pro" + randId2);
        productAttribute.setManifestFileExtensioin("pro" + randId2);
        productAttribute.setOpenFtpTrackFetch(true);
        productAttribute.setOpenApiTrackFetch(true);
        productAttribute.setOpenWebTrackFetch(true);
        productAttribute.setOrganizationId(Long.parseLong(randId2 + ""));
        productAttribute.setCreated(new Date());
        productAttribute.setCreatedby("pro" + randId2);
        productAttribute.setUpdated(new Date());
        productAttribute.setUpdatedby("pro" + randId2);
        productAttribute.setActive(true);

        // 创建一实体
        productAttributeManager.update(productAttribute);

        ProductAttribute productAttribute2 = productAttributeManager.get(productAttribute.getId());

        assertEquals(productAttribute.getOrganizationId(), productAttribute2.getOrganizationId());
    }

    @Test
    public void testTombstoned() {
        ProductAttribute productAttribute = new ProductAttribute();
        Integer randId = new Double(100000 * Math.random()).intValue();

        productAttribute.setProductCode("pro" + randId);
        productAttribute.setButtJoinLabel(true);
        productAttribute.setButtJoinManifest(true);
        productAttribute.setButtJoinPreadvice(true);
        productAttribute.setButtJoinTracking(true);
        productAttribute.setLabelFileExtensioin("pro" + randId);
        productAttribute.setManifestFileExtensioin("pro" + randId);
        productAttribute.setOpenFtpTrackFetch(true);
        productAttribute.setOpenApiTrackFetch(true);
        productAttribute.setOpenWebTrackFetch(true);
        productAttribute.setOrganizationId(Long.parseLong(randId + ""));
        productAttribute.setCreated(new Date());
        productAttribute.setCreatedby("pro" + randId);
        productAttribute.setUpdated(new Date());
        productAttribute.setUpdatedby("pro" + randId);
        productAttribute.setActive(true);

        // 创建一实体
        productAttributeManager.add(productAttribute);

        productAttributeManager.tombstoned(productAttribute.getId());

        ProductAttribute productAttribute2 = productAttributeManager.get(productAttribute.getId());

        assertNull(productAttribute2);
    }

    @Test
    public void testGet() {
        ProductAttribute productAttribute = new ProductAttribute();
        Integer randId = new Double(100000 * Math.random()).intValue();

        productAttribute.setProductCode("pro" + randId);
        productAttribute.setButtJoinLabel(true);
        productAttribute.setButtJoinManifest(true);
        productAttribute.setButtJoinPreadvice(true);
        productAttribute.setButtJoinTracking(true);
        productAttribute.setLabelFileExtensioin("pro" + randId);
        productAttribute.setManifestFileExtensioin("pro" + randId);
        productAttribute.setOpenFtpTrackFetch(true);
        productAttribute.setOpenApiTrackFetch(true);
        productAttribute.setOpenWebTrackFetch(true);
        productAttribute.setOrganizationId(Long.parseLong(randId + ""));
        productAttribute.setCreated(new Date());
        productAttribute.setCreatedby("pro" + randId);
        productAttribute.setUpdated(new Date());
        productAttribute.setUpdatedby("pro" + randId);
        productAttribute.setActive(true);

        // 创建一实体
        productAttributeManager.add(productAttribute);

        ProductAttribute productAttribute2 = productAttributeManager.get(productAttribute.getId());

        assertEquals(productAttribute.getCreatedby(), productAttribute2.getCreatedby());
    }

}
