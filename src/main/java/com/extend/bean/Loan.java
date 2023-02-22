package com.extend.bean;

import jakarta.validation.constraints.NotEmpty;

public class Loan {
	@NotEmpty(message = "Categorycustomer_id feild should not be Empty")
	private String customer_id;
	@NotEmpty(message = "Categorybranch_id feild should not be Empty")
	private String branch_id;
	private int loan_amount;
	private int loan_id;
	public int getLoan_id() {
		return loan_id;
	}
	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
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
	public int getLoan_amount() {
		return loan_amount;
	}
	public void setLoan_amount(int loan_amount) {
		this.loan_amount = loan_amount;
	}

}
