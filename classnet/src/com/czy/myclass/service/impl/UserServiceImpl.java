package com.czy.myclass.service.impl;

import org.springframework.stereotype.Service;

import com.czy.myclass.domain.User;
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
		if(userDao.checkUsernameIsExist(username)){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public User regist(User model) {
		userDao.save(model);
		return userDao.getById(model.getId());
	}

}
