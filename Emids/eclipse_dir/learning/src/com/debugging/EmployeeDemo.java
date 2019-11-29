package com.debugging;

public class EmployeeDemo {
	
	public static void main(String[] args) {
		
		Employee emp = new Employee();
		emp.setEmpId(123);
		emp.setEmpName("kamina");
		emp.setEmpHome("delhi");
		
		
		System.out.println(emp.getEmpHome());
		
		System.out.println(emp.getEmpId());
		
		System.out.println(emp.getEmpName());
		
		emp.toString();
}
}
	