package com.hrms.usercase;

import java.util.Scanner;

import com.hrms.dao.EmployeeDao;
import com.hrms.dao.EmployeeDaoImpl;
import com.hrms.exception.EmployeeException;

public class GetEmployeeByEmpId {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee ID: ");
		int id=sc.nextInt();
		
		EmployeeDao dao=new EmployeeDaoImpl();
		try {
			System.out.println(dao.getEmployeeByID(id));
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
