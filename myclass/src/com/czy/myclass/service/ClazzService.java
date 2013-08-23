package com.czy.myclass.service;

import java.util.List;

import com.czy.myclass.domain.Clazz;
import com.czy.myclass.domain.ClazzMenu;
import com.czy.myclass.domain.ClazzType;
import com.czy.myclass.dto.ClazzMenuDto;
import com.czy.myclass.dto.PageBean;

public interface ClazzService extends BaseService {

	/** 根据 clazzid 获取clazz*/
	public Clazz getClazzById(Long clazzId);

	/** 根据 clazzMemuId 获取ClazzMenu*/
	public ClazzMenu getClazzMenuByid(Long clazzMemuId);

	/** 根据 clazzTypeId 获取ClazzType*/
	public ClazzType getClazzTypeById(Long clazzTypeId);

	/**
	 * 获取一级 课程菜单
	 * 
	 * @return
	 */
	public List<ClazzMenuDto> getFirstClazzMenu();

	/**
	 * 获取二级 课程菜单
	 * 
	 * @return
	 */
	public List<ClazzMenuDto> getSecondClazzMenu(Long parentId);

	/**
	 * 获取所有的课程类型
	 * 
	 * @return
	 */
	public List<ClazzType> getAllFileType();

	/**
	 * 获取最新的课程
	 * 
	 * @return
	 */
	public List<Clazz> getLastClazz();

	/**
	 * 根据信息搜索相关 课程
	 * 
	 * @param firstClazzMenu
	 *            一级目录
	 * @param secondClazzMenu
	 *            二级目录
	 * @param clzzzType
	 *            课程类型
	 * @param keyWord
	 *            关键字
	 * @return
	 */
	public List<Clazz> searchClazz(Long pmenuId, Long menuId, Long clazzTypeId,
			String keyWord);

	/**
	 * 获取推荐教程 clazz.statu = 2
	 * 
	 * @param i
	 * @return
	 */
	public List<Clazz> getTuiJianClazz(int i);

	/**
	 * 添加课程菜单
	 * @param clazzMenuName
	 * @param parentId
	 */
	public void addClazzMenu(String clazzMenuName, Long parentId);

	/**
	 * 编辑课程菜单 name
	 * @param clazzMenuId
	 * @param clazzMenuName
	 */
	public void editClazzMenu(Long clazzMenuId, String clazzMenuName);

	/**
	 * 删除课程类型 根据id 删除一个
	 * @param clazzMenuId
	 */
	public void delClazzMenu(Long clazzMenuId);

	/**
	 * 删除 多个 课程类型
	 * @param ids string slip by ，
	 */
	public void delClazzMenu(String ids);

	/**
	 * 添加课程类型
	 * @param clazzTypeName
	 */
	public void addClazzType(String clazzTypeName);

	/**
	 * 编辑课程类型 name
	 * @param clazzTypeId
	 * @param clazzTypeName
	 */
	public void editClazzType(Long clazzTypeId, String clazzTypeName);

	/**
	 * 删除课程类型 一个 by id
	 * @param clazzTypeId
	 */
	public void delClazzType(Long clazzTypeId);

	/**
	 * 删除课程类型 多个  不ids
	 * @param clazzTypeIds string silp by ，
	 */
	public void delClazzType(String clazzTypeIds);

	/**
	 *  添加课程
	 * @param clazz
	 * @param clazzMenuId
	 * @param clazzTypeId
	 */
	public void addClazz(Clazz clazz, Long clazzMenuId, Long clazzTypeId);

	/**
	 * 更新课程
	 * @param clazz
	 * @param clazzMenuId
	 * @param clazzTypeId
	 */
	public void updataClazz(Clazz clazz, Long clazzMenuId, Long clazzTypeId);

	/**
	 * 改变课程状态
	 * @param clazzId
	 * @param status
	 */
	public void changeClazzStatus(Long clazzId, int status);

	/**
	 * 删除课程 多个
	 * @param ids
	 */
	public void delClazz(String ids);

	/**
	 * 删除课程 一个 
	 * @param clazzId
	 */
	public void delClazz(Long clazzId);

	/**
	 * 获取课程的分页信息   带搜索及分类信息
	 * @param parentId
	 * @param clazzMenuId
	 * @param clazzTypeId
	 * @param key
	 * @param currentPage
	 * @return
	 */
	public PageBean getClazzPageBean(Long parentId, Long clazzMenuId,
			Long clazzTypeId, String key, int currentPage);

}
