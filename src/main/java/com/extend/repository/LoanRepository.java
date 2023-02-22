package com.extend.repository;

import java.util.List;

import com.extend.bean.Loan;

public interface LoanRepository {
public List<Loan> getAllLoan();
    
    public Loan insertLoan(Loan loan);
    
    public Loan update(Loan loan);
    
    public Loan deleteRecordById();

}
