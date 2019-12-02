package com.kartiksirapti;
import java.util.Scanner;

public class LCM 
{
	public static void main(String[] args) {
		System.out.println("enter the first number");
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		System.out.println("enter the second number");
		int n2 = sc.nextInt();
		
		int lcm = find_lcm(n1,n2);
		System.out.println(lcm);
	}
	public static int find_lcm(int n1, int n2)
	{
		int max = (n1 > n2 ? n1 : n2); //find max of the two numbers
		int c = max;
		while(true)
		{
			if(max%n1 == 0 && max%n2 == 0)
			{
				break;
			}
			max = max + c;
		}
		return max;
	}
}
