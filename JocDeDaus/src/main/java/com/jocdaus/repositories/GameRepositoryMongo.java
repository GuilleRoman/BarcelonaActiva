package com.jocdaus.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jocdaus.models.Game;

public interface GameRepositoryMongo extends MongoRepository<Game, Integer> {

}
