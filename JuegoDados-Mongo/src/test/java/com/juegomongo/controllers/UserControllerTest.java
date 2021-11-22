package com.juegomongo.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.juegomongo.services.GlobalService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UserControllerTest{

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@Autowired
	GlobalService service;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testGetPlayers() throws Exception {
		mockMvc.perform(get("/players/")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$[0].id").value("null")).andExpect(jsonPath("$[0].name").value("null"))
				.andExpect(jsonPath("$[0].winRate").value("null"));
//				.andExpect(jsonPath("$[1].id").value("2")).andExpect(jsonPath("$[1].name").value("Tienda2"))
//				.andExpect(jsonPath("$[1].capacidadMaxima").value("125"));
				
	}
	
	@Test
	public void testcreatePlayer() throws Exception {
		mockMvc.perform(get("/shops/1/pictures")).andExpect(status().isOk())
			.andExpect(content().contentType("application/json"))
			.andExpect(jsonPath("$[0].id").value("1")).andExpect(jsonPath("$[0].tienda_id").value("1"))
			.andExpect(jsonPath("$[0].name").value("GUERNICA")).andExpect(jsonPath("$[0].author").value(null))
			.andExpect(jsonPath("$[0].price").value("2005.3"));
	}
	

}
