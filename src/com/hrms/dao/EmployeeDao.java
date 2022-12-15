package com.hrms.dao;

import java.util.List;

import com.hrms.exception.EmployeeException;
import com.hrms.model.Employee;

public interface EmployeeDao {
	
	
	public String registerEmployee(Employee employee) throws EmployeeException;
	
	public List<Employee> getAllEmployee()throws EmployeeException;
	
	public String changeDepartment(int employeeID, int newDepartmentID) throws EmployeeException;
	
	public String changeEmpPassword(int id) throws EmployeeException;
	
	public Employee getEmployeeByID(int id)throws EmployeeException;
	
	public List<Employee> employeeByDepartment(int id)throws EmployeeException;
	
	public String updateEmployee(String Column, String typeName, int id) throws EmployeeException;
	
	
}
