package com.hrms.usercase;

import java.util.List;

import com.hrms.customs.PrintTable;
import com.hrms.dao.EmployeeDao;
import com.hrms.dao.EmployeeDaoImpl;
import com.hrms.exception.EmployeeException;
import com.hrms.model.Employee;

public class GetAllEmployee {

	public static void main(String[] args) {
		   EmployeeDao dao=new EmployeeDaoImpl();
			
			try {
				List<Employee>list=dao.getAllEmployee();
				
				PrintTable.printEmployeeList(list);

			} catch (EmployeeException e) {
				System.out.println(e.getMessage());
			}
			
	}
	

}
