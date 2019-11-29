package com.debugging;

public class Employee {

	private int empId;
	private String empName;
	private String empHome;
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpHome() {
		return empHome;
	}
	public void setEmpHome(String empHome) {
		this.empHome = empHome;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empHome=" + empHome + "]";
	}
		
}
