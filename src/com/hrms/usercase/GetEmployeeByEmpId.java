package com.hrms.usercase;



import com.hrms.customs.PrintTable;
import com.hrms.dao.EmployeeDao;
import com.hrms.dao.EmployeeDaoImpl;
import com.hrms.exception.EmployeeException;

public class GetEmployeeByEmpId {

	public static void main(int id) {
		// TODO Auto-generated method stub
		
		EmployeeDao dao=new EmployeeDaoImpl();
		try {
			PrintTable.printSingleEmployee(dao.getEmployeeByID(id));
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
