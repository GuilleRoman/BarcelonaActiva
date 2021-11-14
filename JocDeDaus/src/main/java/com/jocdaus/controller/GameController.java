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
import com.jocdaus.models.Dice;
import com.jocdaus.models.Game;
import com.jocdaus.models.Player;
import com.jocdaus.models.Roll;
import com.jocdaus.services.DiceService;
import com.jocdaus.services.GameService;
import com.jocdaus.services.PlayerService;
import com.jocdaus.services.RollService;

@Controller
@RequestMapping("")
public class GameController {
	
	
	@Autowired
	PlayerService playerService;
	@Autowired
	GameService gameService;
	@Autowired
	DiceService diceService;
	@Autowired
	RollService rollService;
	
	@GetMapping("/")
	public String start(Model model) {
		model.addAttribute("button","/players" );
		model.addAttribute("button1","/" );
		model.addAttribute("player", new Player());
		model.addAttribute("players", playerService.getPlayers());
		return "login";
	}
	
	
	@PostMapping("/players")
	public String createPlayer(Player player, Model model) {
		
		playerService.createPlayer(player);
		
		Dice dice1= new Dice(player);
		Dice dice2= new Dice(player);
		
		playerService.update(player);
		diceService.createDice(dice1);
		diceService.createDice(dice2);
		
		model.addAttribute("players", playerService.getPlayers());
		model.addAttribute("player", player);
		
		return "players";
	}
	
	@PutMapping("/players")
	public void modifyPlayer(Player player, Model model) {
		playerService.modifyPlayer(player);
		model.addAttribute("Player", player);
	}
	
	@PostMapping("/players/{id}/games/")
	public String rollDices( @PathVariable int id, Model model) {
		Player player;
		Optional<Player> optionalPlayer= playerService.searchById(id);
		player= optionalPlayer.get();
		
		Game game = new Game(player);
		gameService.save(game);
		
		Roll roll = new Roll (game, player);
		rollService.save(roll);
		roll.rollDices();
		gameService.save(game);
		rollService.save(roll);
		playerService.update(player);
		
		
		if(optionalPlayer.isPresent()) {
			List<Roll> rolls= player.getRolls();
			model.addAttribute("player", player);
			model.addAttribute("game", roll.getGame());
			model.addAttribute("rolls",rolls);

			return "game";
		}
		return "game";
	}
	
	@GetMapping("/players/{id}/games/")
	public String getPlayerRolls( @PathVariable int id, Model model) {
		
		Player player;
		Optional<Player> optionalPlayer= playerService.searchById(id);
		
		if(optionalPlayer.isPresent()) {
			player= optionalPlayer.get();
			List<Roll> rolls= player.getRolls();
			model.addAttribute("rolls", rolls);
			model.addAttribute("dices", player.getDices());
			model.addAttribute("player", player);
			model.addAttribute("game", new Game());
			
			return "game";
		}
		return "game";
	}
	
	@GetMapping("/players/ranking")
	public String getRanking( Model model) {
		List<Player>players= (ArrayList<Player>) playerService.getPlayers();
		int timesRolled=0;
		int timesWon=0;
		double winRate=0;
		for (Player p: players) {
			timesRolled =rollService.countTimesRolled(p.getId());
			timesWon = gameService.countTimesWon(p.getName());
			winRate = (timesWon/(double)timesRolled)*100;
			
			winRate = (double)Math.round(winRate * 100d) / 100d;
			p.setWinRate(winRate);
			playerService.update(p);
		}
		
		
		model.addAttribute("players", players);
		model.addAttribute("timesRolled", timesRolled);
		model.addAttribute("timesWon", timesWon);
//		model.addAttribute("winRate", winRate);
		
		return "ranking";
	}
	
	@GetMapping("/players/")
	public String getPlayersInfo( Model model) {
		List<Player>players= (ArrayList<Player>) playerService.getPlayers();
		model.addAttribute("players", players);
		model.addAttribute("button1","/" );
		return "players";
	}
	
	@GetMapping("/players/ranking/loser")
	public String getLoser( Model model) {
		List<Player>players= new ArrayList<Player>();
		Player player = playerService.getLoser();
		players.add(player);
		int timesRolled=0;
		int timesWon=0;
		for(Roll r: player.getRolls()) {
			timesRolled++;
			if(r.getGame().getWinner()== null) {
				continue;
				
			}else if (r.getGame().getWinner().matches(player.getName())) {
				timesWon++;
				
			}
		}
//		int timesRolled =rollService.countTimesRolled(p.getId());
//		int timesWon = gameService.countTimesWon(player.getName());
		model.addAttribute("player", player);
		model.addAttribute("players", players);
		model.addAttribute("timesRolled", timesRolled);
		model.addAttribute("timesWon", timesWon);
		return "ranking";
	}
	
	@GetMapping("/players/ranking/winner")
	public String getWinner( Model model) {
		List<Player>players= new ArrayList<Player>();
		Player player = playerService.getWinner();
		players.add(player);
		int timesRolled=0;
		int timesWon=0;
		for(Roll r: player.getRolls()) {
			timesRolled++;
			if(r.getGame().getWinner()== null) {
				continue;
				
			}else if (r.getGame().getWinner().matches(player.getName())) {
				timesWon++;
				
			}
		}
		model.addAttribute("Player", player);
		model.addAttribute("players", players);
		model.addAttribute("timesRolled", timesRolled);
		model.addAttribute("timesWon", timesWon);
		return "ranking";
	}
	
	
	
}
