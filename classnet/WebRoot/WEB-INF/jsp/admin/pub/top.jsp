<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="header">
<h1 class="logo">后台管理</h1>
<div class="nav">
<ul>
<script type="text/javascript">
var url = document.URL;
document.write('<li><a href="IndexAction">首页</a></li>');
if(url.indexOf("newsAction")!=-1){
	document.write('<li class="bj">新闻</li>');
}
else{
	document.write('<li><a href="">新闻</a></li>');
}
if(url.indexOf("clazzAction")!=-1){
	document.write('<li class="bj">课程中心</li>');
}
else{
	document.write('<li><a href="">课程中心</a></li>');
}
if(url.indexOf("sourceAction")!=-1){
	document.write('<li class="bj">资源下载</li>');
}
else{
	document.write('<li><a href="">资源下载</a></li>');
}
if(url.indexOf("topicAction")!=-1){
	document.write('<li class="bj">互动交流</li>');
}
else{
	document.write('<li><a href="">互动交流</a></li>');
}
</script>
</ul>
</div>
<div class="clear"></div>
<div class="king">
<p>我的信息：管理供用信息</p>
</div>
</div>