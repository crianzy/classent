package com.czy.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.czy.myclass.dao.ClazzDao;
import com.czy.myclass.dao.ClazzMenuDao;
import com.czy.myclass.dao.ClazzTypeDao;
import com.czy.myclass.domain.Clazz;
import com.czy.myclass.domain.ClazzMenu;
import com.czy.myclass.domain.ClazzType;
import com.czy.myclass.dto.ClazzMenuDto;
import com.czy.myclass.dto.PageBean;
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
		//TODO  最新课程 硬编码
		List<Clazz> clazzList = clazzDao.getLastCLazz(8);
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
		clazz.setViewNum(clazz.getViewNum() + 1);
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
		List<Clazz> clazzList = clazzDao.search(pmenuId, menuId, clazzTypeId,
				keyWord);
		return clazzList;
	}

	@Override
	public List<Clazz> getTuiJianClazz(int n) {
		List<Clazz> clazzList = clazzDao.getTuiJianList(n);
		return clazzList;
	}

	@Override
	public void addClazzMenu(String clazzMenuName, Long parentId) {
		ClazzMenu clazzMenu = new ClazzMenu();
		clazzMenu.setName(clazzMenuName);
		if (parentId != null) {
			ClazzMenu parent = clazzMenuDao.getById(parentId);
			clazzMenu.setParentClassMenu(parent);
		}
		clazzMenuDao.save(clazzMenu);
	}

	@Override
	public void editClazzMenu(Long clazzMenuId, String clazzMenuName) {
		ClazzMenu clazzMenu = clazzMenuDao.getById(clazzMenuId);
		clazzMenu.setName(clazzMenuName);
		clazzMenuDao.updata(clazzMenu);
	}

	@Override
	public void delClazzMenu(Long clazzMenuId) {
		clazzMenuDao.delete(clazzMenuId);
	}

	@Override
	public void delClazzMenu(String menuids) {
		String[] ids = menuids.split(",");
		for (String idstr : ids) {
			Long id = Long.parseLong(idstr);
			clazzMenuDao.delete(id);
		}
	}

	@Override
	public void addClazzType(String clazzTypeName) {
		ClazzType clazzType = new ClazzType();
		clazzType.setName(clazzTypeName);
		clazzTypeDao.save(clazzType);
	}

	@Override
	public void editClazzType(Long clazzTypeId, String clazzTypeName) {
		ClazzType clazzType = clazzTypeDao.getById(clazzTypeId);
		clazzType.setName(clazzTypeName);
		clazzTypeDao.updata(clazzType);
	}

	@Override
	public void delClazzType(Long clazzTypeId) {
		clazzTypeDao.delete(clazzTypeId);
	}

	@Override
	public void delClazzType(String clazzTypeIds) {
		String[] ids = clazzTypeIds.split(",");
		for (String idstr : ids) {
			Long id = Long.parseLong(idstr);
			clazzTypeDao.delete(id);
		}
	}

	@Override
	public void addClazz(Clazz clazz, Long clazzMenuId, Long clazzTypeId) {
		ClazzMenu clazzMenu = clazzMenuDao.getById(clazzMenuId);
		ClazzType clazzType = clazzTypeDao.getById(clazzTypeId);
		clazz.setFileType(clazzType);
		clazz.setClazzMenu(clazzMenu);
		clazzDao.save(clazz);
	}

	@Override
	public void updataClazz(Clazz clazz, Long clazzMenuId, Long clazzTypeId) {
		ClazzMenu clazzMenu = clazzMenuDao.getById(clazzMenuId);
		ClazzType clazzType = clazzTypeDao.getById(clazzTypeId);
		clazz.setFileType(clazzType);
		clazz.setClazzMenu(clazzMenu);
		clazzDao.updata(clazz);
	}

	@Override
	public void changeClazzStatus(Long clazzId, int status) {
		Clazz clazz = clazzDao.getById(clazzId);
		clazz.setStatus(status);
		clazzDao.updata(clazz);
	}

	@Override
	public void delClazz(String clazzIds) {
		String[] ids = clazzIds.split(",");
		for (String idstr : ids) {
			Long id = Long.parseLong(idstr);
			clazzDao.delete(id);
		}
	}

	@Override
	public void delClazz(Long clazzId) {
		clazzDao.delete(clazzId);
	}

	@Override
	public PageBean getClazzPageBean(Long parentId, Long clazzMenuId,
			Long clazzTypeId, String key , int currentPage) {
		return clazzDao.getClazzPageBean(parentId, clazzMenuId, clazzTypeId,
				key,currentPage);
	}

}
