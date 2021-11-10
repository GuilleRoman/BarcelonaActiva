package com.jocdaus.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jocdaus.models.Game;
import com.jocdaus.models.Player;
import com.jocdaus.models.Roll;
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
	public String start(Model model) {
		model.addAttribute("button","/players" );
		model.addAttribute("button1","/" );
		model.addAttribute("player", new Player());
		model.addAttribute("players", playerService.getPlayers());
		return "login";
	}
	
//	@PostMapping("/")
//	public String login(Model model, Player player) {
//		model.addAttribute("player", new Player() );
//		model.addAttribute("button","/players" );
//		model.addAttribute("button1","/" );
//		return "login";
//	}
	
	
	@PostMapping("/players")
	public String createPlayer(Player player, Model model) {
		model.addAttribute("button1","/" );
		playerService.createPlayer(player);
		model.addAttribute("players", playerService.getPlayers());
		model.addAttribute("Player", player);
		return "players";
	}
	
	@PutMapping("/players")
	public void modifyPlayer(Player player, Model model) {
		playerService.modifyPlayer(player);
		model.addAttribute("Player", player);
	}
	
	@PostMapping("/players/{id}/games/")
	public String rollDices( @PathVariable("id") int id, Model model) {
	
		Player player;
		Optional<Player> optionalPlayer= playerService.searchById(id);
		
		if(optionalPlayer.isPresent()) {
			player= optionalPlayer.get();
			player.rollDices();
			model.addAttribute("dices", player.getDices());
			model.addAttribute("player", player);
			model.addAttribute("game", new Game());
			List<Roll> rolls =  player.getRolls();
			model.addAttribute("rolls", rolls);
			return "game";
		}
		return "game";
	}
	
	@GetMapping("/players/{id}/games/")
	public String getPlayerRolls( @PathVariable("id") int id, Model model) {
		Player player;
		Optional<Player> optionalPlayer= playerService.searchById(id);
		if(optionalPlayer.isPresent()) {
			player= optionalPlayer.get();
			List<Roll> rolls = player.getRolls();
			model.addAttribute("rolls", rolls);
			model.addAttribute("dices", player.getDices());
			model.addAttribute("player", player);
			model.addAttribute("game", new Game());
			
			return "game";
		}
		return "game";
	}
	
	@GetMapping("/players/ranking")
	public String getRanking(Player player, @PathVariable("id") int id, Model model) {
		playerService.modifyPlayer(player);
		model.addAttribute("Player", player);
		
		return "game";
	}
	
	@GetMapping("/players/")
	public String getPlayersInfo( Model model) {
		List<Player>players= (ArrayList<Player>) playerService.getPlayers();
		model.addAttribute("players", players);
		model.addAttribute("button1","/" );
		return "players";
	}
	
	@GetMapping("/players/ranking/loser")
	public String getLoser(Player player, @PathVariable("id") int id, Model model) {
		playerService.modifyPlayer(player);
		model.addAttribute("Player", player);
		
		return "game";
	}
	
	@GetMapping("/players/ranking/winner")
	public String getWinner(Player player, @PathVariable("id") int id, Model model) {
		playerService.modifyPlayer(player);
		model.addAttribute("Player", player);
		
		return "game";
	}
	
	
	
}
