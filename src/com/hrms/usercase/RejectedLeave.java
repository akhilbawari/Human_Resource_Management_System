package com.hrms.usercase;

import java.util.Scanner;

import com.hrms.dao.LeavesDao;
import com.hrms.dao.LeavesDaoImpl;
import com.hrms.exception.LeavesException;

public class RejectedLeave {
	
	
	public static void main(int id) {
		Scanner sc=new Scanner(System.in);
		LeavesDao l=new LeavesDaoImpl();
		String res;
		try {
			res = l.rejectLeave(id);
			System.out.println(res);
			
		} catch (LeavesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
