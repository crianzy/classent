<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/pub/include.jsp" %>
<script type="text/javascript">
document.write('<ul>');
var url = document.URL;
if(url.indexOf("userAdminAction")!=-1){
	document.write('<li class="bj"><a href="admin/userAdminAction_list">用户管理</a></li>');
}
else{
	document.write('<li><a href="admin/userAdminAction_list">用户管理</a></li>');
}
document.write('</ul>');
</script>