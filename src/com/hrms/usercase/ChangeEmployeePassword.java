package com.hrms.usercase;

import java.util.Scanner;

import com.hrms.dao.EmployeeDao;
import com.hrms.dao.EmployeeDaoImpl;
import com.hrms.exception.EmployeeException;

public class ChangeEmployeePassword {
  public static void main(int empId) {
	  
	  EmployeeDao d=new EmployeeDaoImpl();
		
		
		try {
			String res = d.changeEmpPassword(empId);
			System.out.println(res);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
}
}
