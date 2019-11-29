package com.java8features.predicate;

import java.util.function.Predicate;

/*
 * Chaining of Predicate
 */
public class PredicateDemo2 {
	public static void main(String[] args) {
		
		Predicate<Integer> lessThan = i -> i < 20;
		
		Predicate<Integer> greaterThan = (i) -> i > 15;
		
		boolean result = greaterThan.and(lessThan).test(12);
		
		System.out.println(result);
		
		System.out.println(greaterThan.and(lessThan).test(17));
		
		
		
	}
}
