package com.botiga.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.botiga.models.Collar;
import com.botiga.models.Tienda;
import com.botiga.repositories.TiendasRepository;

@Service
public class TiendasService {
	
	@Autowired
	private TiendasRepository tiendasRepository;
	
	
	
	public List<Tienda> getTiendas(){
		return (List<Tienda>) tiendasRepository.findAll();
	}
	

	public Optional<Tienda> getTiendaById(Integer id) {
		return tiendasRepository.findById(id);
		
	}


	public void crearTienda(Tienda tienda) {
		tiendasRepository.save(tienda);
		
	}


	public void deleteCollares(Iterable<? extends Integer> id) {
		tiendasRepository.deleteAllById(id);
		
	}


	
}
