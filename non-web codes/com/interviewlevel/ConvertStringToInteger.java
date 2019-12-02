package com.interviewlevel;
import java.util.Scanner;
/*
 * this code converts the string of digits into numeric one
 */
public class ConvertStringToInteger {
public static void main(String[] args) {
	System.out.println("enter the string");
	Scanner sc = new Scanner(System.in);
	String s = sc.next();
	int no = convert(s);
	System.out.println(no);
}
public static int convert(String s)
{
	char[] ch = s.toCharArray();
	int f_no = 0;
	int zero_ascii = (int)'0' ;
	//System.out.println((int)'1');
	for(char c: ch)
	{
		if(c >= 48 && c <=57)
			f_no = f_no * 10 + (c - 48);
//		f_no = (f_no * 10) + ((int)c- zero_ascii);
		else
			return -1;
	}
	return f_no;
}
}
