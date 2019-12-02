package com.interviewlevel;

import java.util.Scanner;
/*
 * this code reverses a sentence as
 * java is easy
 * o/p :- avaj si ysae
 */
public class ReverseAStringSentence {
public static void main(String[] args) {
	System.out.println("enter the sentence");
	Scanner sc = new Scanner(System.in);
	String line = sc.nextLine();
	String rev_sentence = reverse_string(line);
	System.out.println(rev_sentence);
}
public static String reverse_string(String s)
{
	char[] ch = s.toCharArray();
	String s1 = "";
	for (int i = 0; i < ch.length; i++) {	
		String rev_word = "";
		while( i < ch.length && ch[i] != ' ')
		{
			rev_word = ch[i] + rev_word;
			i++;
		}
		s1 = s1 + rev_word + " ";
	}
	return s1;
}
}
