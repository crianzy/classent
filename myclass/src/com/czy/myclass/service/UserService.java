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

	/**
	 * 获取所有的 user
	 * @return
	 */
	public List<User> getAllUserList();

	public List<User> search(String key);
	
	/**
	 * 获取user 的分页 带有 搜索信息
	 * @param currentPage
	 * @param key
	 * @return
	 */
	public PageBean getPageBean(int currentPage, String key);

	/**
	 * 改变用户状态 是否可用
	 * @param id
	 * @param enable
	 */
	public void chageUserStatus(Long id, boolean enable);
}
