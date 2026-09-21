package com.school.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.card.dto.CardDTO;
import com.school.card.entity.Card;
import com.school.card.mapper.CardMapper;
import com.school.card.service.CardService;

@RestController
@RequestMapping("api/cards")
public class CardController {
	@Autowired
	private CardService cardService;
	@Autowired
	private CardMapper cardMapper;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody CardDTO cardDTO){
		Card card = cardService.save(cardMapper.toCard(cardDTO));
		return ResponseEntity.status(HttpStatus.CREATED).body(card);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCardById(@PathVariable Long id){
		return ResponseEntity.ok(cardService.getCardById(id));
	}
	
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<?> getByCustomerId(@PathVariable Long customerId){
		return ResponseEntity.ok(cardService.getByCustomerId(customerId));
	}
	
	@GetMapping
	public ResponseEntity<?> list(){
		return ResponseEntity.ok(cardService.getList());
	}
}
