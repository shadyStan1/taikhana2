package com.interviewlevel;
import java.util.*;
public class Anagram {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter the string 1");
	String s1 = sc.nextLine();
	System.out.println("enter the string 2");
	String s2 = sc.nextLine();
	s1 = removeSpaces(s1); s2 = removeSpaces(s2);
	if(s1.length() == s2.length())
	{
		s1 = sameCaseConvert(s1); s2 = sameCaseConvert(s2);
		s1 = sortAlphabets(s1); s2 = sortAlphabets(s2);
		//System.out.println(s1 + "     " + s2);
		boolean b = matchAlphabets(s1, s2);
		if(b)
			System.out.println("s1 and s2 are anagram");
		else
			System.out.println("not");
	}
	else
		System.out.println("s1 and s2 are not anagram");
}
public static String removeSpaces(String s)
{
	char[] ch = s.toCharArray();
	String s1 = "";
	for (int i = 0; i < ch.length; i++) {
		if(ch[i]!= ' ')
			s1 = s1 + ch[i];
	}
		return s1;
}

public static String sameCaseConvert(String s)
{
	char[] ch = s.toCharArray();
	String s1 = "";
	for (int i = 0; i < ch.length; i++) {
		if(ch[i] >= 65 && ch[i]<= 90)
		{
			ch[i] = (char)(ch[i] + 32);
			s1 = s1 + ch[i];
		}
		else
		{
			s1 = s1 + ch[i];
		}
	}
	return s1;
}
public static String sortAlphabets(String s)
{
	char[] ch = s.toCharArray();
	for (int i = 0; i < ch.length-1; i++) {
		for (int j = i+1; j < ch.length; j++) {
			if(ch[i] > ch[j]) //ascending order
			{
				char temp = ch[i];
				ch[i] = ch[j];
				ch[j] = temp;
			}
		}
	}
	return new String(ch);
}
public static boolean matchAlphabets(String s1, String s2)
{
	for (int i = 0; i < s1.length(); i++) {
		if(s1.charAt(i)!= s2.charAt(i))
			return false;
	}
	return true;
}
}
