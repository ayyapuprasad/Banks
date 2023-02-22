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

import com.extend.bean.Finalresponse;
import com.extend.bean.Transactiondetails;
import com.extend.controller.TransactionController;
import com.extendservice.impl.TransactionServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestTransactiondetailscontrollerMockito {
	@InjectMocks
	TransactionController transactionController;
	@Mock
	private TransactionServiceImpl transactionservice;
	
	@Test
	@DisplayName("insert  the transactiondetails object to database")
	public void TransactiondetailsInsert () {
		Transactiondetails transactiondetails = new Transactiondetails();
		transactiondetails.setTransactionnumber("88");
		transactiondetails.setAccountnumber("852469");
		transactiondetails.setDot(java.sql.Date.valueOf("2022-02-12"));
		transactiondetails.setTransaction_amount(1);
		transactiondetails.setCustomer_id("1");
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("One Record was Inserted");
		when(transactionservice.insertTransactiondetails(transactiondetails)).thenReturn(expected);
		Finalresponse actual = transactionController.saveTransactiondetails(transactiondetails);
		assertThat(expected).isEqualTo(actual);	
	}
	@Test
	@DisplayName("update the transactiondetails object to database")
	public void TransactiondetailsUpdate() {
		Transactiondetails transactiondetails = new  Transactiondetails();
		transactiondetails.setTransactionnumber("88");
		transactiondetails.setAccountnumber("705432");
		transactiondetails.setTransaction_amount(10);
		transactiondetails.setDot(java.sql.Date.valueOf("2021-03-29"));
		transactiondetails.setCustomer_id("1");
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was Update");
		when(transactionservice.updateTransactiondetails(transactiondetails)).thenReturn(expected);
		Finalresponse actual = transactionController.updateTransactiondetails(transactiondetails);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("delete the transactiondetails object to database")
	public void TransactiondetailsDelete() {
		Transactiondetails transactiondetails = new Transactiondetails();
		transactiondetails.setTransactionnumber("88");
		transactiondetails.setAccountnumber("852469");
		transactiondetails.setTransaction_amount(1);
		transactiondetails.setDot(java.sql.Date.valueOf("2022-02-12"));
		transactiondetails.setCustomer_id("1");
		Finalresponse expected = new Finalresponse(); 
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was Delete ");
		when(transactionservice.deleteTransactiondetails(1)).thenReturn(expected);
		Finalresponse actual = transactionController.deleteTransactiondetails(1);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("getall the transactiondetails object to database")
	public void TransactiondetailsGetAll() {
		Transactiondetails transactiondetails = new Transactiondetails();
		transactiondetails.setTransactionnumber("2");
		transactiondetails.setAccountnumber("970387");
		transactiondetails.setTransaction_amount(200);
		transactiondetails.setDot(java.sql.Date.valueOf("2021-09-01"));
		transactiondetails.setCustomer_id("2");
		
		Transactiondetails transactiondetails2 = new Transactiondetails(); 
		transactiondetails2.setTransactionnumber("3");
		transactiondetails2.setAccountnumber("970474");
		transactiondetails2.setTransaction_amount(300);
		transactiondetails2.setDot(java.sql.Date.valueOf("2021-03-28"));
		transactiondetails2.setCustomer_id("3");
		
		List<Transactiondetails> list = new ArrayList<>();
		list.add(transactiondetails);
		list.add(transactiondetails2);
		Finalresponse expected = new Finalresponse ();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was getall");
		when(transactionController.getalltransactiondetails()).thenReturn(expected);
		Finalresponse actual = transactionController.getalltransactiondetails();
		assertThat(expected).isEqualTo(actual);
		
}
}
