package com.czy.myclass.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable {

	private static final long serialVersionUID = 2166533299253690487L;

	private Long id;
	private String username;
	private String password;
	private String email;
	private boolean enable = true;

	/**
	 * 角色
	 */
	private String authorite;// ROLE_USER,ROLE_SUPERVISORs

	private Set<Topic> topics = new HashSet<Topic>();
	private Set<TopicAnswer> topicAnswers = new HashSet<TopicAnswer>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getAuthorite() {
		return authorite;
	}

	public void setAuthorite(String authorite) {
		this.authorite = authorite;
	}

	public Set<Topic> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}

	public Set<TopicAnswer> getTopicAnswers() {
		return topicAnswers;
	}

	public void setTopicAnswers(Set<TopicAnswer> topicAnswers) {
		this.topicAnswers = topicAnswers;
	}

}
