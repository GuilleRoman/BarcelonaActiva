package com.jocdaus.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jocdaus.models.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
	
	@Query(value="SELECT COUNT(id) FROM Games WHERE winner = ?1", nativeQuery = true)
	public int countTimesWon(String player);
	
	@Query(value="SELECT * FROM GAMES WHERE player_id = ?1", nativeQuery = true)
	public List<Game> getGamesByPlayer(int id);
}
