package com.hrms.usercase;

import java.util.List;

import com.hrms.customs.PrintTable;
import com.hrms.dao.DepartmentDao;
import com.hrms.dao.DepartmentDaoImpl;
import com.hrms.exception.DepartmentException;
import com.hrms.model.Department;

public class GetAllDepartment {
   public static void main(String[] args) {
	   DepartmentDao dao=new DepartmentDaoImpl();
		
		try {
			List<Department>list=dao.getAllDepartment();
			
			PrintTable.printDepartment(list);
		} catch (DepartmentException e) {
			System.out.println(e.getMessage());
		}
   }
   
}
