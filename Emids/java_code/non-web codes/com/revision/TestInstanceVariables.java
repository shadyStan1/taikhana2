package com.revision;
public class TestInstanceVariables {
	public Object[] element;
	
public void m1(){
	try{System.out.println(element.length);
	}
	catch(Exception e){
	element = new Object[10];
	System.out.println(element.length);
	}
//	System.out.println(element.length);
}
public static void main(String[] args) {
	TestInstanceVariables ti = new TestInstanceVariables();
	ti.m1();
}
}
