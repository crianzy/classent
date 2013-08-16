<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>网站首页</title>

<link rel="stylesheet" type="text/css" href="css/index.css">

</head>

<body>
<div class="wrap">
	<!--头部定义开始-->
	<div id="header" class="main">
		<jsp:include page="/WEB-INF/jsp/pub/header.jsp"></jsp:include>
	</div>
	<!--头部定义结束-->
	<!-- 中部内容定义开始 -->
	<div class="main">
		<!-- 右侧内容定义 -->
		<div class="mainContent">
			<!-- 头条新闻  -->
			<div class="r_navigation">
				&nbsp;<strong style="font-size: 14px;">头条新闻</strong>
			</div>
			<div id="column1">
				<div id="flashNews">
					<div style="width:300px;height: 230px;float:right;text-align:center">
						<a href="newsAction_readNews?newsId=${bigPicnews.id }" target="_blank">
							<img src="file/news/${bigPicnews.img }" alt="${bigPicnews.title }" width="300px"  height="240px"/>
						</a>
					</div>
				</div>
				<div id="newsList">
					<ul class="listStyle1">
						<s:iterator value="#touTiaoNewsList">
							<li><a target="_blank" href="newsAction_readNews?newsId=${id }">${title } </a><s:date name="pubTime" format="MM-dd"/> </li>
						</s:iterator>
					</ul>
				</div>
				<div class="clearbox"></div>
			</div>
			
			<div class="c_spacing"></div>
			<!-- 广告栏 -->
			<div class="ADBanner">
			</div>
			<div class="c_spacing"></div>
			
			<!-- 课程中心 -->
			<div id="moralEduSpace" class="goldenrod">
				<dl>
					<dt>
						<em><a href="clazzAction_index">课程中心</a></em>
						<ul class="colChildNav">
							<s:iterator value="clazzMenuDtoList">
								<li><a href="clazzAction_search?pmenuId=${id }">${name }</a></li>
							</s:iterator>
						</ul>
					</dt>
					
					<dd>
						<ul class="thumbListStlye2">
							<s:iterator value="tuiJianClazzList">
								<li>
									<div class="pe_u_thumb">
										<a href="clazzAction_clazz?clazzId=${id }" target="_blank">
											<img  width="160" height="120"   src="file/clazz/img/${img }"/>
										</a>
									</div>
									<div class="pe_u_thumb_title">
										<a href="clazzAction_clazz?clazzId=${id }" target="_blank">
											${name }
										</a>
										<br/>
									</div>
								</li>		
							</s:iterator>
						</ul>
						<ul class="listStyle1">
							<s:iterator value="lastClazzList">
								<li>
									<a href="clazzAction_clazz?clazzId=${id }" target="_blank">
										${name }
									</a>
									<s:date name="pubTime" format="MM-dd"/>
								</li>
							</s:iterator>
						</ul>
						<div class="clearbox"></div>
					</dd>
				</dl>
			</div>
			<div class="c_spacing"></div>
			<!-- 资源下载 -->
			<div id="moralEduSpace" class="lightGreen" style="margin-top:60px;">
				<dl>
					<dt>
						<em><a href="sourceAction_index">资源下载</a></em>
							
						<ul class="colChildNav">
							<s:iterator value="sourceMenuList">
								<li>
									<a href="sourceAction_sourceMenu?sourceMenuId=${id }">
										${name }
									</a>
								</li>
							</s:iterator>
						</ul>
					</dt>
					<dd>
						<ul class="listStyle1" style="float:left">
							<s:iterator value="lastSourceList" status="vs">
								<li>
								<a href="sourceAction_download?sourceId=${id }">
									${name }
								</a>
								<s:date name="pubTime" format="MM-dd"/>
								</li>
								<s:if test="#vs.index==6">
									</ul><ul class="listStyle1">
								</s:if>
							</s:iterator>
						</ul>
					</dd>
				</dl>
			</div>
			<div class="c_spacing"></div>
			<!-- 互动交流 -->
			<div id="instructionalResearch" class="mediumTurquoise" style="margin-top:20px;">
				<dl>
					<dt>
						<em><a href="topicAction_index">互动交流</a></em>
						<ul class="colChildNav">
							<s:iterator value="topicMenuList">
								<li>
									<a href="topicAction_menuList?topicMenuId=${id }">${name }</a>
								</li>
							</s:iterator>
						</ul>
					</dt>
					<dd>
						<div class="col2">
							<ul class="listStyle1">
								<s:iterator value="lastTopicList" status="vs">	
									<li>
										<a href="topicAction_topic?topicId=${id }">
											${title }
										</a>
										<s:date name="pubTime" format="MM-dd HH:mm"/>
									</li>
									<s:if test="#vs.index == 6">
							</ul>
						</div>
						<div class="col1">
							<ul class="listStyle1">
									</s:if>									
								</s:iterator>
							</ul>
						</div>
					</dd>
				</dl>
			</div>
			<div class="c_spacing"></div>
		</div>
		<!-- 右侧结束 -->
		<!-- 左侧侧边栏 -->
		<div id="sideBar">
			<jsp:include page="/WEB-INF/jsp/userbox.jsp"></jsp:include>
			<div class="left_box">
				<dl>
					<dt><em>学科资源</em></dt>
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
			<div class="clearbox"></div>
		</div>
	</div>
	<!-- 中部内容结束 -->

	<!-- 尾部  -->
	<div class="clearbox"></div>
	<jsp:include page="/WEB-INF/jsp/pub/footer.jsp"></jsp:include>
</div>
</body>
</html>
