package com.example.extend.service.impl;

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
import com.extend.repository.CustomerRepository;
import com.extendservice.impl.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestCustomerServiceMockito {
	//@InjectMocks
	@Mock
private	CustomerServiceImpl customerService;
	//private CustomerRepository customerRepository;
	@Test
	@DisplayName("insert the customer object to database")
	public void CustomerInsert() {
		Customer customer = new Customer();
		customer.setCustomer_id(30);
		customer.setFirstname("kiran");
		customer.setLastname("T");
		customer.setCity("guntur");
		customer.setMobileno("9182233444");
		customer.setDob(java.sql.Date.valueOf("1997-12-08"));
		customer.setUserName("Kirant");
		customer.setPassword("kiran@1");
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
        expected.setStatusCode("200");
        expected.setMessage("One Record was Inserted");
		when(customerService.insertCustomer(customer)).thenReturn(expected);
		Finalresponse actual = customerService.insertCustomer(customer);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("update the customer object to database")
	public void CustomerUpdate() {
		Customer customer = new Customer();
		customer.setCustomer_id(30);
		customer.setFirstname("sandeep");
		customer.setLastname("R");
		customer.setCity("pune");
		customer.setMobileno("9185472316");
		customer.setDob(java.sql.Date.valueOf("1999-07-27"));
		customer.setUserName("Sandeepr");
		customer.setPassword("Sandeep@1");
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was Update");
		when(customerService.update(customer)).thenReturn(expected);
		Finalresponse actual = customerService.update(customer);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("delete the customer object to database")
	public void CustomerDelete() {
		Customer customer = new Customer();
		customer.setCustomer_id(30);
		customer.setFirstname("kiran");
		customer.setLastname("T");
		customer.setCity("guntur");
		customer.setMobileno("9182233444");
		customer.setDob(java.sql.Date.valueOf("1997-12-08"));
		customer.setUserName("Kirant");
		customer.setPassword("Kiran@1");
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was Delete");
		when(customerService.deleteRecordById(30)).thenReturn(expected);
	    Finalresponse actual = customerService.deleteRecordById(30);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("getall the customer object to database")
	public void CustomerGetAll() {
	Customer customer1 = new Customer();
	customer1.setCustomer_id(31);
	customer1.setFirstname("Keshav");
	customer1.setLastname("kumar");
	customer1.setCity("kurnool");
	customer1.setMobileno("8179950207");
	customer1.setDob(java.sql.Date.valueOf("1998-02-22"));
	customer1.setUserName("Keshavkumar");
	customer1.setPassword("Keshav@1");
	
	Customer customer2 = new Customer();
	customer2.setCustomer_id(32);
	customer2.setFirstname("kushal");
	customer2.setLastname("r");
	customer2.setCity("kadapa");
	customer2.setMobileno("9182246278");
	customer2.setDob(java.sql.Date.valueOf("1998-03-12"));
	customer2.setUserName("Kushalr");
	customer2.setPassword("Kushal@1");
	
	List<Customer> list= new ArrayList<>();
	list.add(customer1);
	list.add(customer2);
	Finalresponse expected = new Finalresponse();
	expected.setStatus(true);
	expected.setStatusCode("200");
	expected.setMessage("one Record was Getall");
	when(customerService.getAllCustomer()).thenReturn(expected);
	Finalresponse actual = customerService.getAllCustomer(); 
	assertThat(expected).isEqualTo(actual);
}
}


