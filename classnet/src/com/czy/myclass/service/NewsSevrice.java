package com.czy.myclass.service;

import java.util.List;

import com.czy.myclass.domain.News;
import com.czy.myclass.domain.NewsType;
import com.czy.myclass.dto.NewsFormDto;
import com.czy.myclass.dto.PageBean;

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

	public void addMenu(String menuName);

	public void delMenu(Long menuId);

	public void delMenu(String menuIds);

	public void updateMenu(Long menuId, String menuName);

	public void saveNews(NewsFormDto newsDto);

	public PageBean getnewsPageBean(int currentPage);

	public PageBean getPageBeanSearch(int currentPage, Long menuId, String key);

	public void delNews(Long newsId);

	public void delNews(String newsIds);

	public void chanegNewsStatus(Long newsId, int status);
	
	public List<News> getTouTiaoNews();

	public News getBigPicNews();
}
