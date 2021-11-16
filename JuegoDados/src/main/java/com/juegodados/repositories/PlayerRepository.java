package com.juegodados.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.juegodados.entities.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

	
	
	public List<Player> findByName(String name);

	public boolean existsById(String name);

	public boolean existsByName(String name);

	public void deleteByName(String name);
	
	@Query(value="SELECT * FROM PLAYERS WHERE win_rate = (SELECT MIN(win_rate) FROM PLAYERS)", nativeQuery = true)
	Player getLoser();
	
	@Query(value="SELECT * FROM PLAYERS WHERE win_rate = (SELECT MAX(win_rate) FROM PLAYERS)", nativeQuery = true)
	Player getWinner();
}
