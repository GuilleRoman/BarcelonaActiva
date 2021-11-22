package com.juegomongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.juegomongo.documents.DAOUser;

@Repository
public interface UserRepository extends MongoRepository<DAOUser, String> {

	DAOUser findByUsername(String username);

	

}
