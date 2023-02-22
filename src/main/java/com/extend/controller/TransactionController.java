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
import com.extend.bean.Transactiondetails;
import com.extend.service.TransactionService;

import jakarta.validation.Valid;

@RestController
public class TransactionController {
	@Autowired
	public TransactionService TransactionService;

	@GetMapping("/gettransaction")
	public Finalresponse getalltransactiondetails() {
		return TransactionService.getAllTransactiondetails();
	}

	@PutMapping("/updatetransaction")
	public Finalresponse updateTransactiondetails( @RequestBody @Valid Transactiondetails transactiondetails) {
		return TransactionService.updateTransactiondetails(transactiondetails);
	}

	@PostMapping("/savetransaction")
	public Finalresponse saveTransactiondetails(@RequestBody @Valid Transactiondetails transactiondetails) {
		return TransactionService.insertTransactiondetails(transactiondetails);
	}

	@DeleteMapping("/delete/{id}")
	public Finalresponse deleteTransactiondetails(@PathVariable int id) {
		return TransactionService.deleteTransactiondetails(id);
	}
}



