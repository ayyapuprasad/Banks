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

import com.extend.bean.Account;
import com.extendrepository.impl.AccountRepositoryImpl;

@ExtendWith(MockitoExtension.class)
public class TestAccountrepositorymockito {
	@Mock
	private AccountRepositoryImpl accountRepository;
	
	@Test
	@DisplayName("insert into the accountrepository")
	public void AccountInsert() {
		Account account = new Account();
		account.setAccountnumber("123456");
		account.setCustomer_id("1");
		account.setBranch_id("1");
		account.setOpening_balance(20000);
		when(accountRepository.insertAccount(any(Account.class))).thenReturn(account);
		Account actual = accountRepository.insertAccount(account);
		assertThat(account).isEqualTo(actual);
		
	}
	@Test
	@DisplayName("update into the accountrepository")
	public void AccountUpdate() {
		Account account = new Account();
		account.setAccountnumber("789123");
		account.setCustomer_id("1");
		account.setBranch_id("1");
		account.setOpening_balance(30000);
		when(accountRepository.update(any(Account.class))).thenReturn(account);
		Account actual = accountRepository.update(account);
		assertThat(account).isEqualTo(actual);
		
	}
	@Test
	@DisplayName("delete into the accountrepository")
	public void AccountDelete() {
		Account account = new Account();
		account.setAccountnumber("123456");
		account.setCustomer_id("1");
		account.setBranch_id("1");
		account.setOpening_balance(20000);
		when(accountRepository.deleteRecordById()).thenReturn(account);
		Account actual = accountRepository.deleteRecordById();
		assertThat(account).isEqualTo(actual);
	}
	@Test
	@DisplayName("getall into the accountrepository")
	public void AccountGetall() {
		Account account = new Account();
		account.setAccountnumber("123456");
		account.setCustomer_id("1");
		account.setBranch_id("1");
		account.setOpening_balance(20000);
		
		Account account1 = new Account();
		account1.setAccountnumber("324516");
		account1.setCustomer_id("3");
		account1.setBranch_id("3");
		account1.setOpening_balance(40000);
		List<Account> list= new ArrayList<>();
		list.add(account);
		list.add(account1);
		when(accountRepository.getAllAccount()).thenReturn(list);
		List<Account> actual = accountRepository.getAllAccount();
		assertThat(list).isEqualTo(actual);
	}
	}



