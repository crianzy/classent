package com.czy.myclass.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myclass.domain.Clazz;
import com.czy.myclass.domain.News;
import com.czy.myclass.domain.Source;
import com.czy.myclass.domain.SourceMenu;
import com.czy.myclass.domain.Topic;
import com.czy.myclass.domain.TopicMenu;
import com.czy.myclass.dto.ClazzMenuDto;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class HomeAction extends BaseAction {

	private static final long serialVersionUID = 329394280578895979L;

	@Override
	public String execute() throws Exception {
		// 头条新闻
		List<News> touTiaoNewsList = newsService.getTouTiaoNews();
		ActionContext.getContext().put("touTiaoNewsList", touTiaoNewsList);
		// 首页 大图新闻
		News bigPicnews = newsService.getBigPicNews();
		ActionContext.getContext().put("bigPicnews", bigPicnews);
		
		// 课程中心
		// 课程一级菜单
		List<ClazzMenuDto> clazzMenuDtoList = clazzService.getFirstClazzMenu();
		ActionContext.getContext().put("clazzMenuDtoList", clazzMenuDtoList);
		// 推荐课程
		List<Clazz> tuiJianClazzList = clazzService.getTuiJianClazz(2);
		ActionContext.getContext().put("tuiJianClazzList", tuiJianClazzList);
		// 最新课程
		List<Clazz> lastClazzList = clazzService.getLastClazz();
		ActionContext.getContext().put("lastClazzList", lastClazzList);

		// 资源下载
		// 资源菜单
		List<SourceMenu> sourceMenuList = sourceService.getAllSourceMenu();
		ActionContext.getContext().put("sourceMenuList", sourceMenuList);
		// 最新资源
		List<Source> lastSourceList = sourceService.getLastSourceList(14);
		ActionContext.getContext().put("lastSourceList", lastSourceList);

		// 互动交流
		// 所有版块
		List<TopicMenu> topicMenuList = topicService.getAllTopicMenu();
		ActionContext.getContext().put("topicMenuList", topicMenuList);
		// 最新帖子
		List<Topic> lastTopicList = topicService.getLastTopicList(14);
		ActionContext.getContext().put("lastTopicList", lastTopicList);
		return super.execute();
	}

}
