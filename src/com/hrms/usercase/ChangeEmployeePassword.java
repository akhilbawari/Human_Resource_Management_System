package com.hrms.usercase;

import java.util.Scanner;

import com.hrms.dao.EmployeeDao;
import com.hrms.dao.EmployeeDaoImpl;
import com.hrms.exception.EmployeeException;

public class ChangeEmployeePassword {
  public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter your Employee Id: ");
	  int empId=sc.nextInt();
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
