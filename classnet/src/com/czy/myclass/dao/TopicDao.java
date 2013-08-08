package com.czy.myclass.dao;

import java.util.List;

import com.czy.myclass.domain.Topic;
import com.czy.myclass.dto.PageBean;

public interface TopicDao extends BaseDao<Topic> {

	List<Topic> getLastTopicList(int n);

	PageBean getPage(int currentPage, Long parentId);


}
