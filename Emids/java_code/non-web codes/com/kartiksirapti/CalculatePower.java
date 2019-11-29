package com.kartiksirapti;
import java.util.Scanner;
public class CalculatePower 
{
	public static int power(int num, int power)
	{
		System.out.println(num + "  " + power);
		int i = 0; int p=1;
		while(i < power)
		{
			p = p * num;
			i++;
		}
		return p;
	}
	public static void main(String[] args) 
	{
		int p = power(2,5);
		System.out.println(p);
	}
}
