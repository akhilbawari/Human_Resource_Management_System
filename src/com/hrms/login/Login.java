package com.hrms.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.hrms.dbUtility.Utility;
import com.hrms.exception.EmployeeException;
import com.hrms.model.Employee;
import com.hrms.panels.Panel;

public class Login {
       public static boolean adminLoginAuth() {
		
		Scanner sc=new Scanner(System.in);

		System.out.println("Enter Admin Username");
		String user=sc.next();
		
		System.out.println("Enter Admin Password");
		String pass=sc.next();
		if(user.equals("admin")&&pass.equals("admin123")) {
			return true;
		}else{
			return false;
			
		}
		
		
		
	}
       public static Employee employeeLoginAuth() throws EmployeeException {
   		
   		Employee emp=null;
   		
   		Scanner sc=new Scanner(System.in);
   		
   		System.out.println("Enter Your Email");
   		String email=sc.next();
   		
   		System.out.println("Enter Your Password");
   		String password=sc.next();
   		
   		try (Connection con=Utility.getConnection()){
   			
   			PreparedStatement ps=con.prepareStatement("select * from employee where email=?");
   			
   			ps.setString(1, email);
   			
   			ResultSet rs=ps.executeQuery();
   			
   			if(rs.next()) {
   				emp=new Employee();
   				emp.setId(rs.getInt("id"));
   				emp.setFirstName(rs.getString("firstName"));
   				emp.setLastName(rs.getString("lastName"));
   				emp.setMobile(rs.getString("mobile"));
   				emp.setEmail(rs.getString("email"));
   				emp.setPassword(rs.getString("password"));
   				emp.setDateOfBirth(rs.getString("dateOfBirth"));
   				emp.setAddress(rs.getString("address"));
   				emp.setSalary(rs.getInt("salary"));
   				emp.setHireDate(rs.getString("hireDate"));
   				emp.setDepartmentID(rs.getInt("departmentID"));
   				
   				if(!emp.getPassword().equals(password)) {
   					
   					throw new EmployeeException("Wrong Password");
   					
   				}
   				
   			}
   			else {
   				throw new EmployeeException("Email ID not exist");
   			}
   			
   		} catch (SQLException e) {
   			throw new EmployeeException(e.getMessage());
   		}
   		
   		return emp;
   		
   	}

}
