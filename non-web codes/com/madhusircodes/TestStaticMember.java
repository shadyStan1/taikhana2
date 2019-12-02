package com.madhusircodes;

class supclass
{
	 int x = 20;
}
class mainclass extends supclass
{
	 int x = 10;
}
public class TestStaticMember {
	public static void main(String[] args) {
		mainclass mc = new mainclass();
		supclass mc1 = new mainclass();  //storing the child class object in superclass ref
		mainclass mc3 = (mainclass) mc1; 
		supclass sc2 = new supclass();
		System.out.println(mc.x);// in case of static variables it is variable hiding
		System.out.println(mc1.x);
		System.out.println(sc2.x);
		System.out.println(mc3.x);
		//System.out.println(mainclass.x);
	}
	}
