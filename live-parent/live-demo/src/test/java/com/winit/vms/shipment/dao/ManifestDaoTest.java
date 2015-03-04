package com.winit.vms.shipment.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.winit.vms.shipment.entity.Manifest;
import com.winit.vms.shipment.entity.ManifestStatus;
import com.winit.vms.shipment.query.ManifestQuery;
import com.winit.vms.system.BaseTest;

/**
 * 运输发货单 Dao Test Case Change to the actual description of this class
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

public class ManifestDaoTest extends BaseTest {

    @Resource
    private ManifestDao manifestDao;

    public Manifest getByManifestNo(String manifestNo) {
        ManifestQuery.FindQuery query = new ManifestQuery.FindQuery();
        query.createCriteria().andManifestNoEqualTo(manifestNo).andIsActiveEqualTo(true);
        List<Manifest> list = manifestDao.queryByCriteria(query);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Test
    public void testCreate() {
        Manifest manifest = new Manifest();
        Integer randId = new Double(100000 * Math.random()).intValue();
        manifest.setManifestNo("man" + randId);
        manifest.setManifestNo("man" + randId);
        manifest.setVenderManifestNo("man" + randId);
        manifest.setPath("man" + randId);
        manifest.setOrganizationId(Long.parseLong(randId + ""));
        manifest.setCreated(new Date());
        manifest.setCreatedby("man" + randId);
        manifest.setUpdated(new Date());
        manifest.setUpdatedby("man" + randId);
        manifest.setActive(true);
        manifest.setStatus(ManifestStatus.INI);
        // 创建一实体
        manifestDao.add(manifest);
        manifest = getByManifestNo(manifest.getManifestNo());
        Manifest manifest1 = manifestDao.get(manifest.getId());

        assertEquals(manifest.getOrganizationId(), manifest1.getOrganizationId());

    }

    @Test
    public void testUpdate() {
        Manifest manifest = new Manifest();
        Integer randId = new Double(100000 * Math.random()).intValue();
        manifest.setManifestNo("man" + randId);
        manifest.setManifestNo("man" + randId);
        manifest.setVenderManifestNo("man" + randId);
        manifest.setPath("man" + randId);
        manifest.setOrganizationId(Long.parseLong(randId + ""));
        manifest.setCreated(new Date());
        manifest.setCreatedby("man" + randId);
        manifest.setUpdated(new Date());
        manifest.setUpdatedby("man" + randId);
        manifest.setActive(true);
        manifest.setStatus(ManifestStatus.INI);

        // 创建一实体
        manifestDao.add(manifest);
        manifest = getByManifestNo(manifest.getManifestNo());
        Integer randId2 = new Double(100000 * Math.random()).intValue();
        manifest.setManifestNo("man" + randId2);
        manifest.setManifestNo("man" + randId2);
        manifest.setVenderManifestNo("man" + randId2);
        manifest.setPath("man" + randId2);
        manifest.setOrganizationId(Long.parseLong(randId2 + ""));
        manifest.setCreated(new Date());
        manifest.setCreatedby("man" + randId2);
        manifest.setUpdated(new Date());
        manifest.setUpdatedby("man" + randId2);
        manifest.setActive(true);
        manifest.setStatus(ManifestStatus.INI);

        // 创建一实体
        manifestDao.update(manifest);

        Manifest manifest2 = manifestDao.get(manifest.getId());

        assertEquals(manifest.getOrganizationId(), manifest2.getOrganizationId());
    }

    @Test
    public void testTombstoned() {
        Manifest manifest = new Manifest();
        Integer randId = new Double(100000 * Math.random()).intValue();
        manifest.setManifestNo("man" + randId);
        manifest.setManifestNo("man" + randId);
        manifest.setVenderManifestNo("man" + randId);
        manifest.setPath("man" + randId);
        manifest.setOrganizationId(Long.parseLong(randId + ""));
        manifest.setCreated(new Date());
        manifest.setCreatedby("man" + randId);
        manifest.setUpdated(new Date());
        manifest.setUpdatedby("man" + randId);
        manifest.setActive(true);
        manifest.setStatus(ManifestStatus.INI);

        // 创建一实体
        manifestDao.add(manifest);
        manifest = getByManifestNo(manifest.getManifestNo());
        manifestDao.tombstoned(manifest.getId());

        Manifest manifest2 = manifestDao.get(manifest.getId());

        assertNull(manifest2);
    }

    @Test
    public void testGet() {
        Manifest manifest = new Manifest();
        Integer randId = new Double(100000 * Math.random()).intValue();
        manifest.setManifestNo("man" + randId);
        manifest.setManifestNo("man" + randId);
        manifest.setVenderManifestNo("man" + randId);
        manifest.setPath("man" + randId);
        manifest.setOrganizationId(Long.parseLong(randId + ""));
        manifest.setCreated(new Date());
        manifest.setCreatedby("man" + randId);
        manifest.setUpdated(new Date());
        manifest.setUpdatedby("man" + randId);
        manifest.setActive(true);
        manifest.setStatus(ManifestStatus.INI);

        // 创建一实体
        manifestDao.add(manifest);
        manifest = getByManifestNo(manifest.getManifestNo());
        Manifest manifest2 = manifestDao.get(manifest.getId());

        assertEquals(manifest.getCreatedby(), manifest2.getCreatedby());
    }

}
