package com.czy.myclass.admin.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myclass.action.BaseAction;
import com.czy.myclass.domain.TopicMenu;
import com.czy.myclass.dto.PageBean;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class TopicAdminAction extends BaseAction {

	private static final long serialVersionUID = 2083500023104117426L;

	private String m = "topic";
	private Long menuId;
	private Long topicId;
	private String ids;
	private String menuName;
	private String key;
	private Long topicAnswerId;

	/** 板块列表 */
	public String menuList() {
		List<TopicMenu> menuList = topicService.getAllTopicMenu();
		ActionContext.getContext().put("menuList", menuList);
		return "menuList";
	}

	/** 删除板块 */
	public String delMenu() {
		if (menuId != null) {
			topicService.delMenu(menuId);
		}
		if (ids != null && !"".equals(ids)) {
			topicService.delMenu(ids);
		}
		return "toMenuList";
	}

	/** 添加板块 */
	public String addMenu() {
		topicService.addMenu(menuName);
		return "toMenuList";
	}

	/** 编辑板块 */
	public String editMenu() {
		topicService.updata(menuId, menuName);
		flag = "1";
		return "json";
	}

	/** 帖子列表 带有搜索信息带分页 */
	public String topicList() {
		List<TopicMenu> menuList = topicService.getAllTopicMenu();
		ActionContext.getContext().put("menuList", menuList);
		PageBean pageBean = topicService.getTopciPageBean(currentPage, menuId,
				key);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "topicList";
	}

	/** 删除帖子 */
	public String delTopic() {
		if (topicId != null) {
			topicService.delTopic(topicId);
		}
		if (ids != null && !"".equals(ids)) {
			topicService.delTopic(ids);
		}
		return "toTopicList";
	}

	/** 屏蔽回复 */
	public String pingbiAnswer() {
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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Long getTopicAnswerId() {
		return topicAnswerId;
	}

	public void setTopicAnswerId(Long topicAnswerId) {
		this.topicAnswerId = topicAnswerId;
	}

}
