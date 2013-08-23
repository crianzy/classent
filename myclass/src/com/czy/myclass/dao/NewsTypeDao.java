package com.czy.myclass.dao;

import java.util.List;

import com.czy.myclass.domain.News;
import com.czy.myclass.domain.NewsType;

public interface NewsTypeDao extends BaseDao<NewsType>{

	List<News> getAllNews(Long newsTypeId);

}
