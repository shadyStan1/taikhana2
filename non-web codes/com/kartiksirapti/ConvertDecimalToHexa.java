package com.kartiksirapti;
import java.util.Scanner;
public class ConvertDecimalToHexa 
{
public static void main(String[] args) {
	String s = decimalToHexa(126);
	
	System.out.println(s);
	//System.out.println(0xBB);
}
public static String decimalToHexa(int num)
{
	String result = "";
	while(num > 0)
	{
		int rem = num%16;
		switch(rem)
		{
		case 10: result = result + "A";
				break;
		case 11: result = result + "B";
				break;
		case 12: result = result + "C";
				break;
		case 13: result = result + "D";
				break;
		case 14: result = result + "E";
				break;
		case 15: result = result + "F";
				break;
		default:
			result = result + rem;
		}
		num = num/16;
	}
	return result;
}
}
