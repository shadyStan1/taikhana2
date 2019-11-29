package com.java8features;


/*
 * 
 * constructor reference 
 */
interface demo3{
	void say();
}
public class MethodReference4 {
	public MethodReference4() {
		System.out.println("Object Created");
	}
	public static void main(String[] args) {
		
	
	demo3 d = MethodReference4::new;
	
	d.say();
	}
}
