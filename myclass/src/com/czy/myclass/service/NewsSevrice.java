package com.czy.myclass.service;

import java.util.List;

import com.czy.myclass.domain.News;
import com.czy.myclass.domain.NewsType;
import com.czy.myclass.dto.NewsFormDto;
import com.czy.myclass.dto.PageBean;

public interface NewsSevrice extends BaseService {

	/** 根据 newsTypeId 获取 NewsType */
	public NewsType getNewsTypeById(Long newsTypeId);

	/** 根据 newsId 获取 newsId */
	public News getNewsById(Long newsId);

	/**
	 * 获取所有的新闻类型
	 * 
	 * @return
	 */
	public List<NewsType> getAllNewTypeList();

	/**
	 * 获取最新为新闻 不分类型
	 * 
	 * @return
	 */
	public List<News> getLastNews();

	/**
	 * 获取推荐新闻
	 * 
	 * @return
	 */
	public List<News> getTuijianNews();

	/**
	 * 根据新闻id 读取新闻信息
	 * 
	 * @param id
	 * @return
	 */
	public News readNews(Long newsId);

	/**
	 * 根据该 newsType id获取该类型下的所有news
	 * 
	 * @param newsTypeId
	 * @return
	 */
	public List<News> getAllNews(Long newsTypeId);

	/**
	 * 获取点击率最高的10条 新闻
	 * 
	 * @param newsTypeId
	 * @return
	 */
	public List<News> getHotNews();

	/**
	 * 获取头条新闻
	 * 
	 * @return
	 */
	public List<News> getTouTiaoNews();

	/**
	 * 获取首页大图新闻
	 * 
	 * @return
	 */
	public News getBigPicNews();

	/**
	 * 添加 新闻类型
	 * 
	 * @param menuName
	 */
	public void addMenu(String menuName);

	/**
	 * 删除新闻类型 一个
	 * 
	 * @param menuId
	 */
	public void delMenu(Long menuId);

	/**
	 * 删除新闻类型 多个
	 * 
	 * @param menuIds
	 */
	public void delMenu(String menuIds);

	/**
	 * 更新新闻类型 name
	 * 
	 * @param menuId
	 * @param menuName
	 */
	public void updateMenu(Long menuId, String menuName);

	/**
	 * 保存新闻
	 * 
	 * @param newsDto
	 */
	public void saveNews(NewsFormDto newsDto);

	/**
	 * 获取新闻 分页信息， 不带其他信息
	 * 
	 * @param currentPage
	 * @return
	 */
	public PageBean getnewsPageBean(int currentPage);

	/**
	 * 获取分页信息 带有搜索 类型 信息
	 * 
	 * @param currentPage
	 * @param menuId
	 * @param key
	 * @return
	 */
	public PageBean getPageBeanSearch(int currentPage, Long menuId, String key);

	/**
	 * 删除 新闻 1个
	 * 
	 * @param newsId
	 */
	public void delNews(Long newsId);

	/**
	 * 删除新闻 多个
	 * 
	 * @param newsIds
	 */
	public void delNews(String newsIds);

	/**
	 * 改变 新闻 状态 是否是头条 推荐 等。
	 * 
	 * @param newsId
	 * @param status
	 */
	public void chanegNewsStatus(Long newsId, int status);

}
