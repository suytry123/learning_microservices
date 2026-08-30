package com.school.card.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "cards")
public class Card {
	@Id
	private Long cardId;
	private Long customerId;
	private Long cardNumber;
	private String cardType;
	private BigDecimal totalLimit;
	private BigDecimal amountUsed;
	private BigDecimal availableAmount;
	private LocalDate createDate;
}
