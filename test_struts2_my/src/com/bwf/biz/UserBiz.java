package com.bwf.biz;

public class UserBiz {

	public boolean login(String userName, String userPwd) {
		if("admin".equals(userName)&&"admin".equals(userPwd)){
			return true;
		}else{
			return false;
		}
	}
	
	
}
