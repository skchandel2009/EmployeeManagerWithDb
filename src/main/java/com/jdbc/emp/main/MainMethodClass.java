package com.jdbc.emp.main;
import com.jdbc.emp.service.EmployeeServiceImpl;
public class MainMethodClass {
	public static void main(String[] args) {
		
		//getting all employees data
		EmployeeServiceImpl service=new EmployeeServiceImpl();
		System.out.println(service.getEmployees());
		
		//searching employee data by id 14
//		Employee emp=service.getEmployeeById(14);
//		if(emp!=null) {
//		System.out.println(emp);
//		}else {
//			System.err.println();
//		}
		
		//adding new employee
		//service.addEmployee(new Employee("Anand",8900,"dev"));
		
		//Modifying employee data
        //service.update(new Employee("Suraj",7000,"BSC"),12);
		
		//deleting employee data for empid 12
		//service.delete(12);
		
	}
}
