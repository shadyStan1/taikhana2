package com.learning;
public class PatternHalfTriangle3 {
public static void main(String[] args) {
	int n = 6;
	int count = 1;
	for (int r = 0; r < n; r++) {
		
		for (int c = 0; c <= r; c++) 
		{
			System.out.print((count--)+ " ");
			if(r > c)
				System.out.print("* ");
		}
		System.out.println();
		count = count + (2*r) + 3;
	}
}
}
