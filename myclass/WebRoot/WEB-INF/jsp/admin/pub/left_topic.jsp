<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/pub/include.jsp" %>
<script type="text/javascript">
document.write("<ul>");
var url = document.URL;
if(url.indexOf("menuList")!=-1){
	document.write('<li class="bj"><a href="admin/topicAdminAction_menuList">分类管理</a></li>');
}
else{
	document.write('<li><a href="admin/topicAdminAction_menuList">分类管理</a></li>');
}
if(url.indexOf("topicList")!=-1){
	document.write('<li class="bj"><a href="admin/topicAdminAction_topicList">帖子管理</a></li>');
}
else{
	document.write('<li><a href="admin/topicAdminAction_topicList">帖子管理</a></li>');
}
document.write("</ul>");
</script>