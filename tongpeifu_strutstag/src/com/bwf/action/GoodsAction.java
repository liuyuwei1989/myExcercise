package com.bwf.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;


public class GoodsAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<String> goodsList;
	
	private String goodsName;
	
	public String showAll(){
		goodsList = new ArrayList<>();
		goodsList.add("°â×Ó");
		goodsList.add("Ç¯×Ó");
		goodsList.add("ÂÝË¿µ¶");
		return "showAll";
	}

	public String delete(){
		return "delete";
	}
	
	public String modify(){
		return "modify";
	}
	
	public List<String> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<String> goodsList) {
		this.goodsList = goodsList;
	}

	public String getGoods() {
		return goodsName;
	}

	public void setGoods(String goods) {
		this.goodsName = goods;
	}
	
	
}
