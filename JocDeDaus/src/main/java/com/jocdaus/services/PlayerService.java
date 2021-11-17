package com.jocdaus.services;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jocdaus.models.Player;
import com.jocdaus.repositories.PlayerRepository;

@Service
public class PlayerService {
	@Autowired
	PlayerRepository db;

	
	public void createPlayer(Player player) {
		// TODO Auto-generated method stub
		db.save(player);
	}

	public void modifyPlayer(Player player) {
		// TODO Auto-generated method stub
		db.save(player);
	}

	public List<Player> getPlayers() {
		
		return db.findAll();
	}

	public Optional<Player> searchById(int id) {
		// TODO Auto-generated method stub
		return db.findById(id);
	}

	public void update(Player player) {
		db.save(player);
		
	}

	public void save(Player player) {
		// TODO Auto-generated method stub
		db.save(player);
	}

	public Player getLoser() {
		// TODO Auto-generated method stub
		return db.getLoser();
	}

	public Player getWinner() {
		// TODO Auto-generated method stub
		return db.getWinner();
	}
	public void calculateRanking(ArrayList<Player> players, RollService rollService, GameService gameService){
		int timesRolled=0;
		int timesWon=0;
		double winRate=0;
		for (Player p: players) {
			timesRolled =rollService.countTimesRolled(p.getId());
			timesWon = gameService.countTimesWon(p.getName());
			winRate = (timesWon/(double)timesRolled)*100;
			
			winRate = (double)Math.round(winRate * 100d) / 100d;
			p.setWinRate(winRate);
			this.update(p);
		}
	}

}
