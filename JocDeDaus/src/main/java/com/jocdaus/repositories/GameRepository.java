package com.jocdaus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.jocdaus.models.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

}
