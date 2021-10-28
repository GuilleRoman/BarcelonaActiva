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
import com.tiendas.repositories.DataBaseJDBC;
import com.tiendas.services.CollaresService;
import com.tiendas.services.TiendasService;


@RestController
public class CollarController {
	// PARA USAR LA BD H2, DESCOMENTAR
//	@Autowired
//	private CollaresService collaresService;
	
	@Autowired
	private DataBaseJDBC db = new DataBaseJDBC();
	
	@GetMapping("/pictures/")
	public List<Collar> getCollares(){
//		return collaresService.getCollares();
		
		return db.getCollares();
		
		
	}
	
	@GetMapping("/pictures/{id}")
	public Optional<Collar> getCollarById(@PathVariable Integer id){
//		return collaresService.getCollarById(id);
		
		return Optional.of(db.getCollar(id));
	}
	
	
	
	
	@PostMapping("/pictures/")
	public String addCollar(@RequestParam String name, @RequestParam String author, Collar collar){
		
//		collaresService.addCollar(collar);
		db.crearCollar(collar);
		return "Cuadro creado correctamente";
	}
	
	@PostMapping("/shops/{id}/pictures")
	public String addCollarConFK(@RequestParam int tienda_id ,@RequestParam String name, @RequestParam String author, Collar collar){
		
//		collaresService.addCollar(collar);
		db.crearCollarConFK(collar, tienda_id);
		return "Cuadro creado correctamente";
	}
		

}
	
	

