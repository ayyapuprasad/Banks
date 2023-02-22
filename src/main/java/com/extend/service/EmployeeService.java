package com.extend.service;

import java.util.List;

import com.extend.bean.Employee;
import com.extend.bean.Finalresponse;

public interface EmployeeService {
	public Finalresponse insertEmployee(Employee employee);
	public Finalresponse getAllEmployee();
	public Finalresponse deleteRecordById(int id);
	public Finalresponse updateEmployee(Employee employee);
	public Finalresponse EmployeeLogin(Employee employee);
	public Finalresponse verificationotp(String otp,String phonenumber);
	public Finalresponse validateToken(String Token, Employee employee);
	public Finalresponse EmployeeLogin(String phonenumber, String password);
}
