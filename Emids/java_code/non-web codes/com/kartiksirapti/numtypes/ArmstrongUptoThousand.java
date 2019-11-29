package com.kartiksirapti.numtypes;
public class ArmstrongUptoThousand {

	public static void main(String[] args) 
	 {
		 //int num = Integer.parseInt(args[0]);
		 for(int i = 1; i <= 1000; i++)
		 {
			 int length = count(i);
			 int num2 = armstrong(i, length);
			 //System.err.println(num2);
			 if(i == num2)
				 System.out.println(i + " is an armstrong number");
			 else
				System.out.println(i + " is not an armstrong number");
		 }

	 }
		public static int count(int num)
		{
			int c = 0;
			while(num > 0)
			{
				num = num/10;
				c++;
			}
			return c;
		}
		public static int armstrong(int num, int c)
		{
			int sum = 0;
			while(num > 0)
			{
				int rem = num % 10;
				sum = (int)(sum + Math.pow(rem, c));
				//System.out.println(sum);
				num = num/10;
			}
			return sum;
		}
}
