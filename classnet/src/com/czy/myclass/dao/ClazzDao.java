package com.czy.myclass.dao;

import java.util.List;

import com.czy.myclass.domain.Clazz;

public interface ClazzDao extends BaseDao<Clazz>  {

	public List<Clazz> getLastCLazz(int n);
	
	public List<Clazz> search(Long pmenuId,Long menuId,Long clazzTypeId,String keyWord);

	public List<Clazz> getTuiJianList(int n);
}
