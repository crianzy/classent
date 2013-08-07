package com.czy.myclass.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.czy.myclass.dao.NewsDao;
import com.czy.myclass.domain.News;

@Repository
@SuppressWarnings("unchecked")
public class NewsDaoImpl extends BaseDaoImpl<News> implements NewsDao {

	@Override
	public List<News> getLastNews(int n) {
		List<News> newsList = getSession().createQuery("FROM News news ORDER By news.pubTime DESC")//
			.setMaxResults(n)//
			.list();
		return newsList;
	}

	@Override
	public List<News> getTuijianNews(int n) {
		List<News> newsList = getSession().createQuery("FROM News news WHERE news.status = 2 ORDER By news.pubTime DESC")//
				.setMaxResults(n)//
				.list();
		return newsList;
	}

	@Override
	public List<News> getHotNews(int n) {
		List<News> newsList = getSession().createQuery("FROM News news ORDER By news.viewNum DESC")//
				.setMaxResults(n)//
				.list();
		return newsList;
	}

}
