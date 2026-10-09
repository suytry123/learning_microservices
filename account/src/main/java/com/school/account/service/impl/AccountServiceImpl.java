package com.school.account.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.school.account.dto.AccountDTO;
import com.school.account.entity.Account;
import com.school.account.entity.Customer;
import com.school.account.mapper.AccountMapper;
import com.school.account.repository.AccountRepository;
import com.school.account.repository.CustomerRepository;
import com.school.account.service.AccountService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{
	private final AccountRepository accountRepository;
	private final CustomerRepository customerRepository;
	private final AccountMapper accountMapper;

	public Account saveAccount(AccountDTO dto) {

	    Customer customer = customerRepository.findById(dto.getCustomerId())
	            .orElseThrow(() ->
	                    new RuntimeException("Customer not found"));

	    Account account = accountMapper.toAccount(dto, customer);

	    return accountRepository.save(account);
	}

	@Override
	public List<Account> getAccounts() {
		return accountRepository.findAll();
	}

	@Override
	public Account getById(Long id) {
		return accountRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Account not found"));
	}

}
