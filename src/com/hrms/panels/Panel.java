package com.hrms.panels;

import java.util.Scanner;
import com.hrms.model.Employee;
import com.hrms.usercase.AddDepartment;
import com.hrms.usercase.ApprovedLeaves;
import com.hrms.usercase.ChangeEmployeeDepartment;
import com.hrms.usercase.ChangeEmployeePassword;
import com.hrms.usercase.EmployeeByDepartment;
import com.hrms.usercase.GetAllDepartment;
import com.hrms.usercase.GetAllEmployee;
import com.hrms.usercase.GetEmployeeByEmpId;
import com.hrms.usercase.RegisterEmployee;
import com.hrms.usercase.RequestLeave;
import com.hrms.usercase.ShowPendingLeaves;
import com.hrms.usercase.UpdateDepartment;
import com.hrms.usercase.UpdateEmployee;

public class Panel {
	public static void admin() {
		try {
		System.out.println();
		Thread.sleep(300);
		System.out.println("╰┈┈┈┈➤ 1.  Add Department");
		Thread.sleep(300);
		System.out.println("╰┈┈┈┈➤ 2.  View All Department");
		Thread.sleep(300);
		System.out.println("╰┈┈┈┈➤ 3.  Update Department");
		Thread.sleep(300);
		System.out.println("╰┈┈┈┈➤ 4.  Add New Employee");
		Thread.sleep(300);
		System.out.println("╰┈┈┈┈➤ 5.  View All Employee");
		Thread.sleep(300);
		System.out.println("╰┈┈┈┈➤ 6.  View Leave Request");
		Thread.sleep(300);
		System.out.println("╰┈┈┈┈➤ 7.  View Employee by ID");
		Thread.sleep(300);
		System.out.println("╰┈┈┈┈➤ 8.  Update Employee");
		Thread.sleep(300);
		System.out.println("╰┈┈┈┈➤ 9.  Transfer Employee to other Department");
		Thread.sleep(300);
		System.out.println("╰┈┈┈┈➤ 10. Employee By Department");
		Thread.sleep(300);
		System.out.println("╰┈┈┈┈➤ 11. Approve Leave Request");
		Thread.sleep(300);
		System.out.println("╰┈┈┈┈➤ 12. Reject Leave Request");
		Thread.sleep(300);
		System.out.println("╰┈┈┈┈➤ 13. EXIT");
		Thread.sleep(500);
		System.out.println();
		System.out.println("———————— CHOOSE OPTION ————————");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		switch(n) {
		case 1:
			AddDepartment.main(null);
			Panel.admin();
			break;
		case 2:
			GetAllDepartment.main(null);
			Panel.admin();
			break;
		case 3:
			UpdateDepartment.main(null);
			Panel.admin();
			break;
		case 4:
			RegisterEmployee.main(null);
			Panel.admin();
			break;
		case 5:
			GetAllEmployee.main(null);
			Panel.admin();
			break;
		case 6:
			ShowPendingLeaves.main(null);
			Panel.admin();
			break;
		case 7:
			System.out.println("Enter ID of Employee");
			int id=sc.nextInt();
			GetEmployeeByEmpId.main(id);
			Panel.admin();
			break;
		case 8:
			System.out.println("Enter ID of Employee");
			int id2=sc.nextInt();
			UpdateEmployee.main(id2);
			Panel.admin();
			break;
		case 9:
			ChangeEmployeeDepartment.main(null);
			Panel.admin();
			break;
		case 10:
			EmployeeByDepartment.main(null);
			Panel.admin();
			break;
		case 11:
			System.out.println("Enter ID of Employee");
			int id3=sc.nextInt();
			ApprovedLeaves.main(id3);
			Panel.admin();
		case 12:
			System.out.println("Enter ID of Employee");
			int id4=sc.nextInt();
			RequestLeave.main(id4);
			Panel.admin();
		case 13:
			return;
		default:
			System.out.println("Wrong Input");
	    
	}

	}
	public static void welcomeDepartment() {
		try {
			System.out.println("████████████████████████████████████████████████████████████████████████████████");
			System.out.println();
			Thread.sleep(500);
			System.out.println("»»——————————————————————————　WELCOME TO ADMIN PANEL　——————————————————————————««");
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
    public static void employee(Employee employee) {
    	try {
    	System.out.println();
    	Thread.sleep(300);
		System.out.println("╰┈┈┈┈➤ 1.  View Profile");
		Thread.sleep(300);
		System.out.println("╰┈┈┈┈➤ 2.  Update Profile");
		Thread.sleep(300);
		System.out.println("╰┈┈┈┈➤ 3.  Change Password");
		Thread.sleep(300);
		System.out.println("╰┈┈┈┈➤ 4.  Apply for Leave");
		Thread.sleep(300);
		System.out.println("╰┈┈┈┈➤ 5.  EXIT");
		Thread.sleep(500);
		System.out.println();
		System.out.println("———————— CHOOSE OPTION ————————");
    	} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Scanner sc=new Scanner(System.in);
    	int n=sc.nextInt();
    	switch(n) {
		case 1:
			GetEmployeeByEmpId.main(employee.getId());
			Panel.employee(employee);
			break;
		case 2:
			UpdateEmployee.main(employee.getId());
			Panel.employee(employee);
			break;
		case 3:
			ChangeEmployeePassword.main(employee.getId());
			Panel.employee(employee);
			break;
		case 4:
			RequestLeave.main(employee.getId());
			Panel.employee(employee);
			break;
		case 5:
			System.out.println("ThankYou");
			return;
			default:
				System.out.println("Wrong Input");
		}
    }
    public static void welcomeEmployee(Employee employee) {
		try {
			System.out.println("████████████████████████████████████████████████████████████████████████████████");
			System.out.println();
			Thread.sleep(500);
			System.out.println("»»——————————————————————————　WELCOME "+employee.getFirstName().toUpperCase()+" "+employee.getLastName().toUpperCase()+" TO EMPLOYEE PANEL　——————————————————————————««");
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
