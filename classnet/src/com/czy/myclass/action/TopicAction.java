package com.czy.myclass.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myclass.domain.Topic;
import com.czy.myclass.domain.TopicMenu;
import com.czy.myclass.domain.User;
import com.czy.myclass.dto.PageBean;
import com.czy.myclass.service.TopicService;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class TopicAction extends BaseAction {

	private static final long serialVersionUID = 1380982741227271851L;

	private Long topicMenuId;
	private Long topicId;
	private String content;
	private int currentPage = 1;

	public String index() {
		// 所有版块
		List<TopicMenu> topicMenuList = topicService.getAllTopicMenu();
		ActionContext.getContext().put("topicMenuList", topicMenuList);
		return "index";
	}

	public String menuList() {
		// 所有版块
		List<TopicMenu> topicMenuList = topicService.getAllTopicMenu();
		ActionContext.getContext().put("topicMenuList", topicMenuList);
		// 当前id 的版块
		PageBean pageBean = topicService.getTopicPageBean(currentPage, topicMenuId);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "menuList";
	}

	public String topic() {
		if (topicId == null) {
			return "toIndex";
		}
		Topic topic = topicService.getTopic(topicId);
		ActionContext.getContext().put("topic", topic);
		PageBean pageBean = topicService.getAnswerPageBean(currentPage, topicId);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "topic";
	}

	/** 回复 */
	public String reply() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		topicService.replay(user.getId(), topicId, content);
		return "toTopic";
	}

	public Long getTopicMenuId() {
		return topicMenuId;
	}

	public void setTopicMenuId(Long topicMenuId) {
		this.topicMenuId = topicMenuId;
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public TopicService getTopicService() {
		return topicService;
	}

	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

}
