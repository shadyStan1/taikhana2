package com.java8features.streams;

import java.util.ArrayList;
import java.util.List;

public class StreamReductionDemo {

	public static void main(String[] args) {
		
		
		List<Person> list = new ArrayList<>(5);
		int[] age = {40, 30, 20, 13, 11};
		for (int i = 0; i < 5; i++) {
			Person per = new Person();
			per.setAge(age[i]);
			
			list.add(per);
			
		}
		
		
		//list.stream().map(y -> y.getAge()+2).forEach(y -> System.out.println(y));
		
		list.stream().filter(y -> y.getAge() == 2 * 20).map(x -> x.getAge() + 100).forEach(y -> System.out.println(y));
		
		
		list.stream().filter(y -> y.getAge() == 2 * 20).forEach(y -> System.out.println(y.getAge()));
	}
}
