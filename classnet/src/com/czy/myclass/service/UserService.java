package com.czy.myclass.service;

import java.util.List;

import com.czy.myclass.domain.User;
import com.czy.myclass.dto.PageBean;

public interface UserService extends BaseService{

	/**
	 * 检查验证更新
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public User checkLong(String username, String password);

	/**
	 * 检查该用户名是否可用
	 * @param username
	 * @return
	 */
	public boolean checkUsernameEnable(String username);

	/**
	 * 注册
	 * @param username
	 * @return
	 */
	public User regist(User model);

	public List<User> getAllUserList();

	public List<User> search(String key);

	public PageBean getPageBean(int currentPage, String key);

	public void chageUserStatus(Long id, boolean enable);
}
