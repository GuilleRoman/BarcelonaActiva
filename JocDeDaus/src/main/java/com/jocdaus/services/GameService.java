package com.jocdaus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jocdaus.models.Game;
import com.jocdaus.repositories.GameRepository;
import com.jocdaus.repositories.GameRepositoryMongo;

@Service
public class GameService {
	@Autowired
	GameRepository db;
	@Autowired
	GameRepositoryMongo db1;
	
	public void save(Game game) {
		// TODO Auto-generated method stub
		db.save(game);
	}

	public int countTimesWon(String player) {
		// TODO Auto-generated method stub
		return db.countTimesWon(player);
	}
}
