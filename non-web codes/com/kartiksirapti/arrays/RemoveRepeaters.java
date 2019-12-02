package com.kartiksirapti.arrays;
/*
 REMOVE REPEATED ELEMENTS IN AN ARRAY
 */
public class RemoveRepeaters {
	public static void main(String[] args) {
		int[] ar = {1,2,3,1};
		int[] new_arr= deleteElement(ar);
		for(int x : new_arr)
		{
			System.out.print(x + ", ");
		}
	}
public static int[] deleteElement(int [] ar)
{
	int size = ar.length;
	for (int i = 0; i < size-1; i++) {
		for (int j = i+1; j < size; j++) {
			if(ar[i] == ar[j])
			{
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
	}
	int[] new_arr = new int[size];
	for (int i = 0; i < size; i++) {
		new_arr[i] = ar[i];
	}
	return new_arr;
}
}
