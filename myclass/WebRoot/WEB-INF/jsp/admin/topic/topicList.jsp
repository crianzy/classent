<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>后台管理--帖子管理</title>
<link href="css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
function selectAll(obj){
	var array = document.getElementsByName("topicId");
	if(array){
		for(var i=0;i<array.length;i++){
			if(obj.checked){
				array[i].checked=true;
			}
			else{
				array[i].checked=false;
			}
		}
	}
}
function del(id){
	if(id!=0){
		location='admin/topicAdminAction_delTopic?topicId='+id;
	}
	else{
		var array = document.getElementsByName("topicId");
		var idstr="";
		for(var i=0;i<array.length;i++){
			if(array[i].checked){
				idstr+=array[i].value+",";
			}
		}
		if(idstr){
			location='admin/topicAdminAction_delTopic?ids='+idstr;
		}
		else{
			alert("您还未选择");
		}
	}
}
function search(){
	var key = document.getElementById("key");
	var menuId = document.getElementById("menuId");
	var url = "admin/topicAdminAction_topicList?1=1";
	if(key.value!=""){
		url+="&key="+key.value;
	}
	if(menuId.value!=0){
		url+="&menuId="+menuId.value;
	}
	location=url;
}
function changeMenu(menuId){
	var url = 'admin/topicAdminAction_topicList?1=1';
	if(menuId!=0){
		url+='&menuId='+menuId;
	}
	location=url;
}

function gotoPage(num){
	var key = document.getElementById("key");
	var menuId = document.getElementById("menuId");
	var url = "admin/topicAdminAction_topicList?currentPage="+num;
	if(key.value!=""){
		url+="&key="+key.value;
	}
	if(menuId.value!=0){
		url+="&menuId="+menuId.value;
	}
	location=url;
}
</script>
</head>
<body>
<div class="content">
<jsp:include page="../pub/top.jsp"></jsp:include>
<!--头部结束-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
<td class="left" valign="top">
<jsp:include page="../pub/left_topic.jsp"></jsp:include>
</td>
<td valign="top">
	<div id="c01">
	<dl>
	<dt style="padding-right:20px;">分类：
		<select id="menuId" name="menuId" style="width:100px;" onchange="changeMenu(this.value)">
		<option value="0">全部</option>
		<s:iterator value="menuList">
			<option value="${id}" ${id== menuId?'selected=selected':''}> ${name } </option>
		</s:iterator>
		</select>
	</dt>
	<dt>关键字:<input type="text" class="qidian" id="key" name="key" value="${key}"/> </dt>
	<dd><input type="button" value="查询" class="chaxun" onclick="search()"/></dd>
	</dl>
	  <table width="99%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dae2e5">
	    <tr>
	      <td width="8%" height="30" bgcolor="#e5edfa" align="center">ID</td>
	      <td height="30" bgcolor="#e5edfa" align="center">标题</td>
	      <td width="12%" height="30" bgcolor="#e5edfa" align="center">发布人</td>
	      <td width="15%" height="30" bgcolor="#e5edfa" align="center">发布时间</td>
	      <td width="8%" height="30" bgcolor="#e5edfa" align="center">回复数</td>
	      <td width="15%" height="30" bgcolor="#e5edfa" align="center">操作选项</td>
	    </tr>
		<s:if test="list!=null">
		<s:iterator value="list" status="vs">
		<tr>
	      <td height="30" bgcolor="#FFFFFF" align="center">
	        <input type="checkbox" name="topicId" value="${id}"/> 
	        <c:out value="${vs.index+1}"/></td>
	      <td height="30" bgcolor="#FFFFFF" align="left" style="padding-left:10px;"><a href="topicAction_topic?topicId=${id }" target="_blank"> ${title} </a></td>
	      <td height="30" bgcolor="#FFFFFF" align="center"> ${user.username} </td>
	      <td height="30" bgcolor="#FFFFFF" align="center"><s:date name="pubTime" format="yyyy-MM-dd HH:mm"/> </td>
	      <td height="30" bgcolor="#FFFFFF" align="center"> ${replyNum} </td>
	      <td width="10%" height="30" bgcolor="#FFFFFF" align="center">
	      	<a href="javascript:del(${id})">删除</a>
	      </td>
	    </tr>
	    </s:iterator>				
	    </s:if>
	    <s:else>
		<tr>
			<td colspan="6" height="30" bgcolor="#ffffff" align="center">暂无数据</td>
		</tr>	
		</s:else>
	  </table>
	  <p><input type="checkbox" onclick="selectAll(this)"/> 全选 
	  <input type="button" value="删除" class="shanchu" onclick="del(0)"/></p>
	  <jsp:include page="/WEB-INF/jsp/pub/page.jsp"></jsp:include>
	</div>
	<br />
	<br />
</td>
</tr>
</table>
<jsp:include page="../pub/foot.jsp"></jsp:include>
</div>
</body>
</html>
