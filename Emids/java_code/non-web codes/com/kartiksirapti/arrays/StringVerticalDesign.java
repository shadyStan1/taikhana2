package com.kartiksirapti.arrays;
import java.util.Scanner;
public class StringVerticalDesign {
	public static String[] s1;
public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	System.out.println("enter the string");
	String s = sc.nextLine();
	verticalDesign(s);
}

public static void verticalDesign(String s){
	char[] strToCharArray = s.toCharArray();
	int index = 0;
	int countWords = 0;
	/*this for loop counts the no of words*/
	for(int i = 0; i < strToCharArray.length; i++){
		String word = "";
		while(i < strToCharArray.length && strToCharArray[i] != ' '){
			word  = word + strToCharArray[i];
			i++;
		}
		countWords++;
	}
	
	/* insert individuals words in a string array*/
	s1 = new String[countWords];
	
	for(int i = 0; i < strToCharArray.length; i++){
		String word = "";
		while(i < strToCharArray.length && strToCharArray[i] != ' '){
			word  = word + strToCharArray[i];
			i++;
		}
		insertWords(word, index);
		index++;
	}
	
	/* find the max length string in the array*/
	int max = s1[0].length();
	for(int i = 1 ; i < s1.length ; i++){
			if(max < s1[i].length())
			{
				max = s1[i].length();
			}
	}
	
	int strLength = 0;
	while(strLength < max){
		int i = 0;
		while(i < s1.length){
			try{
				if(s1[i].charAt(strLength) != ' ')
				System.out.print(s1[i].charAt(strLength) + " ");			
			}
			catch(Exception e){
				System.out.print("  ");
			}
			i++;
		}
		strLength++;
		System.out.println();
	}
}

public static void insertWords(String word, int index ){
	s1[index] = word;
}
//char[][] c1 = new char[countWords][];
//for(int i = 0 ; i < c1.length; i++){
//	c1[i] = s1[i].toCharArray();
}
