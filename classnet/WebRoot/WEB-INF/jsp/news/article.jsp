<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
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

<title>${news.title }-新闻</title>
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
					<!-- 网站位置导航信息开始 -->
					<div class="r_navigation">
						您现在的位置： <a href="home">精品课程网</a>&gt;&gt;
						 <a href="newsAction_index"><span class="current">校园 新闻</span> </a>&gt;&gt; 
						 <a href="newsAction_newsType?newsTypeId=${news.newsType.id}">${news.newsType.name}</a>&gt;&gt; 新闻内容
					</div>
					<!-- 网站位置导航信息结束 -->
					<div class="c_spacing"></div>
					<!-- 主体内容开始 -->
					<div class="c_main_content_box">
						<div class="c_title_text" style="padding-top:10px;">
							<h2>${news.title }</h2>
						</div>
						<div class="c_title_author">
							<span>作者：${news.author }</span> <span>来源：${news.source }</span> <span>发布时间：
							<s:date name="#news.pubTime" format="yyyy-MM-dd"  />
							</span>
						</div>
						<!-- 正文 -->
						<div class="c_content_text">
							<div class="c_content_overflow" id="fontzoom">
								<p align="center">${news.content}</p>
							</div>
						</div>
						<!-- 主体内容结束 -->
					</div>
				</div>

				<dir id="sideBar">
					<jsp:include page="/WEB-INF/jsp/userbox.jsp"></jsp:include>
					<div class="left_box">
						<dl>
							<dt>
								<em>栏目列表</em>
							</dt>
							<dd>
								<ul class="subjectList">
									<s:iterator value="newsTypeList" status="st">
										<li><a href="newsAction_newsType?newsTypeId=${id }">${name }</a>
										</li>
										<s:if test="st.index%2==0">
											<div class="clearbox"></div>
										</s:if>
									</s:iterator>
									<div class="clearbox"></div>
									
								</ul>
							</dd>
						</dl>
					</div>
				</dir>
			</div>
		</div>
		<div class="clearbox"></div>
		<jsp:include page="/WEB-INF/jsp/pub/footer.jsp"></jsp:include>
	</div>
</body>
</html>
