package com.juegomongo.services;

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

import com.juegomongo.documents.Game;
import com.juegomongo.documents.Player;
import com.juegomongo.repositories.PlayerRepository;



@RunWith(SpringRunner.class)
@Transactional
class GlobalServiceTest {
	

	@InjectMocks
	GlobalService service;
	
	@Mock
	PlayerRepository repo;

	private List<Player> players;
	private List<Game> games;
	Player player;
	
	
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
		Game game = new Game();
		game.setPlayerName(player.getName());
		Game game1 = new Game();
		game1.setPlayerName(player1.getName());
		players.add(player);
		players.add(player1);
		players.add(player2);
		games.add(game); 
		games.add(game1); 
	}
	
	@Test
	void testGetTiendas() {
		when(service.getPlayers()).thenReturn((ArrayList<Player>) players);
		ArrayList<Player>players= (ArrayList<Player>) service.getPlayers();
		assertThat(players.size()).isEqualTo(3);
	}

	@Test
	void TestCrearTienda() {
		service.save(player);
		verify(repo, times(1)).save(player);
		
	}

}
