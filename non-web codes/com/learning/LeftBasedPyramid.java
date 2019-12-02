package com.learning;
public class LeftBasedPyramid {
public static void main(String[] args) {
	int n = 5;
	for(int r =0; r<=n/2; r++)
	{
		for (int c = 0; r >= c ; c++) {
			System.out.print("* ");
		}
		System.out.println();
	}
	for (int r = n/2 +1; r<n ; r++) {
		for (int c = 0; c <= n/2 ; c++) {
			if(c == 0 ||
					r + c == n-1)
				System.out.print("* ");
		}
		System.out.println();
		
	}
//	for(int r = n/2 +1; r <n; r++){
//		for (int c = 0; r>= c; c++) {
//			System.out.print("* ");
//		}
//		System.out.println();
//	}
	
	
}
}
