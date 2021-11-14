package com.jocdaus.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jocdaus.models.Player;

public interface PlayerRepositoryMongo extends MongoRepository<Player,Integer> {

}
