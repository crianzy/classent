package com.czy.myclass.admin.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myclass.domain.News;
import com.czy.myclass.domain.NewsType;
import com.czy.myclass.dto.NewsFormDto;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class NewsEidtAction extends BaseAdminAction implements
		ModelDriven<NewsFormDto> {
	private static final int BUFFER_SIZE = 16 * 1024;
	private static final long serialVersionUID = -918259509896619880L;

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
			copy(this.imgFile, imageFile);
			newsDto.setImg(this.imgFileFileName);
		}
		newsService.saveNews(newsDto);
		return "toNewsManage";
	}

	// ----------------------------------------
	private static void copy(File src, File dst) {
		try {
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(src),
						BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(dst),
						BUFFER_SIZE);
				byte[] buffer = new byte[BUFFER_SIZE];
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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

}
