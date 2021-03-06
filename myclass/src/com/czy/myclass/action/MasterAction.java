package com.czy.myclass.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myclass.domain.TopicMenu;
import com.czy.myclass.domain.User;
import com.czy.myclass.dto.PageBean;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class MasterAction extends BaseAction{
	private static final long serialVersionUID = 9058487080818543570L;
	
	private Long topicMenuId;
	private Long topicId;
	private String title;
	private String content;

	// userId 直接从 session 中拿
	
	public String index() {
		return "index";
	}

	/**
	 * 发表过的帖子
	 * @return
	 */
	public String myTopicList() {
		// topic Menu
		List<TopicMenu> menuList = topicService.getAllTopicMenu();
		ActionContext.getContext().put("menuList", menuList);
		//user
		User user = (User) ActionContext.getContext().getSession().get("user");
		
		PageBean pageBean = topicService.getMyPostTopic(user.getId(),topicMenuId,currentPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "myTopicList";
	}

	public String postTopicUI() {
		// topic Menu
		List<TopicMenu> menuList = topicService.getAllTopicMenu();
		ActionContext.getContext().put("menuList", menuList);
		return "postTopicUI";
	}

	/**
	 * 发表帖子
	 * @return
	 */
	public String postTopic() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		topicId =  topicService.postTopic(user.getId(),topicMenuId, title, content);
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
