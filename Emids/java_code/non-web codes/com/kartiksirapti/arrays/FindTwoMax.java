package com.kartiksirapti.arrays;
public class FindTwoMax {
	public static void main(String[] args) {
		int[] ar = {12,5,48,3,78};
		findTwoMax(ar);
	}
	public static void findTwoMax(int[] num)
	{
		/*
		 Here in the logic we assume the first max is at the first index
		 and second max is at the second index
		 inside first if we compare for the elements of arrays with the max1 to decide
		  the first 
		 */
		int max1 = num[0];
		int index1 = 0;
		int max2 = num[1];
		int index2 = 1;
		for (int i = 0; i < num.length; i++) {
			if(max1 < num[i])  
			{
				max2 = max1;
				max1 = num[i];
				index2 = index1;
				index1 = i;
			}
			else if(max2 < num[i])
			{
			max2 = num[i];
			index2 = i;
			}
		}
		System.out.println("First max exists at index "+index1+ "= " + max1);
		System.out.println("second max exists at index "+index2+ "= "+max2);
	}
}
