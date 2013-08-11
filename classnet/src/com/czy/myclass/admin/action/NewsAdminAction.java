package com.czy.myclass.admin.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myclass.domain.NewsType;
import com.czy.myclass.dto.PageBean;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class NewsAdminAction extends BaseAdminAction {

	private static final long serialVersionUID = -3962721334206157954L;
	private String m = "news";
	private String menuName;
	private Long menuId;
	private Long newsId;
	private String ids;
	private String flag;
	private int currentPage = 1;
	private String key;
	private int status;

	public String newsMenuManage() {
		List<NewsType> newsTypeList = newsService.getAllNewTypeList();
		ActionContext.getContext().put("newsTypeList", newsTypeList);
		return "newsMenuManage";
	}

	public String addMenu() {
		newsService.addMenu(menuName);
		return "toNewsMenuManage";
	}

	public String delMenu() {
		if (menuId != null) {
			newsService.delMenu(menuId);
		}
		if (ids != null && !ids.equals("")) {
			newsService.delMenu(ids);
		}
		return "toNewsMenuManage";
	}

	public String updataMenu() {
		newsService.updateMenu(menuId, menuName);
		flag = "1";
		return "json";
	}

	public String newsManage() {
		List<NewsType> newsTypeList = newsService.getAllNewTypeList();
		ActionContext.getContext().put("newsTypeList", newsTypeList);

		PageBean pageBean = newsService.getnewsPageBean(currentPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "newsManage";
	}

	public String search() {
		List<NewsType> newsTypeList = newsService.getAllNewTypeList();
		ActionContext.getContext().put("newsTypeList", newsTypeList);

		PageBean pageBean = newsService.getPageBeanSearch(currentPage, menuId,
				key);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "newsManage";
	}

	public String delNews() {
		if (newsId != null) {
			newsService.delNews(newsId);
		}
		if (ids != null && !ids.equals("")) {
			newsService.delNews(ids);
		}
		return "toNewsManage";
	}

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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
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
