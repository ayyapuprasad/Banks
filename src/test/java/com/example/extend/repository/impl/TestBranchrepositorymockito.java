package com.example.extend.repository.impl;



import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.extend.bean.Branch;
import com.extendrepository.impl.BranchRepositoryImpl;

@ExtendWith(MockitoExtension.class)
public class TestBranchrepositorymockito {
	@Mock
	private BranchRepositoryImpl branchRepository;
	@Test
	@DisplayName("insert into the branchrepository")
	public void BranchInsert () {
		Branch branch = new Branch () ;
		branch.setBranch_id("1");
		branch.setBranch_name("sbi");
		branch.setBranch_city("badvel");
		when(branchRepository.insertBranch(branch)).thenReturn(branch);
		Branch actual = branchRepository.insertBranch(branch);
		assertThat(branch).isEqualTo(actual);	
	}
	@Test
	@DisplayName("update into the branchRepository")
	public void BranchUpdate () {
		Branch branch = new Branch ();
		branch.setBranch_id("1");
		branch.setBranch_name("hdfc");
		branch.setBranch_city("bangalore");
		when(branchRepository.update(branch)).thenReturn(branch);
		Branch actual = branchRepository.update(branch);
		assertThat(branch).isEqualTo(actual);
	}
	@Test
	@DisplayName("delete into the branchRepository")
	public void BranchDelete () {
		Branch branch = new Branch();
		branch.setBranch_id("1");
		branch.setBranch_name("sbi");
		branch.setBranch_city("badvel");
		when(branchRepository.deleteRecordById()).thenReturn(branch);
		Branch actual = branchRepository.deleteRecordById();
		assertThat(branch).isEqualTo(actual);
		
	}
	@Test
	@DisplayName("getall into the accountrepository")
	public void BranchGetall() {
		Branch branch = new Branch();
		branch.setBranch_id("2");
		branch.setBranch_name("sbi");
		branch.setBranch_city("kadapa");
		
		Branch branch1 = new Branch();
		branch1.setBranch_id("3");
		branch1.setBranch_name("hdfc");
		branch1.setBranch_city("kadapa");
		List<Branch> list= new ArrayList<>();
		list.add(branch);
		list.add(branch1);
		when(branchRepository.getAllBranch()).thenReturn(list);
		List<Branch> actual = branchRepository.getAllBranch();
		assertThat(list).isEqualTo(actual);
	}

}
