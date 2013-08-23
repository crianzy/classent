package com.czy.myclass.admin.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myclass.action.BaseAction;
import com.czy.myclass.domain.NewsType;
import com.czy.myclass.dto.PageBean;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class NewsAdminAction extends BaseAction {

	private static final long serialVersionUID = -3962721334206157954L;
	private String m = "news";
	private String menuName;
	private Long menuId;
	private Long newsId;
	private String ids;
	private String key;
	private int status;

	/**
	 * 新闻菜单列表管理
	 * @return
	 */
	public String newsMenuManage() {
		List<NewsType> newsTypeList = newsService.getAllNewTypeList();
		ActionContext.getContext().put("newsTypeList", newsTypeList);
		return "newsMenuManage";
	}

	/** 添加新闻菜单*/
	public String addMenu() {
		newsService.addMenu(menuName);
		return "toNewsMenuManage";
	}

	/** 删除新闻菜单*/
	public String delMenu() {
		if (menuId != null) {
			newsService.delMenu(menuId);
		}
		if (ids != null && !ids.equals("")) {
			newsService.delMenu(ids);
		}
		return "toNewsMenuManage";
	}
	/** 更新新闻菜单*/
	public String updataMenu() {
		newsService.updateMenu(menuId, menuName);
		flag = "1";
		return "json";
	}

	/** 新闻列表管理*/
	public String newsManage() {
		List<NewsType> newsTypeList = newsService.getAllNewTypeList();
		ActionContext.getContext().put("newsTypeList", newsTypeList);

		PageBean pageBean = newsService.getnewsPageBean(currentPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "newsManage";
	}

	/** 搜索新闻*/
	public String search() {
		List<NewsType> newsTypeList = newsService.getAllNewTypeList();
		ActionContext.getContext().put("newsTypeList", newsTypeList);

		PageBean pageBean = newsService.getPageBeanSearch(currentPage, menuId,
				key);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "newsManage";
	}

	/** 删除新闻*/
	public String delNews() {
		if (newsId != null) {
			newsService.delNews(newsId);
		}
		if (ids != null && !ids.equals("")) {
			newsService.delNews(ids);
		}
		return "toNewsManage";
	}

	/** 改变新闻状态*/
	public String changeNewsStatus() {
		newsService.chanegNewsStatus(newsId, status);
		flag = "1";
		return "json";
	}

	// ---------------------------------------------------
	public String getM() {
		return m;
	}

	public void setM(String m) {
		this.m = m;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Long getNewsId() {
		return newsId;
	}

	public void setNewsId(Long newsId) {
		this.newsId = newsId;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
