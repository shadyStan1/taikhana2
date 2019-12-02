package com.kartiksirapti.arrays;
public class FindMaxInArray {
public static void main(String[] args)
	{	
		int[] ar = {12,5,48,3,15};
		int max = find_max(ar);
		System.out.println(max);
	}
public static int find_max(int[] ar)
{
	int max = ar[0];
	int max_index = 0;
	for(int i = 1; i < ar.length; i++)
	{
		if(max < ar[i])
		{
			max = ar[i];
			max_index = i;
		}
	}
	System.out.println("the index of max_num = "+ max_index);
	return max;
}
}
