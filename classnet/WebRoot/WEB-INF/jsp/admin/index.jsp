<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理</title>
<link href="<%=request.getContextPath() %>/css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
<script type="text/javascript">
function settime(){
	var time = new Date();
	var str = "";
	str += time.getFullYear()+"-";
	str += (time.getMonth()+1)+"-";
	str += time.getDate()+"-";
	str += " ";
	str += time.getHours()+":";
	str += time.getMinutes()+":";
	str += time.getSeconds();
	$("#time").html(str);
	$("#time1").html(str);
	setTimeout("settime()",1000);
}
$(function(){
	settime();
});
</script>
</head>
<body>
<div class="content">
<jsp:include page="pub/top.jsp"></jsp:include>
<!--头部结束-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
<td class="left" valign="top">
<s:if test="m=='index'">
	<jsp:include page="pub/left.jsp"></jsp:include>
</s:if>
<s:elseif test="m=='news'">
	<jsp:include page="pub/left_news.jsp"></jsp:include>
</s:elseif>
<s:elseif test="m=='clazz'">
	<jsp:include page="pub/left_clazz.jsp"></jsp:include>
</s:elseif>
<s:elseif test="m=='source'">
	<jsp:include page="pub/left_source.jsp"></jsp:include>
</s:elseif>
<s:elseif test="m=='topic'">
	<jsp:include page="pub/left_topic.jsp"></jsp:include>
</s:elseif>
</td>
<td valign="top">
	<div class="xitong">
		<h3>系统参数</h3>
		<ul>
		<li>新闻数量：${newsCount }条 <a href="">查看</a></li>
		<li>课程数量：${clazzCount }条 <a href="">查看</a></li>
		<li>资源数量：${sourceCount }个 <a href="">查看</a></li>
		<li>帖子数量：${topicCount }条 <a href="">查看</a></li>
		<li>登陆IP：127.0.0.1</li>
		<li>当前时间：<span id="time"></span></li>
		<li>最后登陆IP：127.0.0.1</li>
		<li>最后登陆时间：2008-12-12</li>
		<div class="clear"></div>
		</ul>
	</div>
	<br />
	<br />
</td>
</tr>
</table>
<jsp:include page="pub/foot.jsp"></jsp:include>
</div>
</body>
</html>
