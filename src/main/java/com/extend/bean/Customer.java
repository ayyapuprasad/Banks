package com.extend.bean;

import java.sql.Date;

import jakarta.validation.constraints.NotEmpty;

public class Customer {

	private int customer_id;

	@NotEmpty(message = "Categoryfirstname feild should not be Empty")
	private String firstname;

	@NotEmpty(message = "categorylastname feild should not be Empty")
	private String lastname;

	@NotEmpty(message = "categorycity feild should not be Empty")
	private String city;

	@NotEmpty(message = "categorymobileno feild should not be Empty")
	private String mobileno;
	private Date dob;
	//@NotEmpty(message =  " categoryuserName feild should not be Empty")
	private String userName;
	@NotEmpty(message = "categorypassword feild should not be Empty")
	private String password;
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
