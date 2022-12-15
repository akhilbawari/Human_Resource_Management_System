package com.hrms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.hrms.dbUtility.Utility;
import com.hrms.exception.EmployeeException;
import com.hrms.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	
	
	/*------------------------Register Employee-------------------------------*/

	@Override
	public String registerEmployee(Employee employee) throws EmployeeException {
		// TODO Auto-generated method stub
       String message="Employee not Registered !";
		
		try(Connection con=Utility.getConnection()){
			
			PreparedStatement ps=con.prepareStatement
			("insert into employee(firstName,lastName,mobile,email,password,dateOfBirth,address,salary,hireDate,departmentID) values(?,?,?,?,?,?,?,?,?,?)");

			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setString(3, employee.getMobile());
			ps.setString(4, employee.getEmail());
			ps.setString(5, employee.getPassword());
			ps.setString(6, employee.getDateOfBirth());
			ps.setString(7, employee.getAddress());
			ps.setInt(8, employee.getSalary());
			ps.setString(9, employee.getHireDate());
			ps.setInt(10, employee.getDepartmentID());
			
			int x= ps.executeUpdate();
			
			if(x > 0)
				message = "Employee Registered Sucessfully ! Password is "+employee.getPassword();
			
		}catch(SQLException e) {
			message=e.getMessage();
		}
		
		return message;
	}
    
	
	
	/*-----------------------Get All Employee Details -------------------------------------*/
	@Override
	public List<Employee> getAllEmployee() throws EmployeeException {
		
		List<Employee> emp=new ArrayList();
		
		
		try(Connection con=Utility.getConnection()) {
         PreparedStatement ps=con.prepareStatement("select * from employee");
         
         ResultSet rs=ps.executeQuery();
         while(rs.next()) {
        	 Employee e= new Employee();
        	 e.setId(rs.getInt("id"));
        	 e.setFirstName(rs.getString("firstName"));
			 e.setLastName(rs.getString("lastName"));
	         e.setMobile(rs.getString("mobile"));
			 e.setEmail(rs.getString("email"));
			 e.setPassword(rs.getString("password"));
			 e.setDateOfBirth(rs.getString("dateOfBirth"));
			 e.setAddress(rs.getString("address"));
			 e.setSalary(rs.getInt("salary"));
			 e.setHireDate(rs.getString("hireDate"));
			 e.setDepartmentID(rs.getInt("departmentID"));
			 
			 emp.add(e);
         }
         
		} catch (SQLException e) {
			// TODO: handle exception
			throw new EmployeeException(e.getMessage());
		}
		
		// TODO Auto-generated method stub
		return emp;
	}


    /*------------------------Change Department------------------------------------*/
	@Override
	public String changeDepartment(int employeeID, int newDepartmentID) throws EmployeeException{
		// TODO Auto-generated method stub
		String msg="Department Not Changed";
		try(Connection con=Utility.getConnection()) {
			PreparedStatement ps=con.prepareStatement("update employee set departmentid=? where id=?");
			ps.setInt(1,newDepartmentID);
			ps.setInt(2,employeeID);
			
			int x=ps.executeUpdate();
			if(x>0)msg="Department Changed";
		} catch (SQLException e) {
			// TODO: handle exception
			msg=e.getMessage();
		}
		return msg;
	}


    /*----------------Change Employee Password----------------------*/
	@Override
	public String changeEmpPassword(int id) {
		String message="Not Change";
		
		try (Connection con=Utility.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement(" select * from employee where id = ?");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter existing password");
				String pass=sc.next();
				if(pass.equals(rs.getString("password"))) {
					message=changePass(id);
				}
				else {
					message="Incorrect password";
				}
			}
			else {
				return "Employee Not Found";
			}
			
		} catch (SQLException e) {
			message=e.getMessage();
		}

		return message;
	}

	
	private String changePass(int id) {
		String messagesg="Password Not Updated";
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter new password");
		String npass=sc.next();
		
		try (Connection con=Utility.getConnection()){
			PreparedStatement ps=con.prepareStatement("update employee set password=? where id=?");
			ps.setString(1, npass);
			ps.setInt(2, id);
			
			int rs=ps.executeUpdate();
			if(rs>0) {
				messagesg="Password Updated Sucessfully";
			}

		} catch (SQLException e) {
			
			messagesg=e.getMessage();
		 
		}
		
	   return messagesg;
		
	}

    /*------Get Employee By Employee ID--------------------------*/

	@Override
	public Employee getEmployeeByID(int id2) throws EmployeeException {
		// TODO Auto-generated method stub
		Employee emp=new Employee();
		try(Connection con=Utility.getConnection()) {
			
			PreparedStatement ps =con.prepareStatement("select * from employee where id=?");
			ps.setInt(1, id2);
			
			ResultSet rs=ps.executeQuery();
			DateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd");
			
            if(rs.next()) {
				
				int id=rs.getInt("id");
				String firstname=rs.getString("firstName");
				String lastname=rs.getString("lastName");
				String mobile=rs.getString("mobile");
				String email=rs.getString("email");
				String password=rs.getString("password");
				Date dob=rs.getDate("dateOfBirth");
				String dateOfBirth=dateFormat.format(dob); 
				String address=rs.getString("address");
				int salary=rs.getInt("salary");
				Date hd=rs.getDate("hireDate");
				String hireDate=dateFormat.format(hd);
				int departmentId=rs.getInt("departmentId");
				
				emp=new Employee(id, firstname, lastname, mobile, email, password, dateOfBirth, address, salary, hireDate, departmentId);
				
			}else {
				throw new EmployeeException("Employee not exist with this id : "+id2);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new EmployeeException(e.getMessage());
		}
		return emp;
	}


    /*----------Get List of employee by department id -------------------------------*/
	@Override
	public List<Employee> employeeByDepartment(int id) throws EmployeeException {
		// TODO Auto-generated method stub
		List<Employee>emp=new ArrayList();
		try (Connection con=Utility.getConnection()){
			PreparedStatement ps=con.prepareStatement("select * from Employee Where departmentID=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Employee e=new Employee();
				e.setId(rs.getInt("id"));
				e.setFirstName(rs.getString("firstName"));
				e.setLastName(rs.getString("lastName"));
				e.setMobile(rs.getString("mobile"));
				e.setEmail(rs.getString("email"));
				e.setPassword(rs.getString("password"));
				e.setDateOfBirth(rs.getString("dateOfBirth"));
				e.setAddress(rs.getString("address"));
				e.setSalary(rs.getInt("salary"));
				e.setHireDate(rs.getString("hireDate"));
				e.setDepartmentID(rs.getInt("departmentID"));
				
				emp.add(e);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new EmployeeException(e.getMessage());
		}
		
		if(emp.size()==0) throw new EmployeeException("No employee found in this department");
		
		return emp;
	}



	@Override
	public String updateEmployee(String Column, String typeName, int id) throws EmployeeException {
		String msg="Something went wrong..";
		
        try (Connection con=Utility.getConnection()) {
			
			PreparedStatement ps=con.prepareStatement("update employee set "+Column+"=? where id=?");
			
			ps.setString(1, typeName);
			ps.setInt(2, id);
			
			int x=ps.executeUpdate();
			
			if(x>0) {
				msg=Column+" Updated Successfully";
			}
			
		} catch (SQLException e) {
			msg=e.getMessage();
		}
        
        
		return msg;
	}
	
	
	
	
	
	

}
