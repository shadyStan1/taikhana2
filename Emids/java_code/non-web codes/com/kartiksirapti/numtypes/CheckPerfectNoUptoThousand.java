package com.kartiksirapti.numtypes;

import java.util.Scanner;

public class CheckPerfectNoUptoThousand {
	public static void main(String[] args) {
		for (int i = 1; i < 1000; i++) {
			int num2 = perfect(i);
			if(i == num2)
				System.out.println(i + " is a perfect number");
			else
				System.out.println(i + " is not a perfect no");
		}

	}
	public static int perfect(int num)
	{
		int sum = 0;
		for (int i = 1; i <= num/2; i++) {
			if(num % i == 0)
			{
				sum = sum + i;
		}
		}
		return sum;
	}
}
