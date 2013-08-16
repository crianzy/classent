package com.czy.myclass.interceptor;

import com.czy.myclass.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckLoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -2344787632565849076L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		User user = (User) ActionContext.getContext().getSession().get("user");
		if (user == null) {
			return "loginUI";
		} else {
			return invocation.invoke();
		}
	}

}
