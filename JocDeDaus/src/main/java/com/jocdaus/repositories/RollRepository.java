package com.jocdaus.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jocdaus.models.Roll;

@Repository
public interface RollRepository extends JpaRepository<Roll, Integer> {

	@Query(value = "SELECT id, player_id, game_id, resultdice1, resultdice2, result FROM ROLLS WHERE player_id = ?1", nativeQuery = true)
	List<Roll> getRollsByPlayerId(Integer id);
	
	@Query(value="SELECT COUNT(id) FROM Rolls WHERE player_id = ?1", nativeQuery = true)
	public int countTimesRolled(int id);
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM ROLLS WHERE player_id = ?1", nativeQuery = true)
	void deleteAllPlayerGames(int id);
}
