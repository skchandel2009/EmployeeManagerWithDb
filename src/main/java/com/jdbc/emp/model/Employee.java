package com.jdbc.emp.model;
public class Employee {
	private int empId;
	private String name;
	private double bsal;
	private String deptName;
	
	//setter/getter
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBsal() {
		return bsal;
	}
	public void setBsal(double bsal) {
		this.bsal = bsal;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	//constructors
	public Employee(int empId, String name, double bsal, String deptName) {
		super();
		this.empId = empId;
		this.name = name;
		this.bsal = bsal;
		this.deptName = deptName;
	}
	
	public Employee(String name, double bsal, String deptName) {
		this.name = name;
		this.bsal = bsal;
		this.deptName = deptName;
	}
	
	public Employee() {
		this.name = null;
		this.bsal = 0;
		this.deptName = null;
	}
	
	//toString
	@Override
	public String toString() {
		return "\n" + empId + ", " + name + ", " + bsal + ", " + deptName;
	}
}
