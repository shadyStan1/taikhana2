package com.interviewlevel;
import java.util.Scanner;
public class TalentPaceStringQues {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter the string");
	String s = sc.nextLine();
	String new_str = modify(s);
	System.out.println(new_str);
}

public static String modify(String s)
{
	String s1 = "";
	char[] ch = s.toCharArray();
	for (int i = 0; i < ch.length - 1; i++) {
		String res = "";
		if(ch[i] != ' ')
		{
			while(i < ch.length && ch[i] != ' ' )
			{
				res = res + ch[i];i++;
			}
			
			if(res.length() > 3)
			{
			char[] temp = res.toCharArray();
			char first = temp[0];
			temp[0] = temp[temp.length - 1]; temp[temp.length-1] = first;
			res = new String(temp);
			s1 = s1 + " " + res;
			}
			else
			{
				if(s1 == "")
				s1 = s1 + res;
				else
					s1 = s1 + " " + res;
			}
		}
	}
	return s1;
}
}
