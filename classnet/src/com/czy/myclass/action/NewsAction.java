package com.czy.myclass.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myclass.domain.News;
import com.czy.myclass.domain.NewsType;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class NewsAction extends BaseAction<NewsType> {

	private static final long serialVersionUID = 3104691779320434226L;
	private Long newsId;
	private Long newsTypeId;

	public String index() throws Exception {
		//新闻类型 栏目列表
		List<NewsType> newsTypeList = newsSerice.getAllNewTypeList();
		ActionContext.getContext().put("newsTypeList", newsTypeList);
		//最新新闻
		List<News> lastNewsList = newsSerice.getLastNews();
		ActionContext.getContext().put("lastNewsList", lastNewsList);
		//推荐新闻
		List<News> tuijianNewsList = newsSerice.getTuijianNews();
		ActionContext.getContext().put("tuijianNewsList", tuijianNewsList);

		return "newsIndex";
	}

	public String readNews() {
		News news = newsSerice.readNews(newsId);
		System.out.println(news.getTitle());
		ActionContext.getContext().put("news", news);
		//新闻类型 栏目列表
		List<NewsType> newsTypeList = newsSerice.getAllNewTypeList();
		ActionContext.getContext().put("newsTypeList", newsTypeList);
		return "readNews";
	}
	
	public String newsType(){
		//获取当前 id 的 newstype
		NewsType newsType = newsSerice.getNewsTypeById(newsTypeId);
		ActionContext.getContext().put("newsType", newsType);
		
		model.setName(newsType.getName());
		model = newsType;
		//新闻类型 栏目列表
		List<NewsType> newsTypeList = newsSerice.getAllNewTypeList();
		ActionContext.getContext().put("newsTypeList", newsTypeList);
		//热点新闻
		List<News> hotNewsList = newsSerice.getHotNews();
		ActionContext.getContext().put("hotNewsList",hotNewsList);
		//推荐新闻
		List<News> tuijianNewsList = newsSerice.getTuijianNews();
		ActionContext.getContext().put("tuijianNewsList", tuijianNewsList);
		return "newsType";
	}

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
