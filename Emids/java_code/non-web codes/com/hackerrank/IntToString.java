package com.hackerrank;
import java.util.*;
public class IntToString {
	 public static void main(String[] args) {
	  try {
	   Scanner in = new Scanner(System.in);
	   int n = in .nextInt();
	   in.close();
	   //Write your code here
	   int num = n;
	String s="";
	while(num>0){
	    int rem = num%10;
	    s = rem + s;
	    num = num/10;
	}
	System.out.println(s + "    " + n);
	   if (n == Integer.parseInt(s)) {
		    System.out.println("Good job");
		   } else {
		    System.out.println("Wrong answer.");
		   }
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		 }
		}

