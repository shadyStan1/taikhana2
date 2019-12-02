package com.maventec;
import java.util.*;
public class TestFirstQues {
 public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	 System.out.println("enter the string 1");
	 String s1 = sc.next();
	 System.out.println("enter the string 2");
	 String s2 = sc.next();
	 remove(s1, s2);
}
 
 public static void remove(String str, String str1)
 {
	 char[] c1 = str.toCharArray();
	 char[] c2 = str1.toCharArray();
	 for (int i = 0; i < c2.length; i++) {
		 int j =0;int count = 0;
		 while(j < c1.length)
		 {
			 if(c2[i] == c1[j])
			 {
				 count++;
			 }
			 j++;
		 }
		 if(count == 0)
			 System.out.print(c2[i]);
	}
 }
}
