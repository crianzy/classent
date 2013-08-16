package com.czy.myclass.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.czy.myclass.dao.NewsDao;
import com.czy.myclass.dao.NewsTypeDao;
import com.czy.myclass.domain.News;
import com.czy.myclass.domain.NewsType;
import com.czy.myclass.dto.NewsFormDto;
import com.czy.myclass.dto.PageBean;
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
		//推荐新闻 硬编码
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


	@Override
	public void addMenu(String menuName) {
		NewsType newsType  = new NewsType();
		newsType.setName(menuName);
		newsTypeDao.save(newsType);
	}


	@Override
	public void delMenu(Long menuId) {
		newsTypeDao.delete(menuId);
	}


	@Override
	public void delMenu(String menuIds) {
		String[] ids = menuIds.split(",");
		for (String idstr : ids) {
			Long id = Long.parseLong(idstr);
			newsTypeDao.delete(id);
		}
	}


	@Override
	public void updateMenu(Long menuId, String menuName) {
		NewsType newsType = newsTypeDao.getById(menuId);
		newsType.setName(menuName);
		newsTypeDao.updata(newsType);
	}


	@Override
	public void saveNews(NewsFormDto newsDto) {
		NewsType newsType = newsTypeDao.getById(newsDto.getNewsTypeId());
		News news = null;
		if(newsDto.getId()==null){
			news = new News();
		}else{
			news = newsDao.getById(newsDto.getId());
		}
		news.setAuthor(newsDto.getAuthor());
		news.setContent(newsDto.getContent());
		news.setImg(newsDto.getImg());
		news.setSource(newsDto.getSource());
		news.setTitle(newsDto.getTitle());
		news.setNewsType(newsType);
		news.setPubTime(new Date());
		if(news.getId()!=null){
			newsDao.updata(news);
		}else{
			newsDao.save(news);
		}
		newsTypeDao.updata(newsType);
	}


	@Override
	public PageBean getnewsPageBean(int currentPage) {
		return newsDao.getPageBean(currentPage);
	}


	@Override
	public PageBean getPageBeanSearch(int currentPage, Long menuId, String key) {
		return newsDao.getPageBeanSearch(currentPage,menuId,key);
	}


	@Override
	public void delNews(Long newsId) {
		newsDao.delete(newsId);
	}


	@Override
	public void delNews(String newsIds) {
		String[] ids = newsIds.split(",");
		for (String idstr : ids) {
			Long id = Long.parseLong(idstr);
			newsDao.delete(id);
		}
	}


	@Override
	public void chanegNewsStatus(Long newsId, int status) {
		News news = newsDao.getById(newsId);
		news.setStatus(status);
		newsDao.updata(news);
	}


	@Override
	public List<News> getTouTiaoNews() {
		
		return newsDao.getTouTiaoNews(8);
	}


	@Override
	public News getBigPicNews() {
		return newsDao.getBigPicNews();
	}
	
	
	
}
