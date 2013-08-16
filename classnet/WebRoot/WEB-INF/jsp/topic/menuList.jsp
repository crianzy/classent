<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="UTF-8">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>互动交流</title>
<link href="css/default.css" rel="stylesheet" type="text/css" />
<link href="css/article.css" rel="stylesheet" type="text/css" />
<script>
	function gotoPage(num){
		location = "topicAction_menuList?topicMenuId="+${topicMenuId}+"&currentPage="+num;
	}
</script>
<style type="text/css">
/* 分页 */
.class_page_topic {
	clear: left;
	text-align: left;
	color: #4C9DCE;
}

.class_page_topic ul,.class_page_topic li {
	padding: 0px;
	margin: 0px 0px 0px 10px;
	text-align: left;
	list-style: none;
}

.class_page_topic a,.class_page_topic strong {
	display: inline-block;
	border: 1px solid #D7E5F2;
	line-height: 160%;
	text-decoration: none;
	padding: 0 5px;
	color: #4C9DCE;
}

.class_page_topic strong {
	background: #5384AF;
	color: #fff;
}
</style>
</head>
<body>
<s:debug></s:debug>
	<div class="wrap">
			<!--头部定义开始-->
			<div id="header" class="main">
				<jsp:include page="/WEB-INF/jsp/pub/header.jsp"></jsp:include>
			</div>
			<!--头部定义结束-->
			<div id="center_all" class="main">
				<div id="main_bg">
					<div id="sideBar">
						<jsp:include page="/WEB-INF/jsp/userbox.jsp"></jsp:include>
						<div class="left_box">
							<dl>
								<dt><em>栏目列表</em></dt>
								<dd>
									<ul class="subjectList">
										<s:iterator value="#topicMenuList">
										<li><a href="topicAction_menuList?topicMenuId=${id }">${name }</a></li>
										</s:iterator>
										<div class="clearbox"></div>
									</ul>
								</dd>
							</dl>
						</div>
					</div>
					<div id="" style="float:right;width: 750px;">
						<div class="">
								<!-- 网站位置导航信息开始 -->
								<div class="r_navigation">
									您现在的位置： <a href="home">精品课程网</a>&gt;&gt; 
									<a href="topicAction_index"><span class="current">互动交流</span></a>&gt;&gt;
									<a href="topicAction_menuList?topicMenuId=${topicMeun.id }">${topicMeun.name }</a> 
								</div>
								<!-- 网站位置导航信息结束 -->
								<table width="100%" border="0" cellpadding="0" cellspacing="0" style="border:1px solid #a8d7f1">
								<tr>
									<td align="left" width="70%" height="20">
										<jsp:include page="/WEB-INF/jsp/pub/page.jsp" ></jsp:include>
									</td>
									<td align="right" height="20">
										<s:if test="#session.user!=null">
										<input type="button" value="发帖" onclick="location='master/masterAction_postTopicUI?topicMenuId=${topicMeun.id }';"/>
										</s:if>
									</td>
								</tr>
								</table>
								<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8d7f1">
								<tr>
									<td width="60%" align="left" height="30" style="padding-left:6px;color:#ffffff;font-weight: bold;">标题</td>
									<td width="15%" align="center" style="color:#ffffff;font-weight: bold;">发帖人</td>
									<td width="10%" align="center" style="color:#ffffff;font-weight: bold;">回复</td>
									<td width="15%" align="center" style="color:#ffffff;font-weight: bold;">最后更新</td>
								</tr>
								<s:if test="list!=null">
									<s:iterator value="list">
									<tr>
										<td align="left" height="40" bgcolor="${vs.index%2==1?'#e8e9f9':'#ffffff'}" style="padding-left:6px;"><a href="topicAction_topic?topicId=${id }">${title}</a></td>
										<td align="center" bgcolor="${vs.index%2==1?'#e8e9f9':'#ffffff'}">${user.username}<p><s:date name="pubTime" format="MM-dd HH:mm" /></p></td>
										<td align="center" bgcolor="${vs.index%2==1?'#e8e9f9':'#ffffff'}">${replyNum}</td>
										<td align="center" bgcolor="${vs.index%2==1?'#e8e9f9':'#ffffff'}">${editUsername}<p><s:date name="pubTime" format="MM-dd HH:mm" /></p></td>
									</tr>								
									</s:iterator>
								</s:if>
								<s:else>
									<tr>
										<td colspan="4" bgcolor="#ffffff" height="30">暂无帖子</td>
									</tr>
								</s:else>
								</table>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" style="border:1px solid #a8d7f1">
								<tr>
									<td align="left" width="70%" height="20">
										<jsp:include page="/WEB-INF/jsp/pub/page.jsp" ></jsp:include>
									</td>
									<td align="right" height="20">
										<s:if test="#session.user!=null">
											<input type="button" value="发帖" onclick="location='master/masterAction_postTopicUI?topicMenuId=${topicMeun.id }';"/>
										</s:if>
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
