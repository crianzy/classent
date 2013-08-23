<%@ page language="java" import="java.util.*,com.opensymphony.xwork2.ActionContext;" pageEncoding="UTF-8"%>
<%
	String url = (String)ActionContext.getContext().getValueStack().findValue("url");
	response.sendRedirect(url);
%>

