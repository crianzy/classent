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

<title>后台管理--帖子目录</title>
<link href="css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
function edit(id,name){
	$("#menu"+id).html('<input type="text" name="name'+id+'" id="name'+id+'" value="'+$("#menu"+id).text().trim()+'"/>');
	$("#edit"+id).hide();
	$("#edit_submit"+id).show();
}
function edit_submit(id){
	if($("#name"+id).val()==""){
		alert("不能为空");
		return ;
	}
	$.ajax({
		type:"post",
		url:"admin/topicAdminAction_editMenu？",
		data:"menuId="+id+"&menuName="+$("#name"+id).val(),
		success:function(obj){
			if(obj.flag=="1"){
				$("#menu"+id).html($("#name"+id).val());
				alert("操作成功");
				$("#edit"+id).show();
				$("#edit_submit"+id).hide();
			}
			else{
				alert("操作失败");
			}
		}
	});
}
function selectAll(obj){
	var array = document.getElementsByName("menuId");
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
function check(form){
	if(form.name.value==""){
		alert("不能为空");
		return false;
	}
	return true;
}
function del(id){
	if(id!=0){
		location='admin/topicAdminAction_delMenu?menuId='+id;
	}
	else{
		var array = document.getElementsByName("menuId");
		var idstr="";
		for(var i=0;i<array.length;i++){
			if(array[i].checked){
				idstr+=array[i].value+",";
			}
		}
		if(idstr){
			location='admin/topicAdminAction_delMenu?ids='+idstr;
		}
		else{
			alert("您还未选择");
		}
	}
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
	<div class="middle">
		<form action="admin/topicAdminAction_addMenu" method="post" style="margin:0px;" onsubmit="return check(this)">
		<table width="99%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dae2e5">
			<tr>
				<td width="20%" height="30" bgcolor="#ffffff" align="center">目录名称:</td>
			    <td width="60%" height="30" bgcolor="#ffffff" align="center">
					<input type="text" name="menuName"/>	    	
			    </td>
			    <td width="20%" height="30" bgcolor="#ffffff" align="center">
					<input type="submit" value="添加"/>			    
			    </td>
			</tr>
		</table>
		</form>
	</div>
	<div id="c01">
	  <table width="99%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dae2e5">
	    <tr>
	      <td width="20%" height="30" bgcolor="#e5edfa"><div align="center" class="STYLE3">ID</div></td>
	      <td width="60%" height="30" bgcolor="#e5edfa"><div align="center" class="STYLE3">名称</div></td>
	      <td width="20%" height="30" bgcolor="#e5edfa"><div align="center" class="STYLE3">操作选项 </div></td>
	    </tr>
	    	<s:if test="#menuList != null">
	    		<s:iterator value="menuList" status="vs">
	    		<tr>
			      <td width="7%" height="30" bgcolor="#FFFFFF" align="center">
			      	<input type="checkbox" name="menuId" value="${id}"/>&nbsp;${vs.index+1}
			       </td>
			      <td width="10%" height="30" bgcolor="#FFFFFF" align="center" id="menu${id}">
			      	${name}
			      </td>
			      <td width="10%" height="30" bgcolor="#FFFFFF" align="center">
			      	<a id="edit${id}" href="javascript:edit(${id},'${name}')">修改</a> 
			      	<a id="edit_submit${id}" href="javascript:edit_submit(${id})" style="display: none">保存</a>
			      	<a href="javascript:del(${id})">删除</a>
			     </td>
			    </tr>
			    </s:iterator>
	    	</s:if>
	    	<s:else>
	    		<tr>
			      <td colspan="3" align="center" height="30" bgcolor="#ffffff">
					暂无记录
			     </td>
			    </tr>
			</s:else>
	  </table>
	  <p><input type="checkbox" onclick="selectAll(this)"/> 全选 <input type="button" value="删除" class="shanchu" onclick="del(0)"/></p>
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
