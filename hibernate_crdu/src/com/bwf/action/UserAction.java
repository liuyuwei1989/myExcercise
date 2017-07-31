package com.bwf.action;

import java.util.List;

import com.bwf.dao.DepartDAO;
import com.bwf.dao.UserDAO;
import com.bwf.entity.Depart;
import com.bwf.entity.Users;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class UserAction extends ActionSupport implements ModelDriven<Users> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Users user = new Users();
	
	private List<Users> list;
	@Override
	public Users getModel() {
		return user;
	}
	
	public String insert(){
		int id = user.getDepart().getId();
		user.setDepart(new DepartDAO().selectById(id));
		new UserDAO().insert(user);
		return "showAll";
	}

	public String selectAll(){
		setList(new UserDAO().selectAll());
		return "show";
	}
	
	public String delete(){
		new UserDAO().delete(user.getName());
		return "showAll";
	}
	
	public String selectByUser(){
		user = new UserDAO().selectByName(user.getName());
		ValueStack vs = ActionContext.getContext().getValueStack();
		List<Depart> departList = new DepartDAO().selectAll();
		vs.set("departList", departList);
		vs.set("user", user);
		return "update";
	}
	
	public String saveOrUpdate(){
		new UserDAO().saveOrUpdate(user);
		return "showAll";
	}

	public List<Users> getList() {
		return list;
	}

	public void setList(List<Users> list) {
		this.list = list;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
}
