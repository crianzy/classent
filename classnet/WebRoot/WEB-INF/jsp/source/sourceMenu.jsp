<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="UTF-8">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>资源下载</title>
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
							<!-- 右侧二列开始 -->
							<div id="r_main">
								<div class="r_content">
									<dl>
										<dt>热点文章</dt>
										<dd>
											<ul>
												<s:iterator value="#hotNewsList">
						              				<li>
						              					<a href="newsAction_readNews?newsId=${id }">${title }</a>
						              				</li>
						              			</s:iterator>
											</ul>
										</dd>
									</dl>
								</div>
								<div class="c_spacing"></div>
								<div class="r_content">
									<dl>
										<dt>推荐课程</dt>
										<dd>
											<ul>
												<s:iterator value="#tuiJianClazzList">
						              				<li>
						              					<a href="clazzAction_clazz?clazzId=${id }">${name }</a>
						              				</li>
						              			</s:iterator>
											</ul>
										</dd>
									</dl>
								</div>
							</div>
							<div class="c_main">
								<!-- 网站位置导航信息开始 -->
								<div class="r_navigation">
									您现在的位置： <a href="home">精品课程网</a>&gt;&gt;
								 	<a href="sourceAction_index"><span class="current">资源下载</span> </a>&gt;&gt;
									${sourceMenu.name}
								</div>
								<!-- 网站位置导航信息结束 -->
								<div class="c_spacing"></div>
								<div class="centerAD">
									<img src="images/centerAD.jpg" />
								</div>
								<div class="c_spacing"></div>
								<div class="childclasslist_box">
						          <h3>${sourceMenu.name}</h3>
						          <ul class="listStyle1">
						          	<s:iterator value="#sourceMenu.sources">
						          		<li><a href="sourceAction_download?sourceId=${id }">${name}</a>
						          			<s:date name="pubTime" format="MM-dd"/>
						          		</li>
						          	</s:iterator>
						          </ul>
						          </div>
						          <div class="c_spacing"></div>
						         <div class="class_page"><span class="pagecss">
								 </span></div>
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
										<s:iterator value="#sourceMenuList">
											<li>
												<a href="sourceAction_sourceMenu?sourceMenuId=${id }">${name }</a>
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
					</div>
				</div>
			</div>
			<div class="clearbox"></div>
			<jsp:include page="/WEB-INF/jsp/pub/footer.jsp"></jsp:include>
		</div>
	</body>
</html>
