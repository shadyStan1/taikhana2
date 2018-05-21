package com.crudonexcel;

import java.util.Date;

public class Employee {

	private int empId;
	private String empName;
	private Date empJoinDate;
	private double sal;
	
	Employee(int empId, String empName, Date empJoinDate, double sal){
		this.empId = empId;
		this.empName = empName;
		this.empJoinDate = empJoinDate;
		this.sal = sal;
	}
	
	
	public int getEmpId() {
		return empId;
	}


	public String getEmpName() {
		return empName;
	}


	public Date getEmpJoinDate() {
		return empJoinDate;
	}


	public double getSal() {
		return sal;
	}
	
}
