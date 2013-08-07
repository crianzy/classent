package com.czy.myclass.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Topic implements Serializable {

	private static final long serialVersionUID = -4443381495040070333L;

	private Long id;
	private String title;
	private String detail;
	private User user;
	private TopicMenu topicMenu;
	private Date pubTime;
	private Integer replyNum = 0;

	/**
	 * 最后更新的人
	 */
	private String editUsername;

	/**
	 * 更新时间
	 */
	private Date editTime;

	private Set<TopicAnswer> answers = new HashSet<TopicAnswer>();

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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TopicMenu getTopicMenu() {
		return topicMenu;
	}

	public void setTopicMenu(TopicMenu topicMenu) {
		this.topicMenu = topicMenu;
	}

	public Date getPubTime() {
		return pubTime;
	}

	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	public Integer getReplyNum() {
		return replyNum;
	}

	public void setReplyNum(Integer replyNum) {
		this.replyNum = replyNum;
	}

	public String getEditUsername() {
		return editUsername;
	}

	public void setEditUsername(String editUsername) {
		this.editUsername = editUsername;
	}

	public Date getEditTime() {
		return editTime;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

	public Set<TopicAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<TopicAnswer> answers) {
		this.answers = answers;
	}

}
