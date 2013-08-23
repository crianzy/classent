package com.czy.myclass.admin.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myclass.action.BaseAction;
import com.czy.myclass.domain.News;
import com.czy.myclass.domain.NewsType;
import com.czy.myclass.dto.NewsFormDto;
import com.czy.myclass.util.Upload;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class NewsEidtAction extends BaseAction implements
		ModelDriven<NewsFormDto> {
	private static final long serialVersionUID = -918259509896619880L;
	private String m = "news";
	private File imgFile;
	private String imgFileContentType;
	private String imgFileFileName;
	private NewsFormDto newsDto = new NewsFormDto();

	public String pubNewsUI() {
		List<NewsType> newsTypeList = newsService.getAllNewTypeList();
		ActionContext.getContext().put("newsTypeList", newsTypeList);
		if (newsDto.getId() != null) {
			News news = newsService.getNewsById(newsDto.getId());
			ActionContext.getContext().put("news", news);
		}
		return "editUI";
	}

	public String save() {
		if (imgFile != null) {
			this.imgFileFileName = new Date().getTime() + this.imgFileFileName;
			File imageFile = new File(ServletActionContext.getServletContext()
					.getRealPath("/file/news") + "/" + this.imgFileFileName);
			Upload.copy(this.imgFile, imageFile);
			newsDto.setImg(this.imgFileFileName);
		}
		newsService.saveNews(newsDto);
		return "toNewsManage";
	}

	// ----------------------------------------

	@Override
	public NewsFormDto getModel() {
		return newsDto;
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

	public NewsFormDto getNewsDto() {
		return newsDto;
	}

	public void setNewsDto(NewsFormDto newsDto) {
		this.newsDto = newsDto;
	}

	public String getM() {
		return m;
	}

	public void setM(String m) {
		this.m = m;
	}

}
