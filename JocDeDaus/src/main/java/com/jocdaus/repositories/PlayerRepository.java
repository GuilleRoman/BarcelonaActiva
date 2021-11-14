package com.jocdaus.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jocdaus.models.Player;
import com.jocdaus.models.Roll;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
	@Query(value="SELECT * FROM PLAYERS WHERE win_rate = (SELECT MIN(win_rate) FROM PLAYERS)", nativeQuery = true)
	Player getLoser();
	
	@Query(value="SELECT * FROM PLAYERS WHERE win_rate = (SELECT MAX(win_rate) FROM PLAYERS)", nativeQuery = true)
	Player getWinner();
	
}
