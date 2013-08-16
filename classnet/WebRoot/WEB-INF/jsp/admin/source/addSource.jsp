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

<title>后台管理--添加资源</title>
<link href="css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
function trim(str){
	return str.replace(/^\s+|\s+$/,"");
}
function check(form){
	if(form.menuId.value==0){
		alert("您还未选择栏目");
		return false;
	}
	if(trim(form.name.value)==""){
		alert("标题不能为空");
		return false;
	}
	<s:if test="#source == null">
	if(form.file.value==""){
		alert("上传的资源文件不能为空");
		return false;
	}else{
		var strFileName=form.file.value;
		var extend = /\.[^\.]+$/.exec(strFileName);
		if(!(extend==".txt"||extend==".doc"||extend==".docx"||extend==".docx"||extend==".ppt"||extend==".pptx"||extend==".xls"||extend==".rar"||extend==".zip")){
			alert("请上传txt、doc、xls、ppt、txt、rar、zip格式的文件");
			return false;
		}
	}
	</s:if>
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
<jsp:include page="../pub/left_source.jsp"></jsp:include>
</td>
<td valign="top">
	<div class="right">
	<s:if test="#source == null">
	<form action="admin/sourceEditAction_save" method="post" onsubmit="return check(this)" enctype="multipart/form-data" style="margin:0">
	</s:if><s:else>
	<form action="admin/sourceEditAction_updata " method="post" onsubmit="return check(this)" enctype="multipart/form-data" style="margin:0">		
	</s:else>
	<table width="80%" border="0" cellpadding="0" cellspacing="1" bgcolor="#d1d5d8">
	<tr>
	<td height="28" colspan="2" bgcolor="#c6dbf8" class="biaoti" style="padding:0;">
	<s:if test="#source == null">
		添加资源
	</s:if>
	<s:else>
		资源编辑
	</s:else>
	</td>
	</tr>
	<tr>
	<td width="15%" height="28" align="right" bgcolor="#edf1f7"><span>*</span>选择目录：</td>
	<td height="28" bgcolor="#FFFFFF">
		<select name="menuId" id="menuId">
			<option value="0">请选择目录</option>
			<s:iterator value="menuList">
					<option value="${id}" ${source.sourceMenu.id==id?'selected=selected':''}>${name }</option>
			</s:iterator>
		</select>
		<p>请选择目录</p></td>
	</tr>
	<tr>
	<tr>
	<td width="15%" height="28" align="right" bgcolor="#edf1f7"><span>*</span>标题：</td>
	<td height="28" bgcolor="#FFFFFF"><input type="text" name="name" id="name" size="60" value="${source.name}" /><p>请输入资源名称</p></td>
	</tr>
	<%-- <tr>
	<td width="15%" height="28" align="right" bgcolor="#edf1f7"><span>*</span>文件大小：</td>
	<td height="28" bgcolor="#FFFFFF"><input type="text" name="fileSize" id="fileSize" value="${source.fileSize}" maxlength="10"/><p>请输入资源文件大小</p></td>
	</tr> --%>
	<tr>
	<td width="15%" height="28" align="right" bgcolor="#edf1f7"><span>*</span>上传文件：</td>
	<td height="28" bgcolor="#FFFFFF">
		<input type="file" name=sourceFile id="file" />
		<p>请上传资源文件,只能为<span style="color:red">txt、doc、xls、ppt、txt、rar、zip</span>格式</p>
	</td>
	</tr>
	</table>
	<div class="anniu">
	<p><input type="submit" value="提交" class="fabu" /> 
		<s:if test="#sourceMenu == null">
			<input type="reset" value="重置" class="fabu" />
		</s:if><s:else>
			<input type="button" value="返回" class="fabu" onclick="history.back()" />
		</s:else>
	</p>
	<input type="hidden" name="id" value="${source.id}"/>
	<s:if test="#source!=null">
		<input type="hidden" name="filename" value="${source.filename}"/>
		<input type="hidden" name="fileSize" value="${source.fileSize}"/>
		<input type="hidden" name="fileContentType" value="${source.fileContentType}"/>
	</s:if>
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
