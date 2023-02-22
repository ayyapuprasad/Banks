package com.extendrepository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.extend.bean.Account;
import com.extend.repository.AccountRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
	@Autowired
	private EntityManager  entityManager;

	@Override
//	@Transactional
	public List<Account> getAllAccount() {
		Query query = entityManager.createNativeQuery("select * from Account");
		List<Account> account = query.getResultList();
		return account;
	}

	@Override
	@Transactional
	public Account insertAccount(Account account) {
		Query query = entityManager.createNativeQuery("insert  into Account values(?,?,?,?)");
		query.setParameter(1, account.getAccountnumber());
		query.setParameter(2, account.getCustomer_id());
		query.setParameter(3,account.getBranch_id());
		query.setParameter(4, account.getOpening_balance());
		int Rec = query.executeUpdate();
		return account;
	}

	@Override
	@Transactional
	public Account update(Account account) {
		Query query = entityManager.createNativeQuery("update Account set customer_id=?,branch_id=?,operning_balance=? where accountnumber = ?");
		query.setParameter(1, account.getCustomer_id());
		query.setParameter(2, account.getCustomer_id());
		query.setParameter(3, account.getBranch_id());		
		query.setParameter(4, account.getAccountnumber());
		int Rec = query.executeUpdate();
		if(Rec>0) {

		}
		return account;

	}

	@Override
	@Transactional
	public Account deleteRecordById() {
		Account account = new Account();
		Query query = entityManager.createNativeQuery("delete from Account where account = ?");
		query.setParameter(1, account);
		return account;
	}
	

	
}
