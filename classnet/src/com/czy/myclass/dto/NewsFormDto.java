package com.czy.myclass.dto;

import java.io.Serializable;

public class NewsFormDto implements Serializable {

	private static final long serialVersionUID = 5913300281610123450L;

	private Long id;
	private String title;
	private String author;
	private String source;
	private String content;
	private Long newsTypeId;
	private String img;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getNewsTypeId() {
		return newsTypeId;
	}

	public void setNewsTypeId(Long newsTypeId) {
		this.newsTypeId = newsTypeId;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
