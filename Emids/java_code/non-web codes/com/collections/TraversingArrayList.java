package com.collections;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class TraversingArrayList {
public static void main(String[] args) {
	ArrayList al = new ArrayList();
	
	al.add("A");
	al.add("b");
	al.add("c");
	al.add("d");
	al.add("e");
	
	Iterator i = al.iterator();
	
	while(i.hasNext()){
		long start = System.nanoTime();
		
		System.out.println(i.next());
		
		long end = System.nanoTime();
		
		long elapsedTime = end - start;	
		System.out.println(TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS));
//		double elapsedTime =(double) (end - start)/1000000000.0;
		
		//System.out.println(elapsedTime);
		
		
	}
	
	/*
	 * a short for loop to
	 * reduce the no of lines of code
	 */
//	private static long enumSumOf(Vector<Integer> vec) {
//	    long sum = 0;
//	    for (Enumeration<Integer> e = vec.elements(); e.hasMoreElements(); )
//	        sum += e.nextElement();
//	    return sum;
//	}
	//System.out.println(TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS));
			//System.out.println((double)System.nanoTime()*0.0000000010);
}
}
