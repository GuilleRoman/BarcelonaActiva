package com.jocdaus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jocdaus.models.Player;
import com.jocdaus.models.Roll;
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

	


}
