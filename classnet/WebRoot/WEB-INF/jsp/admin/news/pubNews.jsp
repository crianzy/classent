<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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

<title>后台管理--发布新闻</title>
<link href="css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="fckeditor/fckeditor.js"></script>
<script type="text/javascript">
	function trim(str){
		return str.replace(/^\s+|\s+$/,"");
	}
	
	function check(form){
		if(form.newsTypeId.value==0){
			alert("您还未选择新闻栏目");
			return false;
		}
		if(trim(form.title.value)==""){
			alert("新闻标题不能为空");
			return false;
		}
		if(trim(form.author.value)==""){
			alert("作者不能为空");
			return false;
		}
		if(form.imgFile.value!=""){
			var strFileName=form.imgFile.value;
			var extend = /\.[^\.]+$/.exec(strFileName);
			if(!(extend==".jpg"||extend==".gif"||extend==".png")){
				alert("请上传jpg 或gif 或png 格式的图片");
				return false;
			}
		}
		return true;
	}
</script>
</head>

<body>

<div class="content">
<jsp:include page="../pub/top.jsp"></jsp:include>
<!--头部结束-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
<td class="left" valign="top">
<jsp:include page="../pub/left_news.jsp"></jsp:include>
</td>
<td valign="top">
	<div class="right">
	<form action="admin/newsEidtAction_save" method="post" onsubmit="return check(this)" enctype="multipart/form-data" style="margin:0">
	<table width="80%" border="0" cellpadding="0" cellspacing="1" bgcolor="#d1d5d8">
	<tr>
	<td height="28" colspan="2" bgcolor="#c6dbf8" class="biaoti" style="padding:0;">
		<s:if test="news == null">
			新闻发布
		</s:if>
		<s:else>
			新闻编辑
		</s:else>
	</td>
	</tr>
	<tr>
	<td width="15%" height="28" align="right" bgcolor="#edf1f7"><span>*</span>新闻栏目：</td>
	<td height="28" bgcolor="#FFFFFF">
		<select class="sheng" name="newsTypeId" id="menuId">
			<option value="0">选择新闻栏目</option>
			<s:iterator value="newsTypeList" var="menu">
				<option value="${menu.id}" ${news.newsType.id==menu.id?'selected=selected':''}>${menu.name}</option>
			</s:iterator>
		</select> 
		<p>选择新闻栏目</p>
	</td>
	</tr>
	<tr>
	<td width="15%" height="28" align="right" bgcolor="#edf1f7"><span>*</span>标题：</td>
	<td height="28" bgcolor="#FFFFFF"><input type="text" name="title" id="title" size="60" value="${news.title}" maxlength="80"/><p>请输入新闻标题</p></td>
	</tr>
	<tr>
	<td width="15%" height="28" align="right" bgcolor="#edf1f7"><span>*</span>作者：</td>
	<td height="28" bgcolor="#FFFFFF"><input type="text" name="author" id="author" value="<s:property default="admin" value="#news.author"/>" maxlength="10"/><p>请输入新闻作者</p></td>
	</tr>
	<tr>
	<td width="15%" height="28" align="right" bgcolor="#edf1f7">来源：</td>
	<td height="28" bgcolor="#FFFFFF"><input type="text" name="source" value="${news.source}" maxlength="10"/><p>请输入新闻来源</p></td>
	</tr>
	<tr>
	<td width="15%" height="28" align="right" bgcolor="#edf1f7">封面图片：</td>
	<td height="28" bgcolor="#FFFFFF">
		<input type="file" name="imgFile" id="imgFile"/>
		<p>请上传新闻的封面图片,只能为jpg,gif,png格式的图片</p></td>
	</tr>
	<tr>
	<td width="15%" height="28" align="right" bgcolor="#edf1f7"><span>*</span>新闻内容：</td>
	<td height="28" bgcolor="#FFFFFF">
		<textarea name="content">${news.content}</textarea>
		<script type="text/javascript">
			var oFCKeditor = new FCKeditor('content') ;
			oFCKeditor.BasePath	= "${pageContext.request.contextPath}/fckeditor/";
			oFCKeditor.Width="740";
			oFCKeditor.Height="240";
			oFCKeditor.Value="&nbsp;&nbsp;&nbsp;&nbsp;";
			oFCKeditor.ToolbarSet="classnet";
			oFCKeditor.Config["CustomConfigurationsPath"]="${pageContext.request.contextPath}/fckeditor/replyconfig.js?d="+new Date().getTime();
			oFCKeditor.ReplaceTextarea(); 
		</script>
		<p>请输入新闻内容</p></td>
	</tr>
	</table>
	<div class="anniu">
	<p><input type="submit" value="提交" class="fabu" /> <input type="reset" value="重置" class="fabu" /></p>
	<input type="hidden" name="id" value="${news.id}"/>
	</div>
	</form>
	</div>
	<br />
	<br />
</td>
</tr>
</table>
<jsp:include page="../pub/foot.jsp"></jsp:include>
</div>

</body>
</html>
