package com.czy.myclass.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myclass.domain.Clazz;
import com.czy.myclass.domain.News;
import com.czy.myclass.domain.Source;
import com.czy.myclass.domain.SourceMenu;
import com.czy.myclass.domain.Topic;
import com.czy.myclass.domain.TopicMenu;
import com.czy.myclass.dto.ClazzMenuDto;
import com.czy.myclass.service.ClazzService;
import com.czy.myclass.service.NewsSevrice;
import com.czy.myclass.service.SourceService;
import com.czy.myclass.service.TopicService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class HomeAction extends ActionSupport {

	private static final long serialVersionUID = 329394280578895979L;

	@Resource
	private NewsSevrice newsSerice;
	@Resource
	private TopicService topicService;
	@Resource
	private ClazzService clazzService;
	@Resource
	private SourceService sourceService;

	@Override
	public String execute() throws Exception {
		// 推荐新闻
		List<News> tuijianNewsList = newsSerice.getTuijianNews();
		ActionContext.getContext().put("tuijianNewsList", tuijianNewsList);
		
		//课程中心 
		//课程一级菜单
		List<ClazzMenuDto> clazzMenuDtoList = clazzService.getFirstClazzMenu();
		ActionContext.getContext().put("clazzMenuDtoList", clazzMenuDtoList);
		//推荐课程
		List<Clazz> tuiJianClazzList = clazzService.getTuiJianClazz(2);
		ActionContext.getContext().put("tuiJianClazzList", tuiJianClazzList);
		//最新课程
		List<Clazz> lastClazzList = clazzService.getLastClazz();
		ActionContext.getContext().put("lastClazzList", lastClazzList);
		
		//资源下载
		// 资源菜单
		List<SourceMenu> sourceMenuList = sourceService.getAllSource();
		ActionContext.getContext().put("sourceMenuList", sourceMenuList);
		//最新资源
		List<Source> lastSourceList = sourceService.getLastSourceList(14);
		ActionContext.getContext().put("lastSourceList", lastSourceList);
		
		//互动交流
		// 所有版块
		List<TopicMenu> topicMenuList = topicService.getAllTopicMenu();
		ActionContext.getContext().put("topicMenuList", topicMenuList);
		//最新帖子
		List<Topic> lastTopicList = topicService.getLastTopicList(14);
		ActionContext.getContext().put("lastTopicList", lastTopicList);
		return super.execute();
	}

}
