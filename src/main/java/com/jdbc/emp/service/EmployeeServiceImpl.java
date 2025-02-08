package com.jdbc.emp.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.emp.model.Employee;
import com.jdbc.emp.util.DbUtil;

public class EmployeeServiceImpl implements EmployeeService {

	//get employees
	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees=new ArrayList<Employee>();
		Employee emp=null;
		Connection connection=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {

			connection=DbUtil.getDbConnection();

			// 3.Making a statement
			stmt=connection.createStatement();
			String query="select * from employee";

			//4. Statement processing
			rs=stmt.executeQuery(query);

			//5. show result
			while(rs.next()) {
				emp=new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setBsal(rs.getDouble(3));
				emp.setDeptName(rs.getString(2));
				employees.add(emp);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return employees;
	}

	//get employee by id
	@Override
	public Employee getEmployeeById(int empId) {
		
		Connection connection=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Employee emp=null;
		try {
			//1 & 2 performed by DbUtil
			connection=DbUtil.getDbConnection();

			// 3.Making a statement
			String query="select * from employee where empid=?";
			stmt=connection.prepareStatement(query);
			stmt.setInt(1, empId);
			
			//4. Statement processing
			rs=stmt.executeQuery();

			//5. show result
			if(rs.next()){
				emp=new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setBsal(rs.getDouble(3));
				emp.setDeptName(rs.getString(2));
			}else {
				System.err.println(empId+" not found in db...");
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	//adding new employee
	@Override
	public void addEmployee(Employee emp) {
		Connection connection=null;
		PreparedStatement stmt=null;
		
		try {
			//1 & 2 performed by DbUtil
			connection=DbUtil.getDbConnection();

			// 3.Making a statement
			String query="insert into employee(name,bsal,deptname) values(?,?,?);";
			stmt=connection.prepareStatement(query);
			stmt.setString(1, emp.getName());
			stmt.setDouble(2, emp.getBsal());
			stmt.setString(3, emp.getDeptName());
			
			
			//4. Statement processing
			int count=stmt.executeUpdate();

			//5. show result
			if(count>0){
				System.out.println("Employee added successful..");
			}else {
				System.err.println("Employe not added in db...");
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Employee emp, int empId) {
		Connection connection=null;
        PreparedStatement ps=null;



        try {
            connection = DbUtil.getDbConnection();
            String query = "update employee set bsal=? , name=? ,deptname =? where empid=?  ";
            ps = connection.prepareStatement(query);
            ps.setDouble(1,emp.getBsal());
            ps.setString(2,emp.getName());
            ps.setString(3,emp.getDeptName());
            ps.setInt(4,empId);


            int count=ps.executeUpdate();
            if(count>0){
                System.out.println("update successfully ");
            }
            else{
                System.err.println("Employee not found ");
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
	}

	//deleting employee data
	@Override
	public void delete(int empId) {
		Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection = DbUtil.getDbConnection();
            String query = "delete from  employee where empid=?";

            ps = connection.prepareStatement(query);

            ps.setInt(1,empId);
            int count=ps.executeUpdate();
            if(count>0){
                System.out.println("delete  successfully ");
            }
            else{
                System.err.println("Employee not found ");
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
		
	}
}
