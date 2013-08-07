package com.czy.myclass.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myclass.dto.ClazzMenuDto;

@Controller
@Scope("prototype")
public class ChangeMenuAction extends BaseAction {

	private static final long serialVersionUID = -8420433734580207594L;

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
