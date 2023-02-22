package com.extend.bean;

import jakarta.validation.constraints.NotEmpty;

public class Branch {
	@NotEmpty(message = "Categorybranch_id feild should not be Empty")
	private String branch_id;
	@NotEmpty(message = "Categorybranch_name feild should not be Empty")
	private String  branch_name;
	@NotEmpty(message = "Categoryaccountnumber feild should not be Empty")
	private String branch_city;
	public String getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getBranch_city() {
		return branch_city;
	}
	public void setBranch_city(String branch_city) {
		this.branch_city = branch_city;
	}
	

}

