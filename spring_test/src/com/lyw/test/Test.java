package com.lyw.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyw.printer.Printer;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/lyw/config/applicationContext.xml");
		Printer printer = (Printer)context.getBean("printer");
		printer.print();
	}
}
