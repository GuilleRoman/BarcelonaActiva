package com.botiga.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.botiga.models.Tienda;


@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
class TiendasRepositoryTest {

	@Autowired
	TiendasRepository repo;
	
	@Test
	void testFindAll() {
		ArrayList<Tienda>tiendas= (ArrayList<Tienda>) repo.findAll();
		assertThat(tiendas.size()).isEqualTo(9);
	}

	@Test
	void testSave() {
		Tienda tienda= new Tienda("Tienda10", 550);
		repo.save(tienda);
		assertThat(repo.count()).isGreaterThan(9);
	}

	

}
