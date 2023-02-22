package com.extendservice.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.extend.bean.Account;
import com.extend.bean.Finalresponse;
import com.extend.repository.AccountRepository;
import com.extend.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	private static final Logger logger =LoggerFactory.getLogger(AccountServiceImpl.class);
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Finalresponse insertaccount(Account account) {
		accountRepository.insertAccount(account);
		logger.info("inserting  the Data into DB");
		Finalresponse finalresponse = new Finalresponse();
		 if (account != null) {
			 finalresponse.setStatus(true);
             finalresponse.setStatusCode("200");
             finalresponse.setMessage("One Record was Inserted");
             return finalresponse;
         }else {
             finalresponse.setStatus(false);
             finalresponse.setStatusCode("200");
             finalresponse.setErrorMessages("One Record Was Not Recorded");
             return finalresponse;
         }
	}

	@Override
	public Finalresponse getAllAccount() {
		List<Account> account = accountRepository.getAllAccount();
		logger.info("getall the Data into DB");
		Finalresponse finalresponse = new Finalresponse();
		if(account != null) {
			finalresponse.setStatus(true);
			finalresponse.setStatusCode("200");
			finalresponse.setMessage("one Record was GetAll");
			return finalresponse;
		}else {
			finalresponse.setStatus(false);
			finalresponse.setStatusCode("200");
			finalresponse.setErrorMessages("one Record was Not Recorded");
			return finalresponse;
			}
	}

	@Override
	public Finalresponse deleteAccount(int id) {
		accountRepository.deleteRecordById();
		logger.info("delete the Data into DB");
		Finalresponse finalresponse = new Finalresponse();
		if (id > 0) {
			finalresponse.setStatus(true);
			finalresponse.setStatusCode("200");
			finalresponse.setMessage("Record was deleted");
            return finalresponse;
        } else { 
        	finalresponse.setStatus(false);
        	finalresponse.setStatusCode("200");
        	finalresponse.setMessage("Record was not deleted");
        	finalresponse.setErrorMessages("check RoleId Once");
            return finalresponse;
        }
	}

	@Override
	public Finalresponse updateaccount(Account account) {
		logger.info("update the Data into DB");
		Finalresponse finalresponse = new Finalresponse();
		if ( account != null) {
            finalresponse.setStatus(true);
            finalresponse.setStatusCode("200");
            finalresponse.setMessage("Record was update");
            return finalresponse;
        } else { 
            finalresponse.setStatus(false);
            finalresponse.setStatusCode("200");
            finalresponse.setMessage("One Record was Not update"); 
            finalresponse.setErrorMessages("Check All fields");
            return finalresponse;
        }
	}
}
	


	