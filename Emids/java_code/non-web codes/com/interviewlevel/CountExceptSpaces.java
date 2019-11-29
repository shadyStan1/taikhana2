package com.interviewlevel;
import java.util.Scanner;
/*
 this code counts the no of alphabets, numbers and special
 characters including spaces in a string,
 */
public class CountExceptSpaces {
	public static void main(String[] args)
	{
		System.out.println("enter the sentence");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		find_words_count(line);
		//System.out.println("no of the words in the sentence : " + count);
	}

	public static void find_words_count(String s)
	{
		int count = 0;
		int count1 = 0, count2 = 0;
		for(int i = 0; i < s.length(); i++)
		{
			if((s.charAt(i) >= 65 && s.charAt(i) <= 90) ||
					(s.charAt(i) >= 97 && s.charAt(i) <= 122) )
			count++;
			else if(s.charAt(i) >= 48 && s.charAt(i) <= 57)
			{
				count1++;
			}
			else{
				count2++;
			}
		}
	System.out.println("no of alphabtes = " +count);
	System.out.println("no of numericals = " +count1);
	System.out.println("no of special characters = " +count2);
	}

}
