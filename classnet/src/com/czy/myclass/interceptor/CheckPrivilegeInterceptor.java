package com.czy.myclass.interceptor;

import com.czy.myclass.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckPrivilegeInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 2931177661252126023L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		User user = (User) ActionContext.getContext().getSession().get("user");
		if (user==null||!"ROLE_SUPERVISOR".equals(user.getAuthorite())) {
			return "noPrivilege";
		} else {
			return invocation.invoke();
		}
	}

}
