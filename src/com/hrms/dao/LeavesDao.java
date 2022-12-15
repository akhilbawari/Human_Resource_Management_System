package com.hrms.dao;

import java.util.List;

import com.hrms.exception.LeavesException;
import com.hrms.model.Leaves;

public interface LeavesDao {
	
	public String requestLeave(int id, String startDate, String endDate) throws LeavesException;
	
	public String approvedLeave(int id) throws LeavesException;
	
	public String rejectLeave(int id) throws LeavesException;
	
	public List<Leaves> pendingLeaves() throws LeavesException;

}
