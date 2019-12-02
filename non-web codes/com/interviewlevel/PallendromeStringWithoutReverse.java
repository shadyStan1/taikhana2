package com.interviewlevel;
import java.util.Scanner;
public class PallendromeStringWithoutReverse {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter the string");
	String s = sc.next();
	boolean b = check_pallendrome(s);
	if(b == true)
		System.out.println("the string is pallendrome");
	else
		System.out.println("the string is not pallendrome");
	
}
public static boolean check_pallendrome(String s)
{
	boolean b = true;
	int i = 0;
	int mid= s.length()/2;
	while( i < mid)
	{
		if(s.charAt(i) != s.charAt(s.length()-1-i))
		{
			return false;
		}
		i++;
	}
	return b;
}
}
