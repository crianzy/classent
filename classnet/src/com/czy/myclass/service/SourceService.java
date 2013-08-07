package com.czy.myclass.service;

import java.util.List;

import com.czy.myclass.domain.Source;
import com.czy.myclass.domain.SourceMenu;


public interface SourceService {

	public List<SourceMenu> getAllSource();

	public SourceMenu getSourceMenu(Long sourceMenuId);

	public Source getSource(Long sourceId);

	public List<Source> getLastSourceList(int i);
	
}
