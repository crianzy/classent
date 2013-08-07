<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="UTF-8">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="css/default.css" rel="stylesheet" type="text/css" />
		<link href="css/user.css" rel="stylesheet" type="text/css" />
		<title>会员中心--互动交流</title>
		<script type="text/javascript">
			function changeMenu(menuId){
				location="masterAction_myTopicList?topicMenuId="+menuId;
			}
		</script>
	</head>
	<body>
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
								<a href="masterAction_index">会员中心</a>
							</div>
							<div class="c_spacing"></div>
							<div class="u_form1">
								<div style="text-align: center">
									<table width="100%" border="0" cellpadding="0" cellspacing="0">
										<tr align="center">
											<td id="TabTitle0" class="titlemouseover">
												我发布的帖子
											</td>
										</tr>
									</table>
									<table width="100%" border="0" cellpadding="0" cellspacing="0">
										<tr align="center">
											<td height="30" align="left">
												主题目录：
												<select name="topicMenuId" onchange="changeMenu(this.value)" >
	                								<option value="0">请选择目录</option>
	                								<s:iterator	value="menuList">
	                									<option value="${id}" ${topicMenuId==id?'selected=selected':''}>${name}</option>
	                								</s:iterator>
	                							</select>
											</td>
										</tr>
									</table>
									<table class="border" id="EgvContent" style="width: 100%;" border="0" cellpadding="0" cellspacing="1">
										<tr class="Gdvspacingtitle" style="height: 25px;" align="center">
											<th scope="col" style="width: 7%;">ID</th>
											<th scope="col">标题</th>
											<th scope="col" style="width: 10%;">目录</th>
											<th scope="col" style="width: 15%;">发布时间</th>
										</tr>
											<s:if test="#topicList!=null">
											<s:iterator value="#topicList" status="vs">
												<tr class="tdbg" align="center">
													<td height="22">${vs.index+1}</td>
													<td align="left" style="font-weight: bold;">
		                								<a href="topicAction_topic?topicId=${id }">${title}</a>
		                							</td>
		                							<td align="center">
		                								${topicMenu.name}
		                							</td>
		                							<td align="center">
		                								<s:date name="pubTime" format="yyyy-MM-dd HH:mm"/>
		                							</td> 
												</tr>
											</s:iterator>
											</s:if>
											<s:else>
											<tr class="tdbg" align="center">
												<td colspan="5" height="24" align="center">暂无记录</td>
											</tr>
											</s:else>
									</table>
								</div>
								<div class="class_page"><span class="pagecss">
								 	分页
								 </span></div>
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
