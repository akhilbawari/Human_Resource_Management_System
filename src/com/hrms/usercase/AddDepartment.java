package com.hrms.usercase;

import java.util.Scanner;

import com.hrms.dao.DepartmentDao;
import com.hrms.dao.DepartmentDaoImpl;
import com.hrms.exception.DepartmentException;

public class AddDepartment {

	public static void main(String[] args) {
		
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Department Name");
			String dname=sc.nextLine();
			
			
			DepartmentDao dao = new DepartmentDaoImpl();
			String res;
			try {
				res = dao.addDepartment(dname);
				System.out.println(res);
			} catch (DepartmentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

		
	}

}
