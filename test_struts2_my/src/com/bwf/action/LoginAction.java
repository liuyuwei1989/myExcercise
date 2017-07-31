package com.bwf.action;

import com.bwf.biz.UserBiz;

public class LoginAction {
	private String userName;
	private String userPwd;
	private String msg;

	public String execute() {
		UserBiz biz = new UserBiz();
		if (biz.login(userName, userPwd)) {
			return "success";
		} else {
			msg = "your uname or pwd is Error";
			return "failed";
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
