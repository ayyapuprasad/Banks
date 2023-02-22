package com.extend.service;


import com.extend.bean.Finalresponse;
import com.extend.bean.Transactiondetails;


public interface TransactionService {
	public Finalresponse insertTransactiondetails(Transactiondetails transactiondetails);
	public Finalresponse getAllTransactiondetails();
	public Finalresponse deleteTransactiondetails(int id);
	public Finalresponse updateTransactiondetails(Transactiondetails transactiondetails);

}


