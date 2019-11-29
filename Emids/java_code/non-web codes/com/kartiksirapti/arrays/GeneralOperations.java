package com.kartiksirapti.arrays;
import java.util.Scanner;
/*
 THIS CODE PERFORMS THE INSERTION, DELETION, REPLACE, DISPLAY 
 OVER THE ARRAY
 */
public class GeneralOperations {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of array");
		int size = sc.nextInt();
		int[] ar = new int[size];
		for(int i = 0; i < size; i++)
		{
		System.out.println("enter the elements of array");
		ar[i] = sc.nextInt();
		}
		select_choice(ar);
		sc.close();
	}
	public static void select_choice(int[] ar)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("press 1 to insert the element");
		System.out.println("press 2 to delete the element");
		System.out.println("press 3 to display the element");
		System.out.println("press 4 to replace the element");
		System.out.println("press 5 to exit");
		System.out.println("enter the option");
		int ch = sc.nextInt();
		switch(ch)
		{
		case 1:
		{
			System.out.println("enter the element to be inserted");
			int element = sc.nextInt();
			System.out.println("enter the position at which the element is to be inserted");
			int pos=sc.nextInt();
			if(pos >= ar.length)
			{
				System.out.println("the specified index is beyond the array length");
				System.out.println("please enter again");
				select_choice(ar);
			}
			else if(pos >= 0 && pos <ar.length)
			{
			int[] new_arr = insert_element(ar, element, pos);
			System.out.println("element inserted successfully");
			select_choice(new_arr);
			}
			
		}
		case 2:
		{
			System.out.println("enter the index where element is to be deleted");
			int pos1 = sc.nextInt();
			if(pos1 >= ar.length)
			{
				System.out.println("the specified index is beyond the array length");
				System.out.println("please enter again");
				select_choice(ar);
			}
			else if(pos1 >= 0 && pos1 <ar.length)
			{
			int[] new_ar = delete_element(ar, pos1);
			System.out.println("Element deleted successfully");
			select_choice(new_ar);
			}
		}
		case 3:
		{
			display_elements(ar);
			break;
		}
		case 4:
		{
			System.out.println("enter the element to replaced");
			int old_ele = sc.nextInt();
			System.out.println("enter the new value");
			int new_ele = sc.nextInt();
			int[] new_arr = replace_element(ar, old_ele, new_ele);
			select_choice(new_arr);
			
		}
		case 5:
		{
			System.out.println("do you wish to continue");
			String choice = sc.next();
			if(choice.equalsIgnoreCase("no"))
				{
				System.out.println("Hope you loved our app");
				System.out.println("leave a feedback");
				String feedback = sc.next();
				System.out.println("your worthy feedback "+ feedback);
				sc.close();
				System.exit(0);
				}
			else if(choice.equalsIgnoreCase("yes"))
			{
				select_choice(ar);
			}
		}
		}
	//
	}

			/*
			 * 
			 * 
			 this method is for inserting an element in an array at a specified index
			 *
			 *
			 */
	public static int[] insert_element(int[] ar, int element, int pos)
	{
		int[] new_arr = new int[ar.length + 1];
		new_arr[pos] = element;
		for (int i = 0; i < new_arr.length; i++) {
			if(i<pos)
				new_arr[i] = ar[i];
			else if(i > pos)
				new_arr[i] = ar[i-1];	
		}
		return new_arr;
	}


				/*
				 * 
				 * 
				 this method is for deleting an element from an array
				 *
				 *
				 */
	public static int[] delete_element(int[] ar, int pos)
	{
		int[] new_arr = new int[pos - 1];
		for(int i = 0; i < new_arr.length ; i++)
		{
			if(i < pos)
				new_arr[i] = ar[i];
			else
				new_arr[i] = ar[i+1];
		}
		return new_arr;
	}

				/*
				 * 
				 * 
				 this method displays the elements of the array
				 *
				 *
				 */
	public static void display_elements(int[] ar)
	{
		for(int x : ar)
		{
			System.out.print(x + ", ");
		}
		System.out.println();
		select_choice(ar);
	}

			/*
			 this method replaces an element
			 */

	public static int[] replace_element(int[] ar, int old_ele, int new_ele)
	{
		for (int i = 0; i < ar.length; i++) {
			if(ar[i] == old_ele)
			{
				ar[i] = new_ele;
			}
		}
		return ar;
	}
	
}
