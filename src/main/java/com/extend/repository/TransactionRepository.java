
	package com.extend.repository;

	import java.util.List;

import com.extend.bean.Transactiondetails;

	public interface TransactionRepository {
		public List<Transactiondetails> getAllTransactiondetails();
	    
	    public Transactiondetails insertTransactiondetails(Transactiondetails transactiondetails);
	    
	    public Transactiondetails update( Transactiondetails transactiondetails);
	    
	    public Transactiondetails deleteRecordById();

	}

	