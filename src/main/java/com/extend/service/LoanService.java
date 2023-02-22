package com.extend.service;

import com.extend.bean.Finalresponse;
import com.extend.bean.Loan;

public interface LoanService {
	
	public Finalresponse insertLoan(Loan loan);
	public Finalresponse getAllLoan();
	public Finalresponse deleteLoan(int id);
	public Finalresponse updateLoan(Loan loan);
	

}

