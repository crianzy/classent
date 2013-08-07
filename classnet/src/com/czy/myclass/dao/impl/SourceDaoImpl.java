package com.czy.myclass.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.czy.myclass.dao.SourceDao;
import com.czy.myclass.domain.Source;

@Repository
public class SourceDaoImpl extends BaseDaoImpl<Source> implements SourceDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<Source> getLastSource(int n) {
		List<Source> sourceList = getSession().createQuery("FROM Source source ORDER By source.pubTime DESC")//
				.setMaxResults(n)//
				.list();
		return sourceList;
	}

}
