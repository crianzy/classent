package com.czy.myclass.dao;

import java.util.List;

import com.czy.myclass.domain.Topic;

public interface TopicDao extends BaseDao<Topic> {

	List<Topic> getLastTopicList(int n);


}
