package com.madhusircodes;
/*
 OVERRIDING OBJECT CLASS METHODS
 */
public class OverrideObjectClass {
	int num; String name; double marks;
public OverrideObjectClass(int num, String name, double marks) {
	this.num = num;
	this.name = name;
	this.marks = marks;
}

@Override
public boolean equals(Object ob)
{
	OverrideObjectClass sd2 = (OverrideObjectClass) ob; //downcasting
	if(this.num == sd2.num)
		return true;
	else
		return false;
}
@Override
public String toString()
{
	return this.name + "__" + this.num + "  "+ this.marks;
}
public static void main(String[] args) {
	OverrideObjectClass sd = new OverrideObjectClass(123, "aman", 12.23);
	OverrideObjectClass sd1 = new OverrideObjectClass(123, "aman", 12.23);
	boolean b = sd.equals(sd1);
	System.out.println(b);
	System.out.println(sd.toString() +"........." + sd1.toString());
}
}
