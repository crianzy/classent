package com.czy.myclass.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class SourceMenu implements Serializable {

	private static final long serialVersionUID = -4849769923633754693L;
	private Long id;
	private String name;
	private Set<Source> sources = new HashSet<Source>();

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

	public Set<Source> getSources() {
		return sources;
	}

	public void setSources(Set<Source> sources) {
		this.sources = sources;
	}

}
