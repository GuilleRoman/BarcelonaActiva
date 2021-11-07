package com.jocdaus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jocdaus.models.Player;
import com.jocdaus.services.DiceService;
import com.jocdaus.services.GameService;
import com.jocdaus.services.PlayerService;

@RestController
@RequestMapping("")
public class GameController {
	
	@Autowired
	PlayerService playerService;
	@Autowired
	GameService gameService;
	@Autowired
	DiceService diceService;
	
	@GetMapping("/")
	public String login(Model model) {
		return "login";
	}
	@PostMapping("/players")
	public String createPlayer(Player player, Model model) {
		playerService.createPlayer(player);
		return "login";
	}
	
	@PutMapping("/players")
	public void modifyPlayer(Player player) {
		playerService.modifyPlayer(player);
	}
	
	@PostMapping("/players/{id}/games/")
	public void rollDices(Player player, @PathVariable("id") int id) {
		playerService.modifyPlayer(player);
	}
}
