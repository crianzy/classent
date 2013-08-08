<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	function login() {
		var username = $("#username").val();
		var password = $("#password").val();
		$.ajax({
			type:"post",
			url:"userAction_loginAjax",
			data:{username:username,password:password},
			success:function(data){
				if(data.loginFlag=="0"){
					alert("tes");
					location.reload();
				}
				else{
					$("#loginError").html("用户名或密码错误");
				}
			}
		});
	}
</script>
<div class="left_box">
	<dl>
		<dt>
			<em>用户中心 </em>
		</dt>
		<dd>
			<div id="Con_11">
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
								<font color="red"><div id="loginError"></div></font> 
								<li>用户名：
									<input name="username" id="username" type="text" class="inputtext" style="width: 125px;" />
								</li>
								<li>密　码：
									<input name="password" type="password" id="password" class="inputtext" style="width: 125px;" />
								</li>
								<li id="loginButton"><a href="userAction_registUI">注册</a>&nbsp;&nbsp; 
									<input type="submit" value="登　录" class="inputbutton" onclick="login()" />
								</li>
							</s:else>
						</ul>
					</div>
			</div>
		</dd>
	</dl>
</div>

