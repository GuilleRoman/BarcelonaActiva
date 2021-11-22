package com.jocdaus.services;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jocdaus.models.Dice;
import com.jocdaus.models.Player;
import com.jocdaus.repositories.PlayerRepository;

@Service
public class PlayerService {
	@Autowired
	PlayerRepository db;

	@Autowired
	DiceService diceService;
	
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

	public Player savePlayer(Player player) {
		return this.db.save(player);
	}
	
	public Player createNewPlayer(Player player) {
		Player playerToSave = new Player(player.getName(), player.getPassword());
  		this.savePlayer(playerToSave);
  		Dice dice1= new Dice(playerToSave);
		Dice dice2= new Dice(playerToSave);
		ArrayList<Dice> dices= new ArrayList<Dice>();
		dices.add(dice1);
		dices.add(dice2);
		diceService.createDice(dice1);
		diceService.createDice(dice2);
		playerToSave.setDices(dices);
  		return this.savePlayer(playerToSave);
	}

}
