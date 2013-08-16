package com.czy.myclass.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.czy.myclass.cfg.Configuration;
import com.czy.myclass.dao.NewsDao;
import com.czy.myclass.domain.News;
import com.czy.myclass.dto.PageBean;

@Repository
@SuppressWarnings("unchecked")
public class NewsDaoImpl extends BaseDaoImpl<News> implements NewsDao {

	@Override
	public List<News> getLastNews(int n) {
		List<News> newsList = getSession()
				.createQuery("FROM News news ORDER By news.pubTime DESC")//
				.setMaxResults(n)//
				.list();
		return newsList;
	}

	@Override
	public List<News> getTuijianNews(int n) {
		List<News> newsList = getSession()
				.createQuery(
						"FROM News news WHERE news.status = 2 ORDER By news.pubTime DESC")//
				.setMaxResults(n)//
				.list();
		return newsList;
	}

	@Override
	public List<News> getHotNews(int n) {
		List<News> newsList = getSession()
				.createQuery("FROM News news ORDER By news.viewNum DESC")//
				.setMaxResults(n)//
				.list();
		return newsList;
	}

	@SuppressWarnings("rawtypes")
	@Override
	@Transactional(readOnly=true)
	public PageBean getPageBean(int currentPage) {
		int pageSize = Configuration.getPageSize();
		List list = getSession().createQuery(//
				"FROM News news ORDER By news.pubTime DESC")//
				.setFirstResult((currentPage - 1) * pageSize)//
				.setMaxResults(pageSize)//
				.list();
		Long recordCount = (Long) getSession().createQuery(//
				"SELECT COUNT(*) FROM News ")//
				.uniqueResult();
		return new PageBean(currentPage, list, recordCount.intValue(), pageSize);
	}

	@SuppressWarnings("rawtypes")
	@Override
	@Transactional(readOnly=true)
	public PageBean getPageBeanSearch(int currentPage, Long menuId, String key) {
		int pageSize = Configuration.getPageSize();
		String hql = "FROM News news WHERE 1 = 1 ";
		if (menuId != null && menuId != 0) {
			hql += " AND news.newsType.id = " + menuId;
		}
		if (key != null && !"".equals(key)) {
			hql += " AND news.title LIKE '%" + key + "%' ";
		}
		List list = getSession().createQuery(//
					hql+" ORDER By news.pubTime DESC ")//
				.setFirstResult((currentPage - 1) * pageSize)//
				.setMaxResults(pageSize)//
				.list();
		Long recordCount = (Long) getSession().createQuery(//
				"SELECT COUNT(*) " + hql)//
				.uniqueResult();
		return new PageBean(currentPage, list, recordCount.intValue(), pageSize);
	}

	@Override
	public List<News> getTouTiaoNews(int n) {
		List<News> newsList = getSession()
				.createQuery(
						"FROM News news WHERE news.status = 3 ORDER By news.pubTime DESC")//
				.setMaxResults(n)//
				.list();
		return newsList;
	}

	@Override
	public News getBigPicNews() {
		News news = (News) getSession().createQuery("FROM News news WHERE news.status = 4 ORDER By news.pubTime DESC")//
				.setMaxResults(1).uniqueResult();
		return news;
	}

}
