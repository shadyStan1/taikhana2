package com.revision;

public class TestAccessibility {

	static int x = 10;
	
	public void m1(){
		System.out.println(++x);
	}
	public static void main(String[] args) {
		int y;
		TestAccessibility t = new TestAccessibility();
		t.m1();
	}
}
