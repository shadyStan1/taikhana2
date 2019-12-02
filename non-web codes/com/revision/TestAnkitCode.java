package com.revision;
class A
{
	static int x;
}

class B extends A
{
	
	{
		x = 10;
	}
}
public class TestAnkitCode {
public static void main(String[] args) {
	B b = new B();
	System.out.println(A.x);
	System.out.println(B.x);
}
}
