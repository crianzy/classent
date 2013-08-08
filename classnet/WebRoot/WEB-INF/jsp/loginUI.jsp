<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="UTF-8">
<head>
<base href="<%=basePath%>">
<title>用户登录</title>
<link href="css/default.css" rel="stylesheet" type="text/css" />
<link href="css/prompts.css" rel="stylesheet" type="text/css" />
</head>
</head>

<body>
	<div class="wrap">
		<!--头部定义开始-->
		<div id="header" class="main">
			<jsp:include page="/WEB-INF/jsp/pub/header.jsp"></jsp:include>
		</div>
		<!--头部定义结束-->\
		<div id="center_all" class="main">
			<div class="u_management_bg">
			    <form action="userAction_login" method="post">
			    <input type="hidden" name="url" value="${url }"/>
			      <table width="70%" align="right" style="line-height: 30px;">
			        <tr><td width="50">用户名:</td><td><input type='text' name='username'  /></td></tr>
			        <tr><td>密码:</td><td><input type='password' name='password' /></td></tr>
			        <tr>
			        	<td colspan='2'>
			        		<input name="submit" type="submit" value="登录" />
			        		<input name="reset" type="reset" />
			        	</td>
			        </tr>
			      </table>
			    </form>
			</div>
		</div>
		<div class="clearbox"></div>
			<jsp:include page="/WEB-INF/jsp/pub/footer.jsp"></jsp:include>
	</div>
	
</body>
</html>
