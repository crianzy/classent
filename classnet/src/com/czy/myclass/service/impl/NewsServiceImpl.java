package com.czy.myclass.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.czy.myclass.dao.NewsDao;
import com.czy.myclass.dao.NewsTypeDao;
import com.czy.myclass.domain.News;
import com.czy.myclass.domain.NewsType;
import com.czy.myclass.service.NewsSevrice;

@Service
public class NewsServiceImpl implements NewsSevrice{

	@Resource
	private NewsDao newsDao;
	@Resource
	private NewsTypeDao newsTypeDao;
	
	
	@Override
	public List<NewsType> getAllNewTypeList() {
		List<NewsType> newsTypeList = new ArrayList<NewsType>(newsTypeDao.findAll());
		for (NewsType newsType : newsTypeList) {
			int i = 0;
			for(Iterator<News> it = newsType.getAllnews().iterator() ;i<9 && it.hasNext();i++){
				newsType.getLastNews().add(it.next());
			}
			newsType.getAllnews().clear();
		}
		return newsTypeList;
	}


	@Override
	public List<News> getLastNews() {
		List<News> newsList = null;
		newsList = newsDao.getLastNews(6);
		return newsList;
	}


	@Override
	public List<News> getTuijianNews() {
		List<News> newsList = null;
		newsList = newsDao.getTuijianNews(8);
		return newsList;
	}


	@Override
	public News readNews(Long newsId) {
		News news = newsDao.getById(newsId);
		news.setViewNum(news.getViewNum()+1);
		newsDao.updata(news);
		return news;
	}


	@Override
	public List<News> getAllNews(Long newsTypeId) {
		List<News> newsList = null;
		newsList = newsTypeDao.getAllNews(newsTypeId);
		return newsList;
	}


	@Override
	public List<News> getHotNews() {
		List<News> newsList = null;
		newsList = newsDao.getHotNews(10);
		return newsList;
	}


	@Override
	public NewsType getNewsTypeById(Long newsTypeId) {
		NewsType newsType = newsTypeDao.getById(newsTypeId);
		return newsType;
	}


	@Override
	public News getNewsById(Long newsId) {
		News news = newsDao.getById(newsId);
		news.setViewNum(news.getViewNum()+1);
		return news;
	}
	
	
	
}
