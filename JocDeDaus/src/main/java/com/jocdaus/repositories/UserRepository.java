package com.jocdaus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jocdaus.models.*;

@Repository
public interface UserRepository extends JpaRepository<DAOUser, String> {

	DAOUser findByUsername(String username);

	

}
