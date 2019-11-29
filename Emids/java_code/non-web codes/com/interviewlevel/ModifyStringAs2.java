package com.interviewlevel;
import java.util.Scanner;
/*
 * this code modifies string as
 * eg, j2a2v33a i7s e9a8s8y
 * o/p, java37 is7 easy25
 */
public class ModifyStringAs2 {
public static void main(String[] args) {
	System.out.println("enter the string");
	Scanner sc = new Scanner(System.in);
	String s = sc.nextLine();
	String new_str = concat_num_words(s);
	System.out.println(new_str);
}
public static String concat_num_words(String s)
{
	String s1 = "";
	char[] ch = s.toCharArray();
	for (int i = 0; i < ch.length; i++) {
		int sum = 0; String word="";
		while(i < ch.length && ch[i] != ' ')
		{
			if(ch[i] >= 48 && ch[i] <= 57)
			{
				sum = sum + ch[i] - 48;
			}
			else
				word = word + ch[i];
			
			i++;
		}
		s1 = s1 + " " + word + sum;
	}
	return s1;
}
}
