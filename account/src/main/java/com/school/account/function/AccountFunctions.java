package com.school.account.function;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.school.account.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class AccountFunctions {

	@Bean
	Consumer<Long> updateCustomerCommunication(CustomerService customerService){
		return customerId ->{
			customerService.updateCustomerCommunication(customerId);
			log.info("Update customer communication with customerId: {}", customerId);
		};
	}
	
}
