<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="UTF-8">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>${topic.title}--互动交流</title>
		<link href="css/default.css" rel="stylesheet" type="text/css" />
		<link href="css/article.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="fckeditor/fckeditor.js"></script>
		<script type="text/javascript">
			function gotoPage(num){
				location="topicAction_topic?topicId="+${topicId}+"&currentPage="+num
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
					<div id="" style="width: 100%;">
						<div class="">
								<!-- 网站位置导航信息开始 -->
								<div class="r_navigation">
									您现在的位置：
									<a href="home">校园精品网</a>&gt;&gt;
									<a href="topicAction_index"><span class="current">互动交流</span></a>&gt;&gt;
									<a href="topicAction_menuList?topicMenuId=${topic.topicMenu.id}">${topic.topicMenu.name}</a>
								</div>
								<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8d7f1" style="margin-top:8px;">
								<tr>
									<td align="left" height="30" style="color:#ffffff;font-weight: bold;padding-left:8px">
										 ${topic.title}
									</td>
								</tr>
								</table>
								<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8d7f1" style="margin-top:8px;">
								<tr>
									<td width="20%" bgcolor="#e8e9f9" rowspan="3">
										<table width="100%" border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td align="left" valign="middle" style="padding-left:30px;">
												<img src="images/photo.jpg" width="120" height="120"/>
											</td>
										</tr>
										<tr>
											<td style="padding-top:10px;;padding-left:30px;font-weight: bold;" align="left">
												${topic.user.username}
											</td>
										</tr>
										</table>
									</td>
									<td width="80%" height="24" align="left" bgcolor="#e8e9f9">
									<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td align="left" height="24" style="padding-left:10px;">发表于：<s:date name="#topic.pubTime" format="yyyy-MM-dd HH:mm:ss"/></td>	
										<td align="right" style="padding-right:10px;font-weight: bold;">楼主</td>
									</tr>
									</table>
									</td>
								</tr>
								<tr>
									<td height="160" bgcolor="#e8e9f9" align="left" valign="top" style="padding:10px;">
										${topic.detail}
									</td>
								</tr>
								<tr>
									<td bgcolor="#e8e9f9" height="24">
									<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td align="left" height="24" style="padding-left:10px;">回复次数：${topic.replyNum}</td>	
										<td align="right" style="padding-right:10px;font-weight: bold;"><a href="#">TOP</a></td>
									</tr>
									</table>
									</td>
								</tr>
								</table>
								<s:if test="#topic.answers!=null">
								<s:iterator value="list" >
								<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8d7f1" style="margin-top:8px;">
								<tr>
									<td width="20%" bgcolor="#ffffff" rowspan="3">
										<table width="100%" border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td align="left" valign="middle" style="padding-left:30px;">
												<img src="images/photo.jpg" width="120" height="120"/>
											</td>
										</tr>
										<tr>
											<td style="padding-top:10px;;padding-left:30px;font-weight: bold;" align="left">
												${user.username}
											</td>
										</tr>
										</table>
									</td>
									<td width="80%" height="24" align="left" bgcolor="#ffffff">
									<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td align="left" height="24" style="padding-left:10px;">发表于：<s:date name="pubTime" format="yyyy-MM-dd HH:mm:ss"/></td>	
										<td align="right" style="padding-right:10px;font-weight: bold;"># ${flowNum}楼</td>
									</tr>
									</table>
									</td>
								</tr>
								<tr>
									<td height="160" bgcolor="#ffffff" align="left" valign="top" style="padding:10px;">
										<s:if test="status==1">
											${content}
										</s:if>
										<s:else>
											<span style="color:red;background-color: yellow">该回复已经被管理员屏蔽</span>
										</s:else>
									</td>
								</tr>
								<tr>
									<td bgcolor="#ffffff" height="24">
									<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td align="left" height="24" style="padding-left:10px;">
											<a href="javascript:pingbi(${id })"><font style="color:red">屏蔽该回复</font></a>
											<script>
												function pingbi(id){
													$.ajax({
														type:"get",
														url:"admin/topicAdminAction_pingbiAnswer?",
														data:"topicAnswerId="+id,
														success:function(msg){
															if(msg.flag=="1"){
																alert("操作成功");
																location.href=location.href;
															}
															else{
																alert("操作失败");
															}
														}
													});
												}
											</script>
										</td>	
										<td align="right" style="padding-right:10px;font-weight: bold;"><a href="#">TOP</a></td>
									</tr>
									</table>
									</td>
								</tr>
								</table>
								</s:iterator>
								<table width="100%" border="0" cellpadding="0" cellspacing="1" style="margin-top:8px;border:1px solid #a8d7f1">
									<tr >
										<td></td>
										<td align="right" width="80%" height="20">
											<jsp:include page="/WEB-INF/jsp/pub/page.jsp" ></jsp:include>
										</td>
									</tr>
								</table>
								</s:if>
								<table width="100%" border="0" cellpadding="0" cellspacing="1" style="margin-top:8px;border:1px solid #a8d7f1">
								<tr>
									<td width="20%" valign="top" align="center">
										<table width="90%" border="0" cellpadding="0" cellspacing="0" style="border:1px solid #a8d7f1;margin-top:10px;margin-bottom:10px;">
										</table>
									</td>
									<td width="80%" valign="top">
										<form action="topicAction_reply" method="post" style="margin:0" onsubmit="return check()">
										<script type="text/javascript">
											function check(){
												var oEditor = FCKeditorAPI.GetInstance("content");            
										        if(oEditor.GetXHTML() == "" || oEditor.GetXHTML() == "<br />"){  
										            alert("内容不能为空！");  
										            return false;  
										        }  
										        return true;
											}
										</script>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" style="margin-top:10px;">
										<tr><td align="left" height="30">
											<span style="font-weight: bold;">回复内容</span>
											<s:if test="#session.user == null">
												匿名用户不能发表回复！ 
											<a href="userAction_loginUI?url=topicAction_topic?topicId=${topic.id }"><font style="color:red">登录</font></a> | <a href="userAction_registUI" ><font style="color:red">注册</font></a>
											</s:if>
										</td></tr>
										<s:else>
										<tr>
											<td align="left"><textarea id="content" name="content" ${empty user?'disabled=disabled':'' }></textarea></td>
											<script type="text/javascript">
												var oFCKeditor = new FCKeditor('content') ;
												oFCKeditor.BasePath	= "${pageContext.request.contextPath}/fckeditor/";
												oFCKeditor.Width="740";
												oFCKeditor.Height="240";
												oFCKeditor.Value="&nbsp;&nbsp;&nbsp;&nbsp;";
												oFCKeditor.ToolbarSet="classnet";
												oFCKeditor.Config["CustomConfigurationsPath"]="${pageContext.request.contextPath}/fckeditor/replyconfig.js?d="+new Date().getTime();
												oFCKeditor.ReplaceTextarea(); 
											</script>
										</tr>
										<tr>
											<td align="center" height="30">
												<input type="submit" value="提交回复" ${empty user?'disabled=disabled':''} />
												<input type="hidden" name="topicId" value="${topic.id}"/>
											</td>
										</tr>
										</s:else>
										</table>
										</form>
									</td>
								</tr>
								</table>
							</div>
					</div>
					
				</div>
			</div>
			<div class="clearbox"></div>
			<jsp:include page="/WEB-INF/jsp/pub/footer.jsp"></jsp:include>
		</div>
	</body>
</html>

