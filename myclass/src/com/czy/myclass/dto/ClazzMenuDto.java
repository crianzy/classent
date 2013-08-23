package com.czy.myclass.dto;

import java.io.Serializable;

public class ClazzMenuDto implements Serializable {

	private static final long serialVersionUID = -2407438530091042000L;

	private Long id;
	private String name;

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

}
