package com.collections;
import java.util.*;
public class CompareOnDifferentParameters implements Comparator<Object>
{
public int compare(Object ob1, Object ob2)
{
	Student s1 = (Student) ob1;
	Student s2 = (Student) ob2;

	if(s1.cgpa == s2.cgpa)
	{
		return s2.name.compareTo(s1.name);	
	}
	else
	{
		return (int)((s1.cgpa - s2.cgpa)* 1000);
	}
}
}