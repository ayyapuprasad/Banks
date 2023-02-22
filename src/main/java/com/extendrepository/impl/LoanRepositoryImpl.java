package com.extendrepository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.extend.bean.Loan;
import com.extend.repository.LoanRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class LoanRepositoryImpl implements LoanRepository {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Loan> getAllLoan() {
		Query query = entityManager.createNativeQuery("select*from loan");
		List<Loan> loan = query.getResultList();
		return loan;
	}

	@Override
	@Transactional
	public Loan insertLoan(Loan loan) {
		Query query = entityManager.createNativeQuery("insert into loan values(?,?,?,?)");
		query.setParameter(4,loan.getCustomer_id());
		query.setParameter(1, loan.getBranch_id());
		query.setParameter(2, loan.getLoan_amount());
		query.setParameter(3, loan.getLoan_id());
		int Rec = query.executeUpdate();
		return loan;
	}
	@Override
	@Transactional
	public Loan deleteRecordById() {
		Loan  loan = new Loan();
		Query query = entityManager.createNativeQuery("delete from loan where loan_amount=?");
		query.setParameter(1, loan);
		return loan;
	}

	@Override
	@Transactional
	public Loan update(Loan loan) {
		Query query = entityManager.createNativeQuery("update loan set branch_id=?,loan_amount=?,customer_id=? where loan_id=?");
		query.setParameter(1,loan.getBranch_id());
		query.setParameter(2,loan.getLoan_amount());
		query.setParameter(3,loan.getCustomer_id());
		query.setParameter(4, loan.getLoan_id());
		int Rec = query.executeUpdate();
		if(Rec>0) {
			
		}
		return loan;
	}

}


