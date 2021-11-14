package com.jocdaus.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jocdaus.models.Roll;

public interface RollRepositoryMongo extends MongoRepository<Roll, Integer> {

}
