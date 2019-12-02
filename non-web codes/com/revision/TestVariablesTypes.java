package com.revision;
public class TestVariablesTypes {
	static int x = 10;
	int bde = 12;
	{
		System.out.println(bde);
	}
	{
		System.out.println(bde);
	}
	public void m1(int... a){
		System.out.println(a);
	}
public static void main(String[] args) {
	{
		System.out.println(x);
	}
	new TestVariablesTypes().m1();
	System.out.println(x + "  " + new TestVariablesTypes().bde );
	
}
}
