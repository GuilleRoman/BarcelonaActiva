package com.juegodados.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.juegodados.documents.Game;
import com.juegodados.services.GlobalService;
import com.juegodados.entities.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PlayerController {

    @Autowired
    GlobalService globalService;

//    @RequestMapping(value = "info", method = RequestMethod.GET)
//    public String info(){
//        return "The application is up...";
//    }
//
//    @RequestMapping(value = "createresource", method = RequestMethod.POST)
//    public String createStudent(@RequestBody PlayerModel playerModel){
//        return globalService.createResource(playerModel);
//    }
//
//    @RequestMapping(value = "readresources", method = RequestMethod.GET)
//    public List<PlayerModel> readResources(){
//        return globalService.readResources();
//    }
//
//    @RequestMapping(value = "updateresource", method = RequestMethod.PUT)
//    public String updateStudent(@RequestBody PlayerModel playerModel){
//        return globalService.updateResource(playerModel);
//    }
//
//    @RequestMapping(value = "deleteresource", method = RequestMethod.DELETE)
//    public String deleteStudent(@RequestBody PlayerModel playerModel){
//        return globalService.deleteResource(playerModel);
//    }
//    @GetMapping("/")
//	public String start(Model model) {
//		model.addAttribute("button","/players" );
//		model.addAttribute("button1","/" );
//		model.addAttribute("player", new Player());
////		model.addAttribute("players", globalService.readResources());
//		return "login";
//	}
//	
//	
//	@PostMapping("/players")
//	public String createPlayer(PlayerModel player, Model model) {
//		
//		globalService.createResource(player);
//	
//		
//		model.addAttribute("players", globalService.getPlayers());
//		model.addAttribute("player", player);
//		
//		return "players";
//	}
//	
//	@PutMapping("/players")
//	public void modifyPlayer(PlayerModel player, Model model) {
//		globalService.modifyPlayer(player);
//		model.addAttribute("Player", player);
//	}
//	
//	@PostMapping("/players/{id}/games/")
//	public String rollDices( @PathVariable int id, Model model) {
//		Player player;
//		PlayerModel playerModel= new PlayerModel();
//		Optional<Player> optionalPlayer= globalService.searchById(id);
//		if(optionalPlayer.isPresent()) {
//		player= optionalPlayer.get();
//		BeanUtils.copyProperties(player, playerModel);
//		Game game = new Game();
//		game.setPlayerName(player.getName());
//		player.rollDices(game);
//		globalService.save(game);
//		globalService.update(player);
//		List<Game> games = globalService.getGamesByPlayer(player.getName());
//		
//		
//			
//			model.addAttribute("player", player);
//			model.addAttribute("game", game);
//			model.addAttribute("games",games);
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
//		PlayerModel playerModel= new PlayerModel();
//		Optional<Player> optionalPlayer= globalService.searchById(id);
//		if(optionalPlayer.isPresent()) {
//		player= optionalPlayer.get();
//		BeanUtils.copyProperties(player, playerModel);
//		List<Game> games = globalService.getGamesByPlayer(player.getName());
//			
//			model.addAttribute("games", games);
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
//		ArrayList<Player>players= globalService.getPlayers();
//		globalService.calculateRanking(players);
//		model.addAttribute("players", players);
//		return "ranking";
//	}
//	
//	@GetMapping("/players/")
//	public String getPlayersInfo( Model model) {
//		List<PlayerModel>playerModels= (ArrayList<PlayerModel>) globalService.readResources();
//		List<Player>players= new ArrayList<Player>();
//		BeanUtils.copyProperties(playerModels, players);
//		model.addAttribute("players", players);
//		model.addAttribute("button1","/" );
//		return "players";
//	}
//	
//	@GetMapping("/players/ranking/loser")
//	public String getLoser( Model model) {
//		List<Player>players= new ArrayList<Player>();
//	
//		Player player = globalService.getLoser();
//	
//		players.add(player);
//		int timesRolled=globalService.countGamesPlayed(player);
//		int timesWon=globalService.countWins(player);
//		model.addAttribute("Player", player);
//		model.addAttribute("players", players);
//		model.addAttribute("timesRolled", timesRolled);
//		model.addAttribute("timesWon", timesWon);
//		return "winner-loser";
//	}
//	
//	@GetMapping("/players/ranking/winner")
//	public String getWinner( Model model) {
//		List<Player>players= new ArrayList<Player>();
//		
//		Player player = globalService.getWinner();
//	
//		players.add(player);
//		int timesRolled=globalService.countGamesPlayed(player);
//		int timesWon=globalService.countWins(player);
//		model.addAttribute("Player", player);
//		model.addAttribute("players", players);
//		model.addAttribute("timesRolled", timesRolled);
//		model.addAttribute("timesWon", timesWon);
//		return "winner-loser";
//	}
    
    //Crea un nuevo jugador
  	@PostMapping("/player")
  	public ResponseEntity<Player> createPlayer(@RequestBody Player player) {	
  		globalService.savePlayer(player);
  	return ResponseEntity.ok(player);
  	}
  	//Modifica un jugador existente
  	@PutMapping("/players")
  	public ResponseEntity<Player> modifyPlayer(@RequestBody Player player) {
  		globalService.modifyPlayer(player);
  		return ResponseEntity.ok(player);
  	}
  	
  	//Lanza los dados de un jugador
  	@PostMapping("/player/{id}/games/")
  	public ResponseEntity<List<Game>> rollDices(@PathVariable(name="id") Integer id) {
  		Player player;
  		
  		Optional<Player> optionalPlayer= globalService.searchById(id);
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
  	@GetMapping("/players/{id}/games/")
  	public  ResponseEntity<List<Game>>getPlayerRolls( @PathVariable Integer id) {
  		
  		Player player;
  		Optional<Player> optionalPlayer= globalService.searchById(id);
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
  	@DeleteMapping("/players/{id}/games")
  	public ResponseEntity<Player> deleteRolls(@PathVariable Integer id) {
  		Optional<Player> optionalPlayer= globalService.searchById(id);;
  		Player player = optionalPlayer.get();
  		List<Game> games = globalService.getGamesByPlayer(player.getName());
  		globalService.deleteAllPlayerGames( games);

  			return	ResponseEntity.ok(player)	;
  	}
}