package com.extendservice.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.extend.bean.Customer;
import com.extend.bean.Finalresponse;
import com.extend.repository.CustomerRepository;
import com.extend.service.CustomerService;

@Service
public  class CustomerServiceImpl implements CustomerService {
	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Finalresponse insertCustomer(Customer customer) {
		customerRepository.insertCustomer(customer);
		logger.info("Inserting the Data into DB"+customer);
		Finalresponse finalResponse = new Finalresponse();
		 if (customer != null) {
             finalResponse.setStatus(true);
             finalResponse.setStatusCode("200");
             finalResponse.setMessage("One Record was Inserted");
          
         }else {
             finalResponse.setStatus(false);
             finalResponse.setStatusCode("200");
             finalResponse.setErrorMessages("One Record Was Not Recorded");

         }
		return finalResponse;
	}

	@Override
	public Finalresponse getAllCustomer() {
		List<Customer> customer = customerRepository.getAllCustomer();
		logger.info("GetAll the Data into DB");
		Finalresponse finalResponse =  new Finalresponse();
		if(customer != null) {
			finalResponse.setStatus(true);
			finalResponse.setStatusCode("200");
			finalResponse.setMessage("one Record was GetAll");
            finalResponse.data = customer;

			return finalResponse;
		}else {
			finalResponse.setStatus(false);
			finalResponse.setStatusCode("200");
			finalResponse.setErrorMessages("one Record was Not Recorded");
			return finalResponse;
			}
		}
 	

	@Override
	public Finalresponse deleteRecordById(int id) {
		customerRepository.deleteRecordById(id);
		logger.info("Delete the Data into DB");
		Finalresponse finalResponse = new Finalresponse();
		  if (id > 0) {
              finalResponse.setStatus(true);
              finalResponse.setStatusCode("200");
              finalResponse.setMessage("one Record was Delete");
              return finalResponse;
          } else { 
              finalResponse.setStatus(false);
              finalResponse.setStatusCode("200");
              finalResponse.setMessage("one Record was Not Recorded");
              finalResponse.setErrorMessages("check RoleId Once");
              return finalResponse;
          }
  }
	@Override
	public Finalresponse update(Customer customer) {
		customerRepository.update(customer);
		logger.info("Update the Data into DB ");
		Finalresponse finalresponse = new Finalresponse();
		 if (customer != null) {
             finalresponse.setStatus(true);
             finalresponse.setStatusCode("200");
             finalresponse.setMessage(" one Record was Updated");
             return finalresponse;
         } else { 
             finalresponse.setStatus(false);
             finalresponse.setStatusCode("200");
             finalresponse.setMessage("One Record was Not Inserted");
             finalresponse.setErrorMessages("Check All fields");
             return finalresponse;
         }
	}
}

	


	
