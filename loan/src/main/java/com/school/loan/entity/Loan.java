package com.school.loan.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "loans")
public class Loan {
	@Id
	private Long loanNumber;
	private Long customerId;
	private LocalDate startDate;
	private String loanType;
	private BigDecimal totalLoan;
	private BigDecimal amountPaid;
	private BigDecimal outstandingAmount;
	private LocalDate createDate;
}
