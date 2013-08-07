package com.czy.myclass.dao;

import com.czy.myclass.domain.User;

public interface UserDao extends BaseDao<User>{
	
	public User getUserByUsernamePassword(String username,String password);

	public boolean checkUsernameIsExist(String username);
}
