package com.czy.myclass.admin.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class UserAdminAction extends BaseAdminAction {

	private static final long serialVersionUID = -4368336719368356726L;
	private String m = "index";
}
