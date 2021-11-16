package com.juegodados.controllers;

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
import com.juegodados.documents.Game;
import com.juegodados.entities.*;
import com.juegodados.models.GameModel;
import com.juegodados.models.PlayerModel;
import com.juegodados.services.GlobalService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class PlayerController {

    @Autowired
    GlobalService globalService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info(){
        return "The application is up...";
    }

    @RequestMapping(value = "createresource", method = RequestMethod.POST)
    public String createStudent(@RequestBody PlayerModel playerModel){
        return globalService.createResource(playerModel);
    }

    @RequestMapping(value = "readresources", method = RequestMethod.GET)
    public List<PlayerModel> readResources(){
        return globalService.readResources();
    }

    @RequestMapping(value = "updateresource", method = RequestMethod.PUT)
    public String updateStudent(@RequestBody PlayerModel playerModel){
        return globalService.updateResource(playerModel);
    }

    @RequestMapping(value = "deleteresource", method = RequestMethod.DELETE)
    public String deleteStudent(@RequestBody PlayerModel playerModel){
        return globalService.deleteResource(playerModel);
    }
    @GetMapping("/")
	public String start(Model model) {
		model.addAttribute("button","/players" );
		model.addAttribute("button1","/" );
		model.addAttribute("player", new Player());
//		model.addAttribute("players", globalService.readResources());
		return "login";
	}
	
	
	@PostMapping("/players")
	public String createPlayer(PlayerModel player, Model model) {
		
		globalService.createResource(player);
	
		
		model.addAttribute("players", globalService.readResources());
		model.addAttribute("player", player);
		
		return "players";
	}
	
	@PutMapping("/players")
	public void modifyPlayer(PlayerModel player, Model model) {
		globalService.modifyPlayer(player);
		model.addAttribute("Player", player);
	}
	
	@PostMapping("/players/{id}/games/")
	public String rollDices( @PathVariable int id, Model model) {
		Player player;
		PlayerModel playerModel= new PlayerModel();
		Optional<Player> optionalPlayer= globalService.searchById(id);
		if(optionalPlayer.isPresent()) {
		player= optionalPlayer.get();
		BeanUtils.copyProperties(player, playerModel);
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
	
	@GetMapping("/players/{id}/games/")
	public String getPlayerRolls( @PathVariable int id, Model model) {
		
		Player player;
		PlayerModel playerModel= new PlayerModel();
		Optional<Player> optionalPlayer= globalService.searchById(id);
		if(optionalPlayer.isPresent()) {
		player= optionalPlayer.get();
		BeanUtils.copyProperties(player, playerModel);
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
		List<PlayerModel> playerModels= new ArrayList<PlayerModel>(); 
		List<Player> players = globalService.getPlayers();
		BeanUtils.copyProperties(players, playerModels);
		
		int timesRolled=0;
		int timesWon=0;
		double winRate;
		for(Player p: players) {
			timesRolled=globalService.countGamesPlayed(p);
			timesWon=globalService.countWins(p);
			winRate = (timesWon/(double)timesRolled)*100;
			winRate = (double)Math.round(winRate * 100d) / 100d;
			p.setWinRate(winRate);
			globalService.update(p);
			
			
		}
//		BeanUtils.copyProperties(playerModels, players);
		
		
		model.addAttribute("players", players);
		model.addAttribute("timesRolled", timesRolled);
		model.addAttribute("timesWon", timesWon);

		
		return "ranking";
	}
	
	@GetMapping("/players/")
	public String getPlayersInfo( Model model) {
		List<PlayerModel>playerModels= (ArrayList<PlayerModel>) globalService.readResources();
		List<Player>players= new ArrayList<Player>();
		BeanUtils.copyProperties(playerModels, players);
		model.addAttribute("players", players);
		model.addAttribute("button1","/" );
		return "players";
	}
	
	@GetMapping("/players/ranking/loser")
	public String getLoser( Model model) {
		List<Player>players= new ArrayList<Player>();
		PlayerModel playerModel= new PlayerModel();
		Player player = globalService.getLoser();
		BeanUtils.copyProperties(player, playerModel);
		players.add(player);
		int timesRolled=0;
		int timesWon=0;
		for(GameModel g: playerModel.getGamesPlayed()) {
			timesRolled++;
			if(g.getWinner()== null) {
				continue;
				
			}else if (g.getWinner().matches(player.getName())) {
				timesWon++;
				
			}
		}
		model.addAttribute("Player", player);
		model.addAttribute("players", players);
		model.addAttribute("timesRolled", timesRolled);
		model.addAttribute("timesWon", timesWon);
		return "ranking";
	}
	
	@GetMapping("/players/ranking/winner")
	public String getWinner( Model model) {
		List<Player>players= new ArrayList<Player>();
		PlayerModel playerModel= new PlayerModel();
		Player player = globalService.getWinner();
		BeanUtils.copyProperties(player, playerModel);
		players.add(player);
		int timesRolled=0;
		int timesWon=0;
		for(GameModel g: playerModel.getGamesPlayed()) {
			timesRolled++;
			if(g.getWinner()== null) {
				continue;
				
			}else if (g.getWinner().matches(player.getName())) {
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