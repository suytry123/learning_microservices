package com.school.account.config;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.school.account.entity.Account;
import com.school.account.entity.Customer;
import com.school.account.repository.AccountRepository;
import com.school.account.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class SetupAccountRunner implements CommandLineRunner{
	private final AccountRepository accountRepository;
	private final CustomerRepository customerRepository;

	@Override
	public void run(String... args) throws Exception {
		Customer customer = new Customer();
		customer.setCreateDate(LocalDate.now());
		customer.setEmail("panha@gmail.com");
		customer.setMobileNumber("0829913188");
		customer.setName("panha sok");
		customerRepository.save(customer);
		
		Account account = new Account();
		account.setAccountNumber(1L);
		account.setAccountType("Saving");
		account.setBranchAddress("Phnom Penh");
		account.setCreateDate(LocalDate.now());
		account.setCustomer(customer);
		accountRepository.save(account);
		log.info("Account Created");
	}

}
