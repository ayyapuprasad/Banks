package com.extendrepository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.extend.bean.Branch;
import com.extend.repository.BranchRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
@Repository
public class BranchRepositoryImpl implements BranchRepository {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Branch> getAllBranch() {
		Query query = entityManager.createNativeQuery("select * from branch");
		List<Branch> branch = query.getResultList();
		return branch;
	}

	@Override
	@Transactional
	public Branch insertBranch(Branch branch) {
		Query query = entityManager.createNativeQuery("insert into branch values(?,?,?)");
		query.setParameter(1,branch.getBranch_id());
		query.setParameter(2,branch.getBranch_name());
		query.setParameter(3,branch.getBranch_city());
		int Rec = query.executeUpdate();
		return branch;
	}

	@Override
	@Transactional
	public Branch update(Branch branch) {
		Query query = entityManager.createNativeQuery("update branch set branch_name=?,branch_city=? where branch_id=?");
		query.setParameter(1, branch.getBranch_id());
		query.setParameter(2, branch.getBranch_name());
		query.setParameter(3, branch.getBranch_city());
		int Rec = query.executeUpdate();
		if(Rec>0) {
			
		}
		return branch;
	}

	@Override
	@Transactional
	public Branch deleteRecordById() {
		Branch branch = new Branch();
		Query query = entityManager.createNativeQuery("delete from branch where branch_id =?");
		query.setParameter(1, branch);
		return branch;
	}

}

