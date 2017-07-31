package com.lyw.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lyw.inface.Color;

public class Grey implements Color {
	private Object[] array;
	private List<Object> list;
	private Set<Object> set;
	private Map<Object,Object> map;
	@Override
	public void print() {
		System.out.print("ºÚ°×´òÓ¡");
	}
	public Object[] getArray() {
		return array;
	}
	public void setArray(Object[] array) {
		this.array = array;
	}
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	public Set<Object> getSet() {
		return set;
	}
	public void setSet(Set<Object> set) {
		this.set = set;
	}
	public Map<Object,Object> getMap() {
		return map;
	}
	public void setMap(Map<Object,Object> map) {
		this.map = map;
	}

}
