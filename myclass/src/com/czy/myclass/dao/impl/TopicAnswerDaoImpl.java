package com.czy.myclass.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.czy.myclass.cfg.Configuration;
import com.czy.myclass.dao.TopicAnswerDao;
import com.czy.myclass.domain.TopicAnswer;
import com.czy.myclass.dto.PageBean;

@Repository
public class TopicAnswerDaoImpl extends BaseDaoImpl<TopicAnswer> implements
		TopicAnswerDao {

	/**
	 * 获取回复的分页信息
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public PageBean getPage(int currentPage, Long topicId) {
		int pageSize = Configuration.getPageSize();
		List list = getSession()
				.createQuery(//
						"FROM TopicAnswer t WHERE t.topic.id = ? ORDER By t.pubTime ASC")//
				.setParameter(0, topicId)//
				.setFirstResult((currentPage - 1) * pageSize)//
				.setMaxResults(pageSize)//
				.list();
		Long recordCount = (Long) getSession().createQuery(//
				"SELECT COUNT(*)  FROM TopicAnswer t WHERE t.topic.id = ?")//
				.setParameter(0, topicId)//
				.uniqueResult();
		return new PageBean(currentPage, list, recordCount.intValue(), pageSize);
	}

}
