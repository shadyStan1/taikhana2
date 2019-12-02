package com.interviewlevel;
import java.util.Scanner;
public class RecursiveReverseString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the string");
		String s = sc.next();
		String start_empty= ""; //an empty String declared for holding the reverse
								//string in the reverse()
		String rev_str = reverse(s, start_empty, 1);
		
		System.out.println(rev_str);
}
	public static String reverse(String s, String start_empty, int i)
	{
			while(i <= s.length())
			{
			char c = s.charAt(s.length()-i);
			start_empty = start_empty + c;
			i++;        //here i have to increment it so as to fetch next element from
						//the end and so on
			//recursive call to the reverse function
			reverse(s, start_empty,i);
			}
			return start_empty;
	}
}