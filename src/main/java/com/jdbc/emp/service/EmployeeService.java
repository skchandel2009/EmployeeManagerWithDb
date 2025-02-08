package com.jdbc.emp.service;
import java.util.List;
import com.jdbc.emp.model.Employee;
public interface EmployeeService {
	//get employees
	List<Employee> getEmployees();
	
	//get employee by id
	Employee getEmployeeById(int empId);
	
	//adding new employee
	void addEmployee(Employee emp);
	
	//update existing employee
	void update(Employee emp,int empId);
	
	//deleting existing employee by id
	 void delete(int empId);
	
}
