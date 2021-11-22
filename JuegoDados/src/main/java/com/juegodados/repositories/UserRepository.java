package com.juegodados.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.juegodados.documents.DAOUser;

@Repository
public interface UserRepository extends MongoRepository<DAOUser, String> {

	DAOUser findByUsername(String username);

	

}
