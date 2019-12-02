package com.maventec;
import java.util.Scanner;
public class TestSecQues {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter the sentence");
	String s = sc.nextLine();
	String new_str = modifyString(s);
	System.out.println(new_str);
}

public static String modifyString(String s)
{
	char[] c1 = s.toCharArray();
	String final_str = "";
	for (int i = 0; i < c1.length; i++) 
	{
		int sum = 0; 
		while(i < c1.length && c1[i] != ' ')
		{
			if(c1[i] >= 65 && c1[i] <= 90)
			{
				sum = sum + c1[i] - 38;
			}
			else if(c1[i] >=97 && c1[i] <=122)
			{
				sum = sum + c1[i] - 96;	
			}
			i++;
		}
		final_str = final_str + " " + sum;
	}
	return final_str;
}
}
