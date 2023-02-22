package com.extend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.extend.bean.Account;
import com.extend.bean.Finalresponse;
import com.extend.service.AccountService;

import jakarta.validation.Valid;
@RestController
public class AccountController {
	@Autowired
	public AccountService accountService;
	
	@GetMapping("/getaccount")
	public Finalresponse getAccount() {
		return accountService.getAllAccount();
	}
	@PutMapping("/updateaccount")
	public Finalresponse updateAccount(@RequestBody @Valid Account account) {
		return accountService.updateaccount(account);
	}
	@PostMapping("/saveaccount")
	public Finalresponse insertAccount(@RequestBody @Valid Account account) {
		return accountService.insertaccount(account);
	}
	@DeleteMapping("/deleteaccount/{id}")
	public Finalresponse deleteAccount(@PathVariable int id) {
		return accountService.deleteAccount(id);
	}
}


