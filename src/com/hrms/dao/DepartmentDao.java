package com.hrms.dao;

import java.util.List;

import com.hrms.exception.DepartmentException;
import com.hrms.model.Department;

public interface DepartmentDao {

	public  String addDepartment(String name) throws DepartmentException;
	
	public  List<Department> getAllDepartment()throws DepartmentException;
	
	public String updateDepartment(Department department) throws DepartmentException;
	
}
