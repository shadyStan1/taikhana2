package com.learning;
public class PatternHalfTriangle {
public static void main(String[] args) {
	int n = 5, nc = 1;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j <= i; j++) {
			System.out.print(nc-- + " ");
			}
		System.out.println();
		nc = 3 + nc + (2*i);
		}
	}
}

