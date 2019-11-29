package com.interviewlevel;
import java.util.Scanner;
public class CountWordsInString {
	
	public static void main(String[] args)
	{
		System.out.println("enter the sentence");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		int count = find_words_count(line);
		System.out.println("no of the words in the sentence : " + count);
	}

	public static int find_words_count(String s)
	{
		char[] c_ar = s.toCharArray();
		int count;
		if(c_ar[0] != ' ')
		count = 1;
		else
		count = 0;
		for(int i = 0; i < c_ar.length - 1; i++)
		{
			if(c_ar[i] == ' ' && c_ar[i+1] != ' ')
			count++;	
		}
		return count;
	}
}
