package com.czy.myclass.dao;

import java.util.List;

public interface BaseDao<T> {

	/**
	 * 保存
	 * 
	 * @param entity
	 */
	public void save(T entity);

	/**
	 * 根据id删除
	 * 
	 * @param id
	 */
	public void delete(Long id);

	/**
	 * 更新
	 * 
	 * @param entity
	 */
	public void updata(T entity);

	/**
	 * 根据id 获取entity
	 * 
	 * @param id
	 * @return
	 */
	public T getById(Long id);

	/**
	 * 更具 id 数组 获取 entity list
	 * 
	 * @param ids
	 * @return
	 */
	public List<T> getByIds(Long[] ids);

	/**
	 * 获取所有的entity
	 * 
	 * @return
	 */
	public List<T> findAll();
	
	/**
	 * 获取该 entitye 的所有数目
	 * @return
	 */
	public int count();
}
