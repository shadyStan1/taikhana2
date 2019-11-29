package com.java8features.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo1 {
	public static void main(String[] args) {
		
		
		/*
		 * terminal methods
		 * forEach(), collect(), reduce()
		 */
		List<Integer> list = Arrays.asList(10, 21, 12, 5, 10);
		
		Stream<Integer> st1 = list.stream();
		//forEach()
		st1.forEach(y -> System.out.print(y+", "));
		System.out.println();
		//end forEach()
		
		//collect()
		List<Integer> list1 = list.stream().collect(Collectors.toList());
		System.out.println(list1);
		//end collect()
		
		/*
		 * end terminal methods
		 */
		
		/*
		 * Intermediate functions like-
		 * map(), filter(), sorted()
		 */
		//map()
		Set<Integer> set1 =  list.stream().map(y -> y*y).collect(Collectors.toSet());
		
		System.out.println(set1);;
		//end map()
		
		//sorted()
		Stream<Integer> st3 = list.stream();
		
		st3.sorted().forEach(y -> System.out.print(y+", "));
		System.out.println();
		//end sorted()
		
		//filter()
		Stream<Integer> st2 = list.stream();
		
		st2.filter(y -> y > 10).forEach(y -> System.out.print(y+", "));
		System.out.println();
		//end filter()
		
		
		
	}
}
