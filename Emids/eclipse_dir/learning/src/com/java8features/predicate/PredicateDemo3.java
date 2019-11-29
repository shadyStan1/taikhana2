package com.java8features.predicate;

import java.util.function.Predicate;

/*
 * predicate inside a function
 */
public class PredicateDemo3 {
	
	public static void main(String[] args) {
		
		predicate(10, i -> i < 20);
		
	}
	
	public static void predicate(int n, Predicate<Integer> lessThan){
		
		if(lessThan.test(n))
			System.out.println(true);
	}
}
