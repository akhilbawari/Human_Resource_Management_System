package com.hrms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.hrms.dbUtility.Utility;
import com.hrms.exception.DepartmentException;
import com.hrms.model.Department;

public class DepartmentDaoImpl implements DepartmentDao {
	
	
  /*---------------------------Add New Department ----------------------------------------------*/

	@Override
	public String addDepartment(String name) throws DepartmentException {
		String msg="Department Not Added...";
		
		try(Connection con=Utility.getConnection();) {
			
			PreparedStatement ps=con.prepareStatement("insert into department(name) values (?) ");
			ps.setString(1, name);
            int x=ps.executeUpdate();
			
			if(x>0) msg="Department Added...";
			
		} catch (SQLException e) {
			// TODO: handle exception
			msg=e.getMessage();
		}
		
		
		return msg;
		
	}


  /*-----------------------Get All Department---------------------------------------------------*/	
	@Override
	public List<Department> getAllDepartment() throws DepartmentException {
		// TODO Auto-generated method stub
		List<Department> list=new ArrayList();
		try (Connection con=Utility.getConnection()){
			PreparedStatement ps=con.prepareStatement("select * from department");
			ResultSet rs=ps.executeQuery();
		    while(rs.next()) {
		    	int id=rs.getInt("id");
				String name=rs.getString("name");
				Department d=new Department(id, name);
				list.add(d);
				
		    }
		} catch (SQLException e) {
			// TODO: handle exception
			throw new DepartmentException(e.getMessage());
		}
		
		if(list.size()==0)
			throw new DepartmentException("No Department found");
		
		return list;
	}
  

   /*--------------------------------Update Department----------------------------*/

	@Override
	public String updateDepartment(Department department) throws DepartmentException {
		String message="Department not found";
		
		try(Connection con=Utility.getConnection()){
			
			PreparedStatement ps=con.prepareStatement("update department set name=? where id=?");
			
			ps.setString(1, department.getName());
			ps.setInt(2, department.getId());
			int x=ps.executeUpdate();
			
			if(x>0) {
				message="Department updated";
			}
			
		} catch (SQLException e) {
			message=e.getMessage();
		}
		
		return message;
	}
    

}
