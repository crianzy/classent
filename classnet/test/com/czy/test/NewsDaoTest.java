package com.czy.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.czy.myclass.dao.NewsDao;
import com.czy.myclass.dao.NewsTypeDao;
import com.czy.myclass.domain.News;
import com.czy.myclass.domain.NewsType;
import com.czy.myclass.service.NewsSevrice;

public class NewsDaoTest {
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

	@Test
	public void insertData(){
		NewsDao newsDao = (NewsDao)ac.getBean("newsDaoImpl");
		NewsTypeDao newsTypeDao = (NewsTypeDao) ac.getBean("newsTypeDaoImpl");
		//-----------------------
		NewsType newType1 = newsTypeDao.getById((long) 1);
		
		//---------------------------
		News news1 = new News();
		News news2 = new News();
		News news3 = new News();
		News news4 = new News();
		News news5 = new News();
		news1.setTitle("news1b");
		news2.setTitle("news2b");
		news3.setTitle("news3b");
		news4.setTitle("news4b");
		news5.setTitle("news5b");
		newType1.getAllnews().add(news1);
		newType1.getAllnews().add(news2);
		newType1.getAllnews().add(news3);
		newType1.getAllnews().add(news4);
		newType1.getAllnews().add(news5);
		
		//---------------------------
		newsDao.save(news1);
		newsDao.save(news2);
		newsDao.save(news3);
		newsDao.save(news4);
		newsDao.save(news5);
		newsTypeDao.updata(newType1);
		
	}
	
	
	@Test
	public void getLastNews() {
		NewsDao newsDao = (NewsDao) ac.getBean("newsDaoImpl");
		List<News> newsList = newsDao.getLastNews(8); 
		for (News news : newsList) {
			System.out.println(news.getTitle());
		}
	}
	
	@Test
	public void getTuijianNews() {
		NewsDao newsDao = (NewsDao) ac.getBean("newsDaoImpl");
		List<News> newsList = newsDao.getTuijianNews(8); 
		for (News news : newsList) {
			System.out.println(news.getTitle());
		}
	}
	
	@Test
	public void findAll() {
		NewsTypeDao newsTypeDao = (NewsTypeDao) ac.getBean("newsTypeDaoImpl");
		List<NewsType> newsTypes = newsTypeDao.findAll();
		for (NewsType newsType : newsTypes) {
			for (News news : newsType.getAllnews()) {
				System.out.println(news.getTitle());
			}
			System.out.println();
		}
	}
	@Test
	public void getAllNewTypeList() {
		NewsSevrice newsSerice = (NewsSevrice) ac.getBean("newsServiceImpl");
		List<NewsType> newsTypeList = newsSerice.getAllNewTypeList();
		for (NewsType newsType : newsTypeList) {
			for (News news : newsType.getLastNews()) {
				System.out.println(news.getTitle());
			}
			System.out.println();
		}
	}
}
