package com.czy.myclass.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.czy.myclass.dao.SourceDao;
import com.czy.myclass.dao.SourceMenuDao;
import com.czy.myclass.domain.Source;
import com.czy.myclass.domain.SourceMenu;
import com.czy.myclass.dto.PageBean;
import com.czy.myclass.service.SourceService;

@Service
public class SourceServiceImpl implements SourceService {

	@Resource
	private SourceDao sourceDao;

	@Resource
	private SourceMenuDao sourceMenuDao;

	@Override
	public List<SourceMenu> getAllSourceMenu() {
		List<SourceMenu> sourceMenuList = sourceMenuDao.findAll();
		return sourceMenuList;
	}

	@Override
	public SourceMenu getSourceMenu(Long sourceMenuId) {
		SourceMenu sourceMenu = sourceMenuDao.getById(sourceMenuId);
		return sourceMenu;
	}

	@Override
	public Source getSource(Long sourceId) {
		Source source = sourceDao.getById(sourceId);
		return source;
	}

	@Override
	public List<Source> getLastSourceList(int n) {
		List<Source> sourceList = sourceDao.getLastSource(n);
		return sourceList;
	}

	@Override
	public void addMenu(String sourceMenuName) {
		SourceMenu sourceMenu = new SourceMenu();
		sourceMenu.setName(sourceMenuName);
		sourceMenuDao.save(sourceMenu);
	}

	@Override
	public void editMenu(Long sourceMenuId, String sourceMenuName) {
		SourceMenu sourceMenu = sourceMenuDao.getById(sourceMenuId);
		sourceMenu.setName(sourceMenuName);
		sourceMenuDao.updata(sourceMenu);
	}

	@Override
	public void delSourceMenu(Long sourceMenuId) {
		sourceMenuDao.delete(sourceMenuId);
	}

	@Override
	public void delSourceMenu(String menuids) {
		String[] ids = menuids.split(",");
		for (String idstr : ids) {
			Long id = Long.parseLong(idstr);
			sourceMenuDao.delete(id);
		}
	}

	@Override
	public List<Source> getallSourceList(Long sourceMenuId, String key) {
		return sourceDao.getSourceByMenuId(sourceMenuId, key);

	}

	@Override
	public void delSource(Long sourceId) {
		sourceDao.delete(sourceId);
	}

	@Override
	public void delSource(String sourceIds) {
		String[] ids = sourceIds.split(",");
		for (String idstr : ids) {
			Long id = Long.parseLong(idstr);
			sourceDao.delete(id);
		}
	}

	@Override
	public PageBean getPageBeanSource(Long sourceMenuId, String key,
			int currentPage) {
		return sourceDao.getPageBean(sourceMenuId, key, currentPage);
	}

	@Override
	public void saveSource(Source sourceModel, Long menuId) {
		SourceMenu sourceMenu = sourceMenuDao.getById(menuId);
		sourceModel.setSourceMenu(sourceMenu);
		sourceDao.save(sourceModel);
		 
	}

	@Override
	public void updataSource(Source sourceModel, Long menuId) {
		SourceMenu sourceMenu = sourceMenuDao.getById(menuId);
		sourceModel.setSourceMenu(sourceMenu);
		sourceDao.updata(sourceModel);
	}
}
