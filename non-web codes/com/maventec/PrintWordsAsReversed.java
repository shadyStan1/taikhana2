package com.maventec;
import java.util.Scanner;
public class PrintWordsAsReversed {
public static void main(String[] args) {
	System.out.println("enter the string");
	Scanner sc = new Scanner(System.in);
	String s = sc.nextLine();
	String rev_str = reverseWords(s);
	System.out.println("the string in rev order :-");
	System.out.println(rev_str);
	sc.close();
}

public static String reverseWords(String s)
{
	char[] c1 = s.toCharArray();
	String s1 = "";
	for (int i = 0; i < c1.length; i++) 
	{
		String word = "";
		while(i < c1.length && c1[i] != ' ')
		{
			word = c1[i] + word;
			i++;
		}
		s1 = s1 + " " + word;
	}
	return s1;
}
}
