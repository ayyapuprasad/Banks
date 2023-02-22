package com.extendrepository.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.extend.bean.Customer;
import com.extend.repository.CustomerRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
	@Autowired
	private EntityManager entityManager;
	@Transactional
	@Override
	public List<Customer> getAllCustomer() {
      Query query =entityManager.createNativeQuery("select* from Customer");
      List<Customer> customer=query.getResultList();
      return customer;
	}

	
	@Override
	@Transactional
	public Customer insertCustomer(Customer customer) {
		Query query =entityManager.createNativeQuery("insert into customer values(?,?,?,?,?,?,?,?)");
		query.setParameter(1, customer.getCustomer_id());
		query.setParameter(2, customer.getFirstname());
		query.setParameter(3, customer.getLastname());
		query.setParameter(4, customer.getCity());
		query.setParameter(5, customer.getMobileno());
		query.setParameter(6, customer.getDob());
		query.setParameter(7, customer.getUserName());
		query.setParameter(8, customer.getPassword());
		  query.executeUpdate();
	     return customer;
	    }

	@Override
	@Transactional
	public Customer deleteRecordById(int customer_id) {
		Customer customer = new Customer();
		Query query = entityManager.createNativeQuery("delete from customer where customer_Id=?");
		query.setParameter(1,customer_id);
		int Rec = query.executeUpdate();
        return customer;
	}
 
	@Override
	@Transactional
	public Customer update(Customer customer) {
		Query query = entityManager.createNativeQuery("update customer set firstname=?,lastname=?,city=?,mobileno=?,dob=?,userName=?,password=? where customer_id=?");
        query.setParameter(1, customer.getFirstname());
		query.setParameter(2, customer.getLastname());
		query.setParameter(3, customer.getCity());
		query.setParameter(4, customer.getMobileno());
		query.setParameter(5, customer.getDob());
		query.setParameter(6, customer.getCustomer_id());
		query.setParameter(7,customer.getUserName());
		query.setParameter(8, customer.getPassword());
		 int Rec = query.executeUpdate();
	        if (Rec > 0) {
	    }
			return customer;
	}
}
			

		



	        

