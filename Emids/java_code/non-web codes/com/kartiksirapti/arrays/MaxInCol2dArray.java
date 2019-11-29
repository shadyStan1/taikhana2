package com.kartiksirapti.arrays;
/*
 find max element in a column of a 2-d array
 { 	 12 , 4 , 8
  	 10 , 15, 7
  	 33 , 5 , 18}
 */

public class MaxInCol2dArray {
	public static void main(String[] args) {
		int[][] ar = {{12,4,8},{10,15,7},{33,5,18}};
		find_max(ar);
	}

public static void find_max(int[][] ar)
{
	
	for (int i = 0; i < ar.length; i++) {
	int max = ar[0][i];
	
		for (int j = 1; j < ar.length; j++) {
			if(max < ar[j][i])
				max = ar[j][i];
		}
	System.out.println("max element in the first column= "+ max);
}
}
}
