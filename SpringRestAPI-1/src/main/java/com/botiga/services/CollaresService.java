package com.botiga.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.botiga.models.Collar;
import com.botiga.repositories.CollaresRepository;

@Service
public class CollaresService {
	
	@Autowired
	CollaresRepository collaresRepository;
	public List<Collar> getCollares() {
		// TODO Auto-generated method stub
		return (List<Collar>) collaresRepository.findAll();
	}
	public Optional<Collar> getCollarById(Integer id) {
		return collaresRepository.findById(id);
		
		
	}
	public void addCollar(Collar collar) {
		collaresRepository.save(collar);
		
	}
	
	public void deleteCollares(Collar collar) {
		collaresRepository.delete(collar);;
		
	}
	

}
