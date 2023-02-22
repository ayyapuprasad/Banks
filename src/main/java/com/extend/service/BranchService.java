package com.extend.service;

import com.extend.bean.Branch;
import com.extend.bean.Finalresponse;

public interface BranchService {
	public Finalresponse insertBranch(Branch branch);
	public Finalresponse getAllBranch();
	public Finalresponse deleteBranch(int id);
	public Finalresponse updateBranch(Branch branch);
	
}

