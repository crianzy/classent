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
							 <a href="clazzAction_index"><span class="current">课程中心</span> </a>&gt;&gt;
							 课程内容
						</div>
						<!-- 网站位置导航信息结束 -->
						<div class="c_spacing"></div>
						<!-- 主体内容开始 -->
						<div class="c_main_content_box">
							 <div class="c_title_text" style="padding-top:10px;">
							 	 <h2>${clazz.name }</h2>
							 </div>
							 <div class="c_title_author" style="">
							 	<table width="100%" border="0">
							 		<tr>
										<td align="center" width="20%">作者：</td>
								        <td align="left" width="30%">${clazz.author }</td>
										<td align="center" width="50%" rowspan=5>
											<a href="clazzAction_download?clazzId=${clazz.id}">
												<img src="images/zizhan_xia.gif" style="cursor: pointer;"/>
											</a>
										</td>
								    </tr>
								    <tr>
										<td align="center">作者单位：</td>
								        <td align="left">${clazz.school}</td>
								    </tr>
								    <tr>
										<td align="center">文件类型：</td>
								        <td align="left">${clazz.fileType.name}</td>
								    </tr>
								    <tr>
										<td align="center">访问量：</td>
								        <td align="left">${clazz.viewNum}</td>
								    </tr>
							 	</table>
							 </div> 
							 <!-- 正文 -->
							 <div class="c_content_text">
							 	<div class="c_content_overflow" id="fontzoom">
							 		<p>
								 		<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,0,0" width="680" height="538" align="middle">
									        <param name="allowFullScreen" value="false" />
									        <param name="movie" value="upload_http_path/files/${clazz.flashFilename}" />
									        <param name="quality" value="high" />
									        <param name="bgcolor" value="#ffffff" /> 
											<param name="wmode" value="window" /> 
									        <embed src="files/${clazz.flashFilename}" quality="high" bgcolor="#ffffff" width="680" height="538" align="middle" allowScriptAccess="sameDomain" allowFullScreen="false" type="application/x-shockwave-flash" wmode="opaque" pluginspage="http://www.macromedia.com/go/getflashplayer" />
								        </object>
							        </p>
							 	</div>
							 </div>
						</div>
					</div>
				</div>
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
											<a href="clazzAction_clazzMenu?pmenuId=${id }">${name }</a>
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
			</div>
		</div>
		<div class="clearbox"></div>
		<jsp:include page="/WEB-INF/jsp/pub/footer.jsp"></jsp:include>
	</div>
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
