package com.czy.myclass.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.czy.myclass.dao.SourceDao;
import com.czy.myclass.dao.SourceMenuDao;
import com.czy.myclass.domain.Source;
import com.czy.myclass.domain.SourceMenu;
import com.czy.myclass.service.SourceService;

@Service
public class SourceServiceImpl implements SourceService {

	@Resource
	private SourceDao sourceDao;

	@Resource
	private SourceMenuDao sourceMenuDao;

	@Override
	public List<SourceMenu> getAllSource() {
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
		Source source  = sourceDao.getById(sourceId);
		return source;
	}

	@Override
	public List<Source> getLastSourceList(int n) {
		List<Source> sourceList = sourceDao.getLastSource(n);
		return sourceList;
	}
}
