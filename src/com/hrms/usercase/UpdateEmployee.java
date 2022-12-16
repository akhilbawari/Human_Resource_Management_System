package com.hrms.usercase;

import java.util.Scanner;

import com.hrms.dao.EmployeeDao;
import com.hrms.dao.EmployeeDaoImpl;
import com.hrms.exception.EmployeeException;

public class UpdateEmployee {

	public static void main(int id) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		
		System.out.println("Select option which you want to Update :");
		System.out.println("1. First Name");
		System.out.println("2. Last Name");
		System.out.println("3. Mobile");
		System.out.println("4. Email");
		System.out.println("5. DOB");
		System.out.println("6. Address");
		System.out.println("7. Password");
		
		int num=sc.nextInt();
		String column=null;
		String value = null;
		if(num==1) {
			System.out.println("Enter First name: ");
			 column="firstname";
			 value=sc.next();
		}
		if(num==2) {
			System.out.println("Enter Last name: ");
			 column="lastname";
			 value=sc.next();
		}
		if(num==3) {
			System.out.println("Enter Your New Mobile: ");
			 column="mobile";
			 value=sc.next();
		}
		if(num==4) {
			System.out.println("Enter Your New Email: ");
			 column="email";
			 value=sc.next();
		}
		if(num==5) {
			System.out.println("Enter Your New DOB in yyyy-mm-dd Format");
			 column="dateofbirth";
			 value=sc.next();
		}
		if(num==6) {
			System.out.println("Enter Your New Address");
			 column="address";
			sc.nextLine();
			 value=sc.nextLine();
		}
		if(num==7) {
			System.out.println("Enter Your New Password");
			 column="password";
			 value=sc.next();
		}
		
        EmployeeDao e=new EmployeeDaoImpl();
		
		try {
			String res=e.updateEmployee(column, value, id);
			System.out.println(res);
		} catch (EmployeeException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
				

	}

}
