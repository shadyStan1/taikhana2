package com.learning;
public class NumericPyramid 
{
	public static void main(String[] args) 
	{
		int f =1 ;
		for (int i = 1; i < 5; i++) 
			{
			for (int j = 5; j > i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < i; k++) {
				System.out.print(f + " ");
				f++;
			}
			System.out.println();
		}
	}	
}
