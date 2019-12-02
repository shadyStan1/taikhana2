package com.collections;
import java.util.*;
public class CountRepeatHashMap{
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter the sentence");
	String str = sc.nextLine();
	char[] ch = str.toCharArray();
	HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
	/*
	 * this loop checks for the every character(key) existence in the map
	 * if already exists then the corresponding value which is infact the count
	 * is incremented by 1
	 * if not the add into the map with 1 as the value
	 * remember to use containsKey()
	 */
	for (int i = 0; i < ch.length; i++) 
	{
		if(hm.containsKey(ch[i]))
			{
			hm.replace(ch[i], hm.get(ch[i])+1);
			}
		else{
			hm.put(ch[i], 1);
			}
		}
	System.out.println(hm);
	}
}
