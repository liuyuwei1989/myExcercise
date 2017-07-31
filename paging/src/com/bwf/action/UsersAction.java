package com.bwf.action;

import com.bwf.vo.PageResult;
import com.opensymphony.xwork2.ActionSupport;

public class UsersAction extends ActionSupport{
	
	private PageResult pageResult = new PageResult();
	
	private static final long serialVersionUID = 1L;

	public String select(){
		return "show";
	}

//	public String selectByCondition(){
//		if(page==0){
//			page=1;
//		}
//		UserDAO dao = new UserDAO();
//		userList=dao.selectByCondition(key_word, age_min, age_max,page);
//		if(userList.size()==0){
//			page=page-1;
//			userList=dao.selectByCondition(key_word, age_min, age_max,page);
//		}
//		return "show";
//	}
	public String selectByCondition(){
		getPageResult().selectByPage();
		return "show";
	}

	public PageResult getPageResult() {
		return pageResult;
	}

	public void setPageResult(PageResult pageResult) {
		this.pageResult = pageResult;
	}
	

}
