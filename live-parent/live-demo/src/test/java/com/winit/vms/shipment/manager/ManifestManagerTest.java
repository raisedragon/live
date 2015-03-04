package com.winit.vms.shipment.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.winit.vms.shipment.entity.Manifest;
import com.winit.vms.shipment.entity.ManifestStatus;
import com.winit.vms.system.BaseTest;

/**
 * 运输发货单 Manager Test Case Change to the actual description of this class
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

public class ManifestManagerTest extends BaseTest {

    @Resource
    ManifestManager manifestManager;

    @Test
    public void testCreate() {
        Manifest manifest = new Manifest();
        Integer randId = new Double(100000 * Math.random()).intValue();

        manifest.setManifestNo("man" + randId);
        manifest.setOrganizationId(Long.parseLong(randId + ""));
        manifest.setCreated(new Date());
        manifest.setCreatedby("man" + randId);
        manifest.setUpdated(new Date());
        manifest.setUpdatedby("man" + randId);
        manifest.setActive(true);
        manifest.setStatus(ManifestStatus.INI);

        // 创建一实体
        manifestManager.add(manifest);
        manifest = manifestManager.getByManifestNo(manifest.getManifestNo());
        Manifest manifest1 = manifestManager.get(manifest.getId());

        assertEquals(manifest.getOrganizationId(), manifest1.getOrganizationId());

    }

    @Test
    public void testUpdate() {
        Manifest manifest = new Manifest();
        Integer randId = new Double(100000 * Math.random()).intValue();

        manifest.setManifestNo("man" + randId);
        manifest.setOrganizationId(Long.parseLong(randId + ""));
        manifest.setCreated(new Date());
        manifest.setCreatedby("man" + randId);
        manifest.setUpdated(new Date());
        manifest.setUpdatedby("man" + randId);
        manifest.setActive(true);
        manifest.setStatus(ManifestStatus.INI);
        // 创建一实体
        manifestManager.add(manifest);
        manifest = manifestManager.getByManifestNo(manifest.getManifestNo());
        Integer randId2 = new Double(100000 * Math.random()).intValue();
        manifest.setManifestNo("man" + randId2);
        manifest.setOrganizationId(Long.parseLong(randId2 + ""));
        manifest.setCreated(new Date());
        manifest.setCreatedby("man" + randId2);
        manifest.setUpdated(new Date());
        manifest.setUpdatedby("man" + randId2);
        manifest.setActive(true);
        manifest.setStatus(ManifestStatus.INI);
        // 创建一实体
        manifestManager.update(manifest);

        Manifest manifest2 = manifestManager.get(manifest.getId());

        assertEquals(manifest.getOrganizationId(), manifest2.getOrganizationId());
    }

    @Test
    public void testTombstoned() {
        Manifest manifest = new Manifest();
        Integer randId = new Double(100000 * Math.random()).intValue();

        manifest.setManifestNo("man" + randId);
        manifest.setOrganizationId(Long.parseLong(randId + ""));
        manifest.setCreated(new Date());
        manifest.setCreatedby("man" + randId);
        manifest.setUpdated(new Date());
        manifest.setUpdatedby("man" + randId);
        manifest.setActive(true);
        manifest.setStatus(ManifestStatus.INI);
        // 创建一实体
        manifestManager.add(manifest);
        manifest = manifestManager.getByManifestNo(manifest.getManifestNo());
        manifestManager.tombstoned(manifest.getId());

        Manifest manifest2 = manifestManager.get(manifest.getId());

        assertNull(manifest2);
    }

    @Test
    public void testGet() {
        Manifest manifest = new Manifest();
        Integer randId = new Double(100000 * Math.random()).intValue();

        manifest.setManifestNo("man" + randId);
        manifest.setOrganizationId(Long.parseLong(randId + ""));
        manifest.setCreated(new Date());
        manifest.setCreatedby("man" + randId);
        manifest.setUpdated(new Date());
        manifest.setUpdatedby("man" + randId);
        manifest.setActive(true);
        manifest.setStatus(ManifestStatus.INI);
        // 创建一实体
        manifestManager.add(manifest);
        manifest = manifestManager.getByManifestNo(manifest.getManifestNo());
        Manifest manifest2 = manifestManager.get(manifest.getId());

        assertEquals(manifest.getCreatedby(), manifest2.getCreatedby());
    }

    @Test
    public void testGetByManifestNo() {
        Manifest manifest = new Manifest();
        Integer randId = new Double(100000 * Math.random()).intValue();

        manifest.setManifestNo("man" + randId);
        manifest.setOrganizationId(Long.parseLong(randId + ""));
        manifest.setCreated(new Date());
        manifest.setCreatedby("man" + randId);
        manifest.setUpdated(new Date());
        manifest.setUpdatedby("man" + randId);
        manifest.setActive(true);
        manifest.setStatus(ManifestStatus.INI);
        // 创建一实体
        manifestManager.add(manifest);

        Manifest manifest2 = manifestManager.getByManifestNo(manifest.getManifestNo());

        assertEquals(manifest.getCreatedby(), manifest2.getCreatedby());
    }

}
