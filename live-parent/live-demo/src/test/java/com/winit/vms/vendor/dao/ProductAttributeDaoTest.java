package com.winit.vms.vendor.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.winit.vms.system.BaseTest;
import com.winit.vms.vendor.entity.ProductAttribute;

/**
 * 供应商产品属性 Dao Test Case Change to the actual description of this class
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
public class ProductAttributeDaoTest extends BaseTest {

    @Resource
    private ProductAttributeDao productAttributeDao;

    @Test
    @Rollback(true)
    public void testCrud() {
        ProductAttribute productAttribute = new ProductAttribute();
        Integer randId = new Double(100000 * Math.random()).intValue();

        productAttribute.setProductCode("pro" + randId);
        productAttribute.setButtJoinLabel(true);
        productAttribute.setButtJoinManifest(true);
        productAttribute.setButtJoinPreadvice(true);
        productAttribute.setButtJoinTracking(true);
        productAttribute.setLabelFileExtensioin("pro" + randId);
        productAttribute.setManifestFileExtensioin("pro" + randId);
        productAttribute.setLabelImplClass("pro" + randId);
        productAttribute.setManifestImplClass("pro" + randId);
        productAttribute.setPreadviceImplClass("pro" + randId);
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
        productAttributeDao.add(productAttribute);
        Assert.assertNotNull(productAttribute.getId());
        logger.debug("productAttribute1:" + productAttribute.getId());
        // 获取一实体
        ProductAttribute productAttribute2 = (ProductAttribute) productAttributeDao.get(productAttribute.getId());
        Assert.assertNotNull(productAttribute2);
        logger.debug("productAttribute2:" + productAttribute2.toString());
        Integer randId2 = new Double(100000 * Math.random()).intValue();
        productAttribute2.setProductCode("pro" + randId2);
        productAttribute.setButtJoinLabel(true);
        productAttribute.setButtJoinManifest(true);
        productAttribute.setButtJoinPreadvice(true);
        productAttribute.setButtJoinTracking(true);
        productAttribute2.setLabelFileExtensioin("pro" + randId2);
        productAttribute2.setManifestFileExtensioin("pro" + randId2);
        productAttribute2.setLabelImplClass("pro" + randId2);
        productAttribute2.setManifestImplClass("pro" + randId2);
        productAttribute2.setPreadviceImplClass("pro" + randId2);
        productAttribute.setOpenFtpTrackFetch(true);
        productAttribute.setOpenApiTrackFetch(true);
        productAttribute.setOpenWebTrackFetch(true);
        productAttribute2.setOrganizationId(Long.parseLong(randId2 + ""));
        productAttribute2.setCreated(new Date());
        productAttribute.setCreatedby("pro" + randId2);
        productAttribute2.setUpdated(new Date());
        productAttribute.setUpdatedby("pro" + randId2);
        productAttribute.setActive(true);
        // 更新一实体
        productAttributeDao.update(productAttribute2);

        ProductAttribute productAttribute3 = productAttributeDao.get(productAttribute.getId());
        System.out.println("productAttribute3:" + productAttribute3.toString());
        // 删除一实体
        // productAttributeDao.tombstoned(productAttribute.getId());
    }

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
        productAttribute.setLabelImplClass("pro" + randId);
        productAttribute.setManifestImplClass("pro" + randId);
        productAttribute.setPreadviceImplClass("pro" + randId);
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
        productAttributeDao.add(productAttribute);

        ProductAttribute productAttribute1 = productAttributeDao.get(productAttribute.getId());

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
        productAttribute.setLabelImplClass("pro" + randId);
        productAttribute.setManifestImplClass("pro" + randId);
        productAttribute.setPreadviceImplClass("pro" + randId);
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
        productAttributeDao.add(productAttribute);

        Integer randId2 = new Double(100000 * Math.random()).intValue();
        productAttribute.setProductCode("pro" + randId2);
        productAttribute.setButtJoinLabel(true);
        productAttribute.setButtJoinManifest(true);
        productAttribute.setButtJoinPreadvice(true);
        productAttribute.setButtJoinTracking(true);
        productAttribute.setLabelFileExtensioin("pro" + randId2);
        productAttribute.setManifestFileExtensioin("pro" + randId2);
        productAttribute.setLabelImplClass("pro" + randId2);
        productAttribute.setManifestImplClass("pro" + randId2);
        productAttribute.setPreadviceImplClass("pro" + randId2);
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
        productAttributeDao.update(productAttribute);

        ProductAttribute productAttribute2 = productAttributeDao.get(productAttribute.getId());

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
        productAttribute.setLabelImplClass("pro" + randId);
        productAttribute.setManifestImplClass("pro" + randId);
        productAttribute.setPreadviceImplClass("pro" + randId);
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
        productAttributeDao.add(productAttribute);

        productAttributeDao.tombstoned(productAttribute.getId());

        ProductAttribute productAttribute2 = productAttributeDao.get(productAttribute.getId());

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
        productAttribute.setLabelImplClass("pro" + randId);
        productAttribute.setManifestImplClass("pro" + randId);
        productAttribute.setPreadviceImplClass("pro" + randId);
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
        productAttributeDao.add(productAttribute);

        ProductAttribute productAttribute2 = productAttributeDao.get(productAttribute.getId());

        assertEquals(productAttribute.getCreatedby(), productAttribute2.getCreatedby());
    }

    /**
     * 查询派送方式属性列表.
     * 
     * @param map
     * @return
     */
    @Test
    public void queryProductCodeByMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<String> list = new ArrayList<String>();
        list.add("K01");
        list.add("K02");
        map.put("use", 3);
        map.put("prdCodeList", list);
        List<String> prdList = productAttributeDao.queryProductCodeByMap(map);
        System.out.println(prdList.size());
    }

}
