package com.czy.myclass.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ClazzType implements Serializable{

	private static final long serialVersionUID = -4901766428695324524L;
	private Long id;
	private String name;
	private Set<Clazz> clazzs = new HashSet<Clazz>();
	
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
	public Set<Clazz> getClazzs() {
		return clazzs;
	}
	public void setClazzs(Set<Clazz> clazzs) {
		this.clazzs = clazzs;
	}
	
	
}
