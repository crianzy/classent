package com.czy.myclass.dao;

import java.util.List;

import com.czy.myclass.domain.Source;
import com.czy.myclass.dto.PageBean;

public interface SourceDao extends BaseDao<Source>{

	List<Source> getLastSource(int n);

	List<Source> getSourceByMenuId(Long sourceMenuId, String key);

	PageBean getPageBean(Long sourceMenuId, String key, int currentPage);

}
