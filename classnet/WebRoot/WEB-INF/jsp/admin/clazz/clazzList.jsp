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

<title>后台管理--课程列表</title>
<link href="css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
function selectAll(obj){
	var array = document.getElementsByName("clazzId");
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
		location='admin/clazzAdminAction_delClazz?clazzId='+id;
	}
	else{
		var array = document.getElementsByName("clazzId");
		var idstr="";
		for(var i=0;i<array.length;i++){
			if(array[i].checked){
				idstr+=array[i].value+",";
			}
		}
		if(idstr){
			location='admin/clazzAdminAction_delClazz?ids='+idstr;
		}
		else{
			alert("您还未选择");
		}
	}
}
function search(){
	var key = $("#key").val();
	var menuId = $("#menuId").val();
	var parentMenuId = $("#parentMenuId").val();
	var url = "admin/clazzAdminAction_clazzList?1=1";
	if(key!=""){
		url+="&key="+key;
	}
	if(parentMenuId!=0){
		url+="&parentId="+parentMenuId;
	}
	if(menuId&&menuId!=0){
		url+="&clazzMenuId="+menuId;
	}
	if($("#fileTypeId").val()!=0){
		url+='&clazzTypeId='+$("#fileTypeId").val();
	}
	location=url;
}
function changestatus(id,status){
	$.ajax({
		url:"admin/clazzAdminAction_changeClazzStatus?",
		type:"get",
		data:"clazzId="+id+"&status="+status,
		success:function(msg){
			if(msg.flag=="1"){
				alert("操作成功");
			}
			else{
				alert("操作失败");
			}
		}
	});
}
function changeselect(){
	var url='admin/clazzAdminAction_clazzList?1=1';
	var parentId = $("#parentMenuId").val();
	if($("#parentMenuId").val()!=0){
		url+='&parentId='+$("#parentMenuId").val();
	}
	var menuId=$("#menuId").val();
	if(menuId&&menuId!=0&&parentId!=0){
		url+='&clazzMenuId='+menuId;
	}
	if($("#fileTypeId").val()!=0){
		url+='&clazzTypeId='+$("#fileTypeId").val();
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
<jsp:include page="../pub/left_clazz.jsp"></jsp:include>
</td>
<td valign="top">
	<div id="c01">
	<dl>
	<dt style="padding-right:20px;">课程菜单：
		<select id="parentMenuId" name="parentId" style="width:100px;" onchange="changeselect()">
			<option value="0">全部</option>
			<s:iterator value="parentMenuList">
				<option value="${id }" ${parentId==id? 'selected=selected':''}>${name }</option>
			</s:iterator>
		</select>
		<s:if test="#childMenuList != null">
		<select id="menuId" name="clazzMenuId" style="width:100px;" onchange="changeselect()">
			<option value="0">全部</option>
			<s:iterator value="childMenuList">
				<option value="${id}" ${id== clazzMenuId? 'selected=selected':''}>${name }</option>
			</s:iterator>
		</select>
		</s:if>
		文件类型:
		<select id="fileTypeId" name="clazzTypeId" style="width:100px;" onchange="changeselect()">
			<option value="0">全部</option>
			<s:iterator value="clazzTypeList">
				<option value="${id}" ${clazzTypeId== id ?'selected=selected':''}>${name }</option>
			</s:iterator>
		</select>
	</dt>
	<dt>关键字:<input type="text" class="qidian" id="key" name="key" value="${key}"/> </dt>
	<dd><input type="button" value="查询" class="chaxun" onclick="search()"/></dd>
	</dl>
	  <table width="99%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dae2e5">
	    <tr>
	      <td width="10%" height="30" bgcolor="#e5edfa" align="center">ID</td>
	      <td width="30%" height="30" bgcolor="#e5edfa" align="center">标题</td>
	      <td width="20%" height="30" bgcolor="#e5edfa" align="center">发布时间</td>
	      <td width="10%" height="30" bgcolor="#e5edfa" align="center">点击量</td>
	      <td width="10%" height="30" bgcolor="#e5edfa" align="center"></td>
	      <td width="20%" height="30" bgcolor="#e5edfa" align="center">操作选项</td>
	    </tr>
		<s:if test="#clazzList!=null">
		<s:iterator value="clazzList" status="vs">
		<tr>
	      <td height="30" bgcolor="#FFFFFF" align="center">
	        <input type="checkbox" name="clazzId" value="${id}"/> 
	        	${vs.index+1}
	      <td height="30" bgcolor="#FFFFFF" align="left" style="padding-left:10px;"><a href="clazzAction_clazz?clazzId=${id }" target="_blank"> ${name} </a></td>
	      <td height="30" bgcolor="#FFFFFF" align="center"><s:date name="pubTime" format="yyyy-MM-dd HH:mm"/> </td>
	      <td height="30" bgcolor="#FFFFFF" align="center">${viewNum}</td>
	       <td height="30" bgcolor="#FFFFFF" align="center">
	       	<select onchange="changestatus(${id},this.value)">
	       		<option value="1" ${status==1?'selected=selected':''}>正常</option>
	       		<option value="2" ${status==2?'selected=selected':''}>推荐</option>
	       	</select>
	       </td>
	      <td width="10%" height="30" bgcolor="#FFFFFF" align="center">
	      	<a href="admin/clazzEditAction_editUI?clazzId=${id}">修改</a> 
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
	  <!-- <jsp:include page="/WEB-INF/jsp/pub/page.jsp"></jsp:include> -->
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
