package com.hackerrank;
import java.util.Scanner;
public class PrintSubstring {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter the string");
	String s = sc.nextLine();
	System.out.println("enter the string containing indexes");
	String s1 = sc.next();
	String new_str = disp_substr(s, s1);
	System.out.println(new_str);
}
public static String disp_substr(String s, String s1)
{
	char[] ch = s1.toCharArray();
	//int start_index = 0, end = 0;
	int start_index  = ch[0];
	int end= ch[ch.length];
	String f_str = "";
	for (int i = start_index; i < end; i++) {
		f_str = f_str + ch[i];
	}
	return f_str;
}
}
