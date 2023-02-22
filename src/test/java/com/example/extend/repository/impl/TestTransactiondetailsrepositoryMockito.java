package com.example.extend.repository.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.extend.bean.Transactiondetails;
import com.extendrepository.impl.TransactionRepositoryImpl;


@ExtendWith(MockitoExtension.class)
public class TestTransactiondetailsrepositoryMockito {
	@Mock
	private TransactionRepositoryImpl transactionRepository;
	@Test
	@DisplayName("insert  into the transactionrepository")
	public void TransactiondetailsInsert() {
		Transactiondetails transactiondetails = new Transactiondetails();
		transactiondetails.setTransactionnumber("100");
		transactiondetails.setAccountnumber("817995");
		transactiondetails.setTransaction_amount(2000);
		transactiondetails.setDot(java.sql.Date.valueOf("2021-02-23"));
		transactiondetails.setCustomer_id("3");
		when(transactionRepository.insertTransactiondetails(transactiondetails)).thenReturn(transactiondetails);
		Transactiondetails actual = transactionRepository.insertTransactiondetails(transactiondetails);
		assertThat(transactiondetails).isEqualTo(actual);	
	}
	@Test
	@DisplayName("update into the transactionrepository")
	public void TransactiondetailsUpdate() {
		Transactiondetails transactiondetails = new Transactiondetails();
		transactiondetails.setTransactionnumber("101");
		transactiondetails.setAccountnumber("918221");
		transactiondetails.setTransaction_amount(3000);
		transactiondetails.setDot(java.sql.Date.valueOf("2021-09-28"));
		transactiondetails.setCustomer_id("4");
		when(transactionRepository.update(transactiondetails)).thenReturn(transactiondetails);
		Transactiondetails actual = transactionRepository.update(transactiondetails);
		assertThat(transactiondetails).isEqualTo(actual);
	}
	@Test
	@DisplayName("delete into the transactionrepository")
	public void Transactiondelete () {
		Transactiondetails transactiondetails = new Transactiondetails();
		transactiondetails.setTransactionnumber("100");
		transactiondetails.setAccountnumber("817995");
		transactiondetails.setTransaction_amount(2000);
		transactiondetails.setDot(java.sql.Date.valueOf("2021-02-23"));
		transactiondetails.setCustomer_id("3");
		when(transactionRepository.deleteRecordById()).thenReturn(transactiondetails);
		Transactiondetails actual = transactionRepository.deleteRecordById();
		assertThat(transactiondetails).isEqualTo(actual);
	}
	@Test
	@DisplayName("get all into the transactionrepository")
	public void TransactionGetAll() {
		Transactiondetails transactiondetails = new Transactiondetails();
		transactiondetails.setTransactionnumber("102");
		transactiondetails.setAccountnumber("908765");
		transactiondetails.setTransaction_amount(50000);
		transactiondetails.setDot(java.sql.Date.valueOf("1999-06-23"));
		transactiondetails.setCustomer_id("5");
		 
		Transactiondetails  transactiondetails1 =new Transactiondetails();
		transactiondetails1.setTransactionnumber("103");
		transactiondetails1.setAccountnumber("876542");
		transactiondetails1.setTransaction_amount(6000);
		transactiondetails1.setDot(java.sql.Date.valueOf("1998-02-25"));
		transactiondetails1.setCustomer_id("6");
		List<Transactiondetails> list= new ArrayList<>();
		list.add(transactiondetails);
		list.add(transactiondetails1);
		when(transactionRepository.getAllTransactiondetails()).thenReturn(list);
		List<Transactiondetails> actual =  transactionRepository.getAllTransactiondetails();
		assertThat(list).isEqualTo(actual);
	}
}
