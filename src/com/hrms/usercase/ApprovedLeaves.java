package com.hrms.usercase;

import java.util.Scanner;

import com.hrms.dao.LeavesDao;
import com.hrms.dao.LeavesDaoImpl;
import com.hrms.exception.LeavesException;

public class ApprovedLeaves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee id");
		int id=sc.nextInt();
		LeavesDao l=new LeavesDaoImpl();
		String res;
		try {
			res = l.approvedLeave(id);
			System.out.println(res);
			
		} catch (LeavesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
