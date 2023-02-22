package com.extend.service;

import com.extend.bean.Account;
import com.extend.bean.Finalresponse;

public interface AccountService {
	public Finalresponse insertaccount(Account account);
	public Finalresponse getAllAccount();
	public Finalresponse deleteAccount(int id);
	public Finalresponse updateaccount(Account account);
	
}
