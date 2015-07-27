package com.raise.core.manager;

import com.raise.core.dao.BaseDao;
import com.raise.core.entity.BaseEntity;

/**
 * Manager 基础类
 * @author longsheng.wang
 *
 * @param <E>
 * @param <D>
 */
public abstract class BaseManager<E extends BaseEntity, D extends BaseDao<E>> {
	
	/**
	 * 获取对应的DAO实现
	 * @return
	 */
	protected abstract D getDao();

	/**
	 * 根据ID，查询对象
	 * 
	 * @param id
	 * @return
	 */
	public E get(String id) {
		return getDao().get(id);
	}

	/**
	 * 保存对象到数据库
	 * 
	 * @param entity
	 */
	public void save(E entity) {
		getDao().add(entity);
	}

	/**
	 * 根据ID，从数据库中删除对象
	 * 
	 * @param id
	 */
	public void delete(String id) {
		getDao().delete(id);
	}

	/**
	 * 更新对象到数据库
	 * 
	 * @param entity
	 * @return
	 */
	public int update(E entity) {
		return getDao().update(entity);
	}
	
	/**
	 * 设置记录状态“失活”
	 * @param id
	 */
	public void disable(String id){
		getDao().disable(id);
	}
	
	/**
	 * 设置记录状态“激活”
	 * @param id
	 */
	public void enable(String id){
		getDao().enable(id);
	}
}
