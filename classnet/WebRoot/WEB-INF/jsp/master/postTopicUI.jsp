<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="css/default.css" rel="stylesheet" type="text/css" />
		<link href="css/user.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="fckeditor/fckeditor.js"></script>
		<title>会员中心--发布主题</title>
		<script type="text/javascript">
		function check(form){
			if(form.title.value==""){
				alert("标题不能为空");
				return false;
			}
			if(form.menuId.value==0){
				alert("目录没有选择");
				return false;
			}
			if(form.content.value==""||form.content.value=="<br />"){
				alert("详细内容不能为空");
				return false;
			}
			return true;
		}
		</script>
	</head>
	<body>
	<!-- 从 贴子那边传来 需要传 TopicMenu -->
		<div class="wrap">
			<!--头部定义开始-->
			<div id="header" class="main">
				<jsp:include page="/WEB-INF/jsp/pub/header.jsp"></jsp:include>
			</div>
			<!--头部定义结束-->
			<div id="center_all" class="main">
				<div id="main_bg">
					<div id="main_right">
						<div id="main_right_box">
							<div class="r_navigation">
								您现在的位置：
								<a href="home">精品课程网
								</a>&gt;&gt;
								<a href="master/masterAction_index">会员中心</a>
							</div>
							<div class="c_spacing"></div>
							<div class="u_form1">
								<div style="text-align: center">
									<table width="100%" border="0" cellpadding="0" cellspacing="0">
										<tr align="center">
											<td id="TabTitle0" class="titlemouseover">
												发布主题
											</td>
										</tr>
									</table>
									<form action="master/masterAction_postTopic" method="post" onsubmit="return check(this)">
									<table class="border" id="EgvContent" style="width: 100%;" border="0" cellpadding="0" cellspacing="1">
										<tr class="tdbg" align="center">
											<td height="25" width="12%" align="right" style="padding-right:8px">标题:</td>
											<td align="left" style="padding-left:8px">
	                							<input type="text" name="title" size="60" maxlength="200"/>
	                						</td>
										</tr>
										<tr class="tdbg" align="center">
											<td height="25" align="right" style="padding-right:8px">选择目录:</td>
											<td align="left" style="padding-left:8px">
	                							<select name="TopicMenuId">
	                								<option value="0">请选择目录</option>
	                									<s:iterator	value="menuList">
	                										<option value="${id}" ${topicMenuId==id?'selected=selected':''} >${name}</option>
	                									</s:iterator>
	                							</select>
	                						</td>
										</tr>
										<tr class="tdbg" align="center">
											<td height="25" align="right" style="padding-right:8px">详细内容:</td>
											<td align="left" style="padding-left:8px;line-height: 22px">
	                							<textarea name="content"></textarea>
	                							<script type="text/javascript">
													var oFCKeditor = new FCKeditor('content') ;
													oFCKeditor.BasePath	= "${pageContext.request.contextPath}/fckeditor/";
													oFCKeditor.Width="620";
													oFCKeditor.Height="340";
													oFCKeditor.Value="&nbsp;&nbsp;&nbsp;&nbsp;";
													oFCKeditor.ToolbarSet="classnet";
													oFCKeditor.Config["CustomConfigurationsPath"]="${pageContext.request.contextPath}/fckeditor/myconfig.js?d="+new Date().getTime();
													oFCKeditor.ReplaceTextarea();
												</script>
	                						</td>
										</tr>
										<tr class="tdbg" align="center">
											<td height="30" align="right" style="padding-right:8px"></td>
											<td align="left" style="padding-left:8px">
	                							<input type="submit" value="发帖" />
	                							<s:if test="#topicMenu!=null">
	                								<input type="button" value="返回" onclick="javascript:history.back(-1);"/>
	                							</s:if>
	                						</td>
										</tr>
									</table>
									</form>
								</div>
							</div>
						</div>
					</div>
					<!-- 我的控制菜单开始 -->
					<div id="main_left">
						<dl>
							<dt></dt>
							<dd>
								<div id="mg_user_left">
									<ul>
										<li id="menu_1" >
											<a href=#>信息管理</a>
										</li>
									</ul>
								</div>
								<!-- 我的控制菜单开结束 -->
								<div id="mg_user_right">
									<jsp:include page="left.jsp"/>
								</div>
								<div class="clearbox"></div>
								<!-- 用户快捷导航结束 -->
							</dd>
						</dl>
						<div class="clearbox"></div>
					</div>
					<div class="clearbox"></div>
				</div>
			</div>
			<jsp:include page="/WEB-INF/jsp/pub/footer.jsp"></jsp:include>
		</div>

	</body>
</html>
