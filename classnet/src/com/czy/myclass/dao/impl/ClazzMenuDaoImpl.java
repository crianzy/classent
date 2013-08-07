package com.czy.myclass.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.czy.myclass.dao.ClazzMenuDao;
import com.czy.myclass.domain.ClazzMenu;

@Repository
public class ClazzMenuDaoImpl extends BaseDaoImpl<ClazzMenu> implements
		ClazzMenuDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<ClazzMenu> getChildrenByParentId(Long parentId) {
		ClazzMenu parent = getById(parentId);
		if(parent==null){
			List<ClazzMenu> clazzMenuList = getSession()
					.createQuery(
							"FROM ClazzMenu classMenu WHERE classMenu.parentClassMenu = null")//
					.list();
			return clazzMenuList;
		}else{
			List<ClazzMenu> clazzMenuList = getSession()
					.createQuery(
							"FROM ClazzMenu classMenu WHERE classMenu.parentClassMenu = ?")//
					.setParameter(0, parent)//
					.list();
			return clazzMenuList;
		}
		
	}

}
