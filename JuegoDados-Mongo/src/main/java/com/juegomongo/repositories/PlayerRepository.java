package com.juegomongo.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.juegomongo.documents.Player;

@Repository
public interface PlayerRepository extends MongoRepository<Player , String> {

//	Player getLoser();
//
//	Player getWinner();
	
	public Player findFirstByOrderByWinRateDesc();
	
	public Player findFirstByOrderByWinRateAsc();

	 @Query(value="{name:?0}")  
	public Optional<Player> findByName(String name);

	

}
