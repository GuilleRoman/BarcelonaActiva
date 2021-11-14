package com.jocdaus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jocdaus.models.Dice;
import com.jocdaus.repositories.DiceRepository;
import com.jocdaus.repositories.DiceRepositoryMongo;

@Service
public class DiceService {
	@Autowired
	DiceRepository db;
	@Autowired
	DiceRepositoryMongo db1;
	public void createDice(Dice dice) {
		// TODO Auto-generated method stub
		db.save(dice);
	}

	
}
