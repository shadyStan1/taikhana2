package com.kartiksirapti.arrays;
/*
 wap to find highest element present in upper triangle,lower triangle and
 principle diagonal element????
 { 12, 15, 6
 	8, 10, 7
 	3, 4 , 11}
 */
public class FindMaxInPrincipleDiagonal 
{
	public static void main(String[] args) {
		int[][] ar = {{12,15,6}, {8,10,12}, {3,4,11}};
		find_max(ar);
	}
	public static void find_max(int[][] ar)
	{
		int lmax = ar[1][0];   //assuming the first element in lower triangle as max
		int umax = ar[0][1];   //assuming the first element in upper triangle as max
		int diag_max = ar[0][0];	//assuming the first element in diagonal 
									//square as max
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				/*
				 this if block checks for the max inside the lower triangle
				 */
				if(i > j)           
				{
					if(lmax < ar[i][j])
						lmax = ar[i][j];
				}
				/*
				 this block checks for the max inside the diagonal of square
				 */
				else if(i == j)
				{
					if(diag_max < ar[i][j])
						diag_max = ar[i][j];
				}
				/*
				 this block checks the max element inside the upper triangle
				 */
				else
				{
					if(umax < ar[i][j])
						umax = ar[i][j];
				}
			}
		}
		System.out.println("max in lower triangle = " + lmax);
		System.out.println("max in principle diagonal of square = " + diag_max);
		System.out.println("max in upper triangle = " + umax);
	}
	
}
