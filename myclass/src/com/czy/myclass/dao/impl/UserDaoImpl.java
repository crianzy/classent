package com.czy.myclass.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.czy.myclass.cfg.Configuration;
import com.czy.myclass.dao.UserDao;
import com.czy.myclass.domain.User;
import com.czy.myclass.dto.PageBean;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	/**
	 * 登陆  返回user 失败 返回 null
	 */
	@Override
	public User getUserByUsernamePassword(String username, String password) {
		Session session = getSession();
		User user = null;
		user = (User) session
				.createQuery(
						"FROM User u WHERE u.username = ? AND u.password = ?")//
				.setParameter(0, username)//
				.setParameter(1, password)//
				.uniqueResult();
		return user;
	}

	/**
	 * 检查 该用户名是否存在
	 */
	@Override
	public boolean checkUsernameIsExist(String username) {
		Session session = getSession();
		String name = (String) session
				.createQuery(
						"SELECT u.username FROM User u WHERE u.username = ?")//
				.setParameter(0, username)//
				.uniqueResult();
		return name != null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> searchByUsername(String key) {
		List<User> userLsit = getSession().createQuery(
				"FROM User u WHERE u.username LIKE '%" + key + "%' ")//
				.list();
		return userLsit;
	}

	/**
	 * 获取user 的分页信息，可添加username 的搜索信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageBean getPageBean(int currentPage, String key) {
		int pageSize = Configuration.getPageSize();
		if(key==null||"".equals(key)){
			List<User> list = getSession().createQuery(
					"FROM User")//
					.setFirstResult((currentPage-1)*pageSize)//
					.setMaxResults(pageSize)//
					.list();
			Long recordCount = (Long) getSession().createQuery(//
					"SELECT COUNT(*)  FROM User")//
					.uniqueResult();
			return new PageBean(currentPage, list, recordCount.intValue(), pageSize);
		}else{
			List<User> list = getSession().createQuery(
					"FROM User u  WHERE u.username LIKE '%" + key + "%' ")//
					.setFirstResult((currentPage-1)*pageSize)//
					.setMaxResults(pageSize)//
					.list();
			Long recordCount = (Long) getSession().createQuery(//
					"SELECT COUNT(*)  FROM User u  WHERE u.username LIKE '%" + key + "%' ")//
					.uniqueResult();
			return new PageBean(currentPage, list, recordCount.intValue(), pageSize);
		}
	}

}
