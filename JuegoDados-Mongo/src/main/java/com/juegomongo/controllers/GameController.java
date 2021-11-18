package com.juegomongo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.juegomongo.documents.Game;
import com.juegomongo.documents.Player;
import com.juegomongo.services.GlobalService;

@Controller
public class GameController {

    @Autowired
    GlobalService globalService;


    @GetMapping("/")
	public String start(Model model) {
		model.addAttribute("button","/players" );
		model.addAttribute("button1","/" );
		model.addAttribute("player", new Player());
//		model.addAttribute("players", globalService.readResources());
		return "login";
	}
	
	
	@PostMapping("/players")
	public String createPlayer(Player player, Model model) {
		
		globalService.save(player);
	
		
		model.addAttribute("players", globalService.getPlayers());
		model.addAttribute("player", player);
		
		return "players";
	}
	
	@PutMapping("/players")
	public void modifyPlayer(Player player, Model model) {
		globalService.modifyPlayer(player);
		model.addAttribute("Player", player);
	}
	
	@PostMapping("/players/{player_id}/games/")
	public String rollDices( @PathVariable String player_id, Model model) {
		Player player;
		
		Optional<Player> optionalPlayer= globalService.searchById(player_id);
		if(optionalPlayer.isPresent()) {
		player= optionalPlayer.get();
		
		Game game = new Game();
		game.setPlayerName(player.getName());
		player.rollDices(game);
		globalService.save(game);
		globalService.update(player);
		List<Game> games = globalService.getGamesByPlayer(player.getName());
		
		
			
			model.addAttribute("player", player);
			model.addAttribute("game", game);
			model.addAttribute("games",games);

			return "game";
		}
		return "game";
	}
	
	@GetMapping("/players/{player_id}/games/")
	public String getPlayerRolls( @PathVariable String id, Model model) {
		
		Player player;
		Optional<Player> optionalPlayer= globalService.searchById(id);
		if(optionalPlayer.isPresent()) {
		player= optionalPlayer.get();
		
		List<Game> games = globalService.getGamesByPlayer(player.getName());
			
			model.addAttribute("games", games);
			model.addAttribute("player", player);
			model.addAttribute("game", new Game());
			
			return "game";
		}
		return "game";
	}
	
	@GetMapping("/players/ranking")
	public String getRanking( Model model) {
		ArrayList<Player>players= globalService.getPlayers();
		globalService.calculateRanking(players);
		model.addAttribute("players", players);
		return "ranking";
	}
	
	@GetMapping("/players/")
	public String getPlayersInfo( Model model) {
		List<Player>players= new ArrayList<Player>();
		players= globalService.getPlayers();
		model.addAttribute("players", players);
		model.addAttribute("button1","/" );
		return "players";
	}
	
	@GetMapping("/players/ranking/loser")
	public String getLoser( Model model) {
		List<Player>players= new ArrayList<Player>();
	
		Player player = globalService.getLoser();
	
		players.add(player);
		int timesRolled=globalService.countGamesPlayed(player);
		int timesWon=globalService.countWins(player);
		model.addAttribute("Player", player);
		model.addAttribute("players", players);
		model.addAttribute("timesRolled", timesRolled);
		model.addAttribute("timesWon", timesWon);
		return "winner-loser";
	}
	
	@GetMapping("/players/ranking/winner")
	public String getWinner( Model model) {
		List<Player>players= new ArrayList<Player>();
		
		Player player = globalService.getWinner();
	
		players.add(player);
		int timesRolled=globalService.countGamesPlayed(player);
		int timesWon=globalService.countWins(player);
		model.addAttribute("Player", player);
		model.addAttribute("players", players);
		model.addAttribute("timesRolled", timesRolled);
		model.addAttribute("timesWon", timesWon);
		return "winner-loser";
	}

	
}
