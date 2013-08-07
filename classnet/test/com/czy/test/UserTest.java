package com.czy.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.czy.myclass.dao.UserDao;
import com.czy.myclass.domain.User;
import com.czy.myclass.service.UserService;

public class UserTest {
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

	@Test
	public void userSave() {
		UserDao userDao = (UserDao) ac.getBean("userDaoImpl");
		User user = new User();
		user.setUsername("chen");
		user.setPassword("1234");
		userDao.save(user);
		
	}
	
	@Test
	public void getUserByUsernamePassword() {
		UserDao userDao = (UserDao) ac.getBean("userDaoImpl");
		User user = userDao.getUserByUsernamePassword("chen", "1234");
		System.out.println(user);
	}
	
	@Test
	public void checkUsernameIsExist() {
		UserDao userDao = (UserDao) ac.getBean("userDaoImpl");
		System.out.print(userDao.checkUsernameIsExist("chendd"));
	}
	
	@Test
	public void regist() {
		UserService userService = (UserService) ac.getBean("userServiceImpl");
		User user = new User();
		user.setUsername("asdasd");
		user.setPassword("asdasd");
		userService.regist(user);
	}
}
