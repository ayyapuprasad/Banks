package com.extend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.extend.bean.Branch;
import com.extend.bean.Finalresponse;
import com.extend.service.BranchService;

import jakarta.validation.Valid;

@RestController
public class BranchController {
	@Autowired
public BranchService branchService;
	@GetMapping("/getbranch")
public Finalresponse getbranch() {
		return branchService.getAllBranch();
	}
	@PostMapping("/savebranch")
	public Finalresponse insertBranch(@RequestBody @Valid Branch branch) {
		return branchService.insertBranch(branch);
	}
	@PutMapping("/updatebranch")
	public Finalresponse updateBranch(@RequestBody @Valid Branch branch) {
		return branchService.updateBranch(branch);
	}
	@DeleteMapping("/deletebranch/{id}")
	public Finalresponse deleteBranch(@PathVariable int id) {
		return branchService.deleteBranch(id);
	}
	

}

