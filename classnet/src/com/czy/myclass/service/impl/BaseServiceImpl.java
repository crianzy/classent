package com.czy.myclass.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.czy.myclass.dao.ClazzDao;
import com.czy.myclass.dao.ClazzMenuDao;
import com.czy.myclass.dao.ClazzTypeDao;
import com.czy.myclass.dao.NewsDao;
import com.czy.myclass.dao.NewsTypeDao;
import com.czy.myclass.dao.SourceDao;
import com.czy.myclass.dao.SourceMenuDao;
import com.czy.myclass.dao.TopicAnswerDao;
import com.czy.myclass.dao.TopicDao;
import com.czy.myclass.dao.TopicMenuDao;
import com.czy.myclass.dao.UserDao;
import com.czy.myclass.domain.TopicMenu;
import com.czy.myclass.service.BaseService;

@Service
public class BaseServiceImpl implements BaseService{

	@Resource
	protected ClazzDao clazzDao;

	@Resource
	protected ClazzMenuDao clazzMenuDao;

	@Resource
	protected ClazzTypeDao clazzTypeDao;

	@Resource
	protected NewsDao newsDao;

	@Resource
	protected NewsTypeDao newsTypeDao;

	@Resource
	protected SourceDao sourceDao;

	@Resource
	protected SourceMenuDao sourceMenuDao;

	@Resource
	protected TopicDao topicDao;

	@Resource
	protected TopicMenuDao topicMenuDao;

	@Resource
	protected TopicAnswerDao topicAnswerDao;

	@Resource
	protected UserDao userDao;

}
