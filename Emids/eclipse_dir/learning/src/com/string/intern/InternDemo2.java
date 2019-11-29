package com.string.intern;

public class InternDemo2 {

	public static void main(String[] args) {
		String s1= new String("aman");
		
		String s2 = s1.concat("aman");
		
		String s3 = s2.intern();
		
		System.out.println(s2 == s3);
		
		String s4 = ("amanaman");
		
		System.out.println(s2 == s3);
	}
}
