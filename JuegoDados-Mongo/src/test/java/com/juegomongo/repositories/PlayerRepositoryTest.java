package com.juegomongo.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.juegomongo.documents.Player;

@RunWith(SpringRunner.class)
@Transactional
class PlayerRepositoryTest {

	@Autowired
	PlayerRepository repo;
	
	@Test
	void testFindAll() {
		ArrayList<Player>players= (ArrayList<Player>) repo.findAll();
		assertThat(players.size()).isEqualTo(0);
	}

	@Test
	void testSave() {
		Player player= new Player();
		player.setName("Test");
		repo.save(player);
		assertThat(repo.count()).isGreaterThan(0);
	}

}
