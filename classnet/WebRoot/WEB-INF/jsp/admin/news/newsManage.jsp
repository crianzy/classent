<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>My JSP 'newsManage.jsp' starting page</title>

<link href="css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	function gotoPage(num){
		var url = "admin/newsAdminAction_newsManage?currentPage="+num;
		if(url.indexOf("search")){
			url = "admin/newsAdminAction_search?currentPage="+num;
			
			if("${key }"!=""){
				url+="&key="+$("#key").val();
			}
			if("${menuId }"!="0"){
				url+="&menuId="+$("#menuId").val();
			}
		}
		location = url;
	}
	
	function selectAll(obj){
		var array = document.getElementsByName("newsId");
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
			location='admin/newsAdminAction_delNews?newsId='+id;
		}
		else{
			var array = document.getElementsByName("newsId");
			var idstr="";
			for(var i=0;i<array.length;i++){
				if(array[i].checked){
					idstr+=array[i].value+",";
				}
			}
			if(idstr){
				location='admin/newsAdminAction_delNews?ids='+idstr;
			}
			else{
				alert("您还未选择");
			}
		}
	}
	function search(){
		var key = document.getElementById("key");
		var menuId = document.getElementById("menuId");
		var url = "admin/newsAdminAction_search?1=1";
		if(key.value!=""){
			url+="&key="+key.value;
		}
		if(menuId.value!=0){
			url+="&menuId="+menuId.value;
		}
		location=url;
	}
	function changestatus(id,status){
		$.ajax({
			url:"admin/newsAdminAction_changeNewsStatus?",
			type:"get",
			data:"newsId="+id+"&status="+status,
			success:function(data){
				if(data.flag=="1"){
					alert("操作成功");
				}
				else{
					alert("操作失败");
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
						page="../pub/left_news.jsp"></jsp:include></td>
				<td valign="top">
					<div id="c01">
						<dl>
							<dt style="padding-right:20px;">
								新闻栏目： <select id="menuId" name="menuId" style="width:100px;"
									onchange="search()">
									<option value="0">全部</option>
									<s:iterator value="newsTypeList" var="menu" >
										<option value="${menu.id}" ${menu.id==menuId?
											'selected=selected':''}>${menu.name}</option>
									</s:iterator>
								</select>
							</dt>
							<dt>
								关键字:<input type="text" class="qidian" id="key" name="key"
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
								<td width="30%" height="30" bgcolor="#e5edfa" align="center">标题</td>
								<td width="20%" height="30" bgcolor="#e5edfa" align="center">发布时间</td>
								<td width="10%" height="30" bgcolor="#e5edfa" align="center">点击量</td>
								<td width="10%" height="30" bgcolor="#e5edfa" align="center"></td>
								<td width="20%" height="30" bgcolor="#e5edfa" align="center">操作选项</td>
							</tr>
							<s:if test="list!=null">
								<s:iterator value="list" var="news" status="vs">
									<tr>
										<td height="30" bgcolor="#FFFFFF" align="center"><input
											type="checkbox" name="newsId" value="${id}" />
												${vs.index+1}
										</td>
										<td height="30" bgcolor="#FFFFFF" align="left"
											style="padding-left:10px;"><a href="newsAction_readNews?newsId=${id }" target="_blank">${news.title}</a>
										</td>
										<td height="30" bgcolor="#FFFFFF" align="center"><s:date
												name="pubTime" format="yyyy-MM-dd HH:mm" />
										</td>
										<td height="30" bgcolor="#FFFFFF" align="center">${news.viewNum}</td>
										<td height="30" bgcolor="#FFFFFF" align="center"><select
											onchange="changestatus(${news.id},this.value)">
												<option value="1" ${news.status==1? 'selected=selected':''}>普通</option>
												<option value="2" ${news.status==2? 'selected=selected':''}>推荐</option>
												<option value="3" ${news.status==3? 'selected=selected':''}>栏目头条</option>
												<option value="4" ${news.status==4? 'selected=selected':''}>首页大图新闻</option>
										</select></td>
										<td width="10%" height="30" bgcolor="#FFFFFF" align="center">
											<a href="admin/newsEidtAction_pubNewsUI?id=${id }">修改</a> <a href="javascript:del(${id})">删除</a>
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
						<p>
							<input type="checkbox" onclick="selectAll(this)" /> 全选 <input
								type="button" value="删除" class="shanchu"
								onclick="javascript:del(0)" />
						</p>
						<jsp:include page="/WEB-INF/jsp/pub/page.jsp"></jsp:include>
					</div> <br /> <br /></td>
			</tr>
		</table>
		<jsp:include page="../pub/foot.jsp"></jsp:include>
	</div>

</body>
</html>
