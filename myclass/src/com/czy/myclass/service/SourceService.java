package com.czy.myclass.service;

import java.util.List;

import com.czy.myclass.domain.Source;
import com.czy.myclass.domain.SourceMenu;
import com.czy.myclass.dto.PageBean;


public interface SourceService extends BaseService{

	/**
	 * 获取所有新闻菜单
	 * @return
	 */
	public List<SourceMenu> getAllSourceMenu();

	/**
	 * 更具 sourceMenuId 获取下级 资源菜单
	 * @param sourceMenuId
	 * @return
	 */
	public SourceMenu getSourceMenu(Long sourceMenuId);

	/**
	 * 更具id 获取资源
	 * @param sourceId
	 * @return
	 */
	public Source getSource(Long sourceId);

	/**
	 * 获取最新 的  i 个 资源
	 * @param i
	 * @return
	 */
	public List<Source> getLastSourceList(int i);

	/**
	 * 添加资源菜单
	 * @param sourceMenuName
	 */
	public void addMenu(String sourceMenuName);

	/**
	 * 编辑 资源菜单  name
	 * @param sourceMenuId
	 * @param sourceMenuName
	 */
	public void editMenu(Long sourceMenuId, String sourceMenuName);

	/**
	 * 删除 资源菜单 一个
	 * @param sourceMenuId
	 */
	public void delSourceMenu(Long sourceMenuId);

	/**
	 * 删除 资源菜单 多个
	 * @param ids
	 */
	public void delSourceMenu(String ids);

	/**
	 * 更具 父id 和 key 值 得到相对应的 资源 List
	 * @param sourceMenuId
	 * @param key
	 * @return
	 */
	public List<Source> getallSourceList(Long sourceMenuId, String key);

	/**
	 * 删除资源 一个
	 * @param sourceId
	 */
	public void delSource(Long sourceId);

	/**
	 * 删除资源 多个
	 * @param ids
	 */
	public void delSource(String ids);

	/**
	 * 获取分页信息，带有搜索 分类信息
	 * @param sourceMenuId
	 * @param key
	 * @param currentPage
	 * @return
	 */
	public PageBean getPageBeanSource(Long sourceMenuId, String key,
			int currentPage);

	/**
	 * 添加资源
	 * @param sourceModel
	 * @param menuId
	 */
	public void saveSource(Source sourceModel, Long menuId);

	/**
	 * 编辑 更新 资源
	 * @param sourceModel
	 * @param menuId
	 */
	public void updataSource(Source sourceModel, Long menuId);
	
}
