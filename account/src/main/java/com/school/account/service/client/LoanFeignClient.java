package com.school.account.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.school.account.dto.LoanResponseDTO;

@FeignClient(name = "loan")
public interface LoanFeignClient {
	@GetMapping("/api/loans/customer/{customerId}")
	List<LoanResponseDTO> getLoanInfo(@PathVariable Long customerId);
}
