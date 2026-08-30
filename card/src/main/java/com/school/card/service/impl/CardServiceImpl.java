package com.school.card.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.card.entity.Card;
import com.school.card.repository.CardRepository;
import com.school.card.service.CardService;

@Service
public class CardServiceImpl implements CardService{
	@Autowired
	private CardRepository cardRepository;
	
	@Override
	public Card save(Card loan) {
		return cardRepository.save(loan);
	}

	@Override
	public Card getCardById(Long cardId) {
		return cardRepository.findById(cardId)
			.orElseThrow(() -> new RuntimeException());
	}

	@Override
	public List<Card> getList() {
		return cardRepository.findAll();
	}

}