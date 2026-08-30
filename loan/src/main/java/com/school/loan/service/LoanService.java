package com.school.loan.service;

import java.util.List;

import com.school.loan.entity.Loan;

public interface LoanService {
	Loan save(Loan loan);

	Loan getLoanById(Long loanNumber);

	List<Loan> getList();
	
	List<Loan> getLoansByCustomerId(Long customerId);
}
