package com.JocDaus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JocDaus.models.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

}
