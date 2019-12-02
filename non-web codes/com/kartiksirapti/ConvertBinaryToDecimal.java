package com.kartiksirapti;
public class ConvertBinaryToDecimal {
public static void main(String[] args) {
	int d = (int) converttodec(010, 2, 0);
	System.out.println(d);
}
	
	public static double converttodec(int num, int base, int power)
	{
		
		// for decimal to octal pass base = 8
		double res = 0;
		while(num > 0)
		{	
			int ldigit = num % 10;  //this statement extracts the last digit
			res = res + ldigit * Math.pow(base, power++);
			num = num/10;             //this statement extracts the quotient excluding the
										// remainder which will be stored in the num % 10
			//System.out.println(num);
		}
		return res;
	}
}
