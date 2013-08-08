package com.czy.myclass.dao;

import com.czy.myclass.domain.TopicAnswer;
import com.czy.myclass.dto.PageBean;

public interface TopicAnswerDao extends BaseDao<TopicAnswer>{

	public PageBean getPage(int currentPage, Long topicMenuId);
}
