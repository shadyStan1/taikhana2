package com.revision;
import java.util.*;
public class ReverseString {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter the string");
	String s = sc.nextLine();
	String rev_str = reverseString(s);
	System.out.println(rev_str);
}
public static String reverseString(String s)
{
	char[] c = s.toCharArray();
	String s1 = "";
	for (int i = 0; i < c.length; i++) {
		String rev_word = "";
			while(i < c.length && c[i] != ' ')
		{
			rev_word = c[i] + rev_word;
			i++;
		}
		s1 = rev_word + " " + s1;
	}
	return s1;
}
}
