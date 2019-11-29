package com.kartiksirapti.arrays;
/*
 This code counts the repeatitions of every element in an array
 */
public class CountRepeatitionInArray {
	public static void main(String[] args) {
		int[] ar = {1,1,1,2,2,3,3,3};
		countRepeatition(ar);
	}
	public static void countRepeatition(int [] ar)
	{
		int size = ar.length;
		for (int i = 0; i < size-1; i++) {
			int count = 0;
			for (int j = i+1; j < size; j++) {
				if(ar[i] == ar[j])
				{
					count++;
					int k =j;  //taking temp var k to hold j value as we dont want
							//j value to change finally
					while(k < size-1)
					{ 	//this loop keeps on swapping value
						ar[k] = ar[k+1];
						k++;
					}
					j--; size--;  //finally we are decreasing j so as to keep j
					//same in the iteration and reducing the size as to reduce the number
					//of iterations which are not worthy
				}		
			}
			System.out.println(ar[i] +" is repeated for " +count +" times");
		}
	}
}
