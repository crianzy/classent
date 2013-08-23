<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE >
<html>
<head>
<base href="<%=basePath%>">

<title>课程中心</title>
<link href="css/default.css" rel="stylesheet" type="text/css" />
<link href="css/article.css" rel="stylesheet" type="text/css" />
<script src="Scripts/swfobject_modified.js" type="text/javascript"></script>
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
							 		<p align="center">

<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="448" height="291" id="FLVPlayer">
  <param name="movie" value="FLVPlayer_Progressive.swf" />
  <param name="quality" value="high" />
  <param name="wmode" value="opaque" />
  <param name="scale" value="noscale" />
  <param name="salign" value="lt" />
  <param name="FlashVars" value="&amp;MM_ComponentVersion=1&amp;skinName=Halo_Skin_3&amp;streamName=file/clazz/flash/${clazz.flashFilename }&amp;autoPlay=false&amp;autoRewind=false" />
  <param name="swfversion" value="8,0,0,0" />
  <!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
  <param name="expressinstall" value="Scripts/expressInstall.swf" />
  <!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 -->
  <!--[if !IE]>-->
  <object type="application/x-shockwave-flash" data="FLVPlayer_Progressive.swf" width="448" height="291">
    <!--<![endif]-->
    <param name="quality" value="high" />
    <param name="wmode" value="opaque" />
    <param name="scale" value="noscale" />
    <param name="salign" value="lt" />
    <param name="FlashVars" value="&amp;MM_ComponentVersion=1&amp;skinName=Halo_Skin_3&amp;streamName=file/clazz/flash/${clazz.flashFilename }&amp;autoPlay=false&amp;autoRewind=false" />
    <param name="swfversion" value="8,0,0,0" />
    <param name="expressinstall" value="Scripts/expressInstall.swf" />
    <!-- 浏览器将以下替代内容显示给使用 Flash Player 6.0 和更低版本的用户。 -->
    <div>
      <h4>此页面上的内容需要较新版本的 Adobe Flash Player。</h4>
      <p><a href="http://www.adobe.com/go/getflashplayer"><img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="获取 Adobe Flash Player" /></a></p>
    </div>
    <!--[if !IE]>-->
  </object>
  <!--<![endif]-->
</object>
<script type="text/javascript">
swfobject.registerObject("FLVPlayer");
</script>
							 			
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
			url:"clazzAction_changeFirstMenuGetSecond",
			data:"pmenuId="+pid,
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
