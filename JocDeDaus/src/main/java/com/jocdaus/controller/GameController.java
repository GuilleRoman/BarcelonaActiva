package com.jocdaus.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
//	@GetMapping("/")
//	public String start(Model model) {
//		model.addAttribute("button","/players" );
//		model.addAttribute("button1","/" );
//		model.addAttribute("player", new Player());
//		model.addAttribute("players", playerService.getPlayers());
//		return "login";
//	}
//	
//	
//	@PostMapping("/players")
//	public String createPlayer(Player player, Model model) {
//		
//		playerService.createPlayer(player);
//		
//		Dice dice1= new Dice(player);
//		Dice dice2= new Dice(player);
//		
//		playerService.update(player);
//		diceService.createDice(dice1);
//		diceService.createDice(dice2);
//		
//		model.addAttribute("players", playerService.getPlayers());
//		model.addAttribute("player", player);
//		
//		return "players";
//	}
//	
//	@PutMapping("/players")
//	public void modifyPlayer(Player player, Model model) {
//		playerService.modifyPlayer(player);
//		model.addAttribute("Player", player);
//	}
//	
//	@PostMapping("/players/{id}/games/")
//	public String rollDices( @PathVariable int id, Model model) {
//		Player player;
//		Optional<Player> optionalPlayer= playerService.searchById(id);
//		player= optionalPlayer.get();
//		
//		Game game = new Game(player);
//		gameService.save(game);
//		
//		Roll roll = new Roll (game, player);
//		rollService.save(roll);
//		roll.rollDices();
//		gameService.save(game);
//		rollService.save(roll);
//		playerService.update(player);
//		
//		
//		if(optionalPlayer.isPresent()) {
//			List<Roll> rolls= player.getRolls();
//			model.addAttribute("player", player);
//			model.addAttribute("game", roll.getGame());
//			model.addAttribute("rolls",rolls);
//
//			return "game";
//		}
//		return "game";
//	}
//	
//	@GetMapping("/players/{id}/games/")
//	public String getPlayerRolls( @PathVariable int id, Model model) {
//		
//		Player player;
//		Optional<Player> optionalPlayer= playerService.searchById(id);
//		
//		if(optionalPlayer.isPresent()) {
//			player= optionalPlayer.get();
//			List<Roll> rolls= player.getRolls();
//			model.addAttribute("rolls", rolls);
//			model.addAttribute("dices", player.getDices());
//			model.addAttribute("player", player);
//			model.addAttribute("game", new Game());
//			
//			return "game";
//		}
//		return "game";
//	}
//	
//	@GetMapping("/players/ranking")
//	public String getRanking( Model model) {
//		ArrayList<Player>players=  (ArrayList<Player>) playerService.getPlayers();
//		playerService.calculateRanking(players, rollService, gameService);
//		model.addAttribute("players", players);
//		
//		return "ranking";
//	}
//	
//	@GetMapping("/players/")
//	public String getPlayersInfo( Model model) {
//		List<Player>players= (ArrayList<Player>) playerService.getPlayers();
//		model.addAttribute("players", players);
//		model.addAttribute("button1","/" );
//		return "players";
//	}
//	
//	@GetMapping("/players/ranking/loser")
//	public String getLoser( Model model) {
//		List<Player>players= new ArrayList<Player>();
//		Player player = playerService.getLoser();
//		players.add(player);
//		int timesRolled=0;
//		int timesWon=0;
//		for(Roll r: player.getRolls()) {
//			timesRolled++;
//			if(r.getGame().getWinner()== null) {
//				continue;
//				
//			}else if (r.getGame().getWinner().matches(player.getName())) {
//				timesWon++;
//				
//			}
//		}
//
//		model.addAttribute("player", player);
//		model.addAttribute("players", players);
//		model.addAttribute("timesRolled", timesRolled);
//		model.addAttribute("timesWon", timesWon);
//		return "winner-loser";
//	}
//	
//	@GetMapping("/players/ranking/winner")
//	public String getWinner( Model model) {
//		List<Player>players= new ArrayList<Player>();
//		Player player = playerService.getWinner();
//		players.add(player);
//		int timesRolled=0;
//		int timesWon=0;
//		for(Roll r: player.getRolls()) {
//			timesRolled++;
//			if(r.getGame().getWinner()== null) {
//				continue;
//				
//			}else if (r.getGame().getWinner().matches(player.getName())) {
//				timesWon++;
//				
//			}
//		}
//		model.addAttribute("Player", player);
//		model.addAttribute("players", players);
//		model.addAttribute("timesRolled", timesRolled);
//		model.addAttribute("timesWon", timesWon);
//		return "winner-loser";
//	}
  	@PostMapping("/player")
  	public ResponseEntity<Player> createPlayer(@RequestBody Player player) {	
  		
  		return ResponseEntity.ok(playerService.createNewPlayer(player));
  	}
  	//Modifica un jugador existente
  	@PutMapping("/players")
  	public ResponseEntity<Player> modifyPlayer(@RequestBody Player player) {
  		playerService.modifyPlayer(player);
  		return ResponseEntity.ok(player);
  	}
  	
  	//Lanza los dados de un jugador
  	@PostMapping("/player/{id}/games/")
  	public ResponseEntity<Roll> rollDices(@PathVariable(name="id") Integer id) {
  		Player player;
  		
  		Optional<Player> optionalPlayer= playerService.searchById(id);
  		if(optionalPlayer.isPresent()) ;
  		player= optionalPlayer.get();
  		
  		Game game = new Game();
  		game.setPlayer(player);
  		gameService.save(game);
  		
  		Roll roll = new Roll(game,player);
  		roll.rollDices();
  		rollService.save(roll);

  		return ResponseEntity.ok(roll);
  }
  	//Muestra las jugadas de un jugador
  	@GetMapping("/players/{id}/games/")
  	public  ResponseEntity<List<Roll>> getPlayerRolls( @PathVariable Integer id) {
  		
  		List<Roll> games= rollService.getRollsByPlayerId(id);
  			
  		return ResponseEntity.ok(games);
  	}
  	//Muestra el ranking de jugadores
  	@GetMapping("/players/ranking")
  	public ResponseEntity<ArrayList<Player>> getRanking() {
  		ArrayList<Player>players= (ArrayList<Player>) playerService.getPlayers();
  		playerService.calculateRanking(players, rollService, gameService);
  		
  		return ResponseEntity.ok(players);
  	}
  	//Muestra a todos los jugadores
  	@GetMapping("/players/")
  	public ResponseEntity<List<Player>> getPlayersInfo() {
  		List<Player>players= new ArrayList<Player>();
  		players= playerService.getPlayers();

  		return ResponseEntity.ok(players);
  	}
  	//Muestra al jugador con menor winRate (índice de victorias)
  	@GetMapping("/players/ranking/loser")
  	public ResponseEntity<Player> getLoser() {
  		Player player = playerService.getLoser();

  			return	ResponseEntity.ok(player)	;
  	}
  	//Muestra al jugador con mayor winRate (índice de victorias)
  	@GetMapping("/players/ranking/winner")
  	public ResponseEntity<Player> getWinner() {
  		Player player = playerService.getWinner();

  			return	ResponseEntity.ok(player)	;
  	}
  	//Borra las tiradas de un jugador
  	@DeleteMapping("/players/{id}/games")
  	public ResponseEntity<String> deleteRolls(@PathVariable Integer id) {

  		rollService.deleteAllPlayerGamesById(id);
  		
  			return	ResponseEntity.ok("Partidas eliminadas correctamente")	;
  	}
	
	
}
