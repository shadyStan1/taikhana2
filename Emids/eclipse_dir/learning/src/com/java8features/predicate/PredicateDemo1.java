package com.java8features.predicate;

import java.util.function.Predicate;

public class PredicateDemo1 {

	public static void main(String[] args) {
		Predicate<Integer> lessThan = i -> i < 10;
		
			System.out.println(lessThan.test(15));
	}
}
