package com.collections;

/* SORTING OF AN ARRAYLIST IS DONE USING COLLECTIONS.SORT()
 * WHERE WE PASS ARRAYLIST REFERENCE AND OUR DEFINED COMAPARATOR CLASS 
 * OBJECT */


import java.util.*;
public class SortArrayList {
	public static void main(String[] args) {
		ArrayList<Object> al = new ArrayList<Object>();
		al.add("aman");
		al.add("dbas");
		al.add("caca");
		al.add("bvcg");
		
		
		Collections.sort(al,new CompleteComparator());
		System.out.println(al);
		
	}
}
