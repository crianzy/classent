<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/pub/include.jsp"%>
<ul id="globalNav">
<script type="text/javascript">
var url = document.URL;
var index="home";
if(url.indexOf("/news/")!=-1){
	index="news";
}
else if(url.indexOf("/clazz/")!=-1){
	index="clazz";
}
else if(url.indexOf("/source/")!=-1){
	index="source";
} 
else if(url.indexOf("/topic/")!=-1){
	index="topic";
} 
else if(url.indexOf("/master/")!=-1){
	index="master";
} 
if(index=="index"){
	document.write('<li id="topTabOn"><a href="hoem"><span>网站首页</span></a></li>');
}
else{
	document.write('<li><a href="home"><span>网站首页</span></a></li>');
}
if(index=="news"){
	document.write('<li id="topTabOn"><a href="newsAction_index"><span>校园新闻</span></a></li>');
}
else{
	document.write('<li><a href="newsAction_index"><span>校园新闻</span></a></li>');
}
if(index=="clazz"){
	document.write('<li id="topTabOn"><a href="clazzAction_index"><span>课程中心</span></a></li>');
}
else{
	document.write('<li><a href="clazzAction_index"><span>课程中心</span></a></li>');
}
if(index=="source"){
	document.write('<li id="topTabOn"><a href="sourceAction_index"><span>资源下载</span></a></li>');
}
else{
	document.write('<li><a href="sourceAction_index"><span>资源下载</span></a></li>');
}
if(index=="topic"){
	document.write('<li id="topTabOn"><a href="topicAction_index"><span>互动交流</span></a></li>');
}
else{
	document.write('<li><a href="topicAction_index"><span>互动交流</span></a></li>');
}
if(index=="master"){
	document.write('<li id="topTabOn"><a href="masterAction_index"><span>个人中心</span></a></li>');
}
else{
	document.write('<li><a href="masterAction_index"><span>个人中心</span></a></li>');
}
</script>
</ul>