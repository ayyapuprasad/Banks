package com.extend.repository;

import java.util.List;

import com.extend.bean.Customer;

public interface CustomerRepository {
	
	public List<Customer> getAllCustomer();
    
    public Customer insertCustomer(Customer customer);
    
    public Customer update( Customer customer);
    
    public Customer deleteRecordById(int customer_id);
	}





