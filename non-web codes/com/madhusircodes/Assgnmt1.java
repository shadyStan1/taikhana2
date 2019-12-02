package com.madhusircodes;
import java.util.Scanner;
public class Assgnmt1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			System.out.println("enter the string");
			String s = sc.nextLine();
			winner(s);
	}
	public static void winner(String s)
	{
		char[] c = s.toCharArray();
		String i1 = "",i2 = ""; int start_index = 0;
		for (int i = 0; i < c.length; i++) {
			if(c[i] >= 48 && c[i] <=57)
			{
				i1 = i1 + c[i]; start_index = i; 
				if(c[i+1] >= 48 && c[i+1] <= 57)
				{
					i1 = i1 + c[i+1]; start_index = i + 1;
					if(c[i+2] >= 48 && c[i+2] <= 57)
					{
						i1 = i1 + c[i+2]; start_index = i +2;
						break;
					}
					break;
				}
				break;
			}
		}
		
		for(int i = start_index + 1; i < c.length; i++)
		{
			if(c[i] >= 48 && c[i] <=57)
			{
				i2 = i2 + c[i]; 
				if(i != c.length-1 && c[i+1] >= 48 && c[i+1] <= 57)
				{
					i2 = i2 + c[i+1]; 
					if( (i+1)!= c.length-1 &&c[i+2] >= 48 && c[i+2] <= 57)
					{
						i2 = i2 + c[i+2]; 
						break;
					}
					break;
				}
				break;
			}
		}
		int score1 = Integer.parseInt(i1), score2 = Integer.parseInt(i2);
		System.out.println(score1 + "   " + score2);
		if( score1 < score2)
		System.out.println("teamB won");
		else if(score1 > score2)
			System.out.println("teamA won");
		else
			System.out.println("match draw");
	}
}
