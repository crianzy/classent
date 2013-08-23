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
<title>后台管理--编辑课程</title>
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
	if(trim(form.author.value)==""){
		alert("作者不能为空");
		return false;
	}
	if(form.clazzTypeId.value==0){
		alert("文件类型不能为空");
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
	<s:if test="#clazzt == null">
	if(trim(form.file.value)==""){
		alert("课程文件不能为空");
		return false;
	}else{
		var strFileName=form.file.value;
		var extend = /\.[^\.]+$/.exec(strFileName);
		if(!(extend==".txt"||extend==".doc"||extend==".docx"||extend==".docx"||extend==".ppt"||extend==".pptx"||extend==".xls")){
			alert("请上传doc,xls,ppt,txt格式的文件");
			return false;
		}
	}
	if(trim(form.flashFile.value)==""){
		alert("FLASH文件不能为空");
		return false;
	}else{
		var strFileName=form.flashFile.value;
		var extend = /\.[^\.]+$/.exec(strFileName);
		if(extend!=".flv"){
			alert("请上传flv格式的视频");
			return false;
		}
	}
	</s:if>
	return true;
}
function changeMenu(pid){
	$("#menuId").empty();
	if(pid==0){
		return ;
	}
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

</script>
</head>

<div class="content">
	<jsp:include page="../pub/top.jsp"></jsp:include>
	<!--头部结束-->
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td class="left" valign="top"><jsp:include
					page="../pub/left_clazz.jsp"></jsp:include></td>
			<td valign="top">
				<div class="right">
					<s:if test="#clazzt == null">
						<form action="admin/clazzEditAction_add" method="post"
							onsubmit="return check(this)" enctype="multipart/form-data"
							style="margin:0">
					</s:if>
					<s:else>
						<form action="admin/clazzEditAction_edit" method="post"
							onsubmit="return check(this)" enctype="multipart/form-data"
							style="margin:0">
					</s:else>
					<table width="80%" border="0" cellpadding="0" cellspacing="1"
						bgcolor="#d1d5d8">
						<tr>
							<td height="28" colspan="2" bgcolor="#c6dbf8" class="biaoti"
								style="padding:0;"><s:if test="#clazzt == null">
			添加课程
		</s:if> <s:else>
			课程编辑
		</s:else></td>
						</tr>
						<tr>
							<td width="15%" height="28" align="right" bgcolor="#edf1f7"><span>*</span>课程栏目：</td>
							<td height="28" bgcolor="#FFFFFF"><select class="sheng"
								name="pid" id="parentMenuId" onchange="changeMenu(this.value)">
									<option value="0">选择课程栏目</option>
									<s:iterator value="parentMenuList">
										<option value="${id }" ${clazzt.clazzMenu.parentClassMenu.id==id? 'selected=selected':''}>${name }</option>
									</s:iterator>
							</select> <select name="clazzMenuId" id="menuId" class="sheng">
									<s:if test="#childMenuList != null">
										<s:iterator value="#childMenuList">
											<option value="${id}" ${id== clazzt.clazzMenu.id? 'selected=selected':''}>${name }</option>
										</s:iterator>
									</s:if>
							</select></td>
						</tr>
						<tr>
							<td width="15%" height="28" align="right" bgcolor="#edf1f7"><span>*</span>标题：</td>
							<td height="28" bgcolor="#FFFFFF"><input type="text"
								name="name" id="name" size="60" value="${clazzt.name}"
								maxlength="25" />
							<p>请输入课程名称</p>
							</td>
						</tr>
						<tr>
							<td width="15%" height="28" align="right" bgcolor="#edf1f7"><span>*</span>作者：</td>
							<td height="28" bgcolor="#FFFFFF"><input type="text"
								name="author" id="author"
								value="<s:property value="#clazzt.author" default="admin" />"
								maxlength="10" />
							<p>请输入课程作者</p>
							</td>
						</tr>
						<tr>
							<td width="15%" height="28" align="right" bgcolor="#edf1f7">作者单位：</td>
							<td height="28" bgcolor="#FFFFFF"><input type="text"
								name="school" value="${clazzt.school}" maxlength="10" />
							<p>请输入作者单位</p>
							</td>
						</tr>
						<tr>
							<td width="15%" height="28" align="right" bgcolor="#edf1f7">封面图片：</td>
							<td height="28" bgcolor="#FFFFFF"><input type="file"
								name="imgFile" id="imgFile" />
								<p>请上传封面图片,只能为jpg,gif,png格式的图片</p>
							</td>
						</tr>
						<tr>
							<td width="15%" height="28" align="right" bgcolor="#edf1f7"><span>*</span>文件类型：</td>
							<td height="28" bgcolor="#FFFFFF"><select name="clazzTypeId"
								id="clazzTypeId">
									<option value="0">请选择文件类型</option>
									<s:iterator value="clazzTypeList">
										<option value="${id}" ${clazzt.fileType.id==
											id ?'selected=selected':''}>${name }</option>
									</s:iterator>
							</select>
								<p>请选择文件类型</p>
							</td>
						</tr>
						<tr>
						<tr>
							<td width="15%" height="28" align="right" bgcolor="#edf1f7"><s:if
									test="#clazzt == null">
									<span>*</span>
								</s:if>课程文件：</td>
							<td height="28" bgcolor="#FFFFFF"><input type="file"
								name="clazzFile" id="file" />
								<p>请上传课程文件,只能为doc,xls,ppt,txt格式的,大小不能超过5M</p>
							</td>
						</tr>
						<tr>
							<td width="15%" height="28" align="right" bgcolor="#edf1f7"><s:if
									test="#clazzt == null">
									<span>*</span>
								</s:if>FLASH文件：</td>
							<td height="28" bgcolor="#FFFFFF"><input type="file"
								name="flashFile" id="flashFile" />
								<p>请上传课程文件Flash,swf格式,大小不能超过5M</p>
							</td>
						</tr>
					</table>
					<div class="anniu">
						<p>
							<input type="submit" value="提交" class="fabu" />
							<s:if test="#clazzt == null">
								<input type="reset" value="重置" class="fabu" />
							</s:if>
							<s:else>
								<input type="button" value="返回" class="fabu"
									onclick="history.back()" />
							</s:else>
						</p>
						<input type="hidden" name="id" value="${clazzt.id}" />
						<s:if test="#clazzt != null">
							<input type="hidden" name="filename" value="${clazzt.filename }" />
							<input type="hidden" name="flashFilename"
								value="${clazzt.flashFilename }" />
							<input type="hidden" name="img" value="${clazzt.img }" />
						</s:if>
					</div>
					</form>
				</div> <br /> <br /></td>
		</tr>
	</table>
	<jsp:include page="../pub/foot.jsp"></jsp:include>
</div>
</body>
</html>
