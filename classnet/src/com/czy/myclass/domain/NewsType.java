package com.czy.myclass.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NewsType implements Serializable {

	private static final long serialVersionUID = -4792317120467669960L;

	private Long id;
	private String name;
	private Set<News> allnews = new HashSet<News>();
	private List<News> LastNews = new ArrayList<News>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<News> getAllnews() {
		return allnews;
	}

	public void setAllnews(Set<News> allnews) {
		this.allnews = allnews;
	}

	public List<News> getLastNews() {
		return LastNews;
	}

	public void setLastNews(List<News> lastNews) {
		LastNews = lastNews;
	}

}
