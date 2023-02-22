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

import com.extend.bean.Account;
import com.extend.bean.Finalresponse;
import com.extend.controller.AccountController;
import com.extendservice.impl.AccountServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestAccountcontrollermockito {
	@InjectMocks
	AccountController accountController;
	@Mock
	private AccountServiceImpl accountService;
	@Test
	@DisplayName("insert the account object to database")
	public void AccountInsert() {
		Account account = new Account();
		account.setAccountnumber("123456");
		account.setCustomer_id("1");
		account.setBranch_id("1");
		account.setOpening_balance(1000);
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("One Record was Inserted");
		when(accountService.insertaccount(account)).thenReturn(expected);
		Finalresponse actual = accountController.insertAccount(account);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("update the account object to database")
	public void AccountUpdate() {
		Account account = new Account();
		account.setAccountnumber("123456");
		account.setCustomer_id("1");
		account.setBranch_id("1");
		account.setOpening_balance(2000);
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("One Record was Update");
		when(accountService.updateaccount(account)).thenReturn(expected);
		Finalresponse actual = accountController.updateAccount(account);
		assertThat(expected).isEqualTo(actual);
		
	}
	@Test
	@DisplayName("delete the account object to database")
	public void AccountDelete() {
		Account account = new Account();
		account.setAccountnumber("123456");
		account.setCustomer_id("1");
		account.setBranch_id("1");
		account.setOpening_balance(1000);
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("One Record was Delete");
		when(accountService.deleteAccount(1)).thenReturn(expected);
		Finalresponse actual = accountController.deleteAccount(1);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("getall the account object to database")
	public void AccountGet() {
		Account account = new Account();
		account.setAccountnumber("123456");
		account.setCustomer_id("1");
		account.setBranch_id("1");
		account.setOpening_balance(10000);
		
		Account account1 = new Account();
		account1.setAccountnumber("987654");
		account1.setCustomer_id("2");
		account1.setBranch_id("2");
		account1.setOpening_balance(20000);
		List<Account> list= new ArrayList<>();
		list.add(account);
		list.add(account1);
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was getall");
		when(accountService.getAllAccount()).thenReturn(expected);
		Finalresponse actual = accountController.getAccount();
		assertThat(expected).isEqualTo(actual);
	}
	}
	




