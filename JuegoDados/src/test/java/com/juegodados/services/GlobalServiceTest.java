package com.juegodados.services;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.juegodados.documents.Game;
import com.juegodados.entities.Player;
import com.juegodados.repositories.PlayerRepository;



@RunWith(SpringRunner.class)
@Transactional
class GlobalServiceTest {
	

	@InjectMocks
	GlobalService service;
	
	@Mock
	PlayerRepository repo;

	private ArrayList<Player> players;
	private ArrayList<Game> games;
	Player player;
	Game game;
	Game game1;
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setup() { 
		Player player = new Player();
		player.setName("Test");
		MockitoAnnotations.initMocks(this);
		players = new ArrayList<Player>();
		games = new ArrayList<Game>();
		Player player1 = new Player();
		player.setName("Test1");
		Player player2 = new Player();
		game = new Game();
		game.setPlayerName(player.getName());
		game1 = new Game();
		game1.setPlayerName(player.getName());
		players.add(player);
		players.add(player1);
		players.add(player2);
		games.add(game); 
		games.add(game1); 
		
	}
	
	@Test
	void testGetWinner() {
		when(service.getWinner()).thenReturn( player);
		
		assertThat(service.getWinner()).isNull();;
	}

	@Test
	void TestCrearPlayer() {
		service.savePlayer(player);
		verify(repo, times(1)).save(player);
		
	}

}
