package com.java8features;

/*
 * demonstration of method reference
 * in instance methods
 * 
 */

interface demo2{
	void add(int i, int k);
}
public class MethodReference2 {

	public void method(int k, int l){
		System.out.println(k+l);
	}
	public static void main(String[] args) {
		
		MethodReference2 mr = new MethodReference2();
		
		demo2 d2 = mr::method;
		
		d2.add(10, 20);
	}
}
