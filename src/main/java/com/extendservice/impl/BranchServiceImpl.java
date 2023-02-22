package com.extendservice.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.extend.bean.Branch;
import com.extend.bean.Finalresponse;
import com.extend.repository.BranchRepository;
import com.extend.service.BranchService;

@Service
public class BranchServiceImpl implements BranchService {
	private static final Logger logger = LoggerFactory.getLogger(BranchServiceImpl.class);
	@Autowired
	private BranchRepository branchRepository;
	@Override
	public Finalresponse insertBranch(Branch branch) {
		branchRepository.insertBranch(branch);
		logger.info("Inserting the Data into DB");
		Finalresponse finalresponse = new Finalresponse();
		if (branch != null) {
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
	public Finalresponse getAllBranch() {
		List<Branch> branch =  branchRepository.getAllBranch();
		logger.info("GetAll the Data into DB");
		Finalresponse finalresponse = new Finalresponse();
		if(branch != null) {
			finalresponse.setStatus(true);
			finalresponse.setStatusCode("200");
			finalresponse.setMessage("one Record was Inserted");
            finalresponse.data=branch;
			return finalresponse;
		}else {
			finalresponse.setStatus(false);
			finalresponse.setStatusCode("200");
			finalresponse.setErrorMessages("one Record was Not Recorded");
			return finalresponse;
		}
	}
	@Override
	public Finalresponse deleteBranch(int id) {
		branchRepository.deleteRecordById();
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
	public Finalresponse updateBranch(Branch branch) {
		branchRepository.update(branch);
		logger.info("update the Data into DB");
		Finalresponse  finalresponse = new Finalresponse();
		if ( branch != null) {
            finalresponse.setStatus(true);
            finalresponse.setStatusCode("200");
            finalresponse.setMessage("one Record was Updated");
            return finalresponse;
        } else {
            finalresponse.setStatus(false);
            finalresponse.setStatusCode("200");
            finalresponse.setMessage("One Record was Not Inserted");
            finalresponse.setErrorMessages("Check All fields");
            return finalresponse;
        }
	}
}

