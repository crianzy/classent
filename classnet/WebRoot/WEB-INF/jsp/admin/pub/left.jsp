<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/pub/include.jsp" %>
<script type="text/javascript">
document.write('<ul>');
var url = document.URL;
if(url.indexOf("userAction")!=-1){
	document.write('<li class="bj"><a href="#">用户管理</a></li>');
}
else{
	document.write('<li><a href="">用户管理</a></li>');
}
if(url.indexOf("homeworkAction")!=-1){
	document.write('<li class="bj"><a href="#">作业管理</a></li>');
}
else{
	document.write('<li><a href="">作业管理</a></li>');
}
document.write('</ul>');
</script>