package com.czy.myclass.admin.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class TopicAdminAction extends BaseAdminAction{

	private static final long serialVersionUID = 2083500023104117426L;

	private String m ="topic";
	
}
