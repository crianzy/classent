<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>注册成功</title>
<link href="css/default.css" rel="stylesheet" type="text/css" />
<link href="css/prompts.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div class="wrap">
		<!--头部定义开始-->
		<div id="header" class="main">
			<jsp:include page="/WEB-INF/jsp/pub/header.jsp"></jsp:include>
		</div>
		<!--头部定义结束-->
		<div id="center_all" class="main">
			<div class="u_management_bg">
				<div class="P_width">
					<div class="Showms">
						<dl class="top"></dl>
						<dl class="content">
							<dd class="content1">
								<div class="Pic">
									<img id="ImgRight" src="/images/P_Right.gif" style="border-width: 0px;" />
								</div>
								<div class="MS">
									<dl>
										<dt class="titWrong">成功信息</dt>
										<dd>
											<li>注册成功！</li>
										</dd>
									</dl>
								</div>
								<div class="clearbox"></div>
								<div class="BUT">
									<a id="LnkReturnUrl" href="home">&lt;&lt;&nbsp;返回上一页</a>
								</div>
							</dd>
						</dl>
						<dl class="bottom"></dl>
						<dl class="Shadow"></dl>
					</div>
					<div class="clearbox"></div>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/jsp/pub/footer.jsp"></jsp:include>
	</div>
	<!-- end -->
</body>
</html>
