package com.maventec;
import java.util.Scanner;
public class TestThirdQues {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter the number series");
	String s = sc.nextLine();
	//print_all(s);
	print_oddNo(s);
}

public static void print_all(String s)
{
	for (int i = 0; i < s.length(); i++) {
		System.out.print(s.charAt(i) + ", ");
	}
}

public static void print_oddNo(String s)
{
	char[] c1 = s.toCharArray(); 
	int count = 0;
	for (int i = 0; i < c1.length; i++) {

			if(c1[i] % 2 != 0 )
				{
				count++;
				}
		}
	
	char[] new_c1 = new char[count];
	for (int i = 0; i < new_c1.length; i++) {
		
	}
	for(int i =0 ; i < new_c1.length-1; i++)
	{
		for (int j = i+1; j < new_c1.length; j++) {
			if(new_c1[i] > new_c1[j])
			{
				char temp = c1[j];
				c1[j] = c1[i];
				c1[i] = temp;
			}
		}
	}
	for(char c : new_c1)
	{
		System.out.print(c + ", ");
	}
}


//public static void print
}
