package com.czy.myclass.service;

import java.util.List;

import com.czy.myclass.domain.Topic;
import com.czy.myclass.domain.TopicMenu;

public interface TopicService {

	public List<TopicMenu> getAllTopicMenu();

	public TopicMenu getTopicMenu(Long topicMenuId);
	
	public Topic getTopic(Long id);

	public void replay(Long id, Long topicId, String content);

	public Long postTopic(Long userId, Long topicMenuId, String title,
			String content);

	public List<Topic> getUserTopicList(Long userId, Long topicMenuId);

	public List<Topic> getLastTopicList(int i);

}
