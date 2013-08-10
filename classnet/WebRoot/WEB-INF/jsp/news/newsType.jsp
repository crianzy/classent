<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="UTF-8">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>${newsType.name }-新闻</title>
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
              <dd><ul>
              	<s:iterator value="#hotNewsList">
       				<li>
       					<a href="newsAction_readNews?newsId=${id }">${title }</a>
       				</li>
       			</s:iterator>
          	  </ul></dd>
            </dl>
          </div>
          <div class="c_spacing"></div>
          <div class="r_content">
            <dl>
              <dt>推荐文章</dt>
              <dd><ul>
                <s:iterator value="#tuijianNewsList">
       				<li>
       					<a href="newsAction_readNews?newsId=${id }">${title }</a>
       				</li>
       			</s:iterator>
               </ul></dd>
            </dl>
          </div>
        </div>
        <div class="c_main">
        <!-- 网站位置导航信息开始 -->
        <div class="r_navigation">
          	您现在的位置：<a href="home">精品课程网</a>&gt;&gt;
			<a href="newsAction_index">校园新闻</span></a>&gt;&gt;
     		<a href="newsAction_newsType?newsTypeId=${newsType.id }">${newsType.name }</a> 
         </div>
        <!-- 网站位置导航信息结束 -->
          <div class="c_spacing"></div>
          <div class="centerAD"><img src="images/centerAD.jpg" /></div>
          <div class="c_spacing"> </div>
          <!-- 子栏目列表信息列表开始 -->
          <div class="childclasslist_box">
          <h3>${newsType.name }</h3>
          <ul class="listStyle1">
			<s:iterator value="#newsType.allnews">
		 		<li><a target="_blank" href="newsAction_readNews?newsId=${id }">${title } </a><s:date name="pubTime" format="MM-dd"/> </li>
		 	</s:iterator>
          </ul>
          </div>
          <!-- 子栏目列表信息列表结束 -->
          <!-- 分页 -->
          <div class="clearbox"> </div>
        </div>
        <!-- 右侧二列结束 -->
						</div>
					</div>
					<div id="sideBar">
						<jsp:include page="/WEB-INF/jsp/userbox.jsp"></jsp:include>
						<div class="left_box">
							<dl>
								<dt><em>栏目列表</em></dt>
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
					</div>
				</div>
			</div>
			<div class="clearbox"></div>
			<jsp:include page="/WEB-INF/jsp/pub/footer.jsp"></jsp:include>
		</div>
	</body>
</html>