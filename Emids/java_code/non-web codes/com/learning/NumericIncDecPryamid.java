package com.learning;
public class NumericIncDecPryamid 
{
	public static void main(String[] args) {
		int n=5;
		
		for(int row=1;row<n-1;row ++)
			{
			int c =1;
			for (int space=0;space < n - 1 - row; space++)
			{
				System.out.print("  ");
			}
			for(int stars = 0 ; stars <= 2*(row-1); stars++)
			{
				//int c = 1;
				//if(stars == 0 || stars == 2*row)  //comment this statement if not hollow diamond
				if(stars >= 0 && stars <(row - 1))
				{
				System.out.print(c + " ");
				c++;
				}
				else{	
					System.out.print(c + " ");
                  c--;
				}
			}
			System.out.println();
			}
		
//		for (int r = 1; r < n-1; r--) {
//			int c = 1;
//			for (int spaces = n; spaces > n  - r; spaces--) {
//				System.out.print("  ");
//			}
//			for (int stars = 2*(n-r); stars >= n-r ; stars--) {
//				if(stars >= 2*(n-r) && stars < (n-r))
//				{
//				System.out.print(c + " ");
//				c++;
//				}
//				else{	
//					System.out.print(c + " ");
//                  c--;
//			}
//				System.out.println();
//		}
//		}
		/*for(int row=n-1;row>=0;row--)
			{
			for (int space=0;space < n - 1- row; space++)
			{
				System.out.print("  ");
			}
			for(int stars = 0 ; stars <= 2*row; stars++)   //comment this statement if not hollow diamond
			{
				if(stars == 0 || stars == 2*row)
				System.out.print("*" + " ");f
				else
					System.out.print("  ");
			}
			System.out.println();
			}*/
	}
}

