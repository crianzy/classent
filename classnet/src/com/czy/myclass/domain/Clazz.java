package com.czy.myclass.domain;

import java.io.Serializable;
import java.util.Date;

public class Clazz implements Serializable {

	private static final long serialVersionUID = 6700091479320139722L;

	private Long id;
	private String name;
	private String author;
	private Date pubTime = new Date();
	private String school;
	private String filename;
	private String fielContentType;
	private String flashFilename;
	private Integer viewNum = 0;

	/**
	 * 1 普通 2推荐 3首页强推
	 */
	private Integer status = 1;

	/**
	 * 封面图片
	 */
	private String img;

	private ClazzMenu clazzMenu;
	private ClazzType fileType;

	public ClazzType getFileType() {
		return fileType;
	}

	public void setFileType(ClazzType fileType) {
		this.fileType = fileType;
	}

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public ClazzMenu getClazzMenu() {
		return clazzMenu;
	}

	public void setClazzMenu(ClazzMenu clazzMenu) {
		this.clazzMenu = clazzMenu;
	}

	public Date getPubTime() {
		return pubTime;
	}

	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFlashFilename() {
		return flashFilename;
	}

	public void setFlashFilename(String flashFilename) {
		this.flashFilename = flashFilename;
	}

	public Integer getViewNum() {
		return viewNum;
	}

	public void setViewNum(Integer viewNum) {
		this.viewNum = viewNum;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getFielContentType() {
		return fielContentType;
	}

	public void setFielContentType(String fielContentType) {
		this.fielContentType = fielContentType;
	}

}
