package com.czy.myclass.action;

import javax.annotation.Resource;

import com.czy.myclass.service.ClazzService;
import com.czy.myclass.service.NewsSevrice;
import com.czy.myclass.service.SourceService;
import com.czy.myclass.service.TopicService;
import com.czy.myclass.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport {

	private static final long serialVersionUID = -1284458664798869026L;

	@Resource
	protected UserService userService;

	@Resource
	protected NewsSevrice newsService;

	@Resource
	protected ClazzService clazzService;

	@Resource
	protected SourceService sourceService;

	@Resource
	protected TopicService topicService;

}
