package com.botiga.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.botiga.models.Collar;
import com.botiga.models.Tienda;
import com.botiga.services.CollaresService;
import com.botiga.services.TiendasService;

@RestController
public class FranquiciaController {
	
	@Autowired
	private TiendasService tiendasService;

	@Autowired
	private CollaresService collaresService;


	// MÉTODOS PARA LAS TIENDAS


	@GetMapping("/shops/")
	public List<Tienda> getTiendas(){


		return tiendasService.getTiendas();


	}


	@PostMapping("/shops/")
	public String crearTienda(@RequestParam String name,@RequestParam int capacidadMaxima, Tienda tienda) {


		tiendasService.crearTienda(tienda);
		return "Tienda creada correctamente";
	}



	@GetMapping("shops/{id}")
	public Optional<Tienda> getTiendaById(@PathVariable Integer id){
		return tiendasService.getTiendaById(id);

	}

	@GetMapping("/shops/{id}/pictures")
	public List<Collar> getCollaresByTiendaID(@PathVariable Integer id){
		Optional<Tienda> tienda = tiendasService.getTiendaById(id);
		if(tienda.isPresent()) {
			Tienda nuevaTienda = tienda.get();
			return nuevaTienda.getCollares();
		}





		return null;

}


	@DeleteMapping("/shops/{id}/pictures")
	public String incendiarCuadros(@PathVariable Integer id) {
		Optional<Tienda> tienda = tiendasService.getTiendaById(id);
		Tienda tienda1 = tienda.get();
		List<Collar> losCollares = tienda1.getCollares();
		for (Collar c: losCollares) {
			collaresService.deleteCollares(c);
		}


		return "Desapareció cualquier prueba incriminatoria";
	}

	// MÉTODOS PARA LOS CUADROS

	@GetMapping("/pictures/")
	public List<Collar> getCollares(){
		return collaresService.getCollares();




	}

	@GetMapping("/pictures/{id}")
	public Optional<Collar> getCollarById(@PathVariable Integer id){
		return collaresService.getCollarById(id);


	}




	@PostMapping("/pictures/")
	public String addCollar(@RequestParam String name, @RequestParam String author, Collar collar){

		collaresService.addCollar(collar);

		return "Cuadro creado correctamente";
	}

	@PostMapping("/shops/{id}/pictures")
	public String addCollarConFK(@RequestParam int tienda_id ,@RequestParam String name, @RequestParam String author, Collar collar){

		collaresService.addCollar(collar);

		return "Cuadro creado correctamente";
	}




}