package com.czy.myclass.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class RedirectAction extends ActionSupport{
	private static final long serialVersionUID = -162139238245967731L;
	
	
	@Override
	public String execute() throws Exception {
		ActionContext.getContext().getValueStack().findValue("");
		return super.execute();
	}

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
