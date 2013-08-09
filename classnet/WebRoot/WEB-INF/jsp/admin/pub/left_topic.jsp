<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/pub/include.jsp" %>
<script type="text/javascript">
document.write("<ul>");
var url = document.URL;
if(url.indexOf("topicMenuManage")!=-1){
	document.write('<li class="bj"><a href="">分类管理</a></li>');
}
else{
	document.write('<li><a href="">分类管理</a></li>');
}
if(url.indexOf("topic.do")!=-1){
	document.write('<li class="bj"><a href="">帖子管理</a></li>');
}
else{
	document.write('<li><a href="">帖子管理</a></li>');
}
document.write("</ul>");
</script>