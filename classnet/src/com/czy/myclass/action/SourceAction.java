package com.czy.myclass.action;

import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myclass.domain.Clazz;
import com.czy.myclass.domain.News;
import com.czy.myclass.domain.Source;
import com.czy.myclass.domain.SourceMenu;
import com.czy.myclass.service.ClazzService;
import com.czy.myclass.service.NewsSevrice;
import com.czy.myclass.service.SourceService;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class SourceAction {

	@Resource
	private SourceService sourceService;
	@Resource
	private ClazzService clazzService;
	@Resource
	private NewsSevrice newsSevrice;

	private Long sourceMenuId;
	private Long sourceId;
	private String inputPath;
	private String filename;
	private String fileContentType;

	public String index() {
		// 热点新闻
		List<News> hotNewsList = newsSevrice.getHotNews();
		ActionContext.getContext().put("hotNewsList", hotNewsList);
		// 推荐课程
		List<Clazz> tuiJianClazzList = clazzService.getTuiJianClazz(4);
		ActionContext.getContext().put("tuiJianClazzList", tuiJianClazzList);
		// 资源栏
		List<SourceMenu> sourceMenuList = sourceService.getAllSource();
		ActionContext.getContext().put("sourceMenuList", sourceMenuList);
		return "index";
	}

	public String sourceMenu() {
		// 热点新闻
		List<News> hotNewsList = newsSevrice.getHotNews();
		ActionContext.getContext().put("hotNewsList", hotNewsList);
		// 推荐课程
		List<Clazz> tuiJianClazzList = clazzService.getTuiJianClazz(4);
		ActionContext.getContext().put("tuiJianClazzList", tuiJianClazzList);
		// 资源栏
		List<SourceMenu> sourceMenuList = sourceService.getAllSource();
		ActionContext.getContext().put("sourceMenuList", sourceMenuList);
		// 资源 sourceMenu
		SourceMenu sourceMenu = sourceService.getSourceMenu(sourceMenuId);
		ActionContext.getContext().put("sourceMenu", sourceMenu);
		return "sourceMenu";
	}

	public InputStream getInputStream() throws Exception {
		return ServletActionContext.getServletContext().getResourceAsStream(inputPath);
	}

	public String download() {
		Source source = sourceService.getSource(sourceId);
		this.filename = source.getFilename();
		this.fileContentType = source.getFileContentType();
		this.inputPath = "/file/source/"+this.filename;
		return "download";
	}

	public Long getSourceMenuId() {
		return sourceMenuId;
	}

	public void setSourceMenuId(Long sourceMenuId) {
		this.sourceMenuId = sourceMenuId;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

}
