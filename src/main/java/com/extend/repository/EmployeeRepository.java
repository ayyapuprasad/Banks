package com.extend.repository;

import java.sql.Date;
import java.util.List;

import com.extend.bean.Employee;


public interface EmployeeRepository {
	public Employee insertEmployee(Employee employee);

	public Employee updateEmployee(Employee employee);

	public Employee deleteRecordById(int employee_id);

	public List<Object[]> getAllEmployee();

	public List<Object> phonenumber();

	public List<Object> password();

	public List<Object[]> Login(String phonenumber, String password);

	public String checkUserIsPerentByPhonenumber(String phonenumber);

	public String verficationotp(String otp, String phonenumber);

	//public String updateotp(String otp, String phonenumber);

	public java.sql.Date toGetDBOtpTime(String phonenumber);

public 	String updateotp(String otp, String phonenumber, java.util.Date date);

 public Employee insertEmployeeFile(Employee employee);
}
