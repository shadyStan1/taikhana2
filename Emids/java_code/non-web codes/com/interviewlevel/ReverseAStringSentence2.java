package com.interviewlevel;
import java.util.Scanner;
/*
 * this code reverses a string
 * java is easy
 * ysae si avaj
 */
public class ReverseAStringSentence2 {
public static void main(String[] args) {
	System.out.println("enter the sentence");
	Scanner sc = new Scanner(System.in);
	String s1 = sc.nextLine();
	String rev_str = reverse_string(s1);
	System.out.println(rev_str);
	
}
public static String reverse_string(String s)
{	
	char[] c_ar = s.toCharArray();
	String s1 = "";
	for (int i = 0; i < c_ar.length; i++) {
		String rev_word = "";
		while(i < c_ar.length && c_ar[i] != ' ')
		{
			rev_word = c_ar[i] + rev_word;
			i++;
		}
		s1  = rev_word + " " +s1 ; 
	}
	return s1;
}
}
