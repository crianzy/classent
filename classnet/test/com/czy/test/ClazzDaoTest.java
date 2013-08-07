package com.czy.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.czy.myclass.dao.ClazzDao;
import com.czy.myclass.dao.ClazzMenuDao;
import com.czy.myclass.domain.ClazzMenu;

public class ClazzDaoTest {

	ApplicationContext ac = new ClassPathXmlApplicationContext(
			"applicationContext.xml");

	@Test
	public void testDate() {
		ClazzMenuDao clazzMenuDao = (ClazzMenuDao) ac
				.getBean("clazzMenuDaoImpl");
		ClazzMenu clazzMenu1 = new ClazzMenu();
		ClazzMenu clazzMenu2 = new ClazzMenu();
		ClazzMenu clazzMenu3 = new ClazzMenu();
		ClazzMenu clazzMenu4 = new ClazzMenu();
		ClazzMenu clazzMenu5 = new ClazzMenu();
		ClazzMenu clazzMenu6 = new ClazzMenu();
		ClazzMenu clazzMenu7 = new ClazzMenu();
		ClazzMenu clazzMenu8 = new ClazzMenu();
		ClazzMenu clazzMenu9 = new ClazzMenu();

		clazzMenu1.setName("java");
		clazzMenu2.setName("java 语法");
		clazzMenu3.setName("java 面向对象");
		clazzMenu1.getChildrenClassMenu().add(clazzMenu2);
		clazzMenu1.getChildrenClassMenu().add(clazzMenu3);

		clazzMenu4.setName("C++");
		clazzMenu5.setName("C++ 语法");
		clazzMenu6.setName("C++ 面向对象");
		clazzMenu4.getChildrenClassMenu().add(clazzMenu5);
		clazzMenu4.getChildrenClassMenu().add(clazzMenu6);

		clazzMenu7.setName("PHP");
		clazzMenu8.setName("PHP 语法");
		clazzMenu9.setName("PHP 进阶");
		clazzMenu7.getChildrenClassMenu().add(clazzMenu8);
		clazzMenu7.getChildrenClassMenu().add(clazzMenu9);

		clazzMenuDao.save(clazzMenu2);
		clazzMenuDao.save(clazzMenu3);
		clazzMenuDao.save(clazzMenu1);
		clazzMenuDao.save(clazzMenu5);
		clazzMenuDao.save(clazzMenu6);
		clazzMenuDao.save(clazzMenu4);
		clazzMenuDao.save(clazzMenu8);
		clazzMenuDao.save(clazzMenu9);
		clazzMenuDao.save(clazzMenu7);

	}

	@Test
	public void searchTest() {
		ClazzDao clazzDao = (ClazzDao) ac.getBean("clazzDaoImpl");
		clazzDao.search(null, null, new Long(2), "");
	}
}
