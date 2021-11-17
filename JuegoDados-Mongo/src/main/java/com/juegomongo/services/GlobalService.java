package com.juegomongo.services;

import java.util.ArrayList;
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


}
