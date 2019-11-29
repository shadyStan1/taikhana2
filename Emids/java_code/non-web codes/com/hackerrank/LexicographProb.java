package com.hackerrank;
import java.util.*;
public class LexicographProb {
public static void main(String[] args) {
	TreeSet<String> ts = new TreeSet<String>();
	String str = "welcometojava";
	char[] ch = str.toCharArray();
	String[] arr = new String[str.length() - 2];
	for (int i = 0; i <= ch.length - 3; i++) {
		String temp = "";
		int tempo = i;
		
		while(tempo <= i+2)
		{
			temp = temp + ch[tempo];
			tempo++;
		}
		arr[i]=temp;
		ts.add(temp);
	}

	for(String x : arr)
	{
		System.out.print(x + ", ");
	}
	System.out.println();
	System.out.println(ts.first() + "..........." + ts.last());

}
}
