package com.bwf.vo;

import java.util.List;

import com.bwf.dao.UserDAO;
import com.bwf.entity.Users;

public class PageResult {
	
	private int page=1;
	private int nextPage;
	private int prePage;
	private int totalRows;
	private int totalPages;
	private int rowsPerPage=3;
	private String key_word;
	private int age_min;
	private int age_max;
	private List<Users> userList;
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getNextPage() {
		if(page>=totalPages){
			nextPage=page;
		}else{
			nextPage=page+1;
		}
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getPrePage() {
		if(page<=1){
			prePage=1;
		}else{
			prePage=page-1;
		}
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getAge_min() {
		return age_min;
	}

	public void setAge_min(int age_min) {
		this.age_min = age_min;
	}

	public int getAge_max() {
		return age_max;
	}

	public void setAge_max(int age_max) {
		this.age_max = age_max;
	}

	public List<Users> getUserList() {
		return userList;
	}

	public void setUserList(List<Users> userList) {
		this.userList = userList;
	}

	public String getKey_word() {
		return key_word;
	}

	public void setKey_word(String key_word) {
		this.key_word = key_word;
	}

	public int getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	public void selectByPage() {
		UserDAO userDAO = new UserDAO();
		totalRows=userDAO.getRows(key_word, age_min, age_max);
		totalPages=totalRows/rowsPerPage+((totalRows%rowsPerPage==0)?0:1);
		userList = userDAO.selectByCondition(key_word, age_min, age_max, rowsPerPage, page);
	}
}
