package com.bwf.action;

import com.bwf.entity.Users;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;


public class RegisterAction extends ActionSupport implements ModelDriven<Users> {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private Users user = new Users();
	
	private class Temp{
		public int num=2;
		public String str="±±·ç´µ";
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public String getStr() {
			return str;
		}
		public void setStr(String str) {
			this.str = str;
		}
	}
	@Override
	public Users getModel() {
		return user;
	}

	public String doRegiser() {
		
		ValueStack factory = ActionContext.getContext().getValueStack();
	
		factory.getRoot().add(new Temp());

		// ActionContext context = ActionContext.getContext();
		//
		// ValueStack stack = context.getValueStack();
		//
		// Map<String,Object> map = stack.getContext();
		//
		// map.put("stackInfo","info");
		// Map<String, Object> map = context.getSession();
		// map.put("sess", user);
		//
		// HttpServletRequest request = ServletActionContext.getRequest();
		// HttpSession session = request.getSession();
		// session.setAttribute("msg", "AAAA");
		//
		//
		// Map<String, Object> request1 = (Map<String, Object>)
		// ActionContext.getContext().get("request");
		// request1.put("msg2", "11111");
		return "register";
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
