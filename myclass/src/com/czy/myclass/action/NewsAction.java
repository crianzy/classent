package com.czy.myclass.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myclass.domain.News;
import com.czy.myclass.domain.NewsType;
import com.czy.myclass.dto.PageBean;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class NewsAction extends BaseAction {

	private static final long serialVersionUID = 3104691779320434226L;
	private Long newsId;
	private Long newsTypeId;

	/** 新闻首页 */
	public String index() throws Exception {
		// 新闻类型 栏目列表
		List<NewsType> newsTypeList = newsService.getAllNewTypeList();
		ActionContext.getContext().put("newsTypeList", newsTypeList);
		// 最新新闻
		List<News> lastNewsList = newsService.getLastNews();
		ActionContext.getContext().put("lastNewsList", lastNewsList);
		// 头条新闻
		List<News> touTiaoNewsList = newsService.getTouTiaoNews();
		ActionContext.getContext().put("touTiaoNewsList", touTiaoNewsList);

		// 首页 大图新闻
		News bigPicnews = newsService.getBigPicNews();
		ActionContext.getContext().put("bigPicnews", bigPicnews);

		return "newsIndex";
	}

	/** 阅读新闻 */
	public String readNews() {
		News news = newsService.readNews(newsId);
		ActionContext.getContext().put("news", news);
		// 新闻类型 栏目列表
		List<NewsType> newsTypeList = newsService.getAllNewTypeList();
		ActionContext.getContext().put("newsTypeList", newsTypeList);
		return "readNews";
	}

	/** 新闻类型，并取得当前 展现类型下的所有新闻 */
	public String newsType() {
		// 获取当前 id 的 newstype
		NewsType newsType = newsService.getNewsTypeById(newsTypeId);
		ActionContext.getContext().put("newsType", newsType);

		// 该板块的下的 分页信息
		PageBean pageBean = newsService.getPageBeanSearch(currentPage,
				newsTypeId, null);
		ActionContext.getContext().getValueStack().push(pageBean);

		// 新闻类型 栏目列表
		List<NewsType> newsTypeList = newsService.getAllNewTypeList();
		ActionContext.getContext().put("newsTypeList", newsTypeList);
		// 热点新闻
		List<News> hotNewsList = newsService.getHotNews();
		ActionContext.getContext().put("hotNewsList", hotNewsList);
		// 推荐新闻
		List<News> tuijianNewsList = newsService.getTuijianNews();
		ActionContext.getContext().put("tuijianNewsList", tuijianNewsList);
		return "newsType";
	}

	// ---------get-----set------------------------------------------
	public Long getNewsId() {
		return newsId;
	}

	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}

	public Long getNewsTypeId() {
		return newsTypeId;
	}

	public void setNewsTypeId(Long newsTypeId) {
		this.newsTypeId = newsTypeId;
	}

}
