package com.kartiksirapti;

import java.util.Scanner;

public class Armstrong {
 public static void main(String[] args) 
 {
	 Scanner sc = new Scanner(System.in);
	 int num = sc.nextInt();
	 int length = count(num);
	 int num2 = armstrong(num, length);
	 //System.err.println(num2);
	 if(num == num2)
		 System.out.println(num + " is an armstrong number");
	 else
		System.out.println(num + " is not an armstrong number");
 }
	public static int count(int num)
	{
		int c = 0;
		while(num > 0)
		{
			num = num/10;
			c++;
		}
		return c;
	}
	public static int armstrong(int num, int c)
	{
		int sum = 0;
		while(num > 0)
		{
			int rem = num % 10;
			sum = (int)(sum + Math.pow(rem, c));
			//System.out.println(sum);
			num = num/10;
		}
		return sum;
	}
	
}
