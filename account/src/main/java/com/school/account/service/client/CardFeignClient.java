package com.school.account.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.school.account.dto.CardResponseDTO;

@FeignClient(name = "card")
public interface CardFeignClient {
	@GetMapping("/api/cards/customer/{customerId}")
	List<CardResponseDTO> getCardInfo(@PathVariable Long customerId);
}
