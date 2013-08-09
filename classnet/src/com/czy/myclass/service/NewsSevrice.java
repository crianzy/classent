package com.czy.myclass.service;

import java.util.List;

import com.czy.myclass.domain.News;
import com.czy.myclass.domain.NewsType;

public interface NewsSevrice extends BaseService{
	
	
	public NewsType getNewsTypeById(Long newsTypeId);
	
	public News getNewsById(Long newsId);

	/**
	 * 获取所有的新闻类型
	 * @return
	 */
	public List<NewsType> getAllNewTypeList();
	
	/**
	 * 获取最新为新闻 不分类型
	 * @return
	 */
	public List<News> getLastNews();
	
	/**
	 * 获取推荐新闻
	 * @return
	 */
	public List<News> getTuijianNews();
	
	/**
	 * 根据新闻id 读取新闻信息
	 * @param id
	 * @return
	 */
	public News readNews(Long newsId);
	
	/**
	 * 根据该 newsType id获取该类型下的所有news
	 * @param newsTypeId
	 * @return
	 */
	public List<News> getAllNews(Long newsTypeId); 
	
	/**
	 * 获取点击率最高的10条 新闻
	 * @param newsTypeId
	 * @return
	 */
	public List<News> getHotNews();
}
