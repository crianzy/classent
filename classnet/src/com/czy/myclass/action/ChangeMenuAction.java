package com.czy.myclass.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myclass.dto.ClazzMenuDto;
import com.czy.myclass.service.ClazzService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class ChangeMenuAction extends ActionSupport {

	private static final long serialVersionUID = -8420433734580207594L;

	@Resource
	private ClazzService clazzService;

	private Long pid;

	private List<ClazzMenuDto> secondClazzMenuDto;
	
	
	@Override
	public String execute() throws Exception {
		secondClazzMenuDto = clazzService.getSecondClazzMenu(pid);
		return "success";
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public List<ClazzMenuDto> getSecondClazzMenuDto() {
		return secondClazzMenuDto;
	}

	public void setSecondClazzMenuDto(List<ClazzMenuDto> secondClazzMenuDto) {
		this.secondClazzMenuDto = secondClazzMenuDto;
	}

}
