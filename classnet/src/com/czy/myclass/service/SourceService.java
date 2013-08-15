package com.czy.myclass.service;

import java.util.List;

import com.czy.myclass.domain.Source;
import com.czy.myclass.domain.SourceMenu;
import com.czy.myclass.dto.PageBean;


public interface SourceService extends BaseService{

	public List<SourceMenu> getAllSource();

	public SourceMenu getSourceMenu(Long sourceMenuId);

	public Source getSource(Long sourceId);

	public List<Source> getLastSourceList(int i);

	public void addMenu(String sourceMenuName);

	public void editMenu(Long sourceMenuId, String sourceMenuName);

	public void delSourceMenu(Long sourceMenuId);

	public void delSourceMenu(String ids);

	public List<Source> getallSourceList(Long sourceMenuId, String key);

	public void delSource(Long sourceId);

	public void delSource(String ids);

	public PageBean getPageBeanSource(Long sourceMenuId, String key,
			int currentPage);

	public void saveSource(Source sourceModel, Long menuId);

	public void updataSource(Source sourceModel, Long menuId);
	
}
