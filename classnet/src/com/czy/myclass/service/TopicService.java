package com.czy.myclass.service;

import java.util.List;

import com.czy.myclass.domain.Topic;
import com.czy.myclass.domain.TopicMenu;
import com.czy.myclass.dto.PageBean;

public interface TopicService extends BaseService{

	public List<TopicMenu> getAllTopicMenu();

	public TopicMenu getTopicMenu(Long topicMenuId);
	
	public Topic getTopic(Long id);

	public void replay(Long id, Long topicId, String content);

	public Long postTopic(Long userId, Long topicMenuId, String title,
			String content);

	public List<Topic> getUserTopicList(Long userId, Long topicMenuId);

	public List<Topic> getLastTopicList(int i);
	
	public PageBean getTopicPageBean(int currentPage,Long topicMenuId);
	
	public PageBean getAnswerPageBean(int currentPage,Long topicId);

	public void delMenu(Long menuId);

	public void delMenu(String ids);

	public void addMenu(String menuName);

	public void updata(Long menuId, String menuName);

	public PageBean getTopciPageBean(int currentPage, Long menuId, String key);

	public void delTopic(Long topicId);

	public void delTopic(String ids);

	public void pingbiAnswer(Long topicAnswerId);
	

}
