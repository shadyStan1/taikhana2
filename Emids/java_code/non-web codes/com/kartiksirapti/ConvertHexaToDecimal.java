package com.kartiksirapti;
public class ConvertHexaToDecimal {
	public static void main(String[] args) {
		System.out.println(0x1aF); //default way to print in hexaform
//String s = "E";
//char ch = s.charAt(s.length()-1);
//int i = ch - 55;          //when we substract an integer from a char
// then char will be converted into ASCII value then it will subtract the
//given integer
		//System.out.println(i);
		int dec = hextodec("1aE");
		System.out.println(dec);
	}
		
		public static int hextodec(String s)
		{
			int res = 0;
			int count = 0;
			int i = s.length();
			while ( i > 0)
			{
			char ch = s.charAt(i-1);
			if(ch >= 97 && ch <= 102)//for small case alphabets
			{
			res = res + (ch-87)*(int)(Math.pow(16, count++));
			}
			else if (ch>= 65 && ch <=70) //for capital case alphabets 
			{
				res= res + (ch-55)*(int)(Math.pow(16, count++));
				//System.out.println((ch-55)*(int)Math.pow(16, count++));
			}
			else if(ch >= 48 && ch <= 57)// for digits from 0-9 in ASCII form
			{
				res = res + (ch - 48)*(int)(Math.pow(16, count++));
			}
			else
			return -1;
			i--;
	 		}
			return res;
		}
}
