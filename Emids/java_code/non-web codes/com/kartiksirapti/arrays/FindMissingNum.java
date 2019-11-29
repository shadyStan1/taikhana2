package com.kartiksirapti.arrays;
public class FindMissingNum {
public static void main(String[] args) {
	int[] a = {12,17,19,25};
	for(int i = 0 ; i < a.length-1; i++)
	{
		for (int j = a[i]+1; j < a[i+1]; j++) {
			System.out.println(j);
	}
	}
}
}
