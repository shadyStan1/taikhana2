package com.kartiksirapti;
import java.util.Scanner;
public class GenerelCodeToConvert {
	//general code to convert Decimal to any form including binary, octal, hexadecimal
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number to be converted");
		int num = sc.nextInt();
		System.out.println("Enter the number system or base");
		int ns = sc.nextInt();
		String res = convert(num, ns);
		System.out.println(res);
	}
public static String convert(int num, int ns)
{
	String posrem = "0123456789ABCDEF";   // all possible remainders for 2 upto 16
	String res = "";
	while(num > 0)
	{
		int rem = num % ns;
		res = posrem.charAt(rem) + res;
		num = num/ns;
	}
	return res;
}

}
