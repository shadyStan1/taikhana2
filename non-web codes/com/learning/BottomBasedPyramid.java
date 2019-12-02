package com.learning;
public class BottomBasedPyramid {
	public static void main(String[] args) {
		int n =5;
		for (int x = 1; x < n; x++) {
			for (int y = 5; y>x ; y--) {
				System.out.print(" ");
			}
			for (int k = 0; k < x  ; k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
