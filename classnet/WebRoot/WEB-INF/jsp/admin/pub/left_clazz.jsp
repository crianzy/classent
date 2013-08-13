<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/pub/include.jsp" %>
<script type="text/javascript">
document.write("<ul>");
var url = document.URL;
if(url.indexOf("clazzMenu.do")!=-1){
	document.write('<li class="bj"><a href="admin/clazzAdminAction_clazzMenuList">课程目录管理</a></li>');
}
else{
	document.write('<li><a href="admin/clazzAdminAction_clazzMenuList">课程目录管理</a></li>');
}
if(url.indexOf("fileType.do")!=-1){
	document.write('<li class="bj"><a href="admin/clazzAdminAction_clazzTypeList">文件类型</a></li>');
}
else{
	document.write('<li><a href="admin/clazzAdminAction_clazzTypeList">文件类型</a></li>');
}

if(url.indexOf("add.do")!=-1){
	document.write('<li class="bj"><a href="admin/clazzEditAction_editUI">添加课程</a></li>');
}
else{
	document.write('<li><a href="admin/clazzEditAction_editUI">添加课程</a></li>');
}
if(url.indexOf("/news.do")!=-1){
	document.write('<li class="bj"><a href="admin/clazzAdminAction_clazzList">课程管理</a></li>');
}
else{
	document.write('<li><a href="admin/clazzAdminAction_clazzList">课程管理</a></li>');
}
document.write("</ul>");
</script>