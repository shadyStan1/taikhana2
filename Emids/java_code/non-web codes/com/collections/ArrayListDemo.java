package com.collections;
import java.util.*;
import java.util.Collections;
public class ArrayListDemo
{
	public static void main(String[] args)
	{
	ArrayList<Student> al = new ArrayList<Student>();
	Student s1 = new Student("Rumpa", 33, 3.68);
	Student s2 = new Student("Ashis", 85, 3.85);
	Student s3 = new Student("Samiha", 56, 3.75);
	Student s4 = new Student("Samara", 19, 3.71);
	Student s5 = new Student("Fahim", 22, 3.76);
	//Student s1 = new Student("Rumpa", 33, 3.68);
	
	al.add(s1);
	al.add(s2);
	al.add(s3);
	al.add(s4);
	al.add(s5);
	//CompareOnDifferentParameters c = new CompareOnDifferentParameters();
	Collections.sort(al, new CompareOnDifferentParameters());
	for(int i = 0; i <al.size(); i++)
	{
		System.out.println(al.get(i));
	}
}
}