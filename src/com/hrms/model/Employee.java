package com.hrms.model;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String mobile;
	private String email;
	private String password;
	private String dateOfBirth;
	private String address;
	private int salary;
	private String hireDate;
	private int departmentID;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String firstName, String lastName, String mobile, String email, String password,
			String dateOfBirth, String address, int salary, String hireDate, int departmentID) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.salary = salary;
		this.hireDate = hireDate;
		this.departmentID = departmentID;
	}
	public Employee(int id, String firstName, String lastName, String mobile, String email, String password, String dateOfBirth, String address, int salary, String hireDate, int departmentID) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.salary = salary;
		this.hireDate = hireDate;
		this.departmentID = departmentID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	@Override
	public String toString() {
		return "employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobile=" + mobile
				+ ", email=" + email + ", password=" + password + ", dateOfBirth=" + dateOfBirth + ", address="
				+ address + ", salary=" + salary + ", hireDate=" + hireDate + ", departmentID=" + departmentID + "]";
	}
	
	

}
