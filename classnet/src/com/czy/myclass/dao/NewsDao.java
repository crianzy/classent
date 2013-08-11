package com.czy.myclass.dao;

import java.util.List;

import com.czy.myclass.domain.News;
import com.czy.myclass.dto.PageBean;


public interface NewsDao extends BaseDao<News>{

	/**
	 * 获取n条最新新闻
	 * @param n
	 * @return
	 */
	public List<News> getLastNews(int n);
	
	/**
	 * 获取n条最新的推荐新闻
	 * @param n
	 * @return
	 */
	public List<News> getTuijianNews(int n);

	public List<News> getHotNews(int n);

	public PageBean getPageBean(int currentPage);

	public PageBean getPageBeanSearch(int currentPage, Long menuId, String key);
}
