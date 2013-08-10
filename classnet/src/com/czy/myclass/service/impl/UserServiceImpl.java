package com.czy.myclass.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.czy.myclass.domain.User;
import com.czy.myclass.dto.PageBean;
import com.czy.myclass.service.UserService;

@Service
class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Override
	public User checkLong(String username, String password) {
		User user = null;
		user = userDao.getUserByUsernamePassword(username, password);
		return user;
	}

	@Override
	public boolean checkUsernameEnable(String username) {
		if (userDao.checkUsernameIsExist(username)) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public User regist(User model) {
		userDao.save(model);
		return userDao.getById(model.getId());
	}

	@Override
	public List<User> getAllUserList() {
		return userDao.findAll();
	}

	@Override
	public List<User> search(String key) {
		return userDao.searchByUsername(key);
	}

	@Override
	public PageBean getPageBean(int currentPage, String key) {
		return userDao.getPageBean(currentPage, key);
	}

	@Override
	public void chageUserStatus(Long id, boolean enable) {
		User user = userDao.getById(id);
		user.setEnable(enable);
		userDao.updata(user);
	}

}
