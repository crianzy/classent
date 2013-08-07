package com.czy.myclass.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.czy.myclass.dao.NewsTypeDao;
import com.czy.myclass.domain.News;
import com.czy.myclass.domain.NewsType;

@Repository
public class NewsTypeDaoImpl extends BaseDaoImpl<NewsType> implements
		NewsTypeDao {

	@Override
	public List<News> getAllNews(Long newsTypeId) {
		NewsType newsType = getById(newsTypeId);
		List<News> newList = new ArrayList<News>(newsType.getAllnews());
		return newList;
	}

}
