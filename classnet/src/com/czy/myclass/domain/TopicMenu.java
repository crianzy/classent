package com.czy.myclass.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TopicMenu implements Serializable {

	private static final long serialVersionUID = -4194103177268761112L;

	private Long id;
	private String name;
	private Set<Topic> topics = new HashSet<Topic>();

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

	public Set<Topic> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}

}
