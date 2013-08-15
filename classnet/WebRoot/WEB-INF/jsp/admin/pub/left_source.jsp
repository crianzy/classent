<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/pub/include.jsp" %>
<script type="text/javascript">
document.write("<ul>");
var url = document.URL;
if(url.indexOf("sourceMenuManage")!=-1){
	document.write('<li class="bj"><a href="admin/sourceAdminAction_menuList">资源目录管理</a></li>');
}
else{
	document.write('<li><a href="admin/sourceAdminAction_menuList">资源目录管理</a></li>');
}
if(url.indexOf("sourceManage")!=-1){
	document.write('<li class="bj"><a href="admin/sourceAdminAction_sourceList">资源管理</a></li>');
}
else{
	document.write('<li><a href="admin/sourceAdminAction_sourceList">资源管理</a></li>');
}
document.write("</ul>");
</script>