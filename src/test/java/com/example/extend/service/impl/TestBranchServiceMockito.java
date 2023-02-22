package com.example.extend.service.impl;

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
import com.extend.repository.BranchRepository;
import com.extendservice.impl.BranchServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestBranchServiceMockito {
	//@InjectMocks
	@Mock
private	BranchServiceImpl branchService;
	//private BranchRepository branchRepository;
	@Test
	@DisplayName("insert into the object in database")
	public void BranchInsert () {
		Branch branch = new Branch ();
		branch.setBranch_id("1");
		branch.setBranch_name("axis");
		branch.setBranch_city("hyd");
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was Inserted");
		when(branchService.insertBranch(branch)).thenReturn(expected);
		Finalresponse actual = branchService.insertBranch(branch);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("update into the object in database")
	public void BranchUpdate() {
		Branch branch = new Branch ();
		branch.setBranch_id("1");
		branch.setBranch_name("sbi");
		branch.setBranch_city("bangalore");
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was Update");
		when(branchService.updateBranch(branch)).thenReturn(expected);
		Finalresponse actual = branchService.updateBranch(branch);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("delete into the object database")
	public void BranchDelete() {
		Branch branch = new Branch ();
		branch.setBranch_id("1");
		branch.setBranch_name("axis");
		branch.setBranch_city("hyd");
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was Delete");
		when(branchService.deleteBranch(1)).thenReturn(expected);
		Finalresponse actual = branchService.deleteBranch(1);
		assertThat(expected).isEqualTo(actual);
	}
	@Test
	@DisplayName("getall into the object database")
	public void BranchGet() {
		Branch branch = new Branch();
		branch.setBranch_id("2");
		branch.setBranch_name("axis");
		branch.setBranch_city("kurnool");
		
		Branch branch1 = new Branch();
		branch1.setBranch_id("2");
		branch1.setBranch_name("hdfc");
		branch1.setBranch_city("kurnool");
		List<Branch> list = new ArrayList<>();
		list.add(branch);
		list.add(branch1);
		Finalresponse expected = new Finalresponse();
		expected.setStatus(true);
		expected.setStatusCode("200");
		expected.setMessage("one Record was GetAll");
		when(branchService.getAllBranch()).thenReturn(expected);
		Finalresponse actual = branchService.getAllBranch();
		assertThat(expected).isEqualTo(actual);
		
		
	}

}


