package com.learning;
public class PatternHalfTriangle1 
{
	public static void main(String[] args) {
	int n = 5; 
	for (int i = 0; i < n; i++) 
	{
		int count = i + 1;
		for (int j = 0; j <= i; j++) {
			System.out.print(count + " ");
			count = n - 1 + count + j;
		}
		System.out.println();
	}
}
}
