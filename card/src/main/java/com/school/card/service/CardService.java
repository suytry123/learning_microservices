package com.school.card.service;

import java.util.List;

import com.school.card.entity.Card;

public interface CardService {
	Card save(Card loan);

	Card getCardById(Long loanNumber);

	List<Card> getByCustomerId(Long customerId);
	
	List<Card> getList();
}
