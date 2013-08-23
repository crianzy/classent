package com.czy.myclass.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.czy.myclass.cfg.Configuration;
import com.czy.myclass.dao.SourceDao;
import com.czy.myclass.domain.Source;
import com.czy.myclass.dto.PageBean;

@Repository
@SuppressWarnings("unchecked")
public class SourceDaoImpl extends BaseDaoImpl<Source> implements SourceDao {

	/**
	 * 最新课程
	 */
	@Override
	public List<Source> getLastSource(int n) {
		List<Source> sourceList = getSession().createQuery("FROM Source source ORDER By source.pubTime DESC")//
				.setMaxResults(n)//
				.list();
		return sourceList;
	}

	/**
	 * 根据menuID 获取该类型下的课程
	 */
	@Override
	public List<Source> getSourceByMenuId(Long sourceMenuId ,String key) {
		String hql = "SELECT source FROM Source source WHERE 1 = 1";
		if(sourceMenuId != null){
			hql = hql + " AND source.sourceMenu.id = " + sourceMenuId;
		}
		if (key != null && !"".equals(key.trim())) {
			hql = hql + " AND source.name LIKE '%"+ key +"%' ";
		}

		List<Source> sourceList = getSession()
				.createQuery(hql)
				.list();
		return sourceList;
	}

	/**
	 * 更加分类搜索信息获取分页信息
	 */
	@Override
	public PageBean getPageBean(Long sourceMenuId, String key, int currentPage) {
		int pageSize = Configuration.getPageSize();
		String hql = "SELECT source FROM Source source WHERE 1 = 1";
		String where =" ";
		if(sourceMenuId != null){
			where = where + " AND source.sourceMenu.id = " + sourceMenuId;
		}
		if (key != null && !"".equals(key.trim())) {
			where = where + " AND source.name LIKE '%"+ key +"%' ";
		}

		List<Source> list = getSession()
				.createQuery(hql+where)
				.setFirstResult((currentPage -1)*pageSize)//
				.setMaxResults(pageSize)//
				.list();
		Long recordCount =  (Long) getSession().createQuery(//
				"SELECT COUNT(*) FROM Source source WHERE 1 = 1 "+where )//
				.uniqueResult();
		
		return new PageBean(currentPage, list, recordCount.intValue(), pageSize);
	}

}
