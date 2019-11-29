package com.functionalInterface;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionPredicateExampleToIncrementEmpSalary {

	static Predicate<Employee> toFindEmpWithSalBelow10k = emp -> emp.salary < 10000.00;

	static Function<Employee, Double> toHikeSal = employee -> Double.sum(employee.salary, 500.00);

	public static void main(String[] args) {
		ArrayList<Employee> empList = new ArrayList<>();
		insertEmployees(empList);

		System.out.println(empList);
		hikeSalaryOfEmployees(empList);
		System.out.println(empList);
	}

	private static void hikeSalaryOfEmployees(ArrayList<Employee> empList) {

		for (Employee emp : empList) {
			if (toFindEmpWithSalBelow10k.test(emp)) {
				emp.setSalary(toHikeSal.apply(emp));
			}
		}
	}

	private static void insertEmployees(ArrayList<Employee> al) {

		al.add(new Employee("aman", 6090));
		al.add(new Employee("shady", 60900));
		al.add(new Employee("jayZ", 50550));
		al.add(new Employee("akon", 60000));
		al.add(new Employee("selena", 6000));
	}
}
