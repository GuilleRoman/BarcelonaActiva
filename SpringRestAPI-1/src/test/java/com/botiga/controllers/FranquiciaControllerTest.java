package com.botiga.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.botiga.models.Collar;
import com.botiga.models.Tienda;
import com.botiga.repositories.CollaresRepository;
import com.botiga.repositories.TiendasRepository;
import com.botiga.services.CollaresService;
import com.botiga.services.TiendasService;


@RunWith(SpringRunner.class)
@WebMvcTest
class FranquiciaControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	
	@InjectMocks
	TiendasService service;
	
	@InjectMocks
	CollaresService servicio;
	
	@MockBean
	FranquiciaController franquiciaController;
	
	private List<Tienda> tiendas;
	private List<Collar> collares;
	Collar collar;
	Optional<Collar> collar1;
	@BeforeEach
	public void setup() {
		tiendas = new ArrayList<Tienda>();
		collares = new ArrayList<Collar>();
		
		Tienda tienda = new Tienda("Tienda1", 350);
		tienda.setId(1);
		Tienda tienda1 = new Tienda("Tienda2", 230);
		tienda1.setId(2);
		 collar = new Collar();
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
	void testGetTiendas() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		when(franquiciaController.getTiendas()).thenReturn(tiendas);
		
		mockMvc.perform(get("/shops/")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json"))
		.andExpect(jsonPath("$[0].id").value("1")).andExpect(jsonPath("$[0].name").value("Tienda1"))
		.andExpect(jsonPath("$[0].capacidadMaxima").value("350"))
		.andExpect(jsonPath("$[1].id").value("2")).andExpect(jsonPath("$[1].name").value("Tienda2"))
		.andExpect(jsonPath("$[1].capacidadMaxima").value("230"));
		
	}

	@Test
	void testGetCollares() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		when(franquiciaController.getCollares()).thenReturn(collares);
		
		mockMvc.perform(get("/pictures/")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json"));
//		.andExpect(jsonPath("$[0].name").value("Soledad"))
//		.andExpect(jsonPath("$[0].author").value(null))
//		.andExpect(jsonPath("$[0].price").value("2005.3"));
	}
	
	@Test
	void TestGetCollarById() throws Exception{
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		mockMvc.perform(get("/pictures/1")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json"));
		
	}
	
	@Test
	void TestGetTiendaById() throws Exception{
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		
//		when(franquiciaController.getTiendaById(1)).thenReturn(tiendas);
		
		mockMvc.perform(get("/shops/1")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json"));
	}
	
	

}
