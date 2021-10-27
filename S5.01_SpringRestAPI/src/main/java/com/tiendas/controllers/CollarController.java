package com.tiendas.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tiendas.models.Collar;
import com.tiendas.models.Tienda;
import com.tiendas.services.CollaresService;
import com.tiendas.services.TiendasService;


@RestController
public class CollarController {
	@Autowired
	private CollaresService collaresService;
	

	
	@GetMapping("/pictures/")
	public List<Collar> getTiendas(){
		return collaresService.getCollares();
	}
	
	@GetMapping("/pictures/{id}")
	public Optional<Collar> getCollarById(@PathVariable Integer id){
		return collaresService.getCollarById(id);
	}
	
	
	
	
	@PostMapping("/shops/{id}/pictures")
	public void addCollar(@RequestParam String name, @RequestParam String author, Collar collar){
		
		collaresService.addCollar(collar);
	}
		

}
	
	

