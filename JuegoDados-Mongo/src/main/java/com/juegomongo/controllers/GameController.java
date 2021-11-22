package com.juegomongo.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.juegomongo.documents.Game;
import com.juegomongo.documents.Player;
import com.juegomongo.services.GlobalService;

@RestController
public class GameController {

    @Autowired
    GlobalService globalService;

  //Crea un nuevo jugador
  	@PostMapping("/player")
  	public ResponseEntity<Player> createPlayer(@RequestBody Player player) {	
  		globalService.save(player);
  	return ResponseEntity.ok(player);
  	}
  	//Modifica un jugador existente
  	@PutMapping("/players")
  	public ResponseEntity<Player> modifyPlayer(@RequestBody Player player) {
  		globalService.modifyPlayer(player);
  		return ResponseEntity.ok(player);
  	}
  	
  	//Lanza los dados de un jugador
  	@PostMapping("/player/{name}/games/")
  	public ResponseEntity<List<Game>> rollDices(@PathVariable(name="name") String name) {
  		Player player;
  		
  		Optional<Player> optionalPlayer= globalService.searchByName(name);
  		if(optionalPlayer.isPresent()) ;
  		player= optionalPlayer.get();
  		
  		Game game = new Game();
  		game.setPlayerName(player.getName());
  		player.rollDices(game);
  		globalService.save(game);
  		
  		List<Game> games = globalService.getGamesByPlayer(player.getName());
  		
  		return ResponseEntity.ok(games);
  }
  	//Muestra las jugadas de un jugador
  	@GetMapping("/players/{name}/games/")
  	public  ResponseEntity<List<Game>>getPlayerRolls( @PathVariable String name) {
  		
  		Player player;
  		Optional<Player> optionalPlayer= globalService.searchByName(name);
  		if(optionalPlayer.isPresent());
  		player= optionalPlayer.get();
  		
  		List<Game> games = globalService.getGamesByPlayer(player.getName());
  			
  		return ResponseEntity.ok(games);
  	}
  	//Muestra el ranking de jugadores
  	@GetMapping("/players/ranking")
  	public ResponseEntity<ArrayList<Player>> getRanking() {
  		ArrayList<Player>players= globalService.getPlayers();
  		globalService.calculateRanking(players);
  		
  		return ResponseEntity.ok(players);
  	}
  	//Muestra a todos los jugadores
  	@GetMapping("/players/")
  	public ResponseEntity<List<Player>> getPlayersInfo() {
  		List<Player>players= new ArrayList<Player>();
  		players= globalService.getPlayers();

  		return ResponseEntity.ok(players);
  	}
  	//Muestra al jugador con menor winRate (índice de victorias)
  	@GetMapping("/players/ranking/loser")
  	public ResponseEntity<Player> getLoser() {
  		Player player = globalService.getLoser();

//  		int timesRolled=globalService.countGamesPlayed(player);
//  		int timesWon=globalService.countWins(player);

  			return	ResponseEntity.ok(player)	;
  	}
  	//Muestra al jugador con mayor winRate (índice de victorias)
  	@GetMapping("/players/ranking/winner")
  	public ResponseEntity<Player> getWinner() {
  		Player player = globalService.getWinner();

  			return	ResponseEntity.ok(player)	;
  	}
  	//Borra las tiradas de un jugador
  	@DeleteMapping("/players/{name}/games")
  	public ResponseEntity<Player> deleteRolls(@PathVariable String name) {
  		Optional<Player> optionalPlayer= globalService.searchByName(name);
  		Player player = optionalPlayer.get();
  		List<Game> games = globalService.getGamesByPlayer(player.getName());
  		globalService.deleteAllPlayerGames( games);

  			return	ResponseEntity.ok(player)	;
  	}
}
