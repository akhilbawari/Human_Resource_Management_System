package com.hrms.usercase;

import java.util.Scanner;

import com.hrms.dao.DepartmentDao;
import com.hrms.dao.DepartmentDaoImpl;
import com.hrms.exception.DepartmentException;
import com.hrms.model.Department;

public class UpdateDepartment {
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Department ID");
		int did=sc.nextInt();
		
		System.out.println("Enter new name for Department");
		String dname=sc.next();
		
		DepartmentDao dao=new DepartmentDaoImpl();
		
		String res;
		try {
			res = dao.updateDepartment(new Department(did, dname));
			System.out.println(res);
		} catch (DepartmentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	

}
