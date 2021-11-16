package com.jocdaus.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.jocdaus.models.Dice;
import com.jocdaus.repositories.DiceRepository;

@Service
public class DiceService {
	@Autowired
	DiceRepository db;
	public void createDice(Dice dice) {
		// TODO Auto-generated method stub
		db.save(dice);
	}

	
}
