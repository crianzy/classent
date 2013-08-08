package com.czy.myclass.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.czy.myclass.dao.TopicAnswerDao;
import com.czy.myclass.dao.TopicDao;
import com.czy.myclass.dao.TopicMenuDao;
import com.czy.myclass.dao.UserDao;
import com.czy.myclass.domain.Topic;
import com.czy.myclass.domain.TopicAnswer;
import com.czy.myclass.domain.TopicMenu;
import com.czy.myclass.domain.User;
import com.czy.myclass.dto.PageBean;
import com.czy.myclass.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

	@Resource
	private TopicDao topicDao;
	@Resource
	private TopicMenuDao topicMenuDao;
	@Resource
	private TopicAnswerDao topicAnswerDao;
	@Resource
	private UserDao userDao;

	@Override
	public List<TopicMenu> getAllTopicMenu() {
		List<TopicMenu> topicMenuList = topicMenuDao.findAll();
		return topicMenuList;
	}

	@Override
	public TopicMenu getTopicMenu(Long topicMenuId) {
		TopicMenu topicMenu = topicMenuDao.getById(topicMenuId);
		return topicMenu;
	}

	@Override
	public Topic getTopic(Long id) {
		Topic topic =  topicDao.getById(id);
		return topic;
	}

	@Override
	public void replay(Long userId, Long topicId, String content) {
		Date date = new Date();
		User user = userDao.getById(userId);
		Topic topic = topicDao.getById(topicId);
		int flowNum = topic.getReplyNum()+2;
		TopicAnswer answer = new TopicAnswer();
		answer.setContent(content);
		answer.setPubTime(date);
		answer.setUser(user);
		answer.setFlowNum(flowNum);
		topicAnswerDao.save(answer);
		//更新 topic
		topic.getAnswers().add(answer);
		topic.setEditUsername(user.getUsername());
		topic.setReplyNum(topic.getReplyNum()+1);
		topic.setEditTime(date);
		topicDao.updata(topic);
	}

	@Override
	public Long postTopic(Long userId, Long topicMenuId, String title,
			String content) {
		Date date = new Date();
		User user = userDao.getById(userId);
		TopicMenu topicMenu = topicMenuDao.getById(topicMenuId);
		Topic topic = new Topic();
		topic.setPubTime(date);
		topic.setEditTime(date);
		topic.setUser(user);
		topic.setEditUsername(user.getUsername());
		topic.setTopicMenu(topicMenu);
		topic.setTitle(title);
		topic.setDetail(content);
		topicDao.save(topic);
		return topic.getId();
	}

	@Override
	public List<Topic> getUserTopicList(Long userId, Long topicMenuId) {
		User user = userDao.getById(userId);
		List<Topic> topicList = new ArrayList<Topic>();
		if(topicMenuId==null || topicMenuId == 0){
			topicList = new ArrayList<Topic>(user.getTopics());
		}else{
			for (Topic topic : user.getTopics()) {
				if(topic.getTopicMenu().getId() == topicMenuId){
					topicList.add(topic);
				}
			}
		}
		return topicList;
	}

	@Override
	public List<Topic> getLastTopicList(int n) {
		List<Topic> topicList =  topicDao.getLastTopicList(n);
		return topicList;
	}

	@Override
	public PageBean getTopicPageBean(int currentPage, Long topicMenuID) {
		PageBean pageBean =  topicDao.getPage(currentPage, topicMenuID);
		return pageBean;
	}

	@Override
	public PageBean getAnswerPageBean(int currentPage, Long topicId) {
		PageBean pageBean =  topicAnswerDao.getPage(currentPage, topicId);
		return pageBean;
	}


}
