package com.school.loan.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.school.loan.entity.Loan;

public interface LoanRepository extends MongoRepository<Loan, Long>{

}
