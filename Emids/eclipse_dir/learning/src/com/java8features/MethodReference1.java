package com.java8features;

/*
 * demonstration of method reference
 * in static methods
 * 
 */

@FunctionalInterface
interface demo1{
	
	void test(int a, int b);
}

public class MethodReference1 {
	
	public static void add(int a, int b){
		System.out.println(a+b);
	}
	
	public static void main(String[] args) {
		
		demo1 d = MethodReference1::add;
			
		d.test(10, 20);
	}
}
