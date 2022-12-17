package com.hrms.usercase;

import java.util.List;

import com.hrms.customs.PrintTable;
import com.hrms.dao.LeavesDao;
import com.hrms.dao.LeavesDaoImpl;
import com.hrms.exception.LeavesException;
import com.hrms.model.Leaves;

public class ShowPendingLeaves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeavesDao lev=new LeavesDaoImpl();
		List<Leaves> list=null;
		try {
			list = lev.pendingLeaves();
			PrintTable.printLeaveList(list);
		} catch (LeavesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(list.size()==0) {
			System.out.println("No Leave Request");
			return;
		}

	}

}
