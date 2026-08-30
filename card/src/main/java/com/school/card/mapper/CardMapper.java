package com.school.card.mapper;

import org.mapstruct.Mapper;

import com.school.card.dto.CardDTO;
import com.school.card.entity.Card;

@Mapper(componentModel = "spring")
public interface CardMapper {
	
	Card toCard(CardDTO cardDTO);
}
