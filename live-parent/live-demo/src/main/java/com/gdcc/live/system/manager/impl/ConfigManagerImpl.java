package com.gdcc.live.system.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdcc.live.core.dao.Dao;
import com.gdcc.live.core.manager.AbstractManager;
import com.gdcc.live.system.dao.ConfigDao;
import com.gdcc.live.system.entity.Config;
import com.gdcc.live.system.manager.ConfigManager;
import com.gdcc.live.system.query.ConfigQuery;
import com.gdcc.live.system.query.ConfigQuery.FindQuery;

public class ConfigManagerImpl extends AbstractManager<Config,String> implements ConfigManager {

    @Resource
    ConfigDao configDao;

    @Override
    protected Dao<Config, String> getDao() {
        return configDao;
    }

    @Override
    public List<Config> queryByCriteria(ConfigQuery.FindQuery query) {
        return configDao.queryByCriteria(query);
    }

    @Override
    public long queryCountByCriteria(ConfigQuery.FindQuery query) {
        return configDao.queryCountByCriteria(query);
    }

    @Override
    public void updateByUpdateQuery(ConfigQuery.UpdateQuery uQuery) {
        configDao.updateByUpdateQuery(uQuery);
    }

    @Override
    public String getValue(String name) {
        String value = null;

        FindQuery query = new FindQuery();
        query.createCriteria().andNameEqualTo(name);
        List<Config> config = configDao.queryByCriteria(query);
        if (config.size() > 0) {
            value = config.get(0).getValue();
        }

        return value;
    }

    @Override
    public void setValue(String name, String value) {
        FindQuery query = new FindQuery();
        query.createCriteria().andNameEqualTo(name);
        List<Config> configs = configDao.queryByCriteria(query);
        if (configs.size() > 0) {
            Config config = configs.get(0);
            config.setValue(value);
            configDao.update(config);
        }
    }

    public Config getByName(String name) {
        ConfigQuery.FindQuery query = new ConfigQuery.FindQuery();
        query.createCriteria().andNameEqualTo(name).andIsActiveEqualTo(true);
        List<Config> list = configDao.queryByCriteria(query);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }


}
