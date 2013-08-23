package com.czy.myclass.dao;

import java.util.List;

import com.czy.myclass.domain.Clazz;
import com.czy.myclass.dto.PageBean;

public interface ClazzDao extends BaseDao<Clazz> {

	public List<Clazz> getLastCLazz(int n);

	public List<Clazz> search(Long pmenuId, Long menuId, Long clazzTypeId,
			String keyWord);

	public List<Clazz> getTuiJianList(int n);

	public PageBean getClazzPageBean(Long parentId, Long clazzMenuId,
			Long clazzTypeId, String key, int currentPage);
}
