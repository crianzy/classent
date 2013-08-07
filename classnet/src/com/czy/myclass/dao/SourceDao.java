package com.czy.myclass.dao;

import java.util.List;

import com.czy.myclass.domain.Source;

public interface SourceDao extends BaseDao<Source>{

	List<Source> getLastSource(int n);

}
