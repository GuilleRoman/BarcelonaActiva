package com.jocdaus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jocdaus.models.Dice;

@Repository
@Component
public interface DiceRepository extends JpaRepository<Dice, Integer> {

}
