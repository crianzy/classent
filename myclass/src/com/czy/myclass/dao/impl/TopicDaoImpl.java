package com.czy.myclass.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.czy.myclass.cfg.Configuration;
import com.czy.myclass.dao.TopicDao;
import com.czy.myclass.domain.Topic;
import com.czy.myclass.dto.PageBean;

@Repository
public class TopicDaoImpl extends BaseDaoImpl<Topic> implements TopicDao {

	/**
	 * 获取最新的 帖子
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Topic> getLastTopicList(int n) {
		List<Topic> topicList = getSession()
				.createQuery("FROM Topic topic ORDER By topic.pubTime DESC")//
				.setMaxResults(n)//
				.list();
		return topicList;
	}

	/**
	 * 根据类型获取贴子 的分页信息
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public PageBean getPage(int currentPage, Long topicMenuId) {
		int pageSize = Configuration.getPageSize();
		List list = getSession()
				.createQuery(//
						"FROM Topic t WHERE t.topicMenu.id = ? ORDER By t.pubTime DESC")//
				.setParameter(0, topicMenuId)//
				.setFirstResult((currentPage - 1) * pageSize)//
				.setMaxResults(pageSize)//
				.list();
		Long recordCount = (Long) getSession().createQuery(//
				"SELECT COUNT(*) FROM Topic t WHERE t.topicMenu.id = ?")//
				.setParameter(0, topicMenuId)//
				.uniqueResult();
		return new PageBean(currentPage, list, recordCount.intValue(), pageSize);
	}

	/**
	 * 根据搜索信息获取 分页信息
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public PageBean getPage(int currentPage, Long menuId, String key) {
		int pageSize = Configuration.getPageSize();
		String hql = " FROM Topic t WHERE 1 = 1 ";
		String where = "";
		if (menuId != null) {
			where = where + "AND t.topicMenu.id = " + menuId;
		}
		if (key != null && !"".equals(key.trim())) {
			where = where + " AND t.title LIKE '%" + key + "%' ";
		}
		List list = getSession().createQuery(hql + where).setFirstResult((currentPage - 1) * pageSize)//
				.setMaxResults(pageSize).list();
		Long recordCount = (Long) getSession().createQuery(//
				"SELECT COUNT(*) FROM Topic t WHERE 1 = 1 " + where)//
				.uniqueResult();
		return new PageBean(currentPage, list, recordCount.intValue(), pageSize);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public PageBean getPostByUser(Long userid, Long topicMenuId,int currentPage) {
		int pageSize = Configuration.getPageSize();
		String hql = " FROM Topic t ";
		String where = " WHERE t.user.id = " + userid;
		if (topicMenuId != null) {
			where = where + " AND t.topicMenu.id = " + topicMenuId;
		}
		System.out.println(hql + where);
		List list = getSession().createQuery(hql + where).setFirstResult((currentPage - 1) * pageSize)//
				.setMaxResults(pageSize).list();
		Long recordCount = (Long) getSession().createQuery(//
				"SELECT COUNT(*) FROM Topic t " + where)//
				.uniqueResult();
		return new PageBean(currentPage, list, recordCount.intValue(), pageSize);
	}

}
