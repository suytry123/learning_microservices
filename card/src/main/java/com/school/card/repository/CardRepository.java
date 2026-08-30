package com.school.card.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.school.card.entity.Card;

public interface CardRepository extends MongoRepository<Card, Long>{

}
