package com.czy.myclass.service;

import com.czy.myclass.domain.User;

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
}
