package com.czy.myclass.admin.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class NewsAdminAction extends BaseAdminAction{

	private static final long serialVersionUID = -3962721334206157954L;
	private String m ="news";

	
}
