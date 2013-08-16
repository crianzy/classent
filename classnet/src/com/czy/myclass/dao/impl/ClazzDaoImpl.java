package com.czy.myclass.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.czy.myclass.cfg.Configuration;
import com.czy.myclass.dao.ClazzDao;
import com.czy.myclass.domain.Clazz;
import com.czy.myclass.dto.PageBean;

@Repository
@SuppressWarnings("unchecked")
public class ClazzDaoImpl extends BaseDaoImpl<Clazz> implements ClazzDao {

	@Override
	public List<Clazz> getLastCLazz(int n) {
		List<Clazz> clazzList = getSession()
				.createQuery("FROM Clazz clazz ORDER BY clazz.pubTime DESC")//
				.setMaxResults(n)//
				.list();
		return clazzList;
	}


	@Override
	public List<Clazz> search(Long pmenuId, Long menuId, Long clazzTypeId,
			String keyWord ) {
		String hql = "SELECT clazz FROM Clazz clazz WHERE 1 = 1";
		if(pmenuId != null){
			hql = hql + " AND clazz.clazzMenu.parentClassMenu.id = " + pmenuId;
		}
		if (menuId != null) {
			hql = hql + " AND clazz.clazzMenu.id = " + menuId;
		}
		if (clazzTypeId != null) {
			hql = hql + " AND clazz.fileType.id = " + clazzTypeId;
		}
		if (keyWord != null && !"".equals(keyWord.trim())) {
			hql = hql + " AND clazz.name LIKE '%"+ keyWord +"%' ";
		}
		//System.out.println(hql);

		List<Clazz> clazzList = getSession()
				.createQuery(hql)
				.list();
		/*
		 * for (Clazz clazz : clazzList) { System.out.println(clazz.getId() +
		 * "-------" + clazz.getName()); }
		 */

		return clazzList;
	}

	@Override
	public List<Clazz> getTuiJianList(int n) {
		
		List<Clazz> clazzList = getSession()
				.createQuery("FROM Clazz clazz WHERE clazz.status = 2 ORDER BY clazz.pubTime DESC ")//
				.setMaxResults(n)//
				.list();
		return clazzList;
	}


	@SuppressWarnings("rawtypes")
	@Override
	public PageBean getClazzPageBean(Long parentId, Long clazzMenuId,
			Long clazzTypeId, String key,int currentPage) {
		int pageSize = Configuration.getPageSize();
		String hql = " FROM Clazz clazz WHERE 1 = 1 ";
		String where = "";
		if(parentId != null){
			where = where + " AND clazz.clazzMenu.parentClassMenu.id = " + parentId;
		}
		if (clazzMenuId != null) {
			where = where + " AND clazz.clazzMenu.id = " + clazzMenuId;
		}
		if (clazzTypeId != null) {
			where = where + " AND clazz.fileType.id = " + clazzTypeId;
		}
		if (key != null && !"".equals(key.trim())) {
			where = where + " AND clazz.name LIKE '%"+ key +"%' ";
		}
		List list = getSession().createQuery(//
				hql + where +" ORDER BY clazz.pubTime DESC  ")//
				.setFirstResult((currentPage-1)*pageSize)//
				.setMaxResults(pageSize)//
				.list();
		Long recordCount =  (Long) getSession().createQuery(//
				"SELECT COUNT(*) "+hql + where )//
				.uniqueResult();
		return new PageBean(currentPage, list, recordCount.intValue(), pageSize);
	}
}
