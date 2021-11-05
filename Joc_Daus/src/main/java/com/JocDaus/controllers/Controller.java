package com.JocDaus.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.JocDaus.models.Player;
import com.JocDaus.services.DiceService;
import com.JocDaus.services.GameService;
import com.JocDaus.services.PlayerService;

@RestController
@RequestMapping("/")
public class Controller {
	
	
	
	
	
	@GetMapping("/login")
	public String start(Model model) {
		model.addAttribute("titulo", "Introduce your credentials");
		return "login";
	}
	
	
	@PostMapping("/players")
	public String createPlayer(@RequestParam String name,Model model) {
		
		playerService.createPlayer(name);
		model.addAttribute("button", "Create Player");
		model.addAttribute("action", "/players");
		return "Jugador añadido con éxito";
		
	}
	
	@PutMapping("/players")
	public String modifyPlayer(Model model, Player player) {
		
		
		model.addAttribute("button", "Update Player");
		model.addAttribute("action", "/players");
		return "";
		
	}
	
	
	@PostMapping("/players/{id}/games")
	public String rollDice(Model model, Player player1, Player player2) {
		
		
		model.addAttribute("button", "Create Player");
		model.addAttribute("action", "/players/{id}/games");
		return "";
		
	}
	
	@DeleteMapping("/players/{id}/games")
	public String deleteRolls(Model model, Player player) {
		
		
		model.addAttribute("button", "Create Player");
		model.addAttribute("action", "/players/{id}/games");
		return "";
		
	}
	
	
	@GetMapping("/players/{id}/games")
	public String getRolls(Model model, Player player) {
		
		
		model.addAttribute("button", "Create Player");
		model.addAttribute("action", "/players/{id}/games");
		return "";
		
	}
	
	@GetMapping("/players/")
	public ArrayList<Player> getPlayersInfo(Model model) {
		
		
		model.addAttribute("button", "Create Player");
		model.addAttribute("action", "/players/");
		return playerService.getPlayers();
		
	}
	
	@GetMapping("/players/ranking")
	public String getPlayersWinRate(Model model) {
		
		
		model.addAttribute("button", "Create Player");
		model.addAttribute("action", "/players/ranking");
		return "";
		
	}
	
	@GetMapping("/players/ranking/loser")
	public String getLoser(Model model) {
		
		
		model.addAttribute("button", "Create Player");
		model.addAttribute("action", "/players/ranking");
		return "";
		
	}
	@GetMapping("/players/ranking/winner")
	public String getWinner(Model model, Player player) {
		
		
		model.addAttribute("button", "Create Player");
		model.addAttribute("action", "/players/ranking");
		return "";
		
	}
	
	
	
}
