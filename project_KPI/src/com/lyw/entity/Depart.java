package com.lyw.entity;

import java.util.Set;

public class Depart {
	private int id;
	private String name;
	private int count;
	private Set<Users> userSet;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Users> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<Users> userSet) {
		this.userSet = userSet;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}


}
