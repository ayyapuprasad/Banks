package com.extendservice.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.extend.bean.Finalresponse;
import com.extend.bean.Transactiondetails;
import com.extend.repository.TransactionRepository;
import com.extend.service.TransactionService;
@Service
public  class TransactionServiceImpl implements TransactionService{
	private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);
	@Autowired
	private TransactionRepository transactionRepository;
	@Override
	public Finalresponse insertTransactiondetails(Transactiondetails transactiondetails) {
		transactionRepository.insertTransactiondetails(transactiondetails);
		logger.info("insering the Data into DB");
		Finalresponse finalresponse = new Finalresponse();
		 if (transactiondetails != null) {
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
	public Finalresponse getAllTransactiondetails() {
      List<Transactiondetails> transactiondetails =  transactionRepository.getAllTransactiondetails();
		Finalresponse finalresponse = new Finalresponse();
		logger.info("getall the Data into DB");
		if(transactiondetails != null) {
			finalresponse.setStatus(true);
			finalresponse.setStatusCode("200");
			finalresponse.setMessage("one Record was getall");
			return finalresponse;
		}else { 
			finalresponse.setStatus(false);
			finalresponse.setStatusCode("200");
			finalresponse.setErrorMessages("one Record was Not Recorded");
			return finalresponse;
			}
		}


	

	@Override
	public Finalresponse deleteTransactiondetails(int id) {
		transactionRepository.deleteRecordById();
		logger.info("delete the Data into DB");
		Finalresponse finalresponse = new Finalresponse();
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
	public Finalresponse updateTransactiondetails(Transactiondetails transactiondetails) {
		transactionRepository.update(transactiondetails);
		logger.info("update the Data into DB");
		Finalresponse finalresponse = new Finalresponse();
		if ( transactiondetails != null) {
            finalresponse.setStatus(true);
            finalresponse.setStatusCode("200");
            finalresponse.setMessage("one Record was Updated");
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


	



