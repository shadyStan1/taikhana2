package com.madhusircodes;
public class TestHashCodeMethod {
	int m1;
	String name;
	public TestHashCodeMethod(String name) 
	{
		this.name = name;
	}
	public TestHashCodeMethod(int m1)
	{
		this.m1 = m1;
	}
public static void main(String[] args) {
	TestHashCodeMethod ob1 = new TestHashCodeMethod("aman");
	TestHashCodeMethod ob2 = ob1;
	TestHashCodeMethod ob3 = new TestHashCodeMethod(87);
	if(ob1.equals(ob2))       //equals() compare the hashcode of the 2 objects then returns true or 
								//false
	System.out.println(ob1.hashCode()+ "   " + ob2.hashCode());
	
	System.out.println(ob3);
	System.out.println(ob1.toString());  //toString() returns string representation of the object
	//if toString() is removed and pass only ref variable inside println() then
	//toString() is implicitly called which represents the same string displayed by toString()
}
}
