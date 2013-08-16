package com.czy.meclass.install;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.czy.myclass.domain.User;

@Controller
public class Installer {

	@Resource
	private SessionFactory sessionFactory;
	
	@Transactional
	public void install() {
		Session session = sessionFactory.getCurrentSession();
		// 超级管理员
		User user = new User();
		user.setUsername("admin");
		user.setPassword("admin");
		user.setAuthorite("ROLE_SUPERVISOR");
		session.save(user);
		
	}
	public static void main(String[] args) {
		System.out.println("正在执行安装...");

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Installer installer = (Installer) ac.getBean("installer");
		installer.install();

		System.out.println("== 安装完毕 ==");
	}
}
