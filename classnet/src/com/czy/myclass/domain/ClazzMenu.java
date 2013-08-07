package com.czy.myclass.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ClazzMenu implements Serializable {

	private static final long serialVersionUID = -5829236832452397133L;
	private Long id;
	private String name;
	private Set<ClazzMenu> childrenClassMenu = new HashSet<ClazzMenu>();
	private ClazzMenu parentClassMenu;
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

	public Set<ClazzMenu> getChildrenClassMenu() {
		return childrenClassMenu;
	}

	public void setChildrenClassMenu(Set<ClazzMenu> childrenClassMenu) {
		this.childrenClassMenu = childrenClassMenu;
	}

	public ClazzMenu getParentClassMenu() {
		return parentClassMenu;
	}

	public void setParentClassMenu(ClazzMenu parentClassMenu) {
		this.parentClassMenu = parentClassMenu;
	}

	public Set<Clazz> getClazzs() {
		return clazzs;
	}

	public void setClazzs(Set<Clazz> clazzs) {
		this.clazzs = clazzs;
	}

}
