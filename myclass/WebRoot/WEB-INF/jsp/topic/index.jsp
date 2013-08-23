<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="UTF-8">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>互动交流</title>
<link href="css/default.css" rel="stylesheet" type="text/css" />
<link href="css/article.css" rel="stylesheet" type="text/css" />
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
				<div id="sideBar">
					<jsp:include page="/WEB-INF/jsp/userbox.jsp"></jsp:include>
					<div class="left_box">
						<dl>
							<dt>
								<em>栏目列表</em>
							</dt>
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
							您现在的位置： <a href="home">精品课程网</a>&gt;&gt; <a
								href="topicAction_index"><span class="current">互动交流</span>
							</a>
						</div>
						<!-- 父栏目列表信息列表开始 -->
						<div class="classlist_box">
							<!-- 栏目循环列表开始 -->
							<s:iterator value="topicMenuList">
								<div class="classBox">
									<h4>
										<a href="topicAction_menuList?topicMenuId=${id }">${name }</a>
									</h4>
									<ul class="listStyle1">
										<s:iterator value="topics">
											<li><a href="topicAction_topic?topicId=${id }">${title
													}</a> [发布人:<span style="color:#1177b9">${user.username }</span>]
												[时间：<span style="color:#1177b9"><s:date
														name="pubTime" format="MM-dd" />
											</span>] [回复数：<span style="color:#1177b9">${replyNum }</span>]</li>
										</s:iterator>
									</ul>
									<a class="more" href="topicAction_menuList?topicMenuId=${id }">点击这里查看更多内容&gt;&gt;</a>
								</div>
							</s:iterator>
							<!-- 父栏目列表信息列表结束 -->
						</div>
						<!-- 栏目循环列表结束 -->
					</div>
				</div>

			</div>
		</div>
		<div class="clearbox"></div>
		<jsp:include page="/WEB-INF/jsp/pub/footer.jsp"></jsp:include>
	</div>
</body>
</html>
