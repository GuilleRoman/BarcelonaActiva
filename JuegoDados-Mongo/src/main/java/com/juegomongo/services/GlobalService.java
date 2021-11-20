package com.juegomongo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juegomongo.documents.Game;
import com.juegomongo.documents.Player;
import com.juegomongo.repositories.GameRepository;
import com.juegomongo.repositories.PlayerRepository;

@Service
public class GlobalService {
	
	@Autowired
	PlayerRepository playerRepository;
	@Autowired
	GameRepository gameRepository;
	public ArrayList<Player> getPlayers() {
		// TODO Auto-generated method stub
		return (ArrayList<Player>) playerRepository.findAll();
	}
	public int countGamesPlayed(Player p) {
		// TODO Auto-generated method stub
		return gameRepository.countGamesPlayed(p.getName());
	}
	
	public Player getWinner() {
		// TODO Auto-generated method stub
		return playerRepository.findFirstByOrderByWinRateDesc();
	}

	public Player getLoser() {
		// TODO Auto-generated method stub
		return playerRepository.findFirstByOrderByWinRateAsc();
	}

	public void update(Player p) {
		// TODO Auto-generated method stub
		playerRepository.save(p);
	}

	public void modifyPlayer(Player player) {
		// TODO Auto-generated method stub
		playerRepository.save(player);
	}

	public Optional<Player> searchById(String id) {
		// TODO Auto-generated method stub
		return playerRepository.findById(id);
	}
	
	public Optional<Player> searchByName(String name) {
		// TODO Auto-generated method stub
		return playerRepository.findByName(name);
	}

	public void save(Game game) {
		// TODO Auto-generated method stub
		gameRepository.save(game);
	}
	
	public ArrayList<Game> getGamesByPlayer(String playerName){
		return (ArrayList<Game>) gameRepository.findByPlayerName(playerName);
	}
	public int countWins(Player player) {
		// TODO Auto-generated method stub
		return gameRepository.countWins(player.getName());
	}
	public void save(Player player) {
		// TODO Auto-generated method stub
		playerRepository.save(player);
	}
	
	
	public void calculateRanking(ArrayList<Player> players){
		int timesRolled=0;
		int timesWon=0;
		double winRate=0;
		for (Player p: players) {
			timesRolled =this.countGamesPlayed(p);
			timesWon = this.countWins(p);
			winRate = (timesWon/(double)timesRolled)*100;
			
			winRate = (double)Math.round(winRate * 100d) / 100d;
			p.setWinRate(winRate);
			this.playerRepository.save(p);
			
		}
	}
	public void deleteAllPlayerGames(List<Game> games) {
		// TODO Auto-generated method stub
		this.gameRepository.deleteAll(games);
	}

}
