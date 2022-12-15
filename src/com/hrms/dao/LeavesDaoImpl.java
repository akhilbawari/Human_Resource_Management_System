package com.hrms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hrms.dbUtility.Utility;
import com.hrms.exception.LeavesException;
import com.hrms.model.Leaves;

public class LeavesDaoImpl implements LeavesDao {
    
	
	/*---------------------------------------Request Leave-------------------------------------*/
	@Override
	public String requestLeave(int id, String startDate, String endDate) throws LeavesException {
		String msg="Not applied for leave";
		try (Connection con=Utility.getConnection()){
			PreparedStatement ps=con.prepareStatement("insert into leaves(empID,leavefrom,leavetill) values(?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, startDate);
			ps.setString(3, endDate);
			
			int x=ps.executeUpdate();
			if(x>0) msg="Successfully applied for leave";
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			msg=e.getMessage();
		}
		return msg;
	}
    
	
	/*-------------------------------------Approved Leave------------------------------*/
	@Override
	public String approvedLeave(int id) throws LeavesException {
		// TODO Auto-generated method stub
		String msg="Not Approved";
		try(Connection con=Utility.getConnection()) {
			PreparedStatement ps=con.prepareStatement("update leaves set status='Approved' where empid=?");
            ps.setInt(1, id);
			
			int x=ps.executeUpdate();
			if(x>0) {
				msg="Approved";
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			msg=e.getMessage();
		}
		return msg;
	}
	
	
	
	/*---------------------------Reject Leave--------------------------------------------*/
	
	@Override
	public String rejectLeave(int id) throws LeavesException {
		String message="Not Rejected";
		
		try(Connection con=Utility.getConnection()) {
			
			PreparedStatement ps=con.prepareStatement("update leaves set status='Rejected' where empid=?");
			
			ps.setInt(1, id);
			
			int x=ps.executeUpdate();
			if(x>0) {
				message="Rejected";
			}
			
		} catch (SQLException e) {
			message=e.getMessage();
		}
		
		return message;
	}
	
	
	
	/*------------------------------Pending Leaves--------------------------------------------*/
    
	public List<Leaves> pendingLeaves() throws LeavesException{
		List<Leaves> list=new ArrayList<>();
		
		try(Connection con=Utility.getConnection()) {
			
			PreparedStatement ps=con.prepareStatement("select l.empid, l.status, e.firstname, e.lastname, l.leavefrom, l.leavetill, e.departmentid from leaves l inner join employee e on e.id=l.empid and l.status='pending';");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Leaves leave=new Leaves();
				leave.setEmployeeId(rs.getInt("empid"));
				leave.setStartDate(rs.getString("leavefrom"));
				leave.setEndDate(rs.getString("leavetill"));
				leave.setStatus(rs.getString("status"));
				leave.setFirstName(rs.getString("firstname"));
				leave.setLastName(rs.getString("lastname"));
				leave.setDepartmentID(rs.getInt("departmentid"));
				list.add(leave);
			}
			
		} catch (SQLException e) {
			
		}
		
		return list;
	}
	
	
	
}
