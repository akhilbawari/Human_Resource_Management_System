package com.hrms.login;

import java.util.Scanner;

import com.hrms.customs.ConsoleColors;
import com.hrms.exception.EmployeeException;
import com.hrms.model.Employee;
import com.hrms.panels.Panel;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);

		while(true) {
			System.out.println(ConsoleColors.ORANGE+""
					+"╔═══════════════════╗\r\n"
					+"    CHOOSE OPTION\r\n"
					+"╚═══════════════════╝\r\n"
					+"1. Admin login\r\n"
					+"2. Employee login\r\n"
					+"3. Exit");
			
			System.out.println("▃▃▃▃▃▃▃▃▃▃ Choose Option ▃▃▃▃▃▃▃▃▃▃▃");
			System.out.println();
			int choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				if(Login.adminLoginAuth()) {
					Panel.welcomeDepartment();
					Panel.admin();
				}
				else {
					System.out.println("Wrong Credentials Try Again");
				}
				break;
			case 2:
				try {
					Employee emp=Login.employeeLoginAuth();
					Panel.welcomeEmployee(emp);
					Panel.employee(emp);
				} catch (EmployeeException e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 3:
				System.out.println("See You...!");
				System.exit(0);
			default:
				System.out.println("WRONG INPUT!!!!");
			}
		}

	}

}
