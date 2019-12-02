package com.learning;
import java.util.*;
public class PatternHalfTriangleJspider {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the string");
	String s1 = sc.next();
	//String s = "JSPIDER";
	for(int r = 0 ; r<= s1.length(); r++)
	{
		for (int c = 0; c < r; c++) {
			System.out.print(s1.charAt(c) + " ");
		}
		System.out.println();
	}
}
}
