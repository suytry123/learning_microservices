package com.school.loan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.loan.entity.Loan;
import com.school.loan.repository.LoanRepository;
import com.school.loan.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService{
	@Autowired
	private LoanRepository loanRepository;
//	@Autowired
//    private  MongoTemplate mongoTemplate;
	
	@Override
	public Loan save(Loan loan) {
		return loanRepository.save(loan);
	}

	@Override
	public Loan getLoanById(Long loanNumber) {
		return loanRepository.findById(loanNumber)
			.orElseThrow(() -> new RuntimeException());
	}

	@Override
	public List<Loan> getList() {
		return loanRepository.findAll();
	}
	
	/*
	@Override
	public List<Loan> getLoansByCustomerId(Long customerId) {

	    Query query = new Query();

	    query.addCriteria(
	        Criteria.where("customerId").is(customerId)
	    );

	    return mongoTemplate.find(query, Loan.class);
	}*/

	@Override
	public List<Loan> getByCustomerId(Long customerId) {	
		return loanRepository.findByCustomerId(customerId);
	}

}