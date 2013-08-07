package com.czy.myclass.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myclass.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class CheckUsernameAction extends ActionSupport {

	private static final long serialVersionUID = 2687505252508687628L;
	@Resource
	private UserService userService;

	private String username;
	private String usernameFlag;

	@Override
	public String execute() throws Exception {
		if(userService.checkUsernameEnable(username)){
			usernameFlag = "1";
		}
		return super.execute();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsernameFlag() {
		return usernameFlag;
	}

	public void setUsernameFlag(String usernameFlag) {
		this.usernameFlag = usernameFlag;
	}

}
