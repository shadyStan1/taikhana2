package com.conceptoftheday;
import java.io.*;
/*
 * How To Reverse And Add A Number Until You Get A Palindrome?
 * Take number from the user, reverse it and add it to itself. 
 * If the sum is not a palindrome then repeat the procedure until you get a palindrome.
	For example, If 7325 is input number, then
	7325 (Input Number) + 5237 (Reverse Of Input Number) = 12562
	12562 + 26521 = 39083
	39083 + 38093 = 77176
	77176 + 67177 = 144353
	144353 + 353441 = 497794 (Palindrome)
 */
public class ReverseAddPallendrome {
public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("enter the number");
	int num = Integer.parseInt(br.readLine());
	addGetPlndrm(num);
}

public static void addGetPlndrm(int num)
{
	int sum = 0;
	int num_rev = makeRev(num);
	//System.out.println("rev of num = " + num_rev);
	sum = num + num_rev;
	int sum_rev = makeRev(sum);
	if(sum == sum_rev)
	{
		System.out.println(sum + " is pallendrome");
	}
	else{
		addGetPlndrm(sum);
	}
}
public static int makeRev(int numtorev)
{
	String rev = "";
	while(numtorev > 0)
	{
		int rem = numtorev%10;
		rev = rev + rem;
		numtorev = numtorev / 10;
	}
	return Integer.parseInt(rev);
}
}
