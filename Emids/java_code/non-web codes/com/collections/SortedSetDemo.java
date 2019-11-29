package com.collections;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo {
public static void main(String[] args) {
	
	
	SortedSet ss = new TreeSet();
	
	ss.add("A");
	ss.add("Z");
	ss.add("P");
	ss.add("G");
	ss.add("U");
	
	System.out.println(ss);
	
	SortedSet headSet = ss.headSet("P");
	System.out.println(headSet);
	
	SortedSet tailSet = ss.tailSet("P");
	System.out.println(tailSet);
	
	Comparator c = ss.comparator();
	System.out.println(c);
}
}
