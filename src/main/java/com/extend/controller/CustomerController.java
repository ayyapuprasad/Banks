package com.extend.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.extend.bean.Customer;
import com.extend.bean.Finalresponse;
import com.extend.service.CustomerService;

import jakarta.validation.Valid;

@RestController
public class CustomerController {
	@Autowired
	public CustomerService CustomerService;

	@GetMapping("/getcustomerdetails")
	public Finalresponse Gettingcustomer() {
		return CustomerService.getAllCustomer();
	}
	@PutMapping("/updatecustomer")
	public Finalresponse updateCustomer(@RequestBody @Valid Customer customer){
		return CustomerService.update(customer);
	}
	@PostMapping("/savecustomer")
	public Finalresponse saveCustomer(@RequestBody @Valid Customer customer){
		return CustomerService.insertCustomer(customer);
	}
	@DeleteMapping("/deletecustomer/{id}")
	public Finalresponse deleteCustomer(@PathVariable int id) {
		return CustomerService.deleteRecordById(id);
	}
}





