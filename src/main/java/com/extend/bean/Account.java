package com.extend.bean;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Account {
	@NotEmpty(message = "Categoryaccountnumber feild should not be Empty")
	private String accountnumber;
	@NotEmpty(message = "Categorycustomer_id feild should not be Empty")
	private String customer_id;
	@NotEmpty(message = "Categorybranch_id feild should not be Empty")
	private String branch_id;
	
	@NotNull(message = "CategoryOpening_balance feild should not be Empty")
	private int Opening_balance;
	
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}
	public int getOpening_balance() {
		return Opening_balance;
	}
	public void setOpening_balance(int opening_balance) {
		Opening_balance = opening_balance;
	}
	
	

	
}
