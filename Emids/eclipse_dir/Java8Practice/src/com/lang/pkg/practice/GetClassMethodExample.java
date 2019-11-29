package com.lang.pkg.practice;

import java.lang.reflect.Method;

import com.functionalInterface.Employee;

public class GetClassMethodExample {

	public static void main(String[] args) {
		Employee e = new Employee("aman", 100.0);
		Class c = e.getClass();
		
		Method[] meArr = c.getDeclaredMethods();
		for(Method m : meArr)
		{
			System.out.println(m.getName());
		}
		Cloneable
	}
}
