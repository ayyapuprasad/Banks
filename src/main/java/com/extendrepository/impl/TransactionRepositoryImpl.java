package com.extendrepository.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.extend.bean.Transactiondetails;
import com.extend.repository.TransactionRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {
	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public Transactiondetails update(Transactiondetails transactiondetails) {
		Query query = entityManager.createNativeQuery(
				"update Transactiondetails set accountnumber=?,dot=?,transaction_amount=?,customer_id=? where transactionnumber=?");
		query.setParameter(1, transactiondetails.getAccountnumber());
		query.setParameter(2, transactiondetails.getDot());
		query.setParameter(3, transactiondetails.getTransaction_amount());
		query.setParameter(4, transactiondetails.getCustomer_id());
		
		query.setParameter(5, transactiondetails.getTransactionnumber());

		int Rec = query.executeUpdate();
		if (Rec > 0) {
		}
		return transactiondetails;
	}

	@Override
	@Transactional
	public Transactiondetails deleteRecordById() {
		Transactiondetails transactiondetails = new Transactiondetails();
		Query query = entityManager.createNativeQuery("delete from Transactiondetails where transactionnumber = ?");
		query.setParameter(1, transactiondetails);
		return transactiondetails;
	}

	@Override
//	@Transactional
	public List<Transactiondetails> getAllTransactiondetails() {
		Query query = entityManager.createNativeQuery("select * from Transactiondetails");
		List<Transactiondetails> transactiondetails = query.getResultList();
		return transactiondetails;
	}

	@Transactional
	@Override
	public Transactiondetails insertTransactiondetails(Transactiondetails transactiondetails) {

		Query query = entityManager.createNativeQuery("insert into Transactiondetails values(?,?,?,?,?)");
		query.setParameter(1, transactiondetails.getTransactionnumber());
		query.setParameter(2, transactiondetails.getAccountnumber());
		query.setParameter(3, transactiondetails.getDot());
		query.setParameter(4, transactiondetails.getTransaction_amount());
		query.setParameter(5, transactiondetails.getCustomer_id());
		int Rec = query.executeUpdate();
		return transactiondetails;
	}
}

