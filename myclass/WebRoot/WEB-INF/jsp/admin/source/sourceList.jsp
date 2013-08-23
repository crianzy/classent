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

<title>后台管理--资源管理</title>
<link href="css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
function selectAll(obj){
	var array = document.getElementsByName("sourceId");
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
		location='admin/sourceAdminAction_delSource?sourceId='+id;
	}
	else{
		var array = document.getElementsByName("sourceId");
		var idstr="";
		for(var i=0;i<array.length;i++){
			if(array[i].checked){
				idstr+=array[i].value+",";
			}
		}
		if(idstr){
			location='admin/sourceAdminAction_delSource?ids='+idstr;
		}
		else{
			alert("您还未选择");
		}
	}
}
function changeMenu(mid){
	var url = 'admin/sourceAdminAction_sourceList?';
	if(mid!=0){
		url += 'sourceMenuId='+mid;
	}
	location = url;
}
function search(){
	var url = 'admin/sourceAdminAction_sourceList?1=1';
	var mid = document.getElementById("menuId");
	if(mid.value!=0){
		url += '&sourceMenuId='+mid.value;
	}
	var key = document.getElementById("key");
	if(key.value!=""){
		url += '&key='+key.value;
	}
	location = url;
}

function gotoPage(num){

	var url = 'admin/sourceAdminAction_sourceList?currentPage='+num;
	var mid = document.getElementById("menuId");
	if(mid.value!=0){
		url += '&sourceMenuId='+mid.value;
	}
	var key = document.getElementById("key");
	if(key.value!=""){
		url += '&key='+key.value;
	}
	location = url;
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
<jsp:include page="../pub/left_source.jsp"></jsp:include>
</td>
<td valign="top">
	<div class="middle">
		<table width="99%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dae2e5">
			<tr>
				<td height="30" bgcolor="#ffffff" align="left" style="padding-left:10px;">
					选择目录:
					<select name="menuId" id="menuId" onchange="changeMenu(this.value)">
						<option value="0">全部</option>
						<s:iterator value="sourceMenuList">
							<option value="${id}" ${sourceMenuId==id?'selected=selected':''}>${name }</option>
						</s:iterator>
					</select>&nbsp;&nbsp;
					关键字:
					<input type="text" name="key" id="key" value="${key}"/>
					&nbsp;&nbsp;
					<input type="button" value="查询" onclick="search()"/>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="添加" onclick="javascript: location = 'admin/sourceEditAction_editUI'"/>
				</td>
			</tr>
		</table>
	</div>
	<div id="c01">
	  <table width="99%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dae2e5">
	    <tr>
	      <td width="10%" height="30" bgcolor="#e5edfa"><div align="center" class="STYLE3">ID</div></td>
	      <td width="45%" height="30" bgcolor="#e5edfa"><div align="center" class="STYLE3">名称</div></td>
	      <td width="15%" height="30" bgcolor="#e5edfa"><div align="center" class="STYLE3">目录</div></td>
	      <td width="15%" height="30" bgcolor="#e5edfa"><div align="center" class="STYLE3">文件大小</div></td>
	      <td width="15%" height="30" bgcolor="#e5edfa"><div align="center" class="STYLE3">操作选项 </div></td>
	    </tr>
	    	<s:if test="list != null">
	    		<s:iterator value="list" status="vs">
	    		<tr>
			      <td height="30" bgcolor="#FFFFFF" align="center">
			      	<input type="checkbox" name="sourceId" value="${id}"/>&nbsp;${vs.index+1}
			       </td>
			      <td height="30" bgcolor="#FFFFFF" align="center" id="menu${id}">
			      	<a href="sourceAction_download?sourceId=${id }">${name}</a>
			      </td>
			      <td height="30" bgcolor="#FFFFFF" align="center" id="menu${id}">
			      	${sourceMenu.name}
			      </td>
			       <td height="30" bgcolor="#FFFFFF" align="center" id="menu${id}">
			      	${fileSize}
			      </td>
			      <td height="30" bgcolor="#FFFFFF" align="center">
			      	<a href=" admin/sourceEditAction_editUI?sourceId=${id }">修改</a> 
			      	<a href="javascript:del(${id})">删除</a>
			     </td>
			    </tr>
			    </s:iterator>
	    	</s:if>
	    	<s:else>
	    		<tr>
			      <td colspan="4" align="center" height="30" bgcolor="#ffffff">
					暂无记录
			     </td>
			    </tr>
			</s:else>
	  </table>
	  <p><input type="checkbox" onclick="selectAll(this)"/> 全选 <input type="button" value="删除" class="shanchu" onclick="del(0)"/></p>
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
