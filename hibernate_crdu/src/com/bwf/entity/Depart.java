package com.bwf.entity;

import java.util.Set;

public class Depart {
	private int id;
	private String departName;
	private int count;
	private Set<Users> userSet;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Set<Users> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<Users> userSet) {
		this.userSet = userSet;
	}

}
