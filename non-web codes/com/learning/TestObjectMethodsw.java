package com.learning;
public class TestObjectMethodsw {
public static void main(String[] args) {
	Object ob = new Object();
	String ob1 = new String("abc");
	String ob2 = new String("abc");
	//ob2 = ob1;
	System.out.println(ob1.hashCode());
	System.out.println(ob2.hashCode());
	System.out.println(ob1.toString());
	System.out.println(ob1 == ob2);
}
}
