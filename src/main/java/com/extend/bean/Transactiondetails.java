package com.extend.bean;

import java.sql.Date;

import jakarta.validation.constraints.NotEmpty;

public class Transactiondetails {
	@NotEmpty(message = "Categorytransactionnumberfeild should not be Empty")
	private String transactionnumber;
	@NotEmpty(message = "Categoryaccountnumber feild should not be Empty")
	private String accountnumber;
	private Date dot;
	private int transaction_amount;
	@NotEmpty(message = "Categorycustomer_id feild should not be Empty")
	private String customer_id;
	public String getTransactionnumber() {
		return transactionnumber;
	}
	public void setTransactionnumber(String transactionnumber) {
		this.transactionnumber = transactionnumber;
	}
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public Date getDot() {
		return dot;
	}
	public void setDot(Date dot) {
		this.dot = dot;
	}
	public int getTransaction_amount() {
		return transaction_amount;
	}
	public void setTransaction_amount(int transaction_amount) {
		this.transaction_amount = transaction_amount;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

}
