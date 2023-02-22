package com.extend.repository;

import java.util.List;

import com.extend.bean.Branch;

public interface BranchRepository {
	public List<Branch> getAllBranch();
    
    public Branch insertBranch(Branch branch);
    
    public Branch update(Branch branch);
    
    public Branch deleteRecordById();




}

