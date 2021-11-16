package com.juegodados.services;

import java.util.ArrayList;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.juegodados.documents.Game;
import com.juegodados.entities.Player;
import com.juegodados.models.GameModel;
import com.juegodados.models.PlayerModel;
import com.juegodados.repositories.GameRepository;
import com.juegodados.repositories.PlayerRepository;

@Service
public class GlobalService {
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    GameRepository gameRepository;
    
    @Autowired
	MongoTemplate mongoTemplate;
    
    public String createResource(PlayerModel playerModel){
        if (!playerRepository.existsByName(playerModel.getName())){
            Player player = new Player();
            BeanUtils.copyProperties(playerModel, player);
            try {
                playerRepository.save(player);
//                playerModel.getGamesPlayed().stream().forEach(c -> {
//                    Game game = new Game();
//                    c.setPlayerName(playerModel.getName());
//                    BeanUtils.copyProperties(c, game);
//                    try {
//                        gameRepository.save(game);
//                    }catch (Exception e){
//                        throw e;
//                    }
//
//                });
            }catch (Exception e){
                throw e;
            }

            return "Resource added successfully!";
        }else {
            return "Duplicate resource";
        }
    }

    public List<PlayerModel> readResources(){
        List<PlayerModel> players = new ArrayList<>();
        List<Player> playerList = new ArrayList<>();
        try {
            playerList = playerRepository.findAll(); //Fetch all the Students from the database.
        }catch (Exception e){
            throw e;
        }

        if (playerList.size() > 0){ //If the above list is not empty then return the list after unwrapping all the records
            playerList.stream().forEach(s -> { //Traverse through the reords
                PlayerModel playerModel = new PlayerModel();
                playerModel.setName(s.getName());
                playerModel.setRegisterDate(s.getRegisterDate());
                playerModel.setWinRate(s.getWinRate());
                List<Game> gameList = new ArrayList<>();
                List<GameModel> games = new ArrayList<>();
                try {
                   gameList = gameRepository.findByPlayerName(s.getName()); //Fetch all the courses by email ID.
                }catch (Exception e){
                    throw e;
                }
                if (gameList.size() > 0){
                    gameList.stream().forEach(c -> {
                        GameModel gameModel = new GameModel();
                        BeanUtils.copyProperties(c, gameModel);
                        games.add(gameModel);
                    });
                }
                playerModel.setGamesPlayed(games);
                players.add(playerModel);
            });
        }
        return players;
    }

   
    public String updateResource(PlayerModel playerModel){
        if (playerRepository.existsByName(playerModel.getName())){ //Check for availability of resource by email ID. Update if resource exists.
            Player player = playerRepository.findByName(playerModel.getName()).get(0);
            BeanUtils.copyProperties(playerModel, player);
            try {
                playerRepository.save(player); //Update Student
                List<Game> games = gameRepository.findByPlayerName(playerModel.getName()); //Read the courses from the database
                for (int i = 0; i < playerModel.getGamesPlayed().size(); i++){
                    BeanUtils.copyProperties(playerModel.getGamesPlayed().get(i),games.get(i));
                }

                games.stream().forEach(c -> {
                    Game game = gameRepository.findById(c.getId()).get();
                    BeanUtils.copyProperties(c, game);
                    game.setPlayerName(playerModel.getName());
                    gameRepository.save(game);
                });
                playerModel.getGamesPlayed().stream().forEach(c -> { //Traverse through the studentModel to fetch all the courses
                    try {
                        Game game = gameRepository.findGameByPlayerName(playerModel.getName()); //Read the courses from the database
                        if (Objects.nonNull(games)){ //Update the course if exists
                            games.stream().forEach(c1 -> System.out.println(c1.getId()));
                            c.setPlayerName(playerModel.getName());
                            BeanUtils.copyProperties(c, game);
                            try {
                                gameRepository.save(game);
                            }catch (Exception e){
                                throw e;
                            }
                        }
                    }catch (Exception e){
                        throw e;
                    }
                });
            }catch (Exception e){
                throw e;
            }
            return "Resource was updated successfully";
        }else{
            return "Resource does not exist";
        }
    }

    
    public String deleteResource(PlayerModel playerModel){
        if (playerRepository.existsByName(playerModel.getName())){
            try {
                playerRepository.deleteByName(playerModel.getName());
                try {
                    gameRepository.deleteByPlayerName(playerModel.getName());
                }catch (Exception e){
                    throw e;
                }
            }catch (Exception e){
                throw e;
            }
            return "Removed successfully!";
        }else {
            return "Resource does not exist.";
        }
    }

	public Player getWinner() {
		// TODO Auto-generated method stub
		return playerRepository.getWinner();
	}

	public Player getLoser() {
		// TODO Auto-generated method stub
		return playerRepository.getLoser();
	}

	public void update(Player p) {
		// TODO Auto-generated method stub
		playerRepository.save(p);
	}

	public void modifyPlayer(PlayerModel player) {
		// TODO Auto-generated method stub
		this.updateResource(player);
	}

	public Optional<Player> searchById(int id) {
		// TODO Auto-generated method stub
		return playerRepository.findById(id);
	}

	public void save(Game game) {
		// TODO Auto-generated method stub
		gameRepository.save(game);
	}
	
	public ArrayList<Game> getGamesByPlayer(String playerName){
		return (ArrayList<Game>) gameRepository.findByPlayerName(playerName);
	}

	
	public ArrayList<Player> getPlayers(){
		return (ArrayList<Player>) playerRepository.findAll();
	}
	
	
    public int countWins(Player player) {
    	return gameRepository.countWins(player.getName());
    }
    
    public int countGamesPlayed(Player player) {
    	return gameRepository.countGamesPlayed(player.getName());
    }
    
}
