package com.cloning;

public class Employee implements Cloneable{

	int empNo;
	String name;
	public Employee(int empNo, String name) {
		super();
		this.empNo = empNo;
		this.name = name;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
