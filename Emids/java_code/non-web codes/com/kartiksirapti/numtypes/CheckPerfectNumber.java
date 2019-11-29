package com.kartiksirapti.numtypes;
import java.util.Scanner;
public class CheckPerfectNumber 
{
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	System.out.println("enter the no");
	int num = sc.nextInt();
	int num2 = perfect(num);
	if(num == num2)
		System.out.println(num + " is a perfect number");
	else
		System.out.println(num + " is not a perfect no");
	
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
