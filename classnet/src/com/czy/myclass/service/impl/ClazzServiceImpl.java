package com.czy.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.czy.myclass.dao.ClazzDao;
import com.czy.myclass.dao.ClazzMenuDao;
import com.czy.myclass.dao.ClazzTypeDao;
import com.czy.myclass.dao.UserDao;
import com.czy.myclass.domain.Clazz;
import com.czy.myclass.domain.ClazzMenu;
import com.czy.myclass.domain.ClazzType;
import com.czy.myclass.dto.ClazzMenuDto;
import com.czy.myclass.service.ClazzService;

@Service
public class ClazzServiceImpl implements ClazzService {

	@Resource
	private ClazzDao clazzDao;
	@Resource
	private ClazzMenuDao clazzMenuDao;
	@Resource
	private ClazzTypeDao clazzTypeDao;

	@Override
	public List<ClazzMenuDto> getFirstClazzMenu() {
		List<ClazzMenu> clazzMenuList = clazzMenuDao
				.getChildrenByParentId(null);
		List<ClazzMenuDto> clazzMenuDtoList = new ArrayList<ClazzMenuDto>();
		for (ClazzMenu clazzMenu : clazzMenuList) {
			ClazzMenuDto clazzMenuDto = new ClazzMenuDto();
			clazzMenuDto.setId(clazzMenu.getId());
			clazzMenuDto.setName(clazzMenu.getName());
			clazzMenuDtoList.add(clazzMenuDto);
		}
		return clazzMenuDtoList;
	}

	@Override
	public List<ClazzMenuDto> getSecondClazzMenu(Long parentId) {
		if (parentId == 0) {
			return null;
		}
		List<ClazzMenu> clazzMenuList = clazzMenuDao
				.getChildrenByParentId(parentId);
		List<ClazzMenuDto> clazzMenuDtoList = new ArrayList<ClazzMenuDto>();
		for (ClazzMenu clazzMenu : clazzMenuList) {
			ClazzMenuDto clazzMenuDto = new ClazzMenuDto();
			clazzMenuDto.setId(clazzMenu.getId());
			clazzMenuDto.setName(clazzMenu.getName());
			clazzMenuDtoList.add(clazzMenuDto);
		}
		return clazzMenuDtoList;
	}

	@Override
	public List<ClazzType> getAllFileType() {
		List<ClazzType> clazzTypeList = clazzTypeDao.findAll();
		return clazzTypeList;
	}

	@Override
	public List<Clazz> getLastClazz() {
		List<Clazz> clazzList = clazzDao.getLastCLazz(6);
		return clazzList;
	}


	@Override
	public ClazzType getClazzTypeById(Long clazzTypeId) {
		ClazzType clazzType = clazzTypeDao.getById(clazzTypeId);
		return clazzType;
	}

	@Override
	public Clazz getClazzById(Long clazzId) {
		Clazz clazz = clazzDao.getById(clazzId);
		// 点击数据的 增加 有待改进
		clazz.setViewNum(clazz.getViewNum()+1);
		clazzDao.updata(clazz);
		return clazz;
	}

	@Override
	public ClazzMenu getClazzMenuByid(Long clazzMemuId) {
		ClazzMenu clazzMenu = clazzMenuDao.getById(clazzMemuId);
		return clazzMenu;
	}

	@Override
	public List<Clazz> searchClazz(Long pmenuId, Long menuId, Long clazzTypeId,
			String keyWord) {
		List<Clazz> clazzList = clazzDao.search(pmenuId, menuId, clazzTypeId, keyWord);
		return clazzList;
	}

	@Override
	public List<Clazz> getTuiJianClazz(int n) {
		List<Clazz> clazzList = clazzDao.getTuiJianList(n);
		return clazzList;
	}

}
