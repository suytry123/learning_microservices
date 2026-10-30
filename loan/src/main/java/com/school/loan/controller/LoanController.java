package com.school.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.loan.dto.LoanDTO;
import com.school.loan.entity.Loan;
import com.school.loan.mapper.LoanMapper;
import com.school.loan.service.LoanService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/loans")
public class LoanController {
	@Autowired
	private LoanService loanService;
	@Autowired
	private LoanMapper loanMapper;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody LoanDTO loanDTO){
		Loan loan = loanService.save(loanMapper.toLoan(loanDTO));
		return ResponseEntity.status(HttpStatus.CREATED).body(loan);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getLoanById(@PathVariable Long id){
		return ResponseEntity.ok(loanService.getLoanById(id));
	}
	
	@GetMapping
	public ResponseEntity<?> list(){
		return ResponseEntity.ok(loanService.getList());
	}
	
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<?> getByCustomerId(@RequestHeader("suytry123-correlation-id") String correlationId,
			@PathVariable Long customerId){
		//System.out.println("========== Loan Service is called ===========");
		//log.debug("Correlation id found : {}", correlationId);
		
		
		log.debug("fetchLoanDetail method start");
		List<Loan> loans = loanService.getByCustomerId(customerId);
		log.debug("fetchLoanDetail method end");
		return ResponseEntity.ok(loans);
	}
	
	/*@GetMapping("/customer/{customerId}")
	public ResponseEntity<List<Loan>> getLoansByCustomerId(
	        @PathVariable Long customerId) {

	    return ResponseEntity.ok(
	        loanService.getLoansByCustomerId(customerId)
	    );
	}*/
}
