package com.extendservice.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.extend.bean.Finalresponse;
import com.extend.bean.Loan;
import com.extend.repository.LoanRepository;
import com.extend.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {
	private static final Logger logger=LoggerFactory.getLogger(LoanServiceImpl.class);
	@Autowired
	private LoanRepository loanRepository;
	@Override
	public Finalresponse insertLoan(Loan loan) {
		loanRepository.insertLoan(loan);
		logger.info("inserting the Data into DB");
		Finalresponse finalresponse = new Finalresponse();
		if (loan != null) {
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
	public Finalresponse getAllLoan() {
		List<Loan> loan = loanRepository.getAllLoan();
		logger.info("getall the Data into DB");
		Finalresponse finalresponse = new Finalresponse();
		if(loan != null) {
			finalresponse.setStatus(true);
			finalresponse.setStatusCode("200");
			finalresponse.setMessage("one Record was GetAll");
            finalresponse.data = loan;
			return finalresponse;
		}else { 
			finalresponse.setStatus(false);
			finalresponse.setStatusCode("502");
			finalresponse.setErrorMessages("one Record was Not Recorded");
			return finalresponse;
		}
	}

	@Override
	public Finalresponse deleteLoan(int id) {
		loanRepository.deleteRecordById();
		logger.info("delete the Data into DB");
		Finalresponse finalresponse  = new Finalresponse();
		if (id > 0) {
			finalresponse.setStatus(true);
			finalresponse.setStatusCode("200");
			finalresponse.setMessage("one Record was deleted");
            return finalresponse;
        } else { 
        	finalresponse.setStatus(false);
        	finalresponse.setStatusCode("200");
        	finalresponse.setMessage("one Record was not deleted");
        	finalresponse.setErrorMessages("check RoleId Once");
            return finalresponse;
        }
	}
	@Override
	public Finalresponse updateLoan(Loan loan) {
		loanRepository.update(loan);
		logger.info("update the Data into DB");
		Finalresponse finalresponse = new Finalresponse();
		if ( loan != null) {
            finalresponse.setStatus(true);
            finalresponse.setStatusCode("200");
            finalresponse.setMessage("one Record was Updated");
            return finalresponse;
        } else { 
            finalresponse.setStatus(false);
            finalresponse.setStatusCode("200");
            finalresponse.setMessage("One Record was Not Update");
            finalresponse.setErrorMessages("Check All fields");
            return finalresponse;
        }
	}

}

