package com.juegomongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.juegomongo.documents.Game;

@Repository
public interface GameRepository extends MongoRepository<Game, String> {

	public boolean existsByPlayerName(String playerName);
	
	public List<Game> findByPlayerName(String playerName);
	
	public void deleteByPlayerName(String playerName);

	public Game findGameByPlayerName(String name);

	 @Query(value="{winner:?0}", count=true)      
	public int countWins(String playerName);

	 @Query(value="{playerName:?0}", count=true) 
	public int countGamesPlayed(String name);
}
