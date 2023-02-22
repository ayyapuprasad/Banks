package com.example.extend.repository.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.extend.bean.Customer;
import com.extendrepository.impl.CustomerRepositoryImpl;


@ExtendWith(MockitoExtension.class)
public class Testcustromerrepositorymockito {
	
	@Mock
	private CustomerRepositoryImpl customerRepository;
	
	@Test
	@DisplayName("insert into the customerrepository")
	public void CustomerInsert() {
		Customer customer = new Customer();
		customer.setCustomer_id(80);
		customer.setFirstname("surendra");
		customer.setLastname("a");
		customer.setCity("bangalore");
		customer.setMobileno("9182209872");
		customer.setDob(java.sql.Date.valueOf("1994-02-28"));
		customer.setUserName("surendraa");
		customer.setPassword("Surendra@1");
		when(customerRepository.insertCustomer(any(Customer.class))).thenReturn(customer);
		Customer actual = customerRepository.insertCustomer(customer);
		assertThat(customer).isEqualTo(actual);
	}
	@Test
	@DisplayName("update into the customerrepository")
	public void CustomerUpdate() {
		Customer customer1 = new Customer();
		customer1.setCustomer_id(80);
		customer1.setFirstname("nagendra");
		customer1.setLastname("a");
		customer1.setCity("badvel");
		customer1.setMobileno("9182220122");
		customer1.setDob(java.sql.Date.valueOf("1993-08-25"));
		customer1.setUserName("Nagendraa");
		customer1.setPassword("Nagendra@1");
		when(customerRepository.update(any(Customer.class))).thenReturn(customer1);
		Customer actual = customerRepository.update(customer1);
		assertThat(customer1).isEqualTo(actual);
	}
	@Test
	@DisplayName("delete into the customerrepository")
	public void CustomerDelete() {
		Customer customer2 = new Customer();
		customer2.setCustomer_id(80);
		customer2.setFirstname("surendra");
		customer2.setLastname("a");
		customer2.setCity("bangalore");
		customer2.setMobileno("9182209872");
		customer2.setDob(java.sql.Date.valueOf("1994-02-28"));
		customer2.setUserName("Surendras");
		customer2.setPassword("Surendra@2");
		when(customerRepository.deleteRecordById(80)).thenReturn(customer2);
		Customer actual = customerRepository.deleteRecordById(80);
		assertThat(customer2).isEqualTo(actual);
	}
	@Test
	@DisplayName("getall the customer object to database")
	public void Customer3() {
		Customer customer = new Customer();
		customer.setCustomer_id(81);
		customer.setFirstname("chandu");
		customer.setLastname("T");
		customer.setCity("vizag");
		customer.setMobileno("9182736543");
		customer.setDob(java.sql.Date.valueOf("1995-04-28"));
		customer.setUserName("Chandut");
		customer.setPassword("Chandu@7");
		
		Customer customer1 = new Customer();
		customer1.setCustomer_id(82);
		customer1.setFirstname("Ravi");
		customer1.setLastname("S");
		customer1.setCity("nandyal");
		customer1.setMobileno("9182287654");
		customer1.setDob(java.sql.Date.valueOf("1998-03-12"));
		customer1.setUserName("Ravi");
		customer1.setPassword("Ravi@1");
		
		List<Customer> list= new ArrayList<>();
		list.add(customer);
		list.add(customer1);
		when(customerRepository.getAllCustomer()).thenReturn(list);
		List<Customer> actual = customerRepository.getAllCustomer();
		assertThat(list).isEqualTo(actual);
	}
}

