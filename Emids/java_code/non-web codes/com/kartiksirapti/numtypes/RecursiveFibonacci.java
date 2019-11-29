package com.kartiksirapti.numtypes;
public class RecursiveFibonacci {
public static void recfib(int c, int n1, int n2)
{
	if(c > 0)
	{
		int n3 = n1 + n2;
		System.out.print(n1 + ", ");
		recfib(--c, n2, n3);
	}
}
public static void main(String[] args) {
	recfib(12, 0, 1);
}
}
