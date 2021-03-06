package com.czy.myclass.admin.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myclass.action.BaseAction;
import com.czy.myclass.domain.SourceMenu;
import com.czy.myclass.dto.PageBean;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class SourceAdminAction extends BaseAction {

	private static final long serialVersionUID = 1732888140858151030L;
	private String m = "source";
	private String sourceMenuName;
	private Long sourceMenuId;
	private String ids;
	private String key;
	private Long sourceId;

	/** 资源菜单列表*/
	public String menuList() {
		List<SourceMenu> sourceMenuList = sourceService.getAllSourceMenu();
		ActionContext.getContext().put("sourceMenuList", sourceMenuList);
		return "menuList";
	}

	/** 添加资源菜单*/
	public String addMenu() {
		sourceService.addMenu(sourceMenuName);
		return "toMenuList";
	}

	/** 编辑资源菜单*/
	public String edit() {
		sourceService.editMenu(sourceMenuId, sourceMenuName);
		flag = "1";
		return "json";
	}
	/** 删除资源菜单*/
	public String delMenu() {
		if (sourceMenuId != null) {
			sourceService.delSourceMenu(sourceMenuId);
		}
		if (ids != null && !ids.equals("")) {
			sourceService.delSourceMenu(ids);
		}
		return "toMenuList";
	}
	/** 资源列表*/
	public String sourceList() {
		List<SourceMenu> sourceMenuList = sourceService.getAllSourceMenu();
		ActionContext.getContext().put("sourceMenuList", sourceMenuList);
		PageBean pageBean = sourceService.getPageBeanSource(sourceMenuId, key,
				currentPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "sourceList";
	}

	/** 删除资源*/
	public String delSource() {
		if (sourceId != null) {
			sourceService.delSource(sourceId);
		}
		if (ids != null && !ids.equals("")) {
			sourceService.delSource(ids);
		}
		return "toSourceList";
	}
	
	public String getM() {
		return m;
	}

	public void setM(String m) {
		this.m = m;
	}

	public String getSourceMenuName() {
		return sourceMenuName;
	}

	public void setSourceMenuName(String sourceMenuName) {
		this.sourceMenuName = sourceMenuName;
	}

	public Long getSourceMenuId() {
		return sourceMenuId;
	}

	public void setSourceMenuId(Long sourceMenuId) {
		this.sourceMenuId = sourceMenuId;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

}
