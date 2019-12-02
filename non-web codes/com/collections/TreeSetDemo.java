package com.collections;
import java.util.*;
public class TreeSetDemo
{
	public static void main(String[] args) {
		Student s1 = new Student("anshul",1,6.5);
		Student s2 = new Student("vimal",3,6.42);
		Student s3 = new Student("bajaj",8,8.6);
		Student s4 = new Student("dhokebaaj", 5, 347.4);
		Student s5 = new Student("kamine",4,7.4);
		TreeSet<Student> ts = new TreeSet<Student>(new MyComparator());
		ts.add(s1);
		ts.add(s2);
		ts.add(s3);
		ts.add(s4);
		ts.add(s5);
		
		//ts.add("fesbvfegshvf");ts.add("dcesveg");
		Iterator i1 = ts.iterator();
		while(i1.hasNext()){
			Object o = i1.next();
			System.out.println(o);
		}
		System.out.println(ts);
		
	}
}

class MyComparator implements Comparator
{
	public int compare(Object o1, Object o2){
		Student s1 = (Student) o1;
		Student s2 = (Student) o2;
		return s1.id - s2.id;
	}
}