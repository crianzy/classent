package com.czy.myclass.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.czy.myclass.dao.UserDao;
import com.czy.myclass.domain.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

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

	@Override
	public boolean checkUsernameIsExist(String username) {
		Session session = getSession();
		String name = (String) session
				.createQuery(
						"SELECT u.username FROM User u WHERE u.username = ?")//
				.setParameter(0, username)//
				.uniqueResult();
		//System.out.print(name);
		return name != null ? true : false;
	}

}
