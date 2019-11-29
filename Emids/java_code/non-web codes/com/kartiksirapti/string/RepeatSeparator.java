package com.kartiksirapti.string;
public class RepeatSeparator {
public static void main(String[] args) {
	String s = repeatSeparator("word", "X", 3);
	System.out.println(s);
}
public static String repeatSeparator(String word, String rep, int count)
{
	String s1= "";
	for(int i=0 ; i < count*2-1; i++)
	{
		if(i % 2 == 0)
			 s1 = s1 + word ;
		else
			s1 = s1 + rep;
	}
	return s1;
}
}
