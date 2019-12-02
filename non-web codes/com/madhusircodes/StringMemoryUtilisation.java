package com.madhusircodes;
public class StringMemoryUtilisation {
/*
 TWO DIFFERENT SECTIONS IN STRING POOL :-
 										1. CONSTANT POOL
 										2. NON-CONSTANT POOL
 */
	public static void main(String[] args) {
		String s1 = new String("java"); //stored in non-constant pool as different object
		String s2 = "java";  //stored in constant pool
		String s3 = new String("java");  //stored in constant pool as different object
		String s4 = "java";  //share the same object as s2
		String s5 = "j2ee"; // stored in constant pool
		String s6 = s1 + s5; //stored in non constant pool
		String s7 = s2 + "j2ee";
		String s8 = "java" + "j2ee";
		String s9 = "javaj2ee";
		
		
		System.out.println(s1 == s2);  //false
		System.out.println(s1 == s3);	//false
		System.out.println(s2 == s4);	//true
		System.out.println(s6 == s7);	//false
		System.out.println(s8 == s9); 	//true
	}
}
