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

	/**
	 * 获取最新的新闻
	 */
	@Override
	public List<News> getLastNews(int n) {
		List<News> newsList = getSession()
				.createQuery("FROM News news ORDER By news.pubTime DESC")//
				.setMaxResults(n)//
				.list();
		return newsList;
	}

	/**
	 * 获取推荐新闻
	 */
	@Override
	public List<News> getTuijianNews(int n) {
		List<News> newsList = getSession()
				.createQuery(
						"FROM News news WHERE news.status = 2 ORDER By news.pubTime DESC")//
				.setMaxResults(n)//
				.list();
		return newsList;
	}

	/**
	 * 获取最火的新闻，及点击率最高的新闻
	 */
	@Override
	public List<News> getHotNews(int n) {
		List<News> newsList = getSession()
				.createQuery("FROM News news ORDER By news.viewNum DESC")//
				.setMaxResults(n)//
				.list();
		return newsList;
	}

	/**
	 * 获取分页信息，没有分类情况 后台用。
	 */
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

	/**
	 * 更具分类情况获取分页信息
	 */
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

	/**
	 * 获取分页头条新闻
	 */
	@Override
	public List<News> getTouTiaoNews(int n) {
		List<News> newsList = getSession()
				.createQuery(
						"FROM News news WHERE news.status = 3 ORDER By news.pubTime DESC")//
				.setMaxResults(n)//
				.list();
		return newsList;
	}

	/**
	 * 获取大图头条新闻
	 */
	@Override
	public News getBigPicNews() {
		News news = (News) getSession().createQuery("FROM News news WHERE news.status = 4 AND news.img != null ORDER By news.pubTime DESC")//
				.setMaxResults(1).uniqueResult();
		return news;
	}

}
