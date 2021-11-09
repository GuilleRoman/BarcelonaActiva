package com.jocdaus.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

@Controller
@RequestMapping("")
public class GameController {
	
	
	@Autowired
	PlayerService playerService;
	@Autowired
	GameService gameService;
	@Autowired
	DiceService diceService;
	
	@GetMapping("/")
	public String login(Model model, Player player) {
		
		return "login";
	}
	@PostMapping("/players")
	public String createPlayer(Player player, Model model) {
		playerService.createPlayer(player);
		model.addAttribute("Player", player);
		return "login";
	}
	
	@PutMapping("/players")
	public void modifyPlayer(Player player, Model model) {
		playerService.modifyPlayer(player);
		model.addAttribute("Player", player);
	}
	
	@PostMapping("/players/{id}/games/")
	public String rollDices(Player player, @PathVariable("id") int id, Model model) {
	
		playerService.modifyPlayer(player);
		player.rollDices();
		model.addAttribute("hashmap", player.getRolls());
		return "game";
	}
	
	@GetMapping("/players/{id}/games/")
	public String getPlayerRolls(Player player, @PathVariable("id") int id, Model model) {
		playerService.modifyPlayer(player);
		model.addAttribute("Player", player);
		model.addAttribute("hashmap", player.getRolls());
		return "game";
	}
	
	@GetMapping("/players/ranking")
	public String getRanking(Player player, @PathVariable("id") int id, Model model) {
		playerService.modifyPlayer(player);
		model.addAttribute("Player", player);
		model.addAttribute("hashmap", player.getRolls());
		return "game";
	}
	
	@GetMapping("/players/")
	public String getPlayersInfo( Model model) {
		List<Player>players= (ArrayList<Player>) playerService.getPlayers();
		model.addAttribute("players", players);
		
		return "players";
	}
	
	@GetMapping("/players/ranking/loser")
	public String getLoser(Player player, @PathVariable("id") int id, Model model) {
		playerService.modifyPlayer(player);
		model.addAttribute("Player", player);
		model.addAttribute("hashmap", player.getRolls());
		return "game";
	}
	
	@GetMapping("/players/ranking/winner")
	public String getWinner(Player player, @PathVariable("id") int id, Model model) {
		playerService.modifyPlayer(player);
		model.addAttribute("Player", player);
		model.addAttribute("hashmap", player.getRolls());
		return "game";
	}
	
	
	
}
