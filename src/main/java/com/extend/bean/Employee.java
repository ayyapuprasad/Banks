package com.extend.bean;
import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;
public class Employee {
	private int employee_id;
	@NotEmpty(message = "Categoryemployee_name feild should not be Empty")
	private String employee_name;
	@NotEmpty(message = "Categoryphonenumber feild should not be Empty")
	private String phonenumber;
	@NotEmpty(message = "Categorypassword feild should not be Empty")
	private String password;
	private String otp;
	private MultipartFile imagefile;
	
	public MultipartFile getImagefile() {
		return imagefile;
	}
	public void setImagefile(MultipartFile imagefile) {
		this.imagefile = imagefile;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
