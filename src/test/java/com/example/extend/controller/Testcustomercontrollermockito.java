package com.example.extend.controller;

import static org.assertj.core.api.Assertions.assertThat; 
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.extend.bean.Customer;
import com.extend.bean.Finalresponse;
import com.extend.controller.CustomerController;
import com.extendservice.impl.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
public class Testcustomercontrollermockito {
	@InjectMocks
	CustomerController customerController;
	@Mock
	private CustomerServiceImpl customerService;

	@Test
	@DisplayName("insert the customer object to database")
	public void CustomerInsert() {
		Customer customer = new Customer();
		customer.setCustomer_id(71);
		customer.setFirstname("vasmi");
		customer.setLastname("R");
		customer.setCity("Hyd");
		customer.setMobileno("9703878583");
		customer.setDob(java.sql.Date.valueOf("1999-02-28"));
		customer.setUserName("vasmir");
		customer.setPassword("Vasmi@1");
		
		
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("One Record was Inserted");
		when(customerService.insertCustomer(customer)).thenReturn(expected);
		Finalresponse actual = customerController.saveCustomer(customer);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("update the customer object to database")
	public void CustomerUpdate() {
		Customer customer1 = new Customer();
		customer1.setCustomer_id(71);
		customer1.setFirstname("vasmi");
		customer1.setLastname("S");
		customer1.setCity("hyd");
		customer1.setMobileno("9703878583");
		customer1.setDob(java.sql.Date.valueOf("1999-02-28"));
		customer1.setUserName("Vasmis");
		customer1.setPassword("Vasmi@1");
		
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was Update");
		when(customerService.update(customer1)).thenReturn(expected);
		Finalresponse actual = customerController.updateCustomer(customer1);
		assertThat(expected).isEqualTo(actual);
		
	}
	@Test
	@DisplayName("delete the customer object to database")
	public void CustomerDelete() {
		Customer customer2 = new Customer();
		customer2.setCustomer_id(71);
		customer2.setFirstname("vasmi");
		customer2.setLastname("R");
		customer2.setCity("hyd");
		customer2.setMobileno("9703878583");
		customer2.setDob(java.sql.Date.valueOf("1999-02-28"));
		customer2.setUserName("Vasmir");
		customer2.setPassword("Vasmi@3");
		
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was delete");
		when(customerService.deleteRecordById(71)).thenReturn(expected);
		Finalresponse actual = customerController.deleteCustomer(71);
		assertThat(expected).isEqualTo(actual);
		
	}
	@Test
	@DisplayName("getall the customer object to database")
	public void Customer3() {
		Customer customer = new Customer();
		customer.setCustomer_id(71);
		customer.setFirstname("chandu");
		customer.setLastname("T");
		customer.setCity("vizag");
		customer.setMobileno("9182736543");
		customer.setDob(java.sql.Date.valueOf("1995-04-28"));
		customer.setUserName("Chandut");
		customer.setPassword("Chandu@1");
		
		Customer customer1 = new Customer();
		customer1.setCustomer_id(72);
		customer1.setFirstname("Ravi");
		customer1.setLastname("S");
		customer1.setCity("nandyal");
		customer1.setMobileno("9182287654");
		customer1.setDob(java.sql.Date.valueOf("1998-03-12"));
		customer1.setUserName("Ravis");
		customer1.setPassword("Ravi@1");
		
		List<Customer> list= new ArrayList<>();
		list.add(customer);
		list.add(customer1);
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was getall");
		when(customerService.getAllCustomer()).thenReturn(expected);
		Finalresponse actual = customerController.Gettingcustomer();
		assertThat(expected).isEqualTo(actual);
	
	
}
}

