package com.czy.myclass.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.czy.myclass.domain.User;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction {

	private static final long serialVersionUID = 7415497608770607518L;

	private String username;
	private String password;
	private String email;
	private String loginFlag;

	/**
	 * 跳转来的 url
	 */
	private String url;

	/**
	 * 在非首页的 ajax 登陆
	 * @return
	 */
	public String loginAjax() {
		User user = new User();
		user = userService.checkLong(getUsername(), getPassword());
		if (user == null) {
			loginFlag = "1";
		} else {
			loginFlag = "0";
			ActionContext.getContext().getSession().put("user", user);
		}
		return "loginAjax";
	}

	/**
	 * 跳转到 loginUI 页面 并带有调转过来的 url
	 * @return
	 */
	public String loginUI() {
		System.out.println(url);
		return "loginUI";
	}

	/**
	 * 在login UI 上的登录
	 * @return
	 */
	public String login() {
		User user = new User();
		user = userService.checkLong(getUsername(), getPassword());
		if (user == null) {
			// TODO 此处登录错误信息 存在 session中 有待改进
			ActionContext.getContext().getSession().put("errorMsg", "用户名或密码错误");
		} else if(!user.isEnable()){
			ActionContext.getContext().getSession().put("errorMsg","你的账号存在异常，请与管理员联系");
		}else{
			ActionContext.getContext().getSession().remove("errorMsg");
			ActionContext.getContext().getSession().put("user", user);
		}
		if (user != null && !"".equals(url.trim())) {
			return "toUrl";
		}
		return "toHome";
	}

	/**
	 * 退出
	 * @return
	 */
	public String logout() {
		ActionContext.getContext().getSession().remove("user");
		ActionContext.getContext().getSession().remove("errorMsg");
		return "toHome";
	}

	/**
	 * 验证用户名
	 * @return
	 */
	public String checkUsername() {
		if(userService.checkUsernameEnable(username)){
			flag = "1";
		}
		return "checkUsername";
	}

	public String registUI() {
		return "registUI";
	}

	/**
	 * 注册
	 * @return
	 */
	public String regist() {
		if (userService.checkUsernameEnable(this.username)) {
			User registUser = new User();
			registUser.setUsername(username);
			registUser.setPassword(password);
			registUser.setEmail(email);
			User user = userService.regist(registUser);
			ActionContext.getContext().getSession().put("user", user);
			return "registSuccess";
		} else {
			return "registUI";
		}
	}

//-----------get-----set------------------------------------
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}

}
