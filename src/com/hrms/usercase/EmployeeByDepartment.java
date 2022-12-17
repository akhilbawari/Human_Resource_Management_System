package com.hrms.usercase;

import java.util.List;
import java.util.Scanner;

import com.hrms.customs.PrintTable;
import com.hrms.dao.EmployeeDao;
import com.hrms.dao.EmployeeDaoImpl;
import com.hrms.exception.EmployeeException;
import com.hrms.model.Employee;

public class EmployeeByDepartment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Department Id: ");
		int deptId=sc.nextInt();
		
		EmployeeDao dao=new EmployeeDaoImpl();
		try {
			List<Employee>list=dao.employeeByDepartment(deptId);
			PrintTable.printEmployeeList(list);;
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
