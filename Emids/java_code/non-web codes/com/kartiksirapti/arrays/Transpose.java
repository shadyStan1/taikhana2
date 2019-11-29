package com.kartiksirapti.arrays;
public class Transpose {
public static void main(String[] args) {
	int[][] ar = {{1,2,3},{4,5,6},{7,8,9}};
	ar = transpose(ar);
	for(int i =0 ; i < 3; i++)
	{
		for(int j = 0; j < 3; j++)
		{
			System.out.print(ar[i][j] + " ");
		}
		System.out.println();
	}
}
public static int[][] transpose(int[][] ar)
{
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j <= i/2; j++) {
			int temp = ar[i][j];
			ar[i][j] = ar[j][i];
			ar[j][i] = temp;
		}
	}
	return ar;
}
}
