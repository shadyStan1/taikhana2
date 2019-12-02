package com.interviewlevel;
import java.util.Scanner;
public class ReverseString {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter the string");
	String s = sc.next();
	String rev_str = reverse(s);
	System.out.println(rev_str);
	//if(s.equalsIgnoreCase(rev_str))
		
//	int num = sc.nextInt();
//	int rev_num = int_rev(num);
	//System.out.println(num + " is same as the input string: " + num);
}
/*
 This method will reverse a given input string
 */
public static String reverse(String s)
{
	String rev_s = "";
	for (int i = 0; i < s.length(); i++) {
		char c = s.charAt(s.length()-1-i);
		rev_s = rev_s + c;
	}
	return rev_s;
}
/*
 * this method will reverse a given num
 * 					PALLENDROME
 */
//public static int int_rev(int num)
//{
//	String s = "";
//	while(num > 0)
//	{
//	int rem = num%10;   //this extracts the last digit
//	s = s + rem;
//	num = num/10;       //this removes the last digit
//	}
//	return Integer.parseInt(s);
//}
}

//StringBuffer sbuffer = new StringBuffer();
//Scanner input = new Scanner(System.in);
//System.out.println("Enter a string");
//StringBuffer append = sbuffer.append(input.nextLine());
//String new_s = reverse(s);