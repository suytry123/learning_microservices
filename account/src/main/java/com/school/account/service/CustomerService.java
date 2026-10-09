package com.school.account.service;

import java.util.List;

import com.school.account.entity.Customer;

public interface CustomerService {
	Customer save(Customer customer);

	List<Customer> getCustomers();

	Customer getById(Long id);

}
