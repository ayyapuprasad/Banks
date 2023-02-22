package com.extend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.extend.bean.Finalresponse;
import com.extend.bean.Loan;
import com.extend.service.LoanService;

import jakarta.validation.Valid;

@RestController
public class LoanController<Loan> {
	@Autowired
	public LoanService loanService;
	@GetMapping("/getloan")
	public Finalresponse getLoan() {
		return loanService.getAllLoan();	
	}
	@PostMapping("/saveloan")
	public Finalresponse insertLoan(@RequestBody @Valid com.extend.bean.Loan loan) {
		return loanService.insertLoan(loan);
	}
	@PutMapping("/updateloan")
	public Finalresponse updateLoan(@RequestBody @Valid com.extend.bean.Loan loan) {
		return loanService.updateLoan(loan);
	}
	@DeleteMapping("/deleteloan/{id}")
	public Finalresponse deleteLoan(@PathVariable int id) {
		return loanService.deleteLoan(id);
	}

	
}

