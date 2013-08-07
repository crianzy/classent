package com.czy.myclass.domain;

import java.io.Serializable;
import java.util.Date;

public class Source implements Serializable {

	private static final long serialVersionUID = 3307717612099955664L;

	private Long id;
	private String name;
	private Date pubTime = new Date();
	private String fileSize;
	private String filename;
	private String fileContentType;
	private SourceMenu sourceMenu;


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

	public Date getPubTime() {
		return pubTime;
	}

	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public SourceMenu getSourceMenu() {
		return sourceMenu;
	}

	public void setSourceMenu(SourceMenu sourceMenu) {
		this.sourceMenu = sourceMenu;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	
	

}
