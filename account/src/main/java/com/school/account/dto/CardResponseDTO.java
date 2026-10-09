package com.school.account.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class CardResponseDTO {
	private Long cardId;
	private Long customerId;
	private Long cardNumber;
	private String cardType;
	private BigDecimal totalLimit;
	private BigDecimal amountUsed;
	private BigDecimal availableAmount;
	private LocalDate createDate;
}
