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

import com.extend.bean.Finalresponse;
import com.extend.bean.Transactiondetails;
import com.extend.repository.TransactionRepository;
import com.extendservice.impl.TransactionServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestTransactiondetailsServiceMockito {
	//@InjectMocks
	@Mock
private TransactionServiceImpl transactionService;

	//private TransactionRepository transactionRepository;
	@Test
	@DisplayName("insert the transaction object  to database")
	public void TransactiondetailsInsert() {
		Transactiondetails transactiondetails = new Transactiondetails();
		transactiondetails.setTransactionnumber("1");
		transactiondetails.setAccountnumber("123456");
		transactiondetails.setTransaction_amount(10);
		transactiondetails.setDot(java.sql.Date.valueOf("1999-09-01"));
		transactiondetails.setCustomer_id("1");
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was Inserted");
		when(transactionService.insertTransactiondetails(transactiondetails)).thenReturn(expected);
		Finalresponse actual = transactionService.insertTransactiondetails(transactiondetails);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("update the transaction object to database")
	public void TransactiondetailsUpdate() {
		Transactiondetails transactiondetails = new Transactiondetails();
		transactiondetails.setTransactionnumber("2");
		transactiondetails.setAccountnumber("439812");
		transactiondetails.setTransaction_amount(100);
		transactiondetails.setDot(java.sql.Date.valueOf("1998-08-12"));
		transactiondetails.setCustomer_id("1");
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was Update");
		when(transactionService.updateTransactiondetails(transactiondetails)).thenReturn(expected);
		Finalresponse actual = transactionService.updateTransactiondetails(transactiondetails);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("delete the transaction object to database")
	public void TransactiondetailsDelete() {
		Transactiondetails transactiondetails= new Transactiondetails();
		transactiondetails.setTransactionnumber("1");
		transactiondetails.setAccountnumber("123456");
		transactiondetails.setTransaction_amount(10);
		transactiondetails.setDot(java.sql.Date.valueOf("1999-09-01"));
		transactiondetails.setCustomer_id("1");
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was Delete");
		when(transactionService.deleteTransactiondetails(1)).thenReturn(expected);
		Finalresponse actual = transactionService.deleteTransactiondetails(1);
		assertThat(expected).isEqualTo(actual);
		
	}
	@Test
	@DisplayName("getall the transaction object to database")
	public void TransactiondetailsGetAll() {
		Transactiondetails transactiondetails = new Transactiondetails();
		transactiondetails.setTransactionnumber("3");
		transactiondetails.setAccountnumber("987654");
		transactiondetails.setTransaction_amount(30);
		transactiondetails.setDot(java.sql.Date.valueOf("2022-01-28"));
		transactiondetails.setCustomer_id("4");
		
		Transactiondetails transactiondetails1 = new Transactiondetails();
		transactiondetails1.setTransactionnumber("4");
		transactiondetails1.setAccountnumber("784512");
		transactiondetails1.setTransaction_amount(40);
		transactiondetails1.setDot(java.sql.Date.valueOf("2021-02-22"));
		transactiondetails1.setCustomer_id("2");
		List<Transactiondetails> list= new ArrayList<>();
		list.add(transactiondetails);
		list.add(transactiondetails1);
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was getAll");
		when(transactionService.getAllTransactiondetails()).thenReturn(expected);
		Finalresponse actual = transactionService.getAllTransactiondetails();
		assertThat(expected).isEqualTo(actual);
	}
}



