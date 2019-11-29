package com.collections;

import java.util.Enumeration;
import java.util.Stack;

public class StackDemo {
	public static void main(String[] args) {
		Stack st = new Stack();
		st.push("A");
		st.push("d");
		st.push("b");
		st.push(1);
		Enumeration e = st.elements();
		while(e.hasMoreElements()){
			System.out.println(e.nextElement());
		}
		int i = st.search("A");
		System.out.println(i);
		System.out.println(st);
	}
}
