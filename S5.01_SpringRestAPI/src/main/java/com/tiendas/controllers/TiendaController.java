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
public class TiendaController {
	
	@Autowired
	private TiendasService tiendasService;
	
	@Autowired
	private CollaresService collaresService;
	
	@GetMapping("/shops/")
	public List<Tienda> getTiendas(){
		return tiendasService.getTiendas();
	}
	
	
	@PostMapping("/shops/")
	public void crearTienda(@RequestParam String name,@RequestParam int capacidadMaxima, Tienda tienda) {
		tiendasService.addTienda(tienda);
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
	public void incendiarCuadros(@PathVariable Integer id) {
		Optional<Tienda> tienda = tiendasService.getTiendaById(id);
		Tienda tienda1 = tienda.get();
		List<Collar> losCollares = tienda1.getCollares();
		for (Collar c: losCollares) {
			collaresService.deleteCollares(c);
		}
		
	}

	

	
	
	
	

}