<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/pub/include.jsp" %>
<script type="text/javascript">
document.write("<ul>");
var url = document.URL;
if(url.indexOf("newsMenuManage")!=-1){
	document.write('<li class="bj"><a href="admin/newsAdminAction_newsMenuManage">新闻目录管理</a></li>');
}
else{
	document.write('<li><a href="admin/newsAdminAction_newsMenuManage">新闻目录管理</a></li>');
}
if(url.indexOf("pubnews")!=-1){
	document.write('<li class="bj"><a href="admin/newsEidtAction_pubNewsUI">发布新闻</a></li>');
}
else{
	document.write('<li><a href="admin/newsEidtAction_pubNewsUI">发布新闻</a></li>');
}
if(url.indexOf("newsManage")!=-1){
	document.write('<li class="bj"><a href="admin/newsAdminAction_newsManage">新闻管理</a></li>');
}
else{
	document.write('<li><a href="admin/newsAdminAction_newsManage">新闻管理</a></li>');
}
document.write("</ul>");
</script>