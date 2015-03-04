package com.winit.vms.system.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.winit.vms.system.BaseTest;
import com.winit.vms.system.entity.Config;
import com.winit.vms.system.query.ConfigQuery;

/**
 * 系统配置项 Dao Test Case Change to the actual description of this class
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
@SuppressWarnings("deprecation")
public class ConfigDaoTest extends BaseTest {

    @Resource
    private ConfigDao configDao;

    private Config getByName(String name) {
        ConfigQuery.FindQuery query = new ConfigQuery.FindQuery();
        query.createCriteria().andNameEqualTo(name).andIsActiveEqualTo(true);
        List<Config> list = configDao.queryByCriteria(query);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Test
    @Rollback(true)
    public void testCrud() {
        Config config = new Config();
        Integer randId = new Double(100000 * Math.random()).intValue();

        config.setName("con" + randId);
        config.setValue("con" + randId);
        config.setDescription("con" + randId);
        config.setOrganizationId(Long.parseLong(randId + ""));
        config.setCreated(new Date());
        config.setCreatedby("con" + randId);
        config.setUpdated(new Date());
        config.setUpdatedby("con" + randId);
        config.setActive(true);

        // 创建一实体
        configDao.add(config);
        config = getByName(config.getName());
        Assert.assertNotNull(config.getId());
        logger.debug("config1:" + config.getId());
        // 获取一实体
        Config config2 = (Config) configDao.get(config.getId());
        Assert.assertNotNull(config2);
        logger.debug("config2:" + config2.toString());
        Integer randId2 = new Double(100000 * Math.random()).intValue();
        config2.setName("con" + randId2);
        config2.setValue("con" + randId2);
        config2.setDescription("con" + randId2);
        config2.setOrganizationId(Long.parseLong(randId2 + ""));
        config2.setCreated(new Date());
        config.setCreatedby("con" + randId2);
        config2.setUpdated(new Date());
        config.setUpdatedby("con" + randId2);
        config.setActive(true);
        // 更新一实体
        configDao.update(config2);

        Config config3 = configDao.get(config.getId());
        System.out.println("config3:" + config3.toString());
        // 删除一实体
        // configDao.tombstoned(config.getId());
    }

    @Test
    public void testCreate() {
        Config config = new Config();
        Integer randId = new Double(100000 * Math.random()).intValue();

        config.setName("con" + randId);
        config.setValue("con" + randId);
        config.setDescription("con" + randId);
        config.setOrganizationId(Long.parseLong(randId + ""));
        config.setCreated(new Date());
        config.setCreatedby("con" + randId);
        config.setUpdated(new Date());
        config.setUpdatedby("con" + randId);
        config.setActive(true);

        // 创建一实体
        configDao.add(config);
        config = getByName(config.getName());
        Config config1 = configDao.get(config.getId());

        assertEquals(config.getOrganizationId(), config1.getOrganizationId());

    }

    @Test
    public void testUpdate() {
        Config config = new Config();
        Integer randId = new Double(100000 * Math.random()).intValue();

        config.setName("con" + randId);
        config.setValue("con" + randId);
        config.setDescription("con" + randId);
        config.setOrganizationId(Long.parseLong(randId + ""));
        config.setCreated(new Date());
        config.setCreatedby("con" + randId);
        config.setUpdated(new Date());
        config.setUpdatedby("con" + randId);
        config.setActive(true);

        // 创建一实体
        configDao.add(config);
        config = getByName(config.getName());
        Integer randId2 = new Double(100000 * Math.random()).intValue();
        config.setName("con" + randId2);
        config.setValue("con" + randId2);
        config.setDescription("con" + randId2);
        config.setOrganizationId(Long.parseLong(randId2 + ""));
        config.setCreated(new Date());
        config.setCreatedby("con" + randId2);
        config.setUpdated(new Date());
        config.setUpdatedby("con" + randId2);
        config.setActive(true);

        // 创建一实体
        configDao.update(config);

        Config config2 = configDao.get(config.getId());

        assertEquals(config.getOrganizationId(), config2.getOrganizationId());
    }

    @Test
    public void testTombstoned() {
        Config config = new Config();
        Integer randId = new Double(100000 * Math.random()).intValue();

        config.setName("con" + randId);
        config.setValue("con" + randId);
        config.setDescription("con" + randId);
        config.setOrganizationId(Long.parseLong(randId + ""));
        config.setCreated(new Date());
        config.setCreatedby("con" + randId);
        config.setUpdated(new Date());
        config.setUpdatedby("con" + randId);
        config.setActive(true);

        // 创建一实体
        configDao.add(config);
        config = getByName(config.getName());
        configDao.tombstoned(config.getId());

        Config config2 = configDao.get(config.getId());

        assertNull(config2);
    }

    @Test
    public void testGet() {
        Config config = new Config();
        Integer randId = new Double(100000 * Math.random()).intValue();

        config.setName("con" + randId);
        config.setValue("con" + randId);
        config.setDescription("con" + randId);
        config.setOrganizationId(Long.parseLong(randId + ""));
        config.setCreated(new Date());
        config.setCreatedby("con" + randId);
        config.setUpdated(new Date());
        config.setUpdatedby("con" + randId);
        config.setActive(true);

        // 创建一实体
        configDao.add(config);
        config = getByName(config.getName());
        Config config2 = configDao.get(config.getId());

        assertEquals(config.getCreatedby(), config2.getCreatedby());
    }

}
