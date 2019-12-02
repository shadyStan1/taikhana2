package com.kartiksirapti.arrays;
public class TestArray 
{
public static void main(String[] args) {
	// we can pass alphabet in quotes inside size subscript in arrays
	// and it will be converted into ASCII value
	int[] a = new int[-5];
	//throw new java.lang.NegativeArraySixeException("negative size");
	System.out.println(a.length);
}
}
