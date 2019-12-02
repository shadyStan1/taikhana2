package com.conceptoftheday;
import java.util.*;
/*
 * Given an integer array, you have to find all the leader elements in this array. 
 * An element is said to be leader if all the elements on it’s right side are smaller than it. 
 * Rightmost element is always a leader. For example, if {14, 9, 11, 7, 8, 5, 3} 
 * is the given array then {14, 11, 8, 5, 3} are the leaders in this array.
 */
public class LeadersInArray 
{
	static LinkedHashSet<Integer> ts = new LinkedHashSet<Integer>();
	public static void main(String[] args) {
	
	int[] ar = {14, 9 , 11, 7, 8, 5, 3};
	modifyArray(ar);
}

public static void modifyArray(int[] ar)
{
	for(int i = 0; i < ar.length-1; i++)
	{
		int k = i + 1;int count = 0;
		while( k < ar.length)
		{
			if(ar[i] < ar[k])
			{
				count++;
			}
			k++;
		}
		if(count == 0)
		{
			Integer itoadd = new Integer(ar[i]);
			ts.add(itoadd);
		}
	}
	System.out.print(ts);
}
}
