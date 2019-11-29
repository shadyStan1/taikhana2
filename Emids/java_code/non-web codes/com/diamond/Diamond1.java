package com.diamond;
public class Diamond1 {
public static void main(String[] args) {
	int n = 5;
	for(int r = 0 ; r < n; r++)
	{
		for (int spaces = n; spaces > r+1; spaces--) {
			System.out.print("  ");
		}
		for (int stars = 0; stars <= 2*r ; stars++) {
			//if(stars == 0 || stars == 2*r) //condition for printing hollow diamond
			System.out.print("* ");
			//else
				//System.out.print("  ");
		}
		System.out.println();
	}
	
	for (int r = n-1; r > 0; r--) {
		for (int spaces = n; spaces > r; spaces--) {
			System.out.print("  ");
		}
		for (int stars = 1; stars < 2*r; stars++) {
			System.out.print("* ");
		}
		System.out.println();
	}
}
}
