<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
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
<title>课程中心</title>
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
							您现在的位置： <a href="home">精品课程网</a>&gt;&gt;
							 <a href="newsAction_index"><span class="current">课程中心</span> </a>
						</div>
						<!-- 网站位置导航信息结束 -->
						<div class="c_spacing"></div>
						<div class="r_ad" style="border:1px solid #A6C7CC;height: 78px;background:url(images/leftboxContentBg.jpg)">
							<div style="padding-top:10px;text-align: center">
								学科一级目录:
								<select name="pmenuId" id="pmenuId" style="width:100px;" onchange="changemenu(this.value)">
									<option value="0">请选择</option>
									<s:iterator value="firstclazzMenList">
										<option value="${id }">${name }</option>
									</s:iterator>
								</select>
								&nbsp;
								学科二级目录:
								<select name="menuId" id="menuId" style="width:100px;">
									<option value="0">请选择</option>
								</select>
								&nbsp;
								文件类型:
								<select name="ft" id="ft" style="width:100px;">
									<option value="0">请选择</option>
									<s:iterator value="clazzTypeList">
										<option value="${id }">${name }</option>
									</s:iterator>
								</select>
							</div><!-- <div style="padding-top:10px; -->
							<div style="padding-top:10px;text-align: center">
								<input type="text" size="70" name="keyWord" id="key" style="height: 20px;"/>
								<input type="button" value="搜索" style="width: 60px;" onclick="search()"/>
							</div>
						</div><!-- <div class="r_ad" -->
						<div class="childclass_main">
							<!-- 栏目循环列表开始 -->
							<s:iterator value="clazzTypeList">
								<div class="childclass_main_box">
									<div class="childclass_title">
										<div class="more"><a href="clazzAction_search?clazzTypeId=${id }">[更多]</a></div>
										<a href="clazzAction_search?clazzTypeId=${id }">${name }</a>
									</div>
									<div class="childclass_content">
										<ul class="listStyle1">
											<s:iterator value="clazzs">
												<li>
													<a href="clazzAction_clazz?clazzId=${id }">${name }</a>
													<s:date name="pubTime" format="MM-dd"/>
												</li>
											</s:iterator>
										</ul>
										<div class="clearbox"></div>
										
									</div>
									<div class="childclass_bot"></div>
								</div>
							</s:iterator>
							<!-- 栏目循环列表结束 -->
							<div class="clearbox"></div>
						</div><!-- <div class="childclass_main"> -->
						<div class="c_spacing"></div>
						<!-- 最新图片文章开始 -->
						<div class="c_main_one">
							<dl>
								<dt class="c_title">
									<div class="more"></div>
									最新图文
								</dt>
								<dd class="c_content">
									<!-- 显示8张最新图片文章 -->
									<div class="a_photo_list">
										<s:iterator value="lastClazz">
											<li>
												<div class="pe_u_thumb">
													<a href="clazzAction_clazz?clazzId=${id }" target="_blank">
														<img src="/images/${img}" width="160" height="120" border="0">
													</a>
												</div>
												<div class="pe_u_thumb_title">
													<a href="clazzAction_clazz?clazzId=${id }" target="_blank">${name }</a>
													<br />
												</div>
											</li>
										</s:iterator>
									</div>
								</dd>
							</dl>
						</div><!-- <div class="c_main_one"> -->
						<!-- 最新图片文章结束 -->
						
					</div><!-- <div id="main_right_box"> -->
				</div><!-- <div id="main_right"> -->
				<div id="sideBar">
					<jsp:include page="/WEB-INF/jsp/userbox.jsp"></jsp:include>
					<div class="left_box">
						<dl>
							<dt>
								<em>栏目列表</em>
							</dt>
							<dd>
								<ul class="subjectList">
									<s:iterator value="firstclazzMenList">
										<li>
											<a href="clazzAction_search?pmenuId=${id }">${name }</a>
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
				</div><!-- <div id="sideBar"> -->
			</div><!-- <div id="main_bg"> -->
		</div><!-- <div id="center_all" class="main"> -->
		<div class="clearbox"></div>
			<jsp:include page="/WEB-INF/jsp/pub/footer.jsp"></jsp:include>
	</div><!-- <div class="wrap"> -->
	
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	function changemenu(pid){
		$("#menuId").empty();
		$("#menuId").append('<option value="0">请选择</option>');
		$.ajax({
			type:"get",
			url:"changeMenuAction",
			data:"pid="+pid,
			success:function(data){
				$.each(data.secondClazzMenuDto,function(i,item){
					$("#menuId").append('<option value="'+item.id+'">'+item.name+'</option>');
				});
			}
		});
	}
	
	function search(){
		var url = 'clazzAction_search';
		var pmId = $("#pmenuId").val();
		var mId = $("#menuId").val();
		var ftId = $("#ft").val();
		var key = $("#key").val();
		if(pmId==0&&mId==0&&ftId==0&&key==""){
			location = url;
			return ;
		}else{
			url += '?';
			if(pmId!=0){
			url += '&pmenuId='+pmId;
			}
			if(mId!=0){
				url += '&menuId='+mId;
			}
			if(ftId!=0){
				url += '&clazzTypeId='+ftId;
			}
			if(key!=""){
				url += '&keyWord='+key;
			}
			url = url.replace(/\?&/,"?");
			location = url;
		}
		
	}
</script>	
</body>
</html>
