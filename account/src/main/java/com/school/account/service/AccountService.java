package com.school.account.service;

import java.util.List;

import com.school.account.dto.AccountDTO;
import com.school.account.entity.Account;

public interface AccountService {
	Account saveAccount(AccountDTO dto);
	
	List<Account> getAccounts();

	Account getById(Long id);
}
