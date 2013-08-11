<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<title>后台管理--用户管理</title>
<link href="css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	function search() {
		var url = "admin/userAdminAction_list?";
		var key = $("#key").val();
		if (key != "") {
			url += "&key=" + key;
		}
		location = url;
	}
	function gotoPage(num) {
		var url = "admin/userAdminAction_list?key=${key }";
		url += "&currentPage=" + num;
		location = url;
	}
	function changeStatus(id , enable){
		$.ajax({
			type:"post",
			url:"admin/userAdminAction_changeUserStatus",
			data:{id : id , enable : enable},
			success:function(data){
				if(data.flag=="1"){
					location.reload();
				}
			}
		});
	}
</script>
</head>

<body>
	<div class="content">
		<jsp:include page="../pub/top.jsp"></jsp:include>
		<!--头部结束-->
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td class="left" valign="top"><jsp:include
						page="../pub/left.jsp"></jsp:include></td>
				<td valign="top">
					<div id="c01">
						<dl>
							<dt>
								用户名:<input type="text" class="qidian" id="key" name="key"
									value="${key}" />
							</dt>
							<dd>
								<input type="button" value="查询" class="chaxun"
									onclick="search()" />
							</dd>
						</dl>
						<table width="99%" border="0" cellpadding="0" cellspacing="1"
							bgcolor="#dae2e5">
							<tr>
								<td width="10%" height="30" bgcolor="#e5edfa" align="center">ID</td>
								<td width="20%" height="30" bgcolor="#e5edfa" align="center">用户名</td>
								<td width="20%" height="30" bgcolor="#e5edfa" align="center">密码</td>
								<td width="20%" height="30" bgcolor="#e5edfa" align="center">邮箱</td>
								<td width="10%" height="30" bgcolor="#e5edfa" align="center">状态</td>
								<td width="20%" height="30" bgcolor="#e5edfa" align="center">操作选项</td>
							</tr>
							<s:if test="list != null">
								<s:iterator value="list" status="vs">
									<tr>
										<td height="30" bgcolor="#FFFFFF" align="center"><input
											type="checkbox" name="userId" value="${id}" /> ${vs.index+1}</td>
										<td height="30" bgcolor="#FFFFFF" align="left"
											style="padding-left:10px;">${username}</td>
										<td height="30" bgcolor="#FFFFFF" align="center">${password}</td>
										<td height="30" bgcolor="#FFFFFF" align="center">${email}</td>
										<td height="30" bgcolor="#FFFFFF" align="center">
										<s:if test="enable">
	      									正常
	      								</s:if> 
	      								<s:else>
											<span style="color:red">停用</span>
										</s:else>
										</td>
										<td width="10%" height="30" bgcolor="#FFFFFF" align="center">
										<s:if test="enable">
											<a href="javascript: changeStatus( ${id } , false)">停用</a>&nbsp;
	      									恢复
	      								</s:if> <s:else>
	      									停用&nbsp;
							      			<a href="javascript: changeStatus( ${id } , true ) ">恢复</a>
										</s:else>
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
						<jsp:include page="/WEB-INF/jsp/pub/page.jsp"></jsp:include>
					</div> <br /> <br />
				</td>
			</tr>
		</table>
		<jsp:include page="../pub/foot.jsp"></jsp:include>
	</div>
</body>
</html>
