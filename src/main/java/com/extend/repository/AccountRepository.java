package com.extend.repository;

import java.util.List;

import com.extend.bean.Account;


public interface AccountRepository {
	public List<Account> getAllAccount();
    
    public Account insertAccount(Account account);
    
    public Account update(Account account);
    
    public Account deleteRecordById();

}


