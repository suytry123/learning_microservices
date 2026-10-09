package com.school.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.account.dto.CardResponseDTO;
import com.school.account.dto.CustomerDTO;
import com.school.account.dto.CustomerDetailDTO;
import com.school.account.dto.LoanResponseDTO;
import com.school.account.entity.Customer;
import com.school.account.mapper.CustomerMapper;
import com.school.account.service.CustomerService;
import com.school.account.service.client.CardFeignClient;
import com.school.account.service.client.LoanFeignClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private CardFeignClient cardFeignClient;
	@Autowired
	private LoanFeignClient loanFeignClient;
	
	@PostMapping
	public ResponseEntity<?> saveCustomer(@RequestBody CustomerDTO dto){
		Customer customer = customerMapper.toCustomer(dto);
		customer = customerService.save(customer);
		return ResponseEntity.ok(customer);
	}
	
	@GetMapping
	public ResponseEntity<?> getCustomers(){
		return ResponseEntity.ok(customerService.getCustomers());
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<?> getCustomerById(@PathVariable Long customerId){
		return ResponseEntity.ok(customerService.getById(customerId));
	}
	
	@CircuitBreaker(name = "customerDetailSupport")
	@GetMapping("/customerDetail/{customerId}")
	public ResponseEntity<CustomerDetailDTO> getCustomerDetail(@PathVariable Long customerId){
		CustomerDetailDTO customerDetailDTO = new CustomerDetailDTO();
		Customer customer = customerService.getById(customerId);
		if(customer == null) {
			throw new RuntimeException("No customer found with this id");
		}
		CustomerDTO customerDTO = customerMapper.toCustomerDTO(customer);
		List<LoanResponseDTO> loanInfo = loanFeignClient.getLoanInfo(customerId);
		List<CardResponseDTO> cardInfo = cardFeignClient.getCardInfo(customerId);
		
		customerDetailDTO.setCustomer(customerDTO);
		customerDetailDTO.setCards(cardInfo);
		customerDetailDTO.setLoans(loanInfo);
		
		return ResponseEntity.ok(customerDetailDTO);
	}

}
