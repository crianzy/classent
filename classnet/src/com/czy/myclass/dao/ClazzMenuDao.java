package com.czy.myclass.dao;

import java.util.List;

import com.czy.myclass.domain.ClazzMenu;

public interface ClazzMenuDao extends BaseDao<ClazzMenu>{

	public List<ClazzMenu> getChildrenByParentId(Long parentId);
	
}
