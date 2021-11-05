package com.botiga.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.botiga.models.Collar;
import com.botiga.models.Tienda;
import com.botiga.repositories.CollaresRepository;
import com.botiga.repositories.TiendasRepository;
@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
class TiendasServiceTest {
	

	@InjectMocks
	TiendasService service;
	
	@Mock
	TiendasRepository repo;

	private List<Tienda> tiendas;
	private List<Collar> collares;
	
	
	Tienda tienda;
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setup() { 
		tienda = new Tienda("Nueva", 500);
		MockitoAnnotations.initMocks(this);
		tiendas = new ArrayList<Tienda>();
		collares = new ArrayList<Collar>();
		Tienda tienda = new Tienda("Tienda1", 350);
		tienda.setId(1);
		Tienda tienda1 = new Tienda("Tienda2", 230);
		tienda1.setId(2);
		Collar collar = new Collar();
		collar.setName("Soledad");
		collar.setTienda(tienda);
		collar.setAuthor(null);
		collar.setPrice(2005.3);
		collar.setId(1);
		tiendas.add(tienda);
		tiendas.add(tienda1);
		collares.add(collar); 
	}
	
	@Test
	void testGetTiendas() {
		when(service.getTiendas()).thenReturn(tiendas);
		ArrayList<Tienda>tiendas= (ArrayList<Tienda>) service.getTiendas();
		assertThat(tiendas.size()).isEqualTo(2);
	}

	@Test
	void TestCrearTienda() {
		service.crearTienda(tienda);
		verify(repo, times(1)).save(tienda);
		
	}

}
