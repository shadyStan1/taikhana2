package com.interviewlevel;
import java.util.Scanner;
public class RemoveRepeatitionInAString {
	public static void main(String[] args) {
		System.out.println("enter the string");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String ch = remove_repeatition(s);
//		for(char c : ch)
//		{
			System.out.print(ch +" ");
		//}
}
	public static String remove_repeatition(String s)
	{
		char[] c = s.toCharArray();
		int size = c.length;
		for (int i = 0; i < size; i++) {
			for (int j = i+1; j < size; j++) {
				if(c[i] == c[j])
				{
					int k = j;
				while(k < size-1)
				{
					c[k] = c[k+1]; k++;
				}
				j--; size--;
				}
			}
		}
		char[] new_ar = new char[size];
		for(int i = 0 ; i < new_ar.length; i++)
		{
			new_ar[i] = c[i];
		}
		return new String(new_ar);
	}
}