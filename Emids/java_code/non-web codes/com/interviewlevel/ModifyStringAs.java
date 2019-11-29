package com.interviewlevel;
import java.util.Scanner;
/*
 * change string as
 * java is easy
 * o/p :- java4 is2 easy4
 */
public class ModifyStringAs {
public static void main(String[] args)
{
	System.out.println("enter the string");
	Scanner sc = new Scanner(System.in);
	String s = sc.nextLine();
	String new_str = addcount_to_words(s);
	System.out.println(new_str);
}
public static String addcount_to_words(String s)
{
	char[] ch = s.toCharArray();
	String s1 = "";
	for (int i = 0; i < ch.length; i++) {
		int count = 0; String word="";
		while(i < ch.length && ch[i] != ' ')
		{
			count++;
			word = word + ch[i];
			i++;
		}
		s1 = s1 + " " + word + count;
	}
	return s1;
}
}
