<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<div class="left_box">
	<dl>
		<dt>
			<em>用户中心 </em>
		</dt>
		<dd>
			<div id="Con_11">
				<form action="userAction_login" method="post" style="margin:0">
					<div id="LoginFrom" class="Login_ajax">
						<ul style="line-height:30px;">
							<s:if test="#session.user != null">
								<li>欢迎您:</li>
								<li style="padding-left:20px;">${user.username }</li>
								<li style="text-align:center">
								<a href="#">进入后台管理</a> &nbsp;&nbsp;|&nbsp;&nbsp;
								<a href="masterAction_index">进入用户中心</a>
								&nbsp;&nbsp;|&nbsp;&nbsp; <a href="userAction_logout">退出登录</a>
								</li>
							</s:if>
							<s:else>
								<div><font color="red">${errorMsg }</font> </div>
								<li>用户名：
									<input name="username"  type="text" class="inputtext" style="width: 125px;" />
								</li>
								<li>密　码：
									<input name="password" type="password" class="inputtext" style="width: 125px;" />
								</li>
								<li id="loginButton"><a href="userAction_registUI">注册</a>&nbsp;&nbsp; 
									<input type="submit" value="登　录" class="inputbutton" />
								</li>
							</s:else>
						</ul>
					</div>
				</form>
			</div>
		</dd>
	</dl>
</div>

<script type="text/javascript">
	
</script>
