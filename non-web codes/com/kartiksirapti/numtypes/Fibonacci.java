package com.kartiksirapti.numtypes;
public class Fibonacci {
public static void main(String[] args) {
 fibonacci(5);
}
	public static void fibonacci(int num)
	{
		int n1 = 0, n2 = 1;
		System.out.print(n1 +", " +n2+ ", ");
		while( num > 0)
		{
			int n3 = n1 + n2;
			System.out.print(n3 + ", ");
			n1 = n2;
			n2 = n3;
			
			num--;
		}
	}
}

