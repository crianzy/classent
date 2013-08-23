<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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

<title>后台管理--课程目录</title>
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
		url:"admin/clazzAdminAction_editClazzMenu",
		data:"clazzMenuId="+id+"&clazzMenuName="+$("#name"+id).val(),
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
	if(form.clazzMenuName.value==""){
		alert("不能为空");
		return false;
	}
	return true;
}
function del(id){
	if(id!=0){
		location='admin/clazzAdminAction_delClazzMenu?clazzMenuId='+id+"&parentId="+$("#pid").val();
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
			location='admin/clazzAdminAction_delClazzMenu?ids='+idstr+"&parentId="+$("#pid").val();
		}
		else{
			alert("您还未选择");
		}
	}
}
function changeclazzmenu(pid){
	var url='admin/clazzAdminAction_clazzMenuList?';
	if(pid!=0){
		url+='&parentId='+pid;
	}
	location=url;
}
function fo(){
	document.getElementById("name").focus();
}
</script>
</head>

<body onload="fo()">
<div class="content">
<jsp:include page="../pub/top.jsp"></jsp:include>
<!--头部结束-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
<td class="left" valign="top">
<jsp:include page="../pub/left_clazz.jsp"></jsp:include>
</td>
<td valign="top">
	<div class="middle">
		<form action="admin/clazzAdminAction_addClazzMenu" method="post" style="margin:0px;" onsubmit="return check(this)">
		<table width="99%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dae2e5">
			<tr>
				<td width="30%" height="30" bgcolor="#ffffff" align="center">
					父目录: <select name="parentId" id="pid" style="width:150px;" onchange="changeclazzmenu(this.value)">
							<option value="0">无</option>
							<s:iterator value="parentMenuList" >
								<option value="${id}" ${parentId==id?'selected=selected':''}>${name}</option>
							</s:iterator>
						   </select>
				</td>
			    <td width="50%" height="30" bgcolor="#ffffff" align="center">
					目录名称: <input type="text" name="clazzMenuName" id="name"/>	    	
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
	    	<s:if test="#clazzMenuDtoList !=null">
	    		<s:iterator value="clazzMenuDtoList" var="menu" status="vs">
	    		<tr>
			      <td width="7%" height="30" bgcolor="#FFFFFF" align="center">
			      	<input type="checkbox" name="menuId" value="${menu.id}"/>&nbsp;${vs.index+1}
			       </td>
			      <td width="10%" height="30" bgcolor="#FFFFFF" align="center" id="menu${menu.id}">
			      	${menu.name}
			      </td>
			      <td width="10%" height="30" bgcolor="#FFFFFF" align="center">
			      	<a id="edit${menu.id}" href="javascript:edit(${menu.id},'${menu.name}')">修改</a> 
			      	<a id="edit_submit${menu.id}" href="javascript:edit_submit(${menu.id})" style="display: none">保存</a>
			      	<a href="javascript:del(${menu.id})">删除</a>
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
