package com.example.extend.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.extend.bean.Branch;
import com.extend.bean.Finalresponse;
import com.extend.controller.BranchController;
import com.extendservice.impl.BranchServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestBranchcontrollermockito {
	@InjectMocks
	BranchController branchController;
	@Mock
	private BranchServiceImpl branchService;
	@Test
	@DisplayName("insert the branch object to database ")
	public void BranchInsert () {
		Branch branch = new Branch();
		branch.setBranch_id("1");
		branch.setBranch_name("hdfc");
		branch.setBranch_city("kadapa");
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("One Record was Inserted");
		when(branchService.insertBranch(branch)).thenReturn(expected);
		Finalresponse actual = branchController.insertBranch(branch);
		assertThat(expected).isEqualTo(actual);
		
	}
	@Test
	@DisplayName("update the branch object to database")
	public void BranchUpdate () {
		Branch branch = new  Branch();
		branch.setBranch_id("1");
		branch.setBranch_name("sbi");
		branch.setBranch_city("kadapa");
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was Update");
		when(branchService.updateBranch(branch)).thenReturn(expected);
		Finalresponse actual = branchController.updateBranch(branch);
		assertThat(expected).isEqualTo(actual);
		
	}
	@Test
	@DisplayName("delete the branch object to database")
	public void BranchDelete () {
		Branch  branch = new Branch();
		branch.setBranch_id("1");
		branch.setBranch_name("hdfc");
		branch.setBranch_city("kadapa");
		Finalresponse expected = new  Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was Delete");
		when(branchService.deleteBranch(1)).thenReturn(expected);
		Finalresponse actual = branchController.deleteBranch(1);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("getall the branch object to database")
	public void BranchGetAll() {
		Branch branch = new Branch ();
		branch.setBranch_id("2");
		branch.setBranch_name("mydukur");
		branch.setBranch_city("kadapa");
		Branch branch1 = new Branch();
		branch1.setBranch_id("3");
		branch1.setBranch_name("badvel");
		branch1.setBranch_city("kadapa");
		List<Branch> list= new ArrayList<>();
		list.add(branch);
		list.add(branch1);
		Finalresponse expected1 = new Finalresponse();
		expected1.setStatus(true);
		expected1.setStatusCode("200");	
		expected1.setMessage("one Record was GetAll");
		when(branchService.getAllBranch()).thenReturn(expected1);
		Finalresponse actual = branchController.getbranch();
		assertThat(expected1).isEqualTo(actual);
		
	}
}


