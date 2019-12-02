package com.conceptoftheday;
import java.util.*;
public class MoveZeroesToEitherEnd {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter the size of array");
	int size = sc.nextInt();
	int[] ar = new int[size];
	for (int i = 0; i < size ; i++) {
		System.out.println("enter the values");
		ar[i] = sc.nextInt();
	}
	moveToRight(ar);
	moveToLeft(ar); 
}

public static void moveToRight(int[] ar)
{
	int[] new_ar = new int[ar.length];
	int count = 0;
	
	for (int i = 0; i < new_ar.length; i++) {
		int temp = i;
		
		if(ar[i] == 0)
			{
			count++;
			}
		else if(ar[i] != 0)
			new_ar[temp - count] = ar[i];
	}
	for(int x : new_ar){
		System.out.print(x + ", ");
	}
	System.out.println();
}

public static void moveToLeft(int[] ar)
{
	int countofzeros = 0;
	for (int i = 0; i < ar.length; i++) {
		if(ar[i] == 0)
			countofzeros++;
	}
	
	int[] new_ar = new int[ar.length];
	

		for(int k = 0; k < ar.length; k++)
		{
			if(ar[k] != 0)
			{
				new_ar[countofzeros] = ar[k];
				countofzeros++;
			}
		}
	
	for(int x : new_ar)
		System.out.print(x + ", ");
	
}
}
