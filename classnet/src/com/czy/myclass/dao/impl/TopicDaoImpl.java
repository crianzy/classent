package com.czy.myclass.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.czy.myclass.dao.TopicDao;
import com.czy.myclass.domain.Topic;

@Repository
public class TopicDaoImpl extends BaseDaoImpl<Topic> implements TopicDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<Topic> getLastTopicList(int n) {
		List<Topic> topicList = getSession()
				.createQuery("FROM Topic topic ORDER By topic.pubTime DESC")//
				.setMaxResults(n)//
				.list();
		return topicList;
	}

}
