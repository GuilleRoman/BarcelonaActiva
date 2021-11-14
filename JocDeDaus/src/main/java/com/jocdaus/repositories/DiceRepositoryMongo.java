package com.jocdaus.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jocdaus.models.Dice;

public interface DiceRepositoryMongo extends MongoRepository<Dice, Integer> {

}
