package com.string.intern;

public class InternDemo {

	public static void main(String[] args) {
		
		String s1 = new String("aman");
		
		String s2 = s1.intern();
		
		
		System.out.println(s1.hashCode() + "    " + s2.hashCode());
	}
}
