package com.czy.myclass.domain;

import java.io.Serializable;
import java.util.Date;

public class TopicAnswer implements Serializable {

	private static final long serialVersionUID = 610329982093783782L;
	
	private Long id;
	private String content;
	private User user;
	private Date pubTime = new Date();
	private Topic topic;
	private Integer status = 1;
	private Integer flowNum ;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getPubTime() {
		return pubTime;
	}
	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getFlowNum() {
		return flowNum;
	}
	public void setFlowNum(Integer flowNum) {
		this.flowNum = flowNum;
	}
	
	

}
