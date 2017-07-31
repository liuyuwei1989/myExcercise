package com.bwf.action;

import java.util.Iterator;
import java.util.List;

import com.bwf.dao.DepartDAO;
import com.bwf.entity.Depart;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DepartAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Depart> departList;
	
	public String selectAll(){
		DepartDAO dao = new DepartDAO();
		departList=dao.selectAll();
		return "allDepart";
	}

	public List<Depart> getDepartList() {
		return departList;
	}

	public void setDepartList(List<Depart> departList) {
		this.departList = departList;
	}
}
