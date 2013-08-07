package com.czy.myclass.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class CheckUsernameAction extends BaseAction {

	private static final long serialVersionUID = 2687505252508687628L;

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
