package com.cloning;

public class TestCloningEg1 {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Employee emp1 = new Employee(1, "aman");
		
		Employee emp2 = (Employee) emp1.clone();
		//emp1.setEmpNo(2);
		//emp2.setEmpNo(10);
		System.out.println(emp1.getEmpNo());
		System.out.println(emp2.getEmpNo());
		System.out.println(emp1.getName().hashCode());
		System.out.println(emp2.getName().hashCode());
		
		System.out.println(emp1.hashCode() + " " + emp2.hashCode());
	}
}
