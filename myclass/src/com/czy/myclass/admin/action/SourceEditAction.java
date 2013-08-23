package com.czy.myclass.admin.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myclass.action.BaseAction;
import com.czy.myclass.domain.Source;
import com.czy.myclass.domain.SourceMenu;
import com.czy.myclass.util.Upload;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;


@Controller
@Scope("prototype")
public class SourceEditAction extends BaseAction implements
		ModelDriven<Source> {
	private static final long serialVersionUID = -3963573248717793468L;
	private String m = "source";
	private Source sourceModel = new Source();
	private Long sourceId;
	private Long menuId;
	private File sourceFile;
	private String sourceFileContentType;
	private String sourceFileFileName;
	
	public String editUI(){
		if(sourceId!=null){
			Source source = sourceService.getSource(sourceId);
			ActionContext.getContext().put("source", source);
		}
		List<SourceMenu> menuList = sourceService.getAllSourceMenu();
		ActionContext.getContext().put("menuList", menuList);
		return "editUI";
	}
	
	public String save(){
		if (sourceFile != null) {
			this.sourceFileFileName = new Date().getTime() + this.sourceFileFileName;
			File sourcefile = new File(ServletActionContext.getServletContext()
					.getRealPath("/file/source")
					+ "/"
					+ this.sourceFileFileName);
			Upload.copy(this.sourceFile, sourcefile);
			Long length = sourcefile.length()>>10;
			String str = length.intValue()+"";
			sourceModel.setFileSize(str);
			sourceModel.setFilename("file/source/"+sourceFileFileName);
			sourceModel.setFileContentType(sourceFileContentType);
		}
		sourceService.saveSource(sourceModel,menuId);
		return "toSourceList";
	}
	
	public String updata(){
		if (sourceFile != null) {
			this.sourceFileFileName = new Date().getTime() + this.sourceFileFileName;
			File sourcefile = new File(ServletActionContext.getServletContext()
					.getRealPath("/file/source")
					+ "/"
					+ this.sourceFileFileName);
			Upload.copy(this.sourceFile, sourcefile);
			Long length = sourcefile.length()>>10;
			String str = length.intValue()+"";
			sourceModel.setFileSize(str);
			sourceModel.setFilename("file/source/"+sourceFileFileName);
			sourceModel.setFileContentType(sourceFileContentType);
		}
		sourceService.updataSource(sourceModel,menuId);
		return "toSourceList";
	}

	public String getM() {
		return m;
	}

	public void setM(String m) {
		this.m = m;
	}

	public Source getSourceModel() {
		return sourceModel;
	}

	public void setSourceModel(Source sourceModel) {
		this.sourceModel = sourceModel;
	}

	public File getSourceFile() {
		return sourceFile;
	}

	public void setSourceFile(File sourceFile) {
		this.sourceFile = sourceFile;
	}

	public String getSourceFileContentType() {
		return sourceFileContentType;
	}

	public void setSourceFileContentType(String sourceFileContentType) {
		this.sourceFileContentType = sourceFileContentType;
	}

	public String getSourceFileFileName() {
		return sourceFileFileName;
	}

	public void setSourceFileFileName(String sourceFileFileName) {
		this.sourceFileFileName = sourceFileFileName;
	}

	@Override
	public Source getModel() {
		return sourceModel;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

}
