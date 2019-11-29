package com.interviewlevel;
import java.util.Scanner;
public class LongestWordString {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter the sentence");
	String s = sc.nextLine();
	String max = find_max(s);
	System.out.println(max + "- whose length is " +max.length());
}
public static String find_max(String s)
{
	String[] str = s.split("\\s");   //break string at every whitespace character
	int no_words = str.length;       //this gives the no of words in the array
	System.out.println("the no of words =  " + no_words);
	String max = str[0];
	for (int i = 1; i < str.length; i++) {
		if(max.length() < str[i].length())
		{
			max = str[i];
		}
	}
	return max;
}
}
