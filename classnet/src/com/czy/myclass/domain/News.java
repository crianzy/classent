package com.czy.myclass.domain;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable {

	private static final long serialVersionUID = 6598604742711847243L;

	private Long id;
	private String title;
	private String author;
	private String source;
	private Date pubTime = new Date();
	private String content;
	private Integer viewNum = 0;
	private String img;

	/**
	 * 新闻状态 1普通，2推荐， 3栏目头条, 4首页flash 图片新闻
	 */
	private Integer status = 1;
	private NewsType newsType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Date getPubTime() {
		return pubTime;
	}

	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getViewNum() {
		return viewNum;
	}

	public void setViewNum(Integer viewNum) {
		this.viewNum = viewNum;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public NewsType getNewsType() {
		return newsType;
	}

	public void setNewsType(NewsType newsType) {
		this.newsType = newsType;
	}

}
