package com.czy.myclass.service;

import java.util.List;

import com.czy.myclass.domain.Clazz;
import com.czy.myclass.domain.ClazzMenu;
import com.czy.myclass.domain.ClazzType;
import com.czy.myclass.dto.ClazzMenuDto;

public interface ClazzService extends BaseService {

	public Clazz getClazzById(Long clazzId);

	public ClazzMenu getClazzMenuByid(Long clazzMemuId);

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

	public void addClazzMenu(String clazzMenuName, Long parentId);

	public void editClazzMenu(Long clazzMenuId, String clazzMenuName);

	public void delClazzMenu(Long clazzMenuId);

	public void delClazzMenu(String ids);

	public void addClazzType(String clazzTypeName);

	public void editClazzType(Long clazzTypeId, String clazzTypeName);

	public void delClazzType(Long clazzTypeId);

	public void delClazzType(String clazzTypeIds);

	public void addClazz(Clazz clazz, Long clazzMenuId, Long clazzTypeId);

	public void updataClazz(Clazz clazz, Long clazzMenuId, Long clazzTypeId);

	public void changeClazzStatus(Long clazzId, int status);

	public void delClazz(String ids);

	public void delClazz(Long clazzId);

}
