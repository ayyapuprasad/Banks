package com.example.extend.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.extend.bean.Account;
import com.extend.bean.Finalresponse;
import com.extendservice.impl.AccountServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestAccountServicemockito {
	//@InjectMocks
	@Mock
	 private AccountServiceImpl accountService;
	//private AccountRepository accountRepository;
	@Test
	@DisplayName("insert into the object in database")
	public void AccountInsert() {
		Account account = new Account();
		account.setAccountnumber("123456");
		account.setCustomer_id("1");
		account.setBranch_id("1");
		account.setOpening_balance(50000);
		
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("One Record was Inserted");
		when(accountService.insertaccount(account)).thenReturn(expected);
		Finalresponse actual = accountService.insertaccount(account);
		assertThat(expected).isEqualTo(actual);
}
	@Test
	@DisplayName("update into the object in database")
	public void AccountUpdate() {
		Account account = new  Account();
		account.setAccountnumber("789123");
		account.setCustomer_id("1");
		account.setBranch_id("1");
		account.setOpening_balance(20000);
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setErrorMessages("one Record was Update");
		when(accountService.updateaccount(account)).thenReturn(expected);
		Finalresponse actual = accountService.updateaccount(account);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("delete into the object in database")
	public void AccountDelete() {
		Account account = new Account();
		account.setAccountnumber("123456");
		account.setCustomer_id("1");
		account.setBranch_id("1");
		account.setOpening_balance(50000);
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was Delete");
		when(accountService.deleteAccount(1)).thenReturn(expected);
		Finalresponse actual = accountService.deleteAccount(1);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("getall into the object in database")
	public void AccountGet() {
		Account account = new Account();
		account.setAccountnumber("970398");
		account.setCustomer_id("5");
		account.setBranch_id("5");
		account.setOpening_balance(60000);
		
		Account account1 = new Account();
		account1.setAccountnumber("918221");
		account1.setCustomer_id("6");
		account1.setBranch_id("6");
		account1.setOpening_balance(70000);
		
		List<Account> list= new ArrayList<>();
		list.add(account);
		list.add(account1);
		Finalresponse expected = new  Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was GetAll");
        
		when(accountService.getAllAccount()).thenReturn(expected);
		Finalresponse actual = accountService.getAllAccount();
		assertThat(expected).isEqualTo(actual);
	}
}




