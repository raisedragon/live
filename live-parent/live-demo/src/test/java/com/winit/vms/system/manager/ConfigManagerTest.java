package com.winit.vms.system.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.winit.vms.system.BaseTest;
import com.winit.vms.system.entity.Config;

/**
 * 系统配置项 Manager Test Case Change to the actual description of this class
 * 
 * @version Revision History
 * 
 * <pre>
 * Author     			Version       Date			Changes
 * longsheng.wang    	1.0       2015-01-10 20:21:56			Created
 * 
 * </pre>
 * @since 1.
 */

public class ConfigManagerTest extends BaseTest {

    @Resource
    ConfigManager configManager;

    @Test
    public void testCreate() {
        Config config = new Config();
        Integer randId = new Double(100000 * Math.random()).intValue();

        config.setName("con" + randId);
        config.setOrganizationId(Long.parseLong(randId + ""));
        config.setCreated(new Date());
        config.setCreatedby("con" + randId);
        config.setUpdated(new Date());
        config.setUpdatedby("con" + randId);
        config.setActive(true);

        // 创建一实体
        configManager.add(config);
        config = configManager.getByName(config.getName());
        Config config1 = configManager.get(config.getId());

        assertEquals(config.getOrganizationId(), config1.getOrganizationId());

    }

    @Test
    public void testUpdate() {
        Config config = new Config();
        Integer randId = new Double(100000 * Math.random()).intValue();

        config.setName("con" + randId);
        config.setOrganizationId(Long.parseLong(randId + ""));
        config.setCreated(new Date());
        config.setCreatedby("con" + randId);
        config.setUpdated(new Date());
        config.setUpdatedby("con" + randId);
        config.setActive(true);

        // 创建一实体
        configManager.add(config);
        config = configManager.getByName(config.getName());
        Integer randId2 = new Double(100000 * Math.random()).intValue();
        config.setName("con" + randId2);
        config.setOrganizationId(Long.parseLong(randId2 + ""));
        config.setCreated(new Date());
        config.setCreatedby("con" + randId2);
        config.setUpdated(new Date());
        config.setUpdatedby("con" + randId2);
        config.setActive(true);

        // 创建一实体
        configManager.update(config);

        Config config2 = configManager.get(config.getId());

        assertEquals(config.getOrganizationId(), config2.getOrganizationId());
    }

    @Test
    public void testTombstoned() {
        Config config = new Config();
        Integer randId = new Double(100000 * Math.random()).intValue();

        config.setName("con" + randId);
        config.setOrganizationId(Long.parseLong(randId + ""));
        config.setCreated(new Date());
        config.setCreatedby("con" + randId);
        config.setUpdated(new Date());
        config.setUpdatedby("con" + randId);
        config.setActive(true);

        // 创建一实体
        configManager.add(config);
        config = configManager.getByName(config.getName());
        configManager.tombstoned(config.getId());

        Config config2 = configManager.get(config.getId());

        assertNull(config2);
    }

    @Test
    public void testGet() {
        Config config = new Config();
        Integer randId = new Double(100000 * Math.random()).intValue();

        config.setName("con" + randId);
        config.setOrganizationId(Long.parseLong(randId + ""));
        config.setCreated(new Date());
        config.setCreatedby("con" + randId);
        config.setUpdated(new Date());
        config.setUpdatedby("con" + randId);
        config.setActive(true);

        // 创建一实体
        configManager.add(config);
        config = configManager.getByName(config.getName());
        Config config2 = configManager.get(config.getId());

        assertEquals(config.getCreatedby(), config2.getCreatedby());
    }

}
