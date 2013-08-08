<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
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

<title>新闻</title>
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
				<div id="main_right">
					<div id="main_right_box">
						<!-- 网站位置导航信息开始 -->
						<div class="r_navigation">
							您现在的位置： <a href="home"> 圆圆精品课程网</a>&gt;&gt; <a href="newsAction_index">
							<span class="current">校园新闻</span>
							</a>
						</div>
						<!-- 网站位置导航信息结束 -->
						<div class="c_spacing"></div>
						<div id="column1">
							<div
								style="width:300px;height: 240px;float:right;text-align:center">
								flash</div>
							<div class="newsList">
								<h3>校园新闻</h3>
								<ul class="listStyle1">
									<s:iterator value="#tuijianNewsList">
										<li><a target="_blank" href="newsAction_readNews?newsId=${id }">${title } </a><s:date name="pubTime" format="MM-dd"/> </li>
									</s:iterator>
								</ul>
							</div>
							<div class="clearbox"></div>
						</div>
						<div class="c_spacing"></div>
						<div class="clearbox"></div>
						<div class="c_spacing"></div>
						<!-- 广告 -->
						<div class="r_ad">
							<a href="#"><img src="images/rightAD2.JPG" alt="动易网络"
								border="0" />
							</a>
						</div>
						<div class="childclass_main">
							<!-- 栏目循环列表开始 -->
							<s:iterator value="#newsTypeList">
							<div class="childclass_main_box">
								<div class="childclass_title">
									<div class="more">
										<a href="newsAction_newsType?newsTypeId=${id }">[更多]</a>
									</div>
									<a target="_blank" href="newsAction_newsType?newsTypeId=${id }">${name }</a>
								</div>
								<div class="childclass_content">
									<ul class="listStyle1">
										<s:iterator value="LastNews">
											<li><a target="_blank" href="newsAction_readNews?newsId=${id }">${title }</a></li>
											<div class="clearbox"></div>
										</s:iterator>
									</ul>
									<div class="clearbox"></div>
								</div>
								<div class="childclass_bot"></div>
							</div>
							</s:iterator>
							<!-- 栏目循环列表结束 -->
							<div class="clearbox"></div>
						</div>
					</div>
				</div>
				<div id="sideBar">
					<jsp:include page="/WEB-INF/jsp/userbox.jsp"></jsp:include>
					<div class="left_box">
						<dl>
							<dt><em>栏目列表</em></dt>
							<dd>
								<ul class="subjectList">
									<s:iterator  value="newsTypeList">
											<li><a href="newsAction_newsType?newsTypeId=${id }">${name }</a></li>
									</s:iterator>
									<s:if test="st.index%2==0">
											<div class="clearbox"></div>
									</s:if>
									<div class="clearbox"></div>
								</ul>
							</dd>
						</dl>
					</div>
					<div class="left_box">
						<dl>
							<dt><em>最新文章</em></dt>
							<dd>
								<ul>
									<s:iterator value="#lastNewsList">
										<li><a href="newsAction_readNews?newsId=${id }">${title }</a></li>
									</s:iterator>
								</ul>
							</dd>
						</dl>
					</div>
				</div>
			</div>
		</div>
		
		<div class="clearbox"></div>
		<jsp:include page="/WEB-INF/jsp/pub/footer.jsp"></jsp:include>
	</div>
</body>
</html>
