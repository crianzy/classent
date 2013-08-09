package com.czy.myclass.admin.action;

import javax.annotation.Resource;

import com.czy.myclass.service.ClazzService;
import com.czy.myclass.service.NewsSevrice;
import com.czy.myclass.service.SourceService;
import com.czy.myclass.service.TopicService;
import com.czy.myclass.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAdminAction extends ActionSupport{

	private static final long serialVersionUID = -7151604657432616184L;

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
