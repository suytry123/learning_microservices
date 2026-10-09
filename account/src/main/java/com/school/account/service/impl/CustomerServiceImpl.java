package com.school.account.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.school.account.entity.Customer;
import com.school.account.repository.CustomerRepository;
import com.school.account.service.CustomerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
	private final CustomerRepository customerRepository;

	@Override
	public Customer save(Customer customer) {
		 customer = customerRepository.save(customer);
		 return customer;
	}

	@Override
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getById(Long id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Customer not found"));
	}

}
