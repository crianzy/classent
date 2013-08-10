package com.czy.myclass.admin.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myclass.dto.PageBean;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class UserAdminAction extends BaseAdminAction {

	private static final long serialVersionUID = -4368336719368356726L;
	private String m = "index";
	private String key;
	private int currentPage = 1;
	private Long id;
	private String flag;
	private boolean enable;

	public String list() {
		PageBean pageBean = userService.getPageBean(currentPage, key);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "list";
	}

	public String changeUserStatus() {
		userService.chageUserStatus(id,enable);
		flag = "1";
		return "changeUserStatus";
	}

	public String getM() {
		return m;
	}

	public void setM(String m) {
		this.m = m;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
