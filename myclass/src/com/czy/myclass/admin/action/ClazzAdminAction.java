package com.czy.myclass.admin.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myclass.action.BaseAction;
import com.czy.myclass.domain.ClazzType;
import com.czy.myclass.dto.ClazzMenuDto;
import com.czy.myclass.dto.PageBean;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class ClazzAdminAction extends BaseAction {
	private static final long serialVersionUID = -4190690895763944230L;
	private Long parentId;
	private String m = "clazz";
	private String clazzMenuName;
	private Long clazzMenuId;
	private String ids;
	private Long clazzTypeId;
	private String clazzTypeName;
	private String key;
	private Long clazzId;
	private int status;

	/**
	 * 课程菜单列表
	 * 
	 * @return
	 */
	public String clazzMenuList() {
		List<ClazzMenuDto> clazzMenuDtoList = null;
		List<ClazzMenuDto> parentMenuList = clazzService.getFirstClazzMenu();
		ActionContext.getContext().put("parentMenuList", parentMenuList);
		if (parentId == null || parentId == 0) {
			clazzMenuDtoList = clazzService.getFirstClazzMenu();
		} else {
			clazzMenuDtoList = clazzService.getSecondClazzMenu(parentId);
		}
		ActionContext.getContext().put("clazzMenuDtoList", clazzMenuDtoList);
		return "clazzMenuList";
	}

	/**
	 * 添加课程菜单
	 * 
	 * @return
	 */
	public String addClazzMenu() {
		if (clazzMenuName != null && !"".equals(clazzMenuName)) {
			clazzService.addClazzMenu(clazzMenuName, parentId);
		}
		return "toClazzMenuList";
	}

	/**
	 * 编辑课程菜单
	 * 
	 * @return
	 */
	public String editClazzMenu() {
		clazzService.editClazzMenu(clazzMenuId, clazzMenuName);
		flag = "1";
		return "json";
	}

	/**
	 * 删除课程菜单
	 * 
	 * @return
	 */
	public String delClazzMenu() {
		if (clazzMenuId != null) {
			clazzService.delClazzMenu(clazzMenuId);
		}
		if (ids != null && !ids.equals("")) {
			clazzService.delClazzMenu(ids);
		}
		return "toClazzMenuList";
	}

	/**
	 * 课程类型列表
	 * 
	 * @return
	 */
	public String clazzTypeList() {
		List<ClazzType> clazzTypeList = clazzService.getAllFileType();
		ActionContext.getContext().put("clazzTypeList", clazzTypeList);
		return "clazzTypeList";
	}

	/**
	 * 添加课程类型
	 * 
	 * @return
	 */
	public String addClazzType() {
		clazzService.addClazzType(clazzTypeName);
		return "toClazzTypeList";
	}

	/**
	 * 编辑课程类型
	 * 
	 * @return
	 */
	public String editClazzType() {
		clazzService.editClazzType(clazzTypeId, clazzTypeName);
		flag = "1";
		return "json";
	}

	/**
	 * 删除课程类型
	 * 
	 * @return
	 */
	public String delClazzType() {
		if (clazzTypeId != null) {
			clazzService.delClazzType(clazzTypeId);
		}
		if (ids != null && !ids.equals("")) {
			clazzService.delClazzType(ids);
		}
		return "toClazzTypeList";
	}

	/**
	 * 所有课程列表带分页
	 * 
	 * @return
	 */
	public String clazzList() {
		List<ClazzType> clazzTypeList = clazzService.getAllFileType();
		ActionContext.getContext().put("clazzTypeList", clazzTypeList);
		List<ClazzMenuDto> parentMenuList = clazzService.getFirstClazzMenu();
		ActionContext.getContext().put("parentMenuList", parentMenuList);
		PageBean pageBean = clazzService.getClazzPageBean(parentId,
				clazzMenuId, clazzTypeId, key, currentPage);
		if (parentId != null) {
			List<ClazzMenuDto> childMenuList = clazzService
					.getSecondClazzMenu(parentId);
			ActionContext.getContext().put("childMenuList", childMenuList);
		}
		ActionContext.getContext().getValueStack().push(pageBean);
		return "clazzList";
	}

	/**
	 * 改变课程状态
	 * 
	 * @return
	 */
	public String changeClazzStatus() {
		clazzService.changeClazzStatus(clazzId, status);
		flag = "1";
		return "json";
	}

	/**
	 * 删除课程
	 * 
	 * @return
	 */
	public String delClazz() {
		if (clazzId != null) {
			clazzService.delClazz(clazzId);
		}
		if (ids != null && !ids.equals("")) {
			clazzService.delClazz(ids);
		}
		return "toClazzList";
	}

	// ------------get---------set-----------------------------------
	public String getM() {
		return m;
	}

	public void setM(String m) {
		this.m = m;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getClazzMenuName() {
		return clazzMenuName;
	}

	public void setClazzMenuName(String clazzMenuName) {
		this.clazzMenuName = clazzMenuName;
	}

	public Long getClazzMenuId() {
		return clazzMenuId;
	}

	public void setClazzMenuId(Long clazzMenuId) {
		this.clazzMenuId = clazzMenuId;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Long getClazzTypeId() {
		return clazzTypeId;
	}

	public void setClazzTypeId(Long clazzTypeId) {
		this.clazzTypeId = clazzTypeId;
	}

	public String getClazzTypeName() {
		return clazzTypeName;
	}

	public void setClazzTypeName(String clazzTypeName) {
		this.clazzTypeName = clazzTypeName;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Long getClazzId() {
		return clazzId;
	}

	public void setClazzId(Long clazzId) {
		this.clazzId = clazzId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
