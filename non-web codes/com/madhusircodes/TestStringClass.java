package com.madhusircodes;
public class TestStringClass {
	public static void main(String[] args) {
		
		String s1 = new String("hello");
		String s2 = new String("hello");
		
		int i1 = s1.hashCode();
		int i2 = s2.hashCode();
		/*
		 HASHCODE() of Object class is overridden in String class 
		 */
		System.out.println("hashcode of s1 = " +i1);
		System.out.println("hashcode of s2 = " + i2);
		
		/*
		 EQUALS Method is overridden in String class
		 which compares each and every character in the given 2 stringse
		 */
		if(s1.equals(s2))
			System.out.println("true");
		
		if(s1==s2)
			System.out.println("true");
		else
			System.out.println("false");
	}
}
