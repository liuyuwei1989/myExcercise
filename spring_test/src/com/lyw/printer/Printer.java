package com.lyw.printer;

import com.lyw.inface.Color;
import com.lyw.inface.Paper;

public class Printer {
	private Paper paper;

	private Color color;
	
	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void print(){
		this.paper.print();
		System.out.print("+");
		this.color.print();
	}
	
}
