package com.interviewlevel;
class ConvertWord{
	static String[] s1 = {"", "twenty", "thirty", "forty", "fifty", "sixty",
		"seventy", "eighty", "ninety"};
	static String[] s2 = {"", "one", "two", "three", "four", "five", "six","seven",
		"eight", "nine"};
	public static void concat(int num, String str)
	{
		if(num>19)
			System.out.print(s1[num/10] + " " + s2[num%10]);
		else
			System.out.print(s2[num]);
		
		if(num == 0)
			System.out.print(str);
	}
}
public class ConvertNoToWords {
public static void main(String[] args) {
	//int num = Integer.parseInt(args[0]);
	int num = 85874320;
	ConvertWord.concat(num/1000000, "crore");
	ConvertWord.concat((num/100000)% 100, "lakhs");
	ConvertWord.concat((num/1000)%100, "thousands");
	ConvertWord.concat((num/100)%10, "hundred");
}
}
