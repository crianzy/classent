package com.czy.myclass.admin.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myclass.action.BaseAction;
import com.czy.myclass.domain.Clazz;
import com.czy.myclass.domain.ClazzType;
import com.czy.myclass.dto.ClazzMenuDto;
import com.czy.myclass.util.Upload;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class ClazzEditAction extends BaseAction implements ModelDriven<Clazz> {
	private static final long serialVersionUID = -8633937618808225658L;
	private String m = "clazz";
	private Clazz clazz = new Clazz();

	private File imgFile;
	private String imgFileContentType;
	private String imgFileFileName;

	private File clazzFile;
	private String clazzFileContentType;
	private String clazzFileFileName;

	private File flashFile;
	private String flashFileContentType;
	private String flashFileFileName;

	private Long clazzId;
	private Long pid;
	private Long clazzTypeId;
	private Long clazzMenuId;

	public String editUI() {
		List<ClazzMenuDto> parentMenuList = clazzService.getFirstClazzMenu();
		ActionContext.getContext().put("parentMenuList", parentMenuList);
		List<ClazzType> clazzTypeList = clazzService.getAllFileType();
		ActionContext.getContext().put("clazzTypeList", clazzTypeList);
		if (clazzId != null) {
			Clazz clazzt = clazzService.getClazzById(clazzId);
			ActionContext.getContext().put("clazzt", clazzt);
			List<ClazzMenuDto> childMenuList = clazzService
					.getSecondClazzMenu(clazzt.getClazzMenu()
							.getParentClassMenu().getId());
			ActionContext.getContext().put("childMenuList", childMenuList);
		}
		return "editUI";
	}

	public String add() {
		if (imgFile != null) {
			this.imgFileFileName = new Date().getTime() + this.imgFileFileName;
			File imageFile = new File(ServletActionContext.getServletContext()
					.getRealPath("/file/clazz/img")
					+ "/"
					+ this.imgFileFileName);
			Upload.copy(this.imgFile, imageFile);
			clazz.setImg(this.imgFileFileName);
		}

		if (clazzFile != null) {
			this.clazzFileFileName = new Date().getTime()
					+ this.clazzFileFileName;
			File imageFile = new File(ServletActionContext.getServletContext()
					.getRealPath("/file/clazz/clazz")
					+ "/"
					+ this.clazzFileFileName);
			Upload.copy(this.clazzFile, imageFile);
			clazz.setFilename(this.clazzFileFileName);
			clazz.setFielContentType(this.clazzFileContentType);
		}

		if (flashFile != null) {
			this.flashFileFileName = new Date().getTime()
					+ this.flashFileFileName;
			File imageFile = new File(ServletActionContext.getServletContext()
					.getRealPath("/file/clazz/flash")
					+ "/"
					+ this.flashFileFileName);
			Upload.copy(this.flashFile, imageFile);
			clazz.setFlashFilename(this.flashFileFileName);
		}
		clazzService.addClazz(clazz, clazzMenuId, clazzTypeId);
		return "toClazzList";
	}

	public String edit() {
		if (imgFile != null) {
			this.imgFileFileName = new Date().getTime() + this.imgFileFileName;
			File imageFile = new File(ServletActionContext.getServletContext()
					.getRealPath("/file/clazz/img")
					+ "/"
					+ this.imgFileFileName);
			Upload.copy(this.imgFile, imageFile);
			clazz.setImg(this.imgFileFileName);
		}

		if (clazzFile != null) {
			this.clazzFileFileName = new Date().getTime()
					+ this.clazzFileFileName;
			File imageFile = new File(ServletActionContext.getServletContext()
					.getRealPath("/file/clazz/clazz")
					+ "/"
					+ this.clazzFileFileName);
			Upload.copy(this.clazzFile, imageFile);
			clazz.setFilename(this.clazzFileFileName);
		}

		if (flashFile != null) {
			this.flashFileFileName = new Date().getTime()
					+ this.flashFileFileName;
			File imageFile = new File(ServletActionContext.getServletContext()
					.getRealPath("/file/clazz/flash")
					+ "/"
					+ this.flashFileFileName);
			Upload.copy(this.flashFile, imageFile);
			clazz.setFlashFilename(this.flashFileFileName);
		}
		clazzService.updataClazz(clazz, clazzMenuId, clazzTypeId);
		return "toClazzList";
	}

	public String getChildMenuList() {
		return "json";
	}


	@Override
	public Clazz getModel() {
		return clazz;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public File getImgFile() {
		return imgFile;
	}

	public void setImgFile(File imgFile) {
		this.imgFile = imgFile;
	}

	public String getImgFileContentType() {
		return imgFileContentType;
	}

	public void setImgFileContentType(String imgFileContentType) {
		this.imgFileContentType = imgFileContentType;
	}

	public String getImgFileFileName() {
		return imgFileFileName;
	}

	public void setImgFileFileName(String imgFileFileName) {
		this.imgFileFileName = imgFileFileName;
	}

	public File getClazzFile() {
		return clazzFile;
	}

	public void setClazzFile(File clazzFile) {
		this.clazzFile = clazzFile;
	}

	public String getClazzFileContentType() {
		return clazzFileContentType;
	}

	public void setClazzFileContentType(String clazzFileContentType) {
		this.clazzFileContentType = clazzFileContentType;
	}

	public String getClazzFileFileName() {
		return clazzFileFileName;
	}

	public void setClazzFileFileName(String clazzFileFileName) {
		this.clazzFileFileName = clazzFileFileName;
	}

	public File getFlashFile() {
		return flashFile;
	}

	public void setFlashFile(File flashFile) {
		this.flashFile = flashFile;
	}

	public String getFlashFileContentType() {
		return flashFileContentType;
	}

	public void setFlashFileContentType(String flashFileContentType) {
		this.flashFileContentType = flashFileContentType;
	}

	public String getFlashFileFileName() {
		return flashFileFileName;
	}

	public void setFlashFileFileName(String flashFileFileName) {
		this.flashFileFileName = flashFileFileName;
	}

	public Long getClazzId() {
		return clazzId;
	}

	public void setClazzId(Long clazzId) {
		this.clazzId = clazzId;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long getClazzTypeId() {
		return clazzTypeId;
	}

	public void setClazzTypeId(Long clazzTypeId) {
		this.clazzTypeId = clazzTypeId;
	}

	public Long getClazzMenuId() {
		return clazzMenuId;
	}

	public void setClazzMenuId(Long clazzMenuId) {
		this.clazzMenuId = clazzMenuId;
	}

	public String getM() {
		return m;
	}

	public void setM(String m) {
		this.m = m;
	}

}
