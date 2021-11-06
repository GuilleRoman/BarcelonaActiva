package com.botiga.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.botiga.models.Collar;
import com.botiga.models.Tienda;
import com.fasterxml.jackson.databind.ObjectMapper;
@RunWith(SpringRunner.class)
@WebMvcTest
public class TestController{

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testGetTiendas() throws Exception {
		mockMvc.perform(get("/shops")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$[0].id").value("1")).andExpect(jsonPath("$[0].name").value("Tienda1"))
				.andExpect(jsonPath("$[0].capacidadMaxima").value("350"))
				.andExpect(jsonPath("$[1].id").value("2")).andExpect(jsonPath("$[1].name").value("Tienda2"))
				.andExpect(jsonPath("$[1].capacidadMaxima").value("125"));
				
	}
	
	@Test
	public void testGetCuadrosTienda() throws Exception {
		mockMvc.perform(get("/shops/1/pictures")).andExpect(status().isOk())
			.andExpect(content().contentType("application/json"))
			.andExpect(jsonPath("$[0].id").value("1")).andExpect(jsonPath("$[0].tienda_id").value("1"))
			.andExpect(jsonPath("$[0].name").value("GUERNICA")).andExpect(jsonPath("$[0].author").value(null))
			.andExpect(jsonPath("$[0].price").value("2005.3"));
	}
	
	@Test
	@DisplayName("Comprobar crearTienda()")
	public void testCrearTienda() throws Exception {
		//.....
	}
	
	@Test
	@DisplayName("Comprobar crearCuadro()")
	public void testCrearCuadro() throws Exception {
		//.....
	}
	
	@Test
	@DisplayName("Comprobar deleteCuadrosTienda()")
	public void testDeleteCuadrosTienda() throws Exception 
	{
		mockMvc.perform( MockMvcRequestBuilders.delete("/shops/1/pictures") )
	    	.andExpect(status().isOk());
	}
}