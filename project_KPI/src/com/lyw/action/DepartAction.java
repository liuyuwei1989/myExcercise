package com.lyw.action;

import java.util.List;

import com.lyw.dao.DepartDAO;
import com.lyw.dao.UserDAO;
import com.lyw.entity.Depart;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DepartAction extends ActionSupport implements ModelDriven<Depart>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Depart depart = new Depart();
	
	private List<Depart> departList;
	
	public String showAll(){
		DepartDAO dao = new DepartDAO();
		departList=dao.selectAll();
		return "showAll";
	}
	
	public String departManage(){
		DepartDAO dao = new DepartDAO();
		departList=dao.selectAll();
		return "manage";
	}
	
	

	public List<Depart> getDepartList() {
		return departList;
	}

	public void setDepartList(List<Depart> departList) {
		this.departList = departList;
	}

	@Override
	public Depart getModel() {
		return depart;
	}

	public Depart getDepart() {
		return depart;
	}

	public void setDepart(Depart depart) {
		this.depart = depart;
	}

}
