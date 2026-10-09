package com.school.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.account.dto.AccountDTO;
import com.school.account.entity.Account;
import com.school.account.service.AccountService;

@RestController
@RequestMapping("api/accounts")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@PostMapping
	public ResponseEntity<Account> saveAccount(@RequestBody AccountDTO dto) {

	    Account account = accountService.saveAccount(dto);

	    return ResponseEntity.ok(account);
	}
	
	@GetMapping
	public ResponseEntity<?> getAccounts(){
		return ResponseEntity.ok(accountService.getAccounts());
	}
	
	@GetMapping("/{accountId}")
	public ResponseEntity<?> getAccountById(@PathVariable Long accountId){
		return ResponseEntity.ok(accountService.getById(accountId));
	}
	
}
