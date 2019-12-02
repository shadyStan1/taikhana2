package com.kartiksirapti.arrays.sorting;
public class BubbleSort {
public static void main(String[] args) {
	int []ar = {12,3,43,6,7,52};
	int[] rev_ar = sort(ar);
	for(int x: rev_ar)
	{
		System.out.print(x + ", ");
	}
}
public static int[] sort(int[] ar)
{
	for (int i = 0; i < ar.length-1; i++) {
		for (int j = i+1; j < ar.length; j++) {
			if(ar[i] > ar[j])    //for desc change > to <
			{
				int t = ar[i];
				ar[i] = ar[j];
				ar[j] = t;
			}
		}
		
	}
	return ar;
}
}
