package com.czy.myclass.dao;

import java.util.List;

import com.czy.myclass.domain.User;
import com.czy.myclass.dto.PageBean;

public interface UserDao extends BaseDao<User>{
	
	public User getUserByUsernamePassword(String username,String password);

	public boolean checkUsernameIsExist(String username);

	public List<User> searchByUsername(String key);

	public PageBean getPageBean(int currentPage, String key);
}
