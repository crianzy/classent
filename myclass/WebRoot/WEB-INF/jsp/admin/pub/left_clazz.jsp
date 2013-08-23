<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/pub/include.jsp" %>
<script type="text/javascript">
document.write("<ul>");
var url = document.URL;
if(url.indexOf("clazzMenuList")!=-1){
	document.write('<li class="bj"><a href="admin/clazzAdminAction_clazzMenuList">课程目录管理</a></li>');
}
else{
	document.write('<li><a href="admin/clazzAdminAction_clazzMenuList">课程目录管理</a></li>');
}
if(url.indexOf("clazzTypeList")!=-1){
	document.write('<li class="bj"><a href="admin/clazzAdminAction_clazzTypeList">文件类型</a></li>');
}
else{
	document.write('<li><a href="admin/clazzAdminAction_clazzTypeList">文件类型</a></li>');
}

if(url.indexOf("editUI")!=-1){
	document.write('<li class="bj"><a href="admin/clazzEditAction_editUI">添加课程</a></li>');
}
else{
	document.write('<li><a href="admin/clazzEditAction_editUI">添加课程</a></li>');
}
if(url.indexOf("clazzList")!=-1){
	document.write('<li class="bj"><a href="admin/clazzAdminAction_clazzList">课程管理</a></li>');
}
else{
	document.write('<li><a href="admin/clazzAdminAction_clazzList">课程管理</a></li>');
}
document.write("</ul>");
</script>