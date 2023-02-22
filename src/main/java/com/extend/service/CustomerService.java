package com.extend.service;

import com.extend.bean.Customer;
import com.extend.bean.Finalresponse;


public interface  CustomerService {
	public Finalresponse insertCustomer(Customer customer);
    public Finalresponse getAllCustomer() ;
    public Finalresponse deleteRecordById(int id);
    public Finalresponse update(Customer customer);
	}


