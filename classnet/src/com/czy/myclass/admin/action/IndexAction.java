package com.czy.myclass.admin.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myclass.dao.ClazzDao;
import com.czy.myclass.dao.NewsDao;
import com.czy.myclass.dao.SourceDao;
import com.czy.myclass.dao.TopicDao;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class IndexAction extends BaseAdminAction {

	private static final long serialVersionUID = -7367908610507127870L;
	private String m = "index";

	@Resource
	protected ClazzDao clazzDao;
	@Resource
	protected NewsDao newsDao;
	@Resource
	protected SourceDao sourceDao;
	@Resource
	protected TopicDao topicDao;

	@Override
	public String execute() throws Exception {
		int newsCount = newsDao.count();
		ActionContext.getContext().put("newsCount", newsCount);
		int clazzCount = clazzDao.count();
		ActionContext.getContext().put("clazzCount", clazzCount);
		int sourceCount = sourceDao.count();
		ActionContext.getContext().put("sourceCount", sourceCount);
		int topicCount = topicDao.count();
		ActionContext.getContext().put("topicCount", topicCount);
		return super.execute();
	}

	public String getM() {
		return m;
	}

	public void setM(String m) {
		this.m = m;
	}

}
