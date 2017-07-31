package com.lyw.impl;

import com.lyw.inface.Paper;

public class A4 implements Paper {
	
	private Paper a3;
	
	private String str;
	
	public A4(Paper a3, String str) {
		super();
		this.a3 = a3;
		this.str = str;
	}

	@Override
	public void print() {
		System.out.print("A4ж╫уе");
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Paper getA3() {
		return a3;
	}

	public void setA3(Paper a3) {
		this.a3 = a3;
	}

}
