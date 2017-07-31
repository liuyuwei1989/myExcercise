package com.bwf.utils;

import java.util.ArrayList;
import java.util.List;

import com.lyw.entity.Users;

public class PagingUtils {
	private int page=1;
	private int prePage;
	private int nextPage;
	private List<Users> userList;
	private int totalPage;
	private int totalRows;
	private int rowsPerPage=3;
	private List<Integer> pageList = new ArrayList<Integer>();
	
	public int getPage() {
		if(page==0){
			page=1;
		}
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPrePage() {
		if(page<=1){
			prePage=page;
		}else{
			prePage=page-1;
		}
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		if(page>=getTotalPage()){
			nextPage=totalPage;
		}else{
			nextPage=page+1;
		}
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public List<Users> getUserList() {
		return userList;
	}

	public void setUserList(List<Users> userList) {
		this.userList = userList;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPage() {
		totalPage=(totalRows%rowsPerPage==0?0:1)+totalRows/rowsPerPage;
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	public List<Integer> getPageList() {
		for(int i = 0;i<getTotalPage();i++){
			pageList.add(i+1);
		}
		return pageList;
	}

	public void setPageList(List<Integer> pageList) {
		this.pageList = pageList;
	}
}
