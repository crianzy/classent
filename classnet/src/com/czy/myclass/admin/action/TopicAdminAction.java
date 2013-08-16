package com.czy.myclass.admin.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myclass.domain.TopicMenu;
import com.czy.myclass.dto.PageBean;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class TopicAdminAction extends BaseAdminAction {

	private static final long serialVersionUID = 2083500023104117426L;

	private String m = "topic";
	private Long menuId;
	private Long topicId;
	private String ids;
	private String menuName;
	private String flag;
	private String key;
	private int currentPage = 1;
	private Long topicAnswerId;

	public String menuList() {
		List<TopicMenu> menuList = topicService.getAllTopicMenu();
		ActionContext.getContext().put("menuList", menuList);
		return "menuList";
	}

	public String delMenu() {
		if (menuId != null) {
			topicService.delMenu(menuId);
		}
		if (ids != null && !"".equals(ids)) {
			topicService.delMenu(ids);
		}
		return "toMenuList";
	}

	public String addMenu() {
		topicService.addMenu(menuName);
		return "toMenuList";
	}

	public String editMenu() {
		topicService.updata(menuId, menuName);
		flag = "1";
		return "json";
	}

	public String topicList() {
		List<TopicMenu> menuList = topicService.getAllTopicMenu();
		ActionContext.getContext().put("menuList", menuList);
		PageBean pageBean = topicService.getTopciPageBean(currentPage,menuId,key);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "topicList";
	}
	
	public String delTopic(){
		if (topicId != null) {
			topicService.delTopic(topicId);
		}
		if (ids != null && !"".equals(ids)) {
			topicService.delTopic(ids);
		}
		return "toTopicList";
	}
	
	public String pingbiAnswer(){
		topicService.pingbiAnswer(topicAnswerId);
		flag = "1";
		return "json";
	}
	

	public String getM() {
		return m;
	}

	public void setM(String m) {
		this.m = m;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public Long getTopicAnswerId() {
		return topicAnswerId;
	}

	public void setTopicAnswerId(Long topicAnswerId) {
		this.topicAnswerId = topicAnswerId;
	}
	
	

}
