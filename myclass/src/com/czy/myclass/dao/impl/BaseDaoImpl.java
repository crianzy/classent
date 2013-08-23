package com.czy.myclass.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.czy.myclass.dao.BaseDao;

@Transactional
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {

	protected Class<T> clazz;

	@Resource
	private SessionFactory sessionFactory;

	public BaseDaoImpl() {
		// 反射获取 T 的具体类型
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
	}

	@Override
	public int count() {
		Long count = (Long) getSession().createQuery(//
				"SELECT COUNT(*) FROM " + this.clazz.getSimpleName() + " ")//
				.uniqueResult();
		return count.intValue();
	}

	@Override
	public void delete(Long id) {
		Session session = getSession();
		Object obj = session.get(clazz, id);
		session.delete(obj);
	}

	@Override
	public List<T> findAll() {
		List<T> entityList = getSession().createQuery(
				"FROM " + clazz.getSimpleName())//
				.list();
		return entityList;
	}

	@Override
	public T getById(Long id) {
		if (id == null) {
			return null;
		}
		return (T) getSession().get(clazz, id);
	}

	@Override
	public List<T> getByIds(Long[] ids) {
		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
		}
		List<T> entityList = getSession()
				.createQuery(
						"FROM " + clazz.getSimpleName() + " WHERE id IN(:ids)")//
				.setParameterList("ids", ids)//
				.list();
		return entityList;
	}

	/**
	 * 获取当前 session
	 * 
	 * @return
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T entity) {
		Session session = getSession();
		session.save(entity);
	}

	@Override
	public void updata(T entity) {
		Session session = getSession();
		session.update(entity);
	}

}
