package com.hrms.usercase;

import java.util.Scanner;

import com.hrms.dao.LeavesDao;
import com.hrms.dao.LeavesDaoImpl;
import com.hrms.exception.LeavesException;

public class RequestLeave {

	public static void main(String[] args) {
        
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Employee ID: ");
	    int id=sc.nextInt();
		System.out.println("Leave from Date in yyyy-mm-dd format");
		String startDate=sc.next();
		System.out.println("Leave till Date in yyyy-mm-dd format");
		String endDate=sc.next();
		LeavesDao l=new LeavesDaoImpl();
		
		
		try {
			String res = l.requestLeave(id, startDate, endDate);
			System.out.println(res);
			
		} catch (LeavesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
