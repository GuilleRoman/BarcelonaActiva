package com.jocdaus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.jocdaus.models.Game;
import com.jocdaus.repositories.GameRepository;

@Service
public class GameService {
	@Autowired
	GameRepository db;

	
	public void save(Game game) {
		// TODO Auto-generated method stub
		db.save(game);
	}

	public int countTimesWon(String player) {
		// TODO Auto-generated method stub
		return db.countTimesWon(player);
	}
	
	public List<Game> getGamesByPlayer(int id) {
		// TODO Auto-generated method stub
		return this.db.getGamesByPlayer(id);
	}

	public void deleteAll(List<Game> games) {
		// TODO Auto-generated method stub
		this.db.deleteAll(games);
	}
}
