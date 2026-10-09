package com.school.account.mapper;

import org.springframework.stereotype.Component;

import com.school.account.dto.AccountDTO;
import com.school.account.entity.Account;
import com.school.account.entity.Customer;

@Component
public class AccountMapper {

	public Account toAccount(AccountDTO dto, Customer customer) {
		Account account = new Account();
		account.setAccountNumber(dto.getAccountNumber());
		account.setAccountType(dto.getAccountType());
		account.setBranchAddress(dto.getBranchAddress());
		account.setCreateDate(dto.getCreateDate());
		account.setCustomer(customer);
		return account;
	}
}
