package com.czy.myclass.action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myclass.domain.Clazz;
import com.czy.myclass.domain.ClazzMenu;
import com.czy.myclass.domain.ClazzType;
import com.czy.myclass.dto.ClazzMenuDto;
import com.czy.myclass.dto.PageBean;
import com.czy.myclass.service.ClazzService;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class ClazzAction extends BaseAction {

	private static final long serialVersionUID = -1622957345522557223L;

	private Long clazzId;
	private Long clazzTypeId;
	private Long pmenuId;
	private Long menuId;
	private String keyWord;

	private String inputPath;
	private String filename;
	private String fileContentType;
	private int currentPage = 1;

	private List<ClazzMenuDto> secondClazzMenuDto;

	public String index() {
		// 一级菜单 栏目列表
		List<ClazzMenuDto> firstclazzMenList = clazzService.getFirstClazzMenu();
		ActionContext.getContext().put("firstclazzMenList", firstclazzMenList);

		// 课程类型
		List<ClazzType> clazzTypeList = clazzService.getAllFileType();
		ActionContext.getContext().put("clazzTypeList", clazzTypeList);

		// 最新课程
		List<Clazz> lastClazz = clazzService.getLastClazz();
		ActionContext.getContext().put("lastClazz", lastClazz);

		return "index";
	}

	public String clazz() {
		// 一级菜单 栏目列表
		List<ClazzMenuDto> firstclazzMenList = clazzService.getFirstClazzMenu();
		ActionContext.getContext().put("firstclazzMenList", firstclazzMenList);

		Clazz clazz = clazzService.getClazzById(clazzId);
		ActionContext.getContext().put("clazz", clazz);
		return "clazz";
	}

	public String search() {
		// 一级菜单 栏目列表
		List<ClazzMenuDto> firstclazzMenList = clazzService.getFirstClazzMenu();
		ActionContext.getContext().put("firstclazzMenList", firstclazzMenList);

		// 课程类型
		List<ClazzType> clazzTypeList = clazzService.getAllFileType();
		ActionContext.getContext().put("clazzTypeList", clazzTypeList);

		List<Clazz> clazzList = clazzService.searchClazz(pmenuId, menuId,
				clazzTypeId, keyWord);
		PageBean pageBean = clazzService.getClazzPageBean(pmenuId, menuId,
				clazzTypeId, keyWord, currentPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		ActionContext.getContext().put("clazzList", clazzList);
		
		if(pmenuId!=null){
			List<ClazzMenuDto> childMenuList = clazzService.getSecondClazzMenu(pmenuId);
			ActionContext.getContext().put("childMenuList", childMenuList);
		}
		return "toResult";
	}

	// public String clazzMenu() {
	// // TODO 通过传 pmenuId 来获取下级的clazz信息
	//
	// // 一级菜单 栏目列表
	// List<ClazzMenuDto> firstclazzMenList = clazzService.getFirstClazzMenu();
	// ActionContext.getContext().put("firstclazzMenList", firstclazzMenList);
	//
	// // 课程类型
	// List<ClazzType> clazzTypeList = clazzService.getAllFileType();
	// ActionContext.getContext().put("clazzTypeList", clazzTypeList);
	//
	// ClazzMenu clazzMenu = clazzService.getClazzMenuByid(pmenuId);
	// List<Clazz> clazzList = new ArrayList<Clazz>();
	// for (ClazzMenu secondClazzMenu : clazzMenu.getChildrenClassMenu()) {
	// for (Clazz clazz : secondClazzMenu.getClazzs()) {
	// clazzList.add(clazz);
	// }
	// }
	// ActionContext.getContext().put("clazzMenu", clazzMenu);
	// ActionContext.getContext().put("clazzList", clazzList);
	// return "toResult";
	// }

	// public String secondClazzMenu() {
	// // TODO 获取二级菜单信息
	// // 已经菜单 栏目列表
	// List<ClazzMenuDto> firstclazzMenList = clazzService.getFirstClazzMenu();
	// ActionContext.getContext().put("firstclazzMenList", firstclazzMenList);
	//
	// // 课程类型
	// List<ClazzType> clazzTypeList = clazzService.getAllFileType();
	// ActionContext.getContext().put("clazzTypeList", clazzTypeList);
	//
	// ClazzMenu clazzMenu = clazzService.getClazzMenuByid(menuId);
	// ActionContext.getContext().put("clazzMenu", clazzMenu);
	// ActionContext.getContext().put("clazzList",
	// clazzMenu.getChildrenClassMenu());
	// return "toResult";
	// }

	public String download() {
		Clazz clazz = clazzService.getClazzById(clazzId);
		this.filename = clazz.getFilename();
		this.fileContentType = clazz.getFielContentType();
		this.inputPath = "/file/clazz/clazz/" + this.filename;
		System.out.println(inputPath);
		return "download";
	}

	public Long getClazzId() {
		return clazzId;
	}

	public void setClazzId(Long clazzId) {
		this.clazzId = clazzId;
	}

	public Long getClazzTypeId() {
		return clazzTypeId;
	}

	public void setClazzTypeId(Long clazzTypeId) {
		this.clazzTypeId = clazzTypeId;
	}

	public ClazzService getClazzService() {
		return clazzService;
	}

	public void setClazzService(ClazzService clazzService) {
		this.clazzService = clazzService;
	}

	public List<ClazzMenuDto> getSecondClazzMenuDto() {
		return secondClazzMenuDto;
	}

	public void setSecondClazzMenuDto(List<ClazzMenuDto> secondClazzMenuDto) {
		this.secondClazzMenuDto = secondClazzMenuDto;
	}

	public Long getPmenuId() {
		return pmenuId;
	}

	public void setPmenuId(Long pmenuId) {
		this.pmenuId = pmenuId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public InputStream getInputStream() throws Exception {
		return ServletActionContext.getServletContext().getResourceAsStream(
				inputPath);
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

}
